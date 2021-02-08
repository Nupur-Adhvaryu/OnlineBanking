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

import Model.Account;
import Model.User;
import Model.transaction;
import Userdbutil.Userdb;

/**
 * Servlet implementation class AddAcc
 */
public class AddAcc extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Resource(name="jdbc/Bank")
	private DataSource ds;
	private Userdb udb;   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddAcc() {
        super();
        // TODO Auto-generated constructor stub
    }
    public void init() throws ServletException{
    	
	  	   super.init();
	  	   try {
	  		   udb = new Userdb(ds);
	  		   
	  	   }
	  	   catch(Exception ex) {
	  		   throw new ServletException(ex);
	  	   }
	     }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String fName = "";
		String uid = "";
			Cookie[] c = request.getCookies();
			if(c!=null){

				for(Cookie cookie:c){
					if(cookie.getName().equals("user")){
						fName =cookie.getValue();
					}
				}
				
			
			for(Cookie cookie:c){
				if(cookie.getName().equals("id")){
					uid =cookie.getValue();
					}
			}
			}
			if(fName ==null && uid == null) {
				response.sendRedirect("SessionTimeOutError.jsp");
			}
			else {
			String type = request.getParameter("type");
			String givingId = request.getParameter("id");
			double transcAmt = Double.parseDouble(request.getParameter("amt"));
			Account a = new Account(type,0);
			try {
				User u = udb.getUser(uid);
				Account b = udb.getTheAccount(givingId);
				if(b.getAmt()<transcAmt) {
					response.sendRedirect("Error.jsp");
				}
				else {
				udb.addNewAccount(a, u);
				udb.transfer(givingId,a.getId(),transcAmt);
				transaction t = new transaction(givingId,a.getId(),transcAmt);
				udb.addToTranscationHistory(t.getgId(),t.getrId(),t.getAmt(),t.getDateCreated());
				udb.refereshUsers();
				response.sendRedirect("MainPage");
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			}	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
