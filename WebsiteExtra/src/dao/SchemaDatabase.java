package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SchemaDatabase {

	public static boolean checkUser(String email, String pass) throws SQLException {
		boolean st = false;
		Connection conn = null;
		try {
			// Trying to make a connection and store it in conn
			conn = Mysql.mysqlConn();
			PreparedStatement ps = conn
					.prepareStatement("select * from websiteusers where email=? and pass=?");
			ps.setString(1, email);
			ps.setString(2, pass);
			ResultSet rs = ps.executeQuery();
			st = rs.next();
			
			// Close database connection
			conn.close();

		} catch (Exception e) {
			// Prints Exception
			e.printStackTrace();
		}
		finally{
			//  Close connection if it isn't closed yet.
			if(conn != null) conn.close();
		}
		// Returns True or False for checklogin
		return st;

	}

}
