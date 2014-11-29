package login;

import java.sql.*;

/**
 * Servlet implementation class Validate
 */

public class Validate
{
    public static boolean checkUser(String email,String pass) 
    {
     boolean st =false;
     try{
    	 
	 //loads the mysql-java-connector
        Class.forName("com.mysql.jdbc.Driver");

	 //creating connection with the database 
        Connection con=DriverManager.getConnection
                       ("jdbc:mysql://localhost:3306/users","root","MysqlPass");
        PreparedStatement ps =con.prepareStatement
                            ("select * from websiteusers where email=? and pass=?");
        ps.setString(1, email);
        ps.setString(2, pass);
        ResultSet rs =ps.executeQuery();
        st = rs.next();
       
     }catch(Exception e)
     {
    	 //making error handling easier (writes to javadoc)
         e.printStackTrace();
     }
        return st;                 
 }   
}