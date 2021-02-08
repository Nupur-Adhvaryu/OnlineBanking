package LoginController;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import Model.User;
import Userdbutil.Userdb;

/**
 * Servlet implementation class AdminLogin
 */
public class AdminLogin extends HttpServlet {
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
   
    public AdminLogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<User> users = null;
		String id = request.getParameter("adminid");
		String pass = request.getParameter("adminpass");
		
		
		if(id.equals("HIMad123")&& pass.equals("qwerty")) {
			
			Cookie admin = new Cookie("adminID",id);
			admin.setMaxAge(60);
			response.addCookie(admin);
			
			try {
				 users = udb.getTheUserList();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			request.setAttribute("users",users);
			request.getRequestDispatcher("showUsers.jsp").forward(request, response);
		}
	}

}
