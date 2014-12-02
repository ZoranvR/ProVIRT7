package dao;



import java.sql.*;



public class Mysql {
	//Database location:
	static final String DB_URL = "jdbc:mysql://localhost/websiteusers";
	
	//Database Connection
	static final String USER = "root";
	static final String PASS = "";
	static Connection conn = null;

	
	protected static Connection mysqlConn() throws Exception {
		
		Class.forName("com.mysql.jdbc.Driver");
		if (conn != null){
			return conn;
		}
		
		try{
			
			 //creating connection with the database 
		  conn = DriverManager.getConnection(DB_URL,USER,PASS);
			
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return conn;
	}
}
