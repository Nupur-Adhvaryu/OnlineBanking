package AccountController;

import java.io.IOException;
import java.sql.SQLException;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import Userdbutil.Userdb;

/**
 * Servlet implementation class MainPageProcessor
 */

public class MainPageProcessor extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Resource(name="jdbc/Bank")
	private DataSource ds;
	private Userdb udb;
       
    
	public void init() throws ServletException{
	  	   super.init();
	  	   try {
	  		   udb = new Userdb(ds);
	  		   
	  	   }
	  	   catch(Exception ex) {
	  		   throw new ServletException(ex);
	  	   }
	     }
    public MainPageProcessor() {
        super();
            }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Cookie error=null;
		int e = 5;
		String id = request.getParameter("userid");
		String pass = request.getParameter("pass");
		Cookie userId = null;
		Cookie  fname = null;
		Cookie[] c = request.getCookies();
		if(c!=null){
			for(Cookie cookie:c){
				if(cookie.getName().equals("user")) {
					fname = cookie;
				}
				if(cookie.getName().equals("id")){
				userId= cookie;
		
				}
				if(cookie.getName().equals("error")){
						error = cookie;
				}
				
			}
		}
		if(id == null && pass == null) {
				if(fname == null || userId == null) {
					response.sendRedirect("WelcomeError.jsp");
				}
				else {
					fname.setMaxAge(5*60);
					userId.setMaxAge(5*60);
					response.addCookie(fname);
					response.addCookie(userId);
					response.sendRedirect("MainPage");
					}
			}
		else {
			try {
				if(udb.checkUserExistance(id,pass)) {
					userId=new Cookie("id",id);
					fname= new Cookie("user",(udb.getUser(id)).getfName());
					fname.setMaxAge(5*60);
					userId.setMaxAge(5*60);
					response.addCookie(fname);
					response.addCookie(userId);
					response.sendRedirect("MainPage");
				}
				else {
					if(error==null) {
					error = new Cookie("error",String.valueOf(e));
					error.setMaxAge(5*60);
					response.addCookie(error);
					}
					else {
						e = Integer.parseInt(error.getValue());
					}
					if(e<=0) {
						response.sendRedirect("Blocked.jsp");
					}
					else {
					if(error!= null) {	
					
					e =e-1;
					error = new Cookie("error",String.valueOf(e));
					error.setMaxAge(5*60);
					response.addCookie(error);
					response.sendRedirect("WelcomeError.jsp");
					}
				}
					}
			} catch (SQLException f) {
				f.printStackTrace();
			}
		}
		}
	}


