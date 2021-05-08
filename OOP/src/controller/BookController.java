package controller;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

import model.Book;

public class BookController 
{
	private DatabaseConnection database;
	
	public BookController()
	{
		 database = new DatabaseConnection();
	}
	
    //view all available book for customer book searching
    public List<Book> viewAvailableBook()
    {
        Connection conn=null;
        Statement stmt=null;
        ResultSet rs=null;
       
        String sql="SELECT Book.BookID,title,TypeName,Author,COUNT(Copy.bookID),price FROM Book " + 
        "INNER JOIN booktype ON Book.typeID=booktype.typeID " +
        "INNER JOIN Copy ON book.bookID=copy.bookID WHERE copyCondition = 'Available' GROUP BY Book.BookID ORDER BY BookID";

        List<Book> bookList = new ArrayList<Book>();

        try
        {
        	conn=database.getConnection();
        	stmt=conn.createStatement();
            rs=stmt.executeQuery(sql);
            while(rs.next())
            {
                Book book = new Book();
                book.setBookID(rs.getInt(1));
                book.setTitle(rs.getString(2));
                book.setTypeName(rs.getString(3));
                book.setAuthor(rs.getString(4));
                book.setAvailableUnit(rs.getInt(5));
                book.setPrice(rs.getInt(6));

                bookList.add(book);
            }
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
        finally
        {
            try
            {
                if(stmt!=null)
                    stmt.close();
                if (rs!=null)
                     rs.close();
                 if(conn!=null)
                     conn.close();
            }
            catch(Exception ex){}
        }
        return bookList;
    }

    //search available book with book id
    public Book searchBookID(int BookID)
    {
        Connection conn=null;
        PreparedStatement ps = null;
        ResultSet rs=null;
        int count = 0;
       
        String sql="SELECT Book.BookID,title,TypeName,Author,COUNT(Copy.bookID),price FROM Book " + 
        "INNER JOIN booktype ON Book.typeID=booktype.typeID " +
        "INNER JOIN Copy ON book.bookID=copy.bookID WHERE copyCondition = 'Available' AND Book.BookID = ? " +
        "GROUP BY title";
        
        Book book = new Book();
        
        try
        {        
        	
        	conn = database.getConnection();
        	ps = conn.prepareStatement(sql);
        	ps.setInt(1,BookID);
            rs = ps.executeQuery();
            
            while(rs.next())
            {          
            	count++;
                book.setBookID(rs.getInt(1));
                book.setTitle(rs.getString(2));
                book.setTypeName(rs.getString(3));
                book.setAuthor(rs.getString(4));
                book.setAvailableUnit(rs.getInt(5));
                book.setPrice(rs.getDouble(6));
            }
            
            if(count == 0 )
            {
            	return null;
            }
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
        finally
        {
            try
            {
                if(ps!=null)
                    ps.close();
                if (rs!=null)
                    rs.close();
                 if(conn!=null)
                    conn.close();
            }
            catch(Exception ex){}
        }
        return book;
    }
    
    //search available book with book title
    public List<Book> searchBookTitle(String title)
    {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
       
        String sql="SELECT Book.BookID,title,TypeName,Author,COUNT(Copy.bookID),price FROM Book " + 
        "INNER JOIN booktype ON Book.typeID=booktype.typeID " +
        "INNER JOIN Copy ON book.bookID=copy.bookID WHERE copyCondition = 'Available' AND title LIKE ? " +
        "GROUP BY title ORDER BY Book.BookID";
        
        
        List<Book> bookList = new ArrayList<Book>();
        try
        {                
        	conn = database.getConnection();
        	ps = conn.prepareStatement(sql);
        	ps.setString(1,"%"+title+"%");
            rs = ps.executeQuery();
            while(rs.next())
            {        
            	Book book = new Book();
                book.setBookID(rs.getInt(1));
                book.setTitle(rs.getString(2));
                book.setTypeName(rs.getString(3));
                book.setAuthor(rs.getString(4));
                book.setAvailableUnit(rs.getInt(5));
                book.setPrice(rs.getDouble(6));
                bookList.add(book);
            }
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
        finally
        {
            try
            {
                if(ps!=null)
                    ps.close();
                if (rs!=null)
                    rs.close();
                 if(conn!=null)
                    conn.close();
            }
            catch(Exception ex){}
        }
        return bookList;
    }

    //search book copy for customer add book into rent list
    public Book searchBookID(int bookID,int copyID)
    {
        Connection conn= null;
        PreparedStatement ps = null;
        ResultSet rs= null;
        Book book = new Book();
        int count = 0;
       
        String sql="SELECT Book.BookID,Copy.CopyID,title,TypeName,Author,COUNT(Copy.bookID),price FROM Book " + 
        "INNER JOIN booktype ON Book.typeID=booktype.typeID " +
        "INNER JOIN Copy ON book.bookID=copy.bookID WHERE copyCondition = 'Available' AND Book.BookID = ? AND Copy.CopyID=? " ;
        
        try
        {        
        	conn = database.getConnection();
        	ps = conn.prepareStatement(sql);
        	ps.setInt(1,bookID);
            ps.setInt(2,copyID);
            rs = ps.executeQuery();

            while(rs.next())
            {
                count++;
                book.setBookID(rs.getInt(1));
                book.setCopyID(rs.getInt(2));
                book.setTitle(rs.getString(3));
                book.setTypeName(rs.getString(4));
                book.setAuthor(rs.getString(5));
                book.setAvailableUnit(rs.getInt(6));
                book.setPrice(rs.getDouble(7));
            }
            if(count == 0 || book.getBookID() == 0)
            {
            	return null;
            }
           
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
        finally
        {
            try
            {
                if (ps!=null)
                     ps.close();
                if (rs!=null)
                     rs.close();
                 if(conn!=null)
                     conn.close();
            }
            catch(Exception ex){}
        }
        return book;
    }

    //update copy condition to rented after customer rent it
    public void updateRentBook(int bookID, int copyID)
    {
    	Connection conn = null;
    	PreparedStatement ps = null;
    	String sql = "Update copy SET copyCondition = 'Rented' where bookID = ? AND copyID = ?";
    	try 
    	{
    		conn =  database.getConnection();
    		ps = conn.prepareStatement(sql);
    		ps.setInt(1,bookID);
    		ps.setInt(2,copyID);
    		ps.executeUpdate();
    	}
    	catch(Exception ex)
    	{
    		ex.printStackTrace();
    	}
		finally
	    {
	           try
	           {
	               if (ps!=null)
	                  ps.close();
	               if(conn!=null)
	                   conn.close();
	            }
	            catch(Exception ex){}
	        }
    	}
    
    //admin insert new book
    public int insertBook(Book book)
    {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "INSERT INTO Book(BookID,TypeID,Title,Author,Status) VALUES (NULL,?,?,?,'Available')";
        int status = 0, bookID =0;
        
        try
        {
            conn = database.getConnection();
           ps = conn.prepareStatement(sql);
           ps.setInt(1, book.getTypeID());
           ps.setString(2, book.getTitle());
           ps.setString(3, book.getAuthor());
           status = ps.executeUpdate();
           if(status!=0)
           {
               //select the new insert book ID
               sql = "SELECT MAX(BookID) FROM Book";
               ps = conn.prepareStatement(sql);
               rs = ps.executeQuery();
               if(rs.next())
               {
                    bookID = rs.getInt(1);
               }
           }
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
        finally
        {
             try
	           {
	                if (ps!=null)
	                    ps.close();
                    if(rs!=null)
                        rs.close();
	                if(conn!=null)
	                    conn.close();
	            }
	            catch(Exception ex){}
        }
        return bookID;
    }

    //Admin insert new copy
    public int insertCopy(int bookID)
    {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        //count the latest copyID for that book
        String sql = "SELECT MAX(CopyID)+1 FROM Copy WHERE bookID = ?";
        int status = 0;
        int copyID = 0;

        try
        {
           conn = database.getConnection();
           ps =conn.prepareStatement(sql);
           ps.setInt(1, bookID);
           rs = ps.executeQuery();
           if(rs.next())
           {
               copyID = rs.getInt(1);
                if(copyID == 0)
                {
                    copyID = 1;
                }
           }
           
           //add new copy
           sql = "INSERT INTO Copy(BookID,CopyID,copyCondition) VALUES (?,?,'Available')";
           ps = conn.prepareStatement(sql);
           ps.setInt(1, bookID);
           ps.setInt(2, copyID);
           status= ps.executeUpdate();
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
        finally
        {
             try
	           {
	                if(ps!=null)
	                    ps.close();
                    if(rs!=null)
                        rs.close();
	                if(conn!=null)
	                   conn.close();
	            }
	            catch(Exception ex){}
        }
        return status;
    }

 //search book copy with book ID and copy ID
 public Book searchBookIDName (int bookID, int copyID)
    {
        Connection conn= null;
        PreparedStatement ps = null;
        ResultSet rs= null;
        Book book = new Book();
        int count = 0;
       
        String sql="SELECT Book.BookID,Copy.CopyID,title,TypeName,Author,COUNT(Copy.bookID),price FROM Book " + 
        "INNER JOIN booktype ON Book.typeID=booktype.typeID " +
        "INNER JOIN Copy ON book.bookID=copy.bookID WHERE copyCondition = 'Available' AND Book.BookID = ? AND Copy.CopyID=? " ;
        
        try
        {        
        	conn = database.getConnection();
        	ps = conn.prepareStatement(sql);
        	ps.setInt(1,bookID);
            ps.setInt(2,copyID);
            rs = ps.executeQuery();

            while(rs.next())
            {
                count++;
                book.setBookID(rs.getInt(1));
                book.setCopyID(rs.getInt(2));
                book.setTitle(rs.getString(3));
                book.setTypeName(rs.getString(4));
                book.setAuthor(rs.getString(5));
                book.setAvailableUnit(rs.getInt(6));
                book.setPrice(rs.getDouble(7));
            }
            if(count == 0 || book.getBookID() == 0)
            {
            	return null;
            }
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
        finally
        {
            try
            {
                if (ps!=null)
                     ps.close();
                if (rs!=null)
                     rs.close();
                 if(conn!=null)
                     conn.close();
            }
            catch(Exception ex){}
        }
        return book;  
    }

    //select product name for product type combo box
    public List<Book> selectProductType()
    {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        String sql = "SELECT TypeName FROM BookType";
        
        List<Book> bookList = new ArrayList<Book>();
        try
        {
           conn = database.getConnection();
           stmt = conn.createStatement();
           rs =stmt.executeQuery(sql);

           while(rs.next())
           {
               Book book = new Book();
               book.setTypeName(rs.getString(1));
               bookList.add(book);
           }
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
        finally
        {
             try
	           {
	               if (stmt!=null)
	                  stmt.close();
                    if(rs!=null)
                        rs.close();
	               if(conn!=null)
	                   conn.close();
	            }
	            catch(Exception ex){}
        }
        return bookList;
    }

    //search type name with type ID
    public int searchTypeID(String typeName)
    {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT typeID FROM BookType where typeName=?";
       int typeID = 0;
   
        try
        {        
        	
        	conn = database.getConnection();
        	ps = conn.prepareStatement(sql);
        	ps.setString(1,typeName);
            rs = ps.executeQuery();
             while(rs.next())
            {          
                typeID = rs.getInt(1);
            }
            }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
        finally
        {
            try
            {
                if (ps!=null)
                     ps.close();
                if (rs!=null)
                     rs.close();
                 if(conn!=null)
                     conn.close();
            }
            catch(Exception ex){}
        }

        return typeID;  
    }

    //search title and author with bookID
    public Book searchBook(int bookID)
    {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Book book = new Book();
        String sql = "SELECT title, author,bookID FROM Book where bookID=?";
        int count = 0;
        
        try
        {        
        	conn = database.getConnection();
        	ps = conn.prepareStatement(sql);
        	ps.setInt(1,bookID);
            rs = ps.executeQuery();
             while(rs.next())
            {          
            	count++;
                book.setTitle(rs.getString(1));
                book.setAuthor(rs.getString(2));
                book.setBookID(rs.getInt(3));
            }
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
        finally
        {
            try
            {
                if (ps!=null)
                     ps.close();
                if (rs!=null)
                     rs.close();
                if(conn!=null)
                     conn.close();
            }
            catch(Exception ex){}
        }
        if(count == 0)
        {
        	book = null;
        }
        return book;  
    }

    //search max copy ID
    public int searchMaxCopyID(int bookID)
    {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        int copyID = 0;

        String sql = "SELECT MAX(CopyID) FROM Copy where BookID=?";
        try
        {        
        	
        	conn = database.getConnection();
        	ps = conn.prepareStatement(sql);
        	ps.setInt(1,bookID);
            rs = ps.executeQuery();
            while(rs.next())
            {          
                copyID = rs.getInt(1);
            }
            }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
        finally
        {
            try
            {
                if (ps!=null)
                     ps.close();
                if (rs!=null)
                     rs.close();
                 if(conn!=null)
                     conn.close();
            }
            catch(Exception ex){}
        }
        return copyID;  
    }

    //update title and author with book ID
    public int updateBook(Book book)
    {
        Connection conn = null;
        PreparedStatement ps = null;
        int status = 0;

        String sql = "UPDATE Book SET Title = ?, Author = ? WHERE BookID = ?";
        try
        {        
        	conn = database.getConnection();
        	ps = conn.prepareStatement(sql);
        	ps.setString(1,book.getTitle());
            ps.setString(2,book.getAuthor());
            ps.setInt(3,book.getBookID());
            status = ps.executeUpdate();
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
        finally
        {
            try
            {
                if (ps!=null)
                     ps.close();
                 if(conn!=null)
                     conn.close();
            }
            catch(Exception ex){}
        }
        return status;  
    }

    //update copy condition
    public int updateCopy(Book book)
    {
        Connection conn = null;
        PreparedStatement ps = null;
        int status = 0;

        String sql = "UPDATE Copy SET copyCondition = ? WHERE BookID = ? AND CopyID = ?";
        try
        {        
        	conn = database.getConnection();
        	ps = conn.prepareStatement(sql);
        	ps.setString(1,book.getCondition());
            ps.setInt(2,book.getBookID());
            ps.setInt(3,book.getCopyID());
            status = ps.executeUpdate();
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
        finally
        {
            try
            {
                if (ps!=null)
                     ps.close();
                 if(conn!=null)
                     conn.close();
            }
            catch(Exception ex){}
        }
        return status;  
    }
    
    //search copy condition with copyID and BookID
    public Book searchCopyCondition(int bookID, int copyID)
    {
    	Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Book book = new Book();
        int count = 0;

        String sql = "SELECT copyCondition,bookID,copyID FROM copy WHERE BookID = ? AND copyID = ? AND copyCondition NOT IN('Rented')";
        try
        {        
        	conn = database.getConnection();
        	ps = conn.prepareStatement(sql);
        	ps.setInt(1,bookID);
            ps.setInt(2,copyID);
            rs = ps.executeQuery();
            if(rs.next())
            {
                count++;
            	book.setCondition(rs.getString(1));
            	book.setBookID(rs.getInt(2));
            	book.setCopyID(rs.getInt(3));
            }
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
        finally
        {
            try
            {
                if (ps!=null)
                    ps.close();
                if(rs!=null)
                	rs.close();
                 if(conn!=null)
                    conn.close();
            }
            catch(Exception ex){}
        }

        if(count == 0)
        {
            book = null;
        }
        return book;  
    }

    //view all book in the store
    public List<Book> viewAllBook()
    {
        Connection conn=null;
        Statement stmt=null;
        ResultSet rs=null;
       
        String sql="SELECT Book.bookID,Copy.copyID,title,TypeName,Author,copyCondition,price FROM Book " + 
        "INNER JOIN booktype ON Book.typeID=booktype.typeID " + 
        "INNER JOIN Copy ON book.bookID=copy.bookID ORDER BY BookID,copyID";

        List<Book> bookList = new ArrayList<Book>();
        try
        {
        	conn=database.getConnection();
        	stmt=conn.createStatement();
            rs=stmt.executeQuery(sql);
            while(rs.next())
            {
                Book book = new Book();
                book.setBookID(rs.getInt(1));
                book.setCopyID(rs.getInt(2));
                book.setTitle(rs.getString(3));
                book.setTypeName(rs.getString(4));
                book.setAuthor(rs.getString(5));
                book.setCondition(rs.getString(6));
                book.setPrice(rs.getInt(7));

                bookList.add(book);
            }
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
        finally
        {
            try
            {
                if (rs!=null)
                    rs.close();
                 if(conn!=null)
                    conn.close();
                if(stmt!=null)
                    stmt.close();
            }
            catch(Exception ex){}
        }
        return bookList;
    }
    
    //search in all book 
    public List<Book> searchAllBook(int bookID)
    {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
       
        String sql="SELECT Book.bookID,Copy.copyID,title,TypeName,Author,copyCondition,price FROM Book " +
        "INNER JOIN booktype ON Book.typeID=booktype.typeID " +
        "INNER JOIN Copy ON book.bookID=copy.bookID WHERE Book.BookID = ? ORDER BY BookID,copyID";

        List<Book> bookList = new ArrayList<Book>();
        try
        {
        	conn = database.getConnection();
        	ps = conn.prepareStatement(sql);
            ps.setInt(1, bookID);
            rs = ps.executeQuery();
            while(rs.next())
            {
                Book book = new Book();
                book.setBookID(rs.getInt(1));
                book.setCopyID(rs.getInt(2));
                book.setTitle(rs.getString(3));
                book.setTypeName(rs.getString(4));
                book.setAuthor(rs.getString(5));
                book.setCondition(rs.getString(6));
                book.setPrice(rs.getInt(7));

                bookList.add(book);
            }
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
        finally
        {
            try
            {
                if(ps!=null)
                    ps.close();
                if (rs!=null)
                    rs.close();
                 if(conn!=null)
                    conn.close();
            }
            catch(Exception ex){}
        }
        return bookList;
    }

    //update rented book to available after customer return the book
    public int updateBookReturn(int bookID, int copyID)
    {
        Connection conn = null;
        PreparedStatement ps = null;
        int status = 0;
       
        String sql="Update copy SET copyCondition = 'Available' WHERE bookID = ? AND copyID = ?";
         try
        {
        	conn = database.getConnection();
        	ps = conn.prepareStatement(sql);
            ps.setInt(1, bookID);
            ps.setInt(2,copyID);
            status = ps.executeUpdate();
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
        finally
        {
            try
            {
                if(ps!=null)
                    ps.close();
                 if(conn!=null)
                    conn.close();
            }
            catch(Exception ex){}
        }
        return status;
    }

    // update book status to available 
     public int updateBookToAvailable()
    {
        Connection conn = null;
        PreparedStatement ps = null;
        int status = 0;

        String sql ="Update Book SET status = 'Available' WHERE BookID IN(SELECT bookID "
        		+ "FROM(SELECT Book.BookID,COUNT(Copy.bookID) AS Quantity FROM Book "
        		+ "INNER JOIN Copy ON book.bookID=copy.bookID WHERE copyCondition = 'Available' AND Status = 'Not Available'"
        		+ "GROUP BY Book.BookID HAVING Quantity > 0)Book)";
        try
        {        
        	conn = database.getConnection();
        	ps = conn.prepareStatement(sql);
            status = ps.executeUpdate();
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
        finally
        {
            try
            {
                if (ps!=null)
                     ps.close();
                 if(conn!=null)
                     conn.close();
            }
            catch(Exception ex){}
        }
        return status;  
    }

    // update book status to Not available 
     public int updateBookToNotAvailable()
    {
        Connection conn = null;
        PreparedStatement ps = null;
        int status = 0;

        String sql ="Update Book SET status = 'Not Available' WHERE BookID NOT IN " 
        		+ "(SELECT BookID FROM (SELECT Book.BookID,COUNT(Copy.bookID) AS Quantity FROM Book " 
        		+ "INNER JOIN Copy ON book.bookID=copy.bookID WHERE copyCondition = 'Available' AND Status = 'Available' "
        		+ "GROUP BY Book.BookID)Book)";
        try
        {        
        	conn = database.getConnection();
        	ps = conn.prepareStatement(sql);
            status = ps.executeUpdate();
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
        finally
        {
            try
            {
                if (ps!=null)
                     ps.close();
                 if(conn!=null)
                     conn.close();
            }
            catch(Exception ex){}
        }
        return status;  
    }



}



