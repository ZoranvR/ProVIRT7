package login;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
import javax.servlet.http.Cookie;

/**
 * Servlet implementation class Welcome
 */

public class Welcome extends HttpServlet {

    
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        Cookie ck[]=request.getCookies();
		if(ck!=null){
		 String email=ck[0].getValue();
		if(!email.equals("")||email!=null){
			out.print("<b>Welcome to Profile</b>");
			out.print("<br>Welcome, "+email);
		}
		}else{
			out.print("Please login first");
			request.getRequestDispatcher("login.html").include(request, response);
		}
		out.close();
      }  
}
