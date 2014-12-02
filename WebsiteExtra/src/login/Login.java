package login;

import java.io.*;

import javax.servlet.*;
import javax.servlet.http.*;

import java.sql.*;

import javax.servlet.http.Cookie;

import dao.*;

/**
 * Servlet implementation class Login
 */
public class Login extends HttpServlet {

    //Called by the server (via the service method) to allow a servlet to handle a POST request.
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    //gives an exception to the servlet which it can throw it encounters difficulty.
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        String email = request.getParameter("email");
        String pass = request.getParameter("pass");
        //asks the Validate.checkUser if the login is valid. 
        try {
			if(SchemaDatabase.checkUser(email, pass))
			{
				Cookie ck=new Cookie("email",email);
				response.addCookie(ck);
				ck.setMaxAge(1800);
			    RequestDispatcher rs = request.getRequestDispatcher("Welcome");
			    rs.forward(request, response);
			}
			else
			{
			   out.println("Username or Password incorrect");
			   RequestDispatcher rs = request.getRequestDispatcher("login.html");
			   rs.include(request, response);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
       
    }  
}
