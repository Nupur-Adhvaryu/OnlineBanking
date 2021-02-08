package LoginController;

import java.io.IOException;
import java.sql.SQLException;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import Model.Account;
import Model.User;
import Userdbutil.Userdb;

/**
 * Servlet implementation class registration
 */
public class registration extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Resource(name="jdbc/Bank")
	private DataSource ds;
	private Userdb udb;
	private String fName;
	private String lName;
	private String email;
	private String add;
	private String pCode;
	private String birth;
	private String pass;
	private int sin;
	private double amt;

	public void init() throws ServletException{
	  	   super.init();
	  	   try {
	  		   udb = new Userdb(ds);
	  		   
	  	   }
	  	   catch(Exception ex) {
	  		   throw new ServletException(ex);
	  	   }
	     }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		fName = request.getParameter("fname");
		lName = request.getParameter("lname");
		email = request.getParameter("email");
		add = request.getParameter("add");
		pCode = request.getParameter("pcode");
		birth= request.getParameter("birth");
		pass = request.getParameter("pass");
		sin = Integer.parseInt(request.getParameter("sin"));
		amt = Integer.parseInt(request.getParameter("amt"));
		User u = new User(fName,lName,email,add,pCode,birth,pass,sin,amt);
		try {
			if(udb.checkUserExistance(u.getId(), pass)) {
				response.sendRedirect("registration.jsp");
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Account acc = new Account("Checking",amt);
		try {
			// user will be added and will get a new Id with it
			udb.addNewUser(u);
			// the user will get a new account with the amount he/she specified - (for now a checking account)
			udb.addNewAccount(acc,u);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Cookie a = new Cookie("id",u.getId());
		Cookie c = new Cookie("user",u.getfName());
		c.setMaxAge(5*60);
		a.setMaxAge(5*60);
		response.addCookie(c); 
		response.addCookie(a);
		response.sendRedirect("registration1.jsp");
	}

}