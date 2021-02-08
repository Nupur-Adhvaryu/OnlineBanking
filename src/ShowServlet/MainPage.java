package ShowServlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;

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
 * Servlet implementation class MainPage
 */
public class MainPage extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Resource(name="jdbc/Bank")
	private DataSource ds;
	private Userdb udb;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MainPage() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    public void init() throws ServletException{
    	
	  	   super.init();
	  	   try {
	  		   udb = new Userdb(ds);
	  		   
	  	   }
	  	   catch(Exception ex) {
	  		   throw new ServletException(ex);
	  	   }
	     }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<Account> CheckingAcc = null;
		ArrayList<Account> SavingAcc = null;
		 String fName = "";
		 String id = "";
		
		Cookie[] c = request.getCookies();
		if(c!=null){

			for(Cookie cookie:c){
				if(cookie.getName().equals("user")){
					fName =cookie.getValue();
				}
			}
			
		
		for(Cookie cookie:c){
			if(cookie.getName().equals("id")){
				id =cookie.getValue();
				}
		}
		}
		if(fName==null&&id==null) {
			response.sendRedirect("SessionTimeOutError.jsp");
		}
		else {
		PrintWriter pw = response.getWriter();
		response.setContentType("text/html");
		String docType =
		         "<!doctype html public \"-//w3c//dtd html 4.0 " + "transitional//en\">\n";
		         
		 pw.println(docType +
		         "<html>\n" +
		            "<head><title></title>");
		 pw.println("<link type=\"text/css\" rel=\"stylesheet\" href=\"style/main.css\">");
		 pw.println("<style> "
		 		+ "body {\n" + 
		 		"  font-family: Arial, Helvetica, sans-serif;\n" + 
		 		"} \n" + 
		 		"\n" + 
		 		".navbar {\n" + 
		 		"  overflow: hidden;\n" + 
		 		"  background-color: #333;\n" + 
		 		"}\n" + 
		 		"\n" + 
		 		".navbar a {\n" + 
		 		"  float: left;\n" + 
		 		"  font-size: 16px;\n" + 
		 		"  color: white;\n" + 
		 		"  text-align: center;\n" + 
		 		"  padding: 14px 16px;\n" + 
		 		"  text-decoration: none;\n" + 
		 		"}\n" + 
		 		"\n" + 
		 		".dropdown {\n" + 
		 		"  float: left;\n" + 
		 		"  overflow: hidden;\n" + 
		 		"}\n" + 
		 		"\n" + 
		 		".dropdown .dropbtn {\n" + 
		 		"  font-size: 16px;  \n" + 
		 		"  border: none;\n" + 
		 		"  outline: none;\n" + 
		 		"  color: white;\n" + 
		 		"  padding: 14px 16px;\n" + 
		 		"  background-color: inherit;\n" + 
		 		"  font-family: inherit;\n" + 
		 		"  margin: 0;\n" + 
		 		"}\n" + 
		 		"\n" + 
		 		".navbar a:hover, .dropdown:hover .dropbtn {\n" + 
		 		"}\n" + 
		 		"\n" + 
		 		".dropdown-content {\n" + 
		 		"  display: none;\n" + 
		 		"  position: absolute;\n" + 
		 		"  background-color: #f9f9f9;\n" + 
		 		"  min-width: 160px;\n" + 
		 		"  box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);\n" + 
		 		"  z-index: 1;\n" + 
		 		"}\n" + 
		 		"\n" + 
		 		".dropdown-content a {\n" + 
		 		"  float: none;\n" + 
		 		"  color: black;\n" + 
		 		"  padding: 12px 16px;\n" + 
		 		"  text-decoration: none;\n" + 
		 		"  display: block;\n" + 
		 		"  text-align: left;\n" + 
		 		"}\n" + 
		 		"\n" + 
		 		".dropdown-content a:hover {\n" + 
		 		"  background-color: #ddd;\n" + 
		 		"}\n" + 
		 		"\n" + 
		 		".dropdown:hover .dropdown-content {\n" + 
		 		"  display: block;\n" + 
		 		"}"
		 		+ "</style>" 
		 		+"</head>");
		 
		            pw.println("<body>") ;
		            
		pw.print("<div class=\"navbar\">\n" + 
				"  <a href=\"#\"><form action = \"MainPage\" method = \"POST\"><input type = \"hidden\" value=\"add\" name = \"way\"><input type = \"submit\" name = \"submit\" value = \"Create a new Savings account\"> </form>" + 
				"		</a>\n" + 
				
				"  <a href=\"#\"><form action = \"MainPage\" method = \"POST\"><input type = \"hidden\" value=\"transfer\" name = \"way\"><input type = \"submit\" name = \"submit\" value = \"Transfer Money\"> </form> </a>\n" + 
				"  <div class=\"dropdown\">\n" + 
				"    <button class=\"dropbtn\">My Account\n" + 
				"      <i class=\"fa fa-caret-down\"></i>\n" + 
				"    </button>\n" + 
				"    <div class=\"dropdown-content\">\n" + 
				"      <a href=\"#\"><form action = \"profile.jsp\" method = \"POST\"><input type = \"submit\" name = \"submit\" value = \"My Profile\"> </form></a>\n" + 
				"      <a href=\"#\"><form action = \"ContactUs.jsp\" method = \"POST\"><input type = \"submit\" name = \"submit\" value = \"Contact us\"> </form></a>\n" + 
				"      <a href=\"#\"><form action = \"MainPage\" method = \"POST\"><input type = \"hidden\" value=\"history\" name = \"way\"><input type = \"submit\" name = \"submit\" value = \"Show My History\"> </form></a>\n" + 

				"    </div>\n" + 
				"  </div> \n" + 
				"</div>\n");
		pw.print("<h1> Hello "+fName+"</h1>");
		try {
			 CheckingAcc = udb.getTheAccountList(id, "Checking");
			 SavingAcc = udb.getTheAccountList(id, "Saving");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// checking account
		if(CheckingAcc!=null) {
		pw.print("<h2>Your Checking Account</h2>");
		pw.print("<table>");
		pw.print("<tr>");
		pw.print("<th>ID</th>");
		pw.print("<th>Amount</th>");
		pw.print("<th>Date Created</th>");
		pw.print("</tr>");
		for(int i = 0 ;i < CheckingAcc.size();i++) {
			pw.print("<tr>");
			pw.print("<td>");
			pw.print(CheckingAcc.get(i).getId());
			pw.print("</td>");
			pw.print("<td>");
			pw.print(CheckingAcc.get(i).getAmt());
			pw.print("</td>");
			pw.print("<td>");
			pw.print(CheckingAcc.get(i).getDate());
			pw.print("</td>");
			pw.print("</tr>");
			
		}
		pw.print("</table>");
		}
		// saving account
		if(SavingAcc!=null) {
		pw.print("<h2>Your Saving Account</h2>");
		pw.print("<table>");
		pw.print("<tr>");
		pw.print("<th>ID</th>");
		pw.print("<th>Amount</th>");
		pw.print("<th>Date Created</th>");
		pw.print("</tr>");
		for(int i = 0 ;i < SavingAcc.size();i++) {
			pw.print("<tr>");
			pw.print("<td>");
			pw.print(SavingAcc.get(i).getId());
			pw.print("</td>");
			pw.print("<td>");
			pw.print(SavingAcc.get(i).getAmt());
			pw.print("</td>");
			pw.print("<td>");
			pw.print(SavingAcc.get(i).getDate());
			pw.print("</td>");
			pw.print("</tr>");
		}
		pw.print("</table>");
		}
		//pw.print("<form action = \"MainPage\" method = \"POST\"><input type = \"hidden\" value=\"add\" name = \"way\"><input type = \"submit\" name = \"submit\" value = \"Create a new Savings account\"> </form>");
		//pw.print("<form action = \"MainPage\" method = \"POST\"><input type = \"hidden\" value=\"transfer\" name = \"way\"><input type = \"submit\" name = \"submit\" value = \"Transfer Money\"> </form>");
		//pw.print("<form action = \"MainPage\" method = \"POST\"><input type = \"hidden\" value=\"history\" name = \"way\"><input type = \"submit\" name = \"submit\" value = \"Show My History\"> </form>");
		//pw.print("<form action = \"MainPage\" method = \"POST\"><input type = \"hidden\" value=\"profile\" name = \"way\"><input type = \"submit\" name = \"submit\" value = \"My Profile\"> </form>");
		pw.print("<form action = \"Logout\"><input type = \"submit\" name = \"submit\" value = \"Logout\"> </form>");
		pw.print("</body>");
		pw.print("</html>");
		pw.close();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<Account> CheckingAcc = null;
		ArrayList<Account> SavingAcc = null;
		 ArrayList<transaction> sentHistory = null;
		 ArrayList<transaction> recievedHistory = null;
		
		String fName = "";
		 String id = "";
		Cookie[] c = request.getCookies();
		if(c!=null){

			for(Cookie cookie:c){
				if(cookie.getName().equals("user")){
					fName =cookie.getValue();
				}
			}
			
		
		for(Cookie cookie:c){
			if(cookie.getName().equals("id")){
				id =cookie.getValue();
				}
		}
		}
		if(fName==null&&id==null) {
			response.sendRedirect("SessionTimeOutError.jsp");
		}
		else {
		try {
			 CheckingAcc = udb.getTheAccountList(id, "Checking");
			 SavingAcc = udb.getTheAccountList(id, "Saving");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("cAcc", CheckingAcc);
		request.setAttribute("sAcc", SavingAcc);
		String way = request.getParameter("way");
		if(way.equals("transfer")){
			request.getRequestDispatcher("transfer.jsp").forward(request, response);
		}
		if(way.equals("add")){
		request.getRequestDispatcher("AddAccount.jsp").forward(request, response);
		}
		if(way.equals("history")){
			try {
				sentHistory = udb.sentHistory(id);
				recievedHistory = udb.recievedHistory(id);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			request.setAttribute("sent",sentHistory);
			request.setAttribute("recieved",recievedHistory);
			request.getRequestDispatcher("transactionHistory.jsp").forward(request, response);
			}
		if(way.equals("profile")) {
			try {
				User u = udb.getUser(id);
				request.setAttribute("user",u);
				request.getRequestDispatcher("profile.jsp").forward(request, response);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}}

}
