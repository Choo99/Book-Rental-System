package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.User;
//import com.mysql.jdbc.PreparedStatement;

public class UserController {

	private DatabaseConnection database;
    
    public UserController ()
    {
        database = new DatabaseConnection();
    }

    // add new user and will return status to check the new user registration is success or not
    public int addUser(User user)
    {
        int status = 0;
        String sql= "INSERT INTO user(name, ic, phone, role, password, registerDate) VALUES (?, ?, ?, ?, ?, CURDATE())";
        Connection conn =null;
        PreparedStatement ps = null;

        try
        {
            conn = database.getConnection();
            ps = conn.prepareStatement(sql);

            ps.setString(1, user.getName());
            ps.setString(2, user.getIC());
            ps.setString(3, user.getPhone());
            ps.setString(4, user.getRole());
            ps.setString(5, user.getPassword());
            
           status = ps.executeUpdate();
        }
        catch (Exception ex) 
        {
			ex.printStackTrace();
		}        
        finally
        {
            try{
                if(ps!=null)
                     ps.close();
                 if(conn!=null)
                     conn.close();
            }
            catch(Exception e)
            {}
            
        }


       return status;                
    }

    // check the user entered password is same as password in database or not
    // return true if password is correct and user may login
	public boolean checkPassword(int userID, String password)
	{
		String password2="";
		Boolean found=false;
		
		String sql="SELECT password FROM user WHERE userID= ?";
        Connection conn =null;
        PreparedStatement ps = null;

       int row=0;
        
        try{
        	
        conn = database.getConnection();
        
        ps = conn.prepareStatement(sql);
        ps.setInt(1, userID);

        ResultSet rs = ps.executeQuery();
       
        	if(rs.next())
        	{
        		row++;
        		password2=rs.getString(1);  
        	}
        
        	if(row==0)
        	{		
        		return found;
        	}
        
    
		 if(password.equals(password2))
	     {
			 
	        found = true;
	     }
		 
		

        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
		
        finally{
                 try{
                     if (ps != null)
                      ps.close();
            
                       if (conn != null)
                       conn.close();
                      }
                 catch(Exception e)
                     {}
                 }
        
        return found;
    }

    // used to check the user IC is exist or not
    public boolean isUserIDExist(int userID)
    {
        boolean found= false;
        String sql ="SELECT EXISTS (SELECT * FROM user WHERE userID=? )";
        Connection conn =null;
        PreparedStatement ps = null;
        ResultSet rs =null;

        try{
            conn = database.getConnection();
            ps = conn.prepareStatement(sql);

            ps.setInt(1, userID);
            rs = ps.executeQuery();
            rs.next();

             if(rs.getInt(1)==1)
             {
                found = true;
             }
             

        }catch (Exception ex) {
			
			ex.printStackTrace();
		}
         finally
        {
            try{
                if(ps!=null)
                     ps.close();
                if (rs!=null)
                     rs.close();
                 if(conn!=null)
                     conn.close();
            }
            catch(Exception e)
            {}
             
        }
        return found;
    }

// check the new user IC exist or not to avoid duplicate registration
public boolean isUserICExist(String ic)
    {
        boolean found= false;
        String sql ="SELECT EXISTS (SELECT * FROM user WHERE ic=? )";
        Connection conn =null;
        PreparedStatement ps = null;
        ResultSet rs =null;

        try{
            conn = database.getConnection();
            ps = conn.prepareStatement(sql);

            ps.setString(1, ic);
            rs = ps.executeQuery();
            rs.next();

             if(rs.getInt(1)==1)
             {
                found = true;
             }
             

        }catch (Exception ex) {
			
			ex.printStackTrace();
		}
         finally
        {
            try{
                if(ps!=null)
                     ps.close();
                if (rs!=null)
                     rs.close();
                 if(conn!=null)
                     conn.close();
            }
            catch(Exception e)
            {}
             
        }
        return found;
    }

    // to check the user role by userID when login
    public String getUserRole(int userID)
    {
        String sql="SELECT Role FROM User WHERE userID = ?";
        String roleName = "";
        Connection conn =null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try
        {
            conn = database.getConnection();
            ps=conn.prepareStatement(sql);
            ps.setInt(1, userID);
            rs=ps.executeQuery();
            rs.next();
            roleName = rs.getString(1);
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
        finally
        {
            try{
                if(ps!=null)
                     ps.close();
                if (rs!=null)
                     rs.close();
                 if(conn!=null)
                     conn.close();
            }
            catch(Exception e)
            {}
        }
        return roleName;
    }

    // search user info by userID
    public User searchUser(int userID)
    {
        String sql="SELECT name,phone,userID FROM User WHERE UserID = ?";
        Connection conn =null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        int status = 0;

        User user = null;
        try
        {
            conn = database.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, userID);
            rs = ps.executeQuery();
            if(rs.next())
            {
                user = new User();
                user.setName(rs.getString(1));
                user.setPhone(rs.getString(2));
                user.setUserID(rs.getInt(3));
            }
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
        finally
        {
            try{
                if(ps!=null)
                     ps.close();
                if (rs!=null)
                     rs.close();
                 if(conn!=null)
                     conn.close();
            }
            catch(Exception e)
            {}
        }
        return user;
    }

    // update user info by id
    public int updateAccount(User user)
    {
        String sql="Update User SET name = ?,phone = ? WHERE userID = ?";
        Connection conn =null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        int status = 0;

        try
        {
            conn = database.getConnection();
            ps=conn.prepareStatement(sql);
            ps.setString(1, user.getName());
            ps.setString(2, user.getPhone());
            ps.setInt(3, user.getUserID());
            status = ps.executeUpdate();
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
        finally
        {
            try{
                if(ps!=null)
                     ps.close();
                if (rs!=null)
                     rs.close();
                 if(conn!=null)
                     conn.close();
            }
            catch(Exception e)
            {}
        }
        return status;
    }


    // to get new user id and display to allow new user login
    public int getNewUserID()
    {
        String sql="SELECT MAX(userID) FROM user";
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        int userID = 0;

        try
        {
            conn = database.getConnection();
            ps=conn.prepareStatement(sql);
            rs= ps.executeQuery();
            rs.next();
            userID=rs.getInt(1);

        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
        finally
        {
            try{
                if(ps!=null)
                     ps.close();
                if (rs!=null)
                     rs.close();
                 if(conn!=null)
                     conn.close();
            }
            catch(Exception e)
            {}
        }
        return userID;
    }



}
