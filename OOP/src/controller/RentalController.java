package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.sql.Date;

import model.Book;
import model.Rental;
import model.User;

public class RentalController 
{
    private DatabaseConnection database;

    public RentalController()
    {
        this.database = new DatabaseConnection();
    }

    // get the maximum rental ID
    public int maxRental()
    {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        String sql = "SELECT MAX(RentalID) FROM Rental";
        int rentID = 0;

        try
        {
            conn = database.getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            if(rs.next())
            {
            	rentID = rs.getInt(1);
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
            }
            catch(Exception ex){}
        }
        return rentID;
    }

    // add customer's rental into rental table
    public int insertRental(User user)
    {
        int status = 0;
        Connection conn = null;
        PreparedStatement ps = null;
        String sql = "INSERT INTO Rental (rentalID,userID,rentDate,returnDate,overdueFee,status) VALUES(NULL,?,CURDATE(),NULL,0,'Unpaid')";

        try
        {
            conn = database.getConnection();
            ps = conn.prepareStatement(sql);

            ps.setInt(1, user.getUserID());
    
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
                 if(conn!=null)
                     conn.close();
            }
            catch(Exception ex){}
        }
        return status;
    }

    // add rented copy list  
    public int insertRentalCopy(Rental rental)
    {
        int status = 0;
        Connection conn = null;
        PreparedStatement ps = null;
        String sql = "INSERT INTO rentalCopy (BookID,CopyID,RentalID) VALUES (?,?,?)";

        try
        {
            conn = database.getConnection();
            ps = conn.prepareStatement(sql);
          
            ps.setInt(1, rental.getBookID());
            ps.setInt(2, rental.getCopyID());
            ps.setInt(3, rental.getRentID());
            
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
                if(conn!=null)
                     conn.close();
            }
            catch(Exception ex){}
        }

        return status;
    }

    // search rental info and the expected return date by rental ID to print receipt
	public void searchRecipeInformation(Rental rental, User user) 
	{
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql ="SELECT name,rentDate,(rentDate + INTERVAL 7 DAY)AS A FROM rental INNER JOIN user ON rental.userID = user.userID WHERE rentalID = ?";
		try
		{
			conn = database.getConnection(); 
			ps = conn.prepareStatement(sql);
			ps.setInt(1,rental.getRentID());
			
			rs = ps.executeQuery();
			if(rs.next())
			{
				user.setName(rs.getString(1));
				rental.setRentDate(rs.getString(2));
				rental.setExpectedDate(rs.getString(3));
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
                if(conn!=null)
                     conn.close();
            }
            catch(Exception ex){}
        }
	}
	
    // search all rented copy info in customer rental list by rental ID
    public List<Book> searchRentList(Rental rental)
	{
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "SELECT RentalCopy.BookID,RentalCopy.CopyID,Title,TypeName,Author,Price FROM RentalCopy " +
        "INNER JOIN Book ON RentalCopy.BookID = Book.BookID " + 
        "INNER JOIN BookType ON Book.TypeID = BookType.TypeID WHERE RentalID = ?";
        List<Book> BookList = new ArrayList<Book>();
        try
        {
            conn = database.getConnection();
            ps = conn.prepareStatement(sql);  
            ps.setInt(1,rental.getRentID());
            rs = ps.executeQuery();

            while(rs.next())
            {
                Book book = new Book();
                book.setBookID(rs.getInt(1));
                book.setCopyID(rs.getInt(2));
                book.setTypeName(rs.getString(3));
                book.setTitle(rs.getString(4));
                book.setAuthor(rs.getString(5));
                book.setPrice(rs.getInt(6));
                BookList.add(book);
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
                if(conn!=null)
                    conn.close();
            }
            catch(Exception ex){}
        }
        return BookList;
	}

    // list out all rent
    public List<Rental> viewAllRentList ()
    {
        Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "SELECT rentalcopy.rentalID,name,rentDate,(rentDate + INTERVAL 7 DAY),returnDate,sum(price),rental.status FROM rentalcopy " + 
                     "INNER JOIN rental ON rentalcopy.rentalID = rental.rentalID " +
                     "INNER JOIN User ON rental.userID = user.userID " +
                     "INNER JOIN book ON book.bookID = rentalcopy.bookID " +
                     "INNER JOIN booktype ON book.typeID = booktype.typeID " +
                     "GROUP BY rental.rentalID";
        List<Rental> rentalList = new ArrayList<Rental>();
        
        try
        {
            conn = database.getConnection();
            ps = conn.prepareStatement(sql);  
            
            rs = ps.executeQuery();

            while(rs.next())
            {
                Rental rental = new Rental ();
                rental.setRentID(rs.getInt(1));
                rental.setCustomerName(rs.getString(2));
                rental.setRentDate(rs.getString(3));
                rental.setExpectedDate(rs.getString(4));
                rental.setReturnDate(rs.getString(5));
                rental.setRentFee(rs.getDouble(6));
                rental.setStatus(rs.getString(7));
               
                rentalList.add(rental);
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
                if(conn!=null)
                    conn.close();
                if(ps!=null)
                ps.close();
                if (rs!=null)
                rs.close();
            }
            catch(Exception ex){}
        }
        return rentalList;
	}

    // search rent by rentalID
     public Rental searchAllRental (int rentalID)
    {
        Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "SELECT rentalcopy.rentalID,name,rentDate,(rentDate + INTERVAL 7 DAY),returnDate,sum(price),rental.status FROM rentalcopy " + 
                     "INNER JOIN rental ON rentalcopy.rentalID = rental.rentalID " +
                     "INNER JOIN User ON rental.userID = user.userID " +
                     "INNER JOIN book ON book.bookID = rentalcopy.bookID " +
                     "INNER JOIN booktype ON book.typeID = booktype.typeID " +
                     "WHERE rentalcopy.rentalID = ? GROUP BY rental.rentalID";
        Rental rental = null;
        try
        {
            conn = database.getConnection();
            ps = conn.prepareStatement(sql);  
            ps.setInt(1, rentalID);
            rs = ps.executeQuery();

            while(rs.next())
            {
                rental = new Rental();
                rental.setRentID(rs.getInt(1));
                rental.setCustomerName(rs.getString(2));
                rental.setRentDate(rs.getString(3));
                rental.setExpectedDate(rs.getString(4));
                rental.setReturnDate(rs.getString(5));
                rental.setRentFee(rs.getDouble(6));
                rental.setStatus(rs.getString(7));
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
                if(conn!=null)
                    conn.close();
                if(ps!=null)
                ps.close();
                if (rs!=null)
                rs.close();
            }
            catch(Exception ex){}
        }
        return rental;
	}

    public Rental searchRentalFee(int rentalID)
    {
        Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "SELECT name,rentDate,(rentDate + INTERVAL 7 DAY),sum(price),rental.rentalID FROM rental " + 
        "INNER JOIN user ON rental.userID = user.userID " +
        "INNER JOIN rentalcopy ON rental.RentalID = rentalcopy.RentalID " +
        "INNER JOIN Book ON book.BookID = rentalCopy.bookID " +
        "INNER JOIN bookType ON book.typeID = bookType.typeID WHERE rental.rentalID = ? AND rental.status = 'Unpaid'";
        Rental rental = null;
		try
		{
			conn = database.getConnection(); 
			ps = conn.prepareStatement(sql);
			ps.setInt(1,rentalID);
			
			rs = ps.executeQuery();
			if(rs.next())
			{
                rental = new Rental();
				rental.setCustomerName(rs.getString(1));
                rental.setRentDate(rs.getString(2));
                rental.setExpectedDate(rs.getString(3));
                rental.setRentFee(rs.getDouble(4));
                rental.setRentID(rs.getInt(5));
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
                if(conn!=null)
                    conn.close();
            }
            catch(Exception ex){}
        }
        if(rental.getRentDate() == null)
        {
            rental = null;
        }
        return rental;
    }
    //print current date from sql
     public String currentDate()
    {
        Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
	    String sql = "SELECT curDate()";
        String date="";
		try
		{
			conn = database.getConnection(); 
			ps = conn.prepareStatement(sql);
			
			rs = ps.executeQuery();
			if(rs.next())
			{
				date = rs.getString(1);
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
                if(conn!=null)
                    conn.close();
            }
            catch(Exception ex){}
        }
       
        return date;
    }
    
    // search rent with rental status is renting when customer want to return books
    public Rental searchReturnBook(int rentalID)
    {
        Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
	    String sql = "SELECT name,(rentDate + INTERVAL 7 DAY),CURDATE(),rentalID FROM Rental " +
        "INNER JOIN User ON rental.UserID = user.UserID WHERE rentalID = ? AND status = 'Renting'";
        Rental rental = null;
		try
		{
			conn = database.getConnection(); 
			ps = conn.prepareStatement(sql);
			ps.setInt(1, rentalID);
			rs = ps.executeQuery();
			if(rs.next())
			{
				rental = new Rental();
                rental.setCustomerName(rs.getString(1));
                rental.setExpectedDate(rs.getString(2));
                rental.setReturnDate(rs.getString(3));
                rental.setRentID(rs.getInt(4));
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
                if(conn!=null)
                    conn.close();
                if(ps!=null)
                    ps.close();
                if(rs!=null)
                    rs.close();
            }
            catch(Exception ex){}
        }
       
        return rental;
    }
    
    //update overdue fee of rental
    public int updateOverDueFee(double overdueFee, int rentalID)
    {
        Connection conn = null;
		PreparedStatement ps = null;
	    String sql = "Update Rental SET overDueFee = ? , status = 'Overdue' WHERE RentalID = ?";
        int status = 0;

		try
		{
			conn = database.getConnection(); 
			ps = conn.prepareStatement(sql);
            ps.setDouble(1, overdueFee);
			ps.setInt(2, rentalID);
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
                if(conn!=null)
                    conn.close();
                if(ps!=null)
                    ps.close();
            }
            catch(Exception ex){}
        }
        return status;
    }
//count different duration between two date
    public int differentDate(String expectedDate,String returnDate)
    {
        Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
	    String sql = "SELECT DATEDIFF(?,?)";
        int duration=0;
		try
		{
			conn = database.getConnection(); 
			ps = conn.prepareStatement(sql);
			ps.setString(1, returnDate);
            ps.setString(2, expectedDate);
			rs = ps.executeQuery();
			if(rs.next())
			{
				duration = rs.getInt(1);
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
                if(conn!=null)
                    conn.close();
            }
            catch(Exception ex){}
        }
       
        return duration;
    }

    //update rental status to complete
    public int completeStatus(int rentalID)
    {
         Connection conn = null;
		PreparedStatement ps = null;
	    String sql = "Update Rental SET Status = 'Completed', returnDate = CURDATE() WHERE rentalID = ?";
        int status = 0;
		try
		{
			conn = database.getConnection(); 
			ps = conn.prepareStatement(sql);
			ps.setInt(1, rentalID);
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
    //update copyCondition to available after customer return book
    public int returnBook(int bookID,int copyID)
    {
        Connection conn = null;
		PreparedStatement ps = null;
	    String sql = "Update Copy SET copyCondition = 'Available' WHERE bookID = ? AND copyID = ?";
        int status = 0;
		try
		{
			conn = database.getConnection(); 
			ps = conn.prepareStatement(sql);
			ps.setInt(1, bookID);
            ps.setInt(2, copyID);
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
                if(conn!=null)
                    conn.close();
            }
            catch(Exception ex){}
        }
        return status;
    }
    
    //search renting book list of the rental when billing
    public List<Book> searchNotCompleteRentList(Rental rental)
	{
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "SELECT RentalCopy.BookID,RentalCopy.CopyID,Title,TypeName,Author,Price FROM RentalCopy " +
		"INNER JOIN Rental ON rental.rentalID = rentalcopy.rentalID " +
        "INNER JOIN Book ON RentalCopy.BookID = Book.BookID " +
        "INNER JOIN BookType ON Book.TypeID = BookType.TypeID WHERE rental.RentalID = ? AND rental.status = 'Renting'";
        List<Book> BookList = new ArrayList<Book>();
        try
        {
            conn = database.getConnection();
            ps = conn.prepareStatement(sql);  
            ps.setInt(1,rental.getRentID());
            rs = ps.executeQuery();

            while(rs.next())
            {
                Book book = new Book();
                book.setBookID(rs.getInt(1));
                book.setCopyID(rs.getInt(2));
                book.setTypeName(rs.getString(3));
                book.setTitle(rs.getString(4));
                book.setAuthor(rs.getString(5));
                book.setPrice(rs.getInt(6));
                BookList.add(book);
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
                if(conn!=null)
                    conn.close();
            }
            catch(Exception ex){}
        }
        return BookList;
	}
     
    //update unpaid rental's status to renting
    public int updateRenting(int rentalID)
    {
    	Connection conn = null;
 		PreparedStatement ps = null;
 		String sql = "Update Rental SET status = 'Renting' WHERE rentalID = ?";
 		int status = 0;
 		
         try
         {
             conn = database.getConnection();
             ps = conn.prepareStatement(sql);  
             ps.setInt(1,rentalID);
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
                 if(conn!=null)
                     conn.close();
                 if(ps!=null)
                	 ps.close();
             }
             catch(Exception ex){}
         }
         return status;
     }
    
    // search rent by rental ID  with rental status renting
    public Rental searchRenting(int rentalID)
    {
        Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "SELECT name,rentDate,(rentDate + INTERVAL 7 DAY),sum(price),rental.rentalID FROM rental " + 
        "INNER JOIN user ON rental.userID = user.userID " +
        "INNER JOIN rentalcopy ON rental.RentalID = rentalcopy.RentalID " +
        "INNER JOIN Book ON book.BookID = rentalCopy.bookID " +
        "INNER JOIN bookType ON book.typeID = bookType.typeID WHERE rental.rentalID = ? AND rental.status = 'Renting'";
        Rental rental = null;
		try
		{
			conn = database.getConnection(); 
			ps = conn.prepareStatement(sql);
			ps.setInt(1,rentalID);
			
			rs = ps.executeQuery();
			if(rs.next())
			{
                rental = new Rental();
				rental.setCustomerName(rs.getString(1));
                rental.setRentDate(rs.getString(2));
                rental.setExpectedDate(rs.getString(3));
                rental.setRentFee(rs.getDouble(4));
                rental.setRentID(rs.getInt(5));
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
                if(conn!=null)
                    conn.close();
            }
            catch(Exception ex){}
        }
        if(rental.getRentDate() == null)
        {
            rental = null;
        }
        return rental;
    }
}







