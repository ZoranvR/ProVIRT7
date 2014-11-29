package register;

import java.io.*;  
import java.sql.*;  
import javax.servlet.*;  
import javax.servlet.http.*;
  
public class Register extends HttpServlet {  
public void doPost(HttpServletRequest request, HttpServletResponse response)  
            throws ServletException, IOException {  
  
response.setContentType("text/html");  
PrintWriter out = response.getWriter();  
          
String firstname = request.getParameter("firstname");  
String lastname = request.getParameter("lastname");  
String email = request.getParameter("email");
String town = request.getParameter("town");  
String street = request.getParameter("street"); 
String housenumber = request.getParameter("housenumber"); 
String zipcode = request.getParameter("zipcode");
String password = request.getParameter("password"); 
          
try{
	 
//loads the mysql-java-connector
   Class.forName("com.mysql.jdbc.Driver");

//creating connection with the database 
   Connection con=DriverManager.getConnection
                  ("jdbc:mysql://localhost:3306/users","root","Vcsdixf1!!");  
  
PreparedStatement ps=con.prepareStatement("insert into websiteusers (firstname,lastname,email,town,street,housenumber,zipcode,pass) VALUES (?,?,?,?,?,?,?,?);");  
  
ps.setString(1, firstname);  
ps.setString(2, lastname);  
ps.setString(3, email);  
ps.setString(4, town);
ps.setString(5, street);  
ps.setString(6, housenumber);  
ps.setString(7, zipcode);  
ps.setString(8, password);
          
int i=ps.executeUpdate();  
if(i>0)  
out.print("You are successfully registered...");  
      
          
}catch (Exception e2) {System.out.println(e2);}  
          
out.close();  
}  
  
}  