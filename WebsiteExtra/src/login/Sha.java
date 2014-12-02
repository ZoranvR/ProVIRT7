package login;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.security.*;

public class Sha
{
	String hashedpass = pass;
	public String hashedpass( String key ) {
	    try {
	        MessageDigest md = MessageDigest.getInstance( "SHA1" );
	        md.update( key.getBytes() );
	        return new hashedpass( 1, md.digest() ).toString(16);
	    }
	    catch (NoSuchAlgorithmException e) {
	        // error handler
	    }
	}
}
