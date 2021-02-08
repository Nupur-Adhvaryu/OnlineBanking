package Userdbutil;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.sql.DataSource;

import Model.Account;
import Model.User;
import Model.transaction;
 
public class Userdb {

	private DataSource ds;
	
	public Userdb(DataSource ds){
		this.ds = ds;
	}
	// add a new user
	public void addNewUser(User u) throws SQLException {
		Connection conn =null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			conn = ds.getConnection();
			String sql = "INSERT INTO `UserAccount`(UserId,fName,lName,Email,Address,PCode,DateOfBirth,Password,SINNumber,AccountTotal) VALUES(?,?,?,?,?,?,?,?,?,?)";
			ps=conn.prepareStatement(sql);
			ps.setString(1, u.getId());
			ps.setString(2, u.getfName());
			ps.setString(3, u.getlName());
			ps.setString(4, u.getEmail());
			ps.setString(5, u.getAdd());
			ps.setString(6, u.getpCode());
			ps.setString(7, u.getBirth());
			ps.setString(8, u.getPass());
			ps.setInt(9, u.getSin());
			ps.setDouble(10, u.getAmt());
			ps.executeUpdate();
			
			
			}
		
		catch(SQLException e) {  
			e.printStackTrace();
		}
		finally {
			close(conn,ps,rs);
		}
		
	}
	// get and set the user id
	public String getUserId(User u) throws SQLException 
	{
		String id = "" ;
		Connection conn =null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			conn = ds.getConnection();
			String sql = "SELECT * FROM `UserAccount` WHERE Email like ? AND Password like ?";
			ps=conn.prepareStatement(sql);
			ps.setString(1, u.getEmail());
			ps.setString(2,u.getPass() );
			rs = ps.executeQuery();
			while(rs.next()) {
				id = rs.getString(1);
			}
			}
		
		catch(SQLException e) {  
			e.printStackTrace();
		}
		finally {
			close(conn,ps,rs);
		}
		return id;
		
	}
	// checks if the user exists
		public boolean checkUserExistance(String id, String pass) throws SQLException {
			Connection conn =null;
			PreparedStatement ps = null;
			ResultSet rs = null;
			 try {
				 conn = ds.getConnection();
				 String sql = "SELECT * FROM `useraccount` WHERE userid = ? and password = ?";
				 ps = conn.prepareStatement(sql);
				 ps.setString(1,id);
				 ps.setString(2,pass);
				 rs=ps.executeQuery();
				 while(rs.next()) {
					 return true;
				 }
			 }
			 catch(SQLException e) {  
					e.printStackTrace();
				}
				finally {
					close(conn,ps,null);
				}
			return false;
		}
		// returns a user by an id
		public User getUser(String id) throws SQLException{
			User u = null;
			Connection conn =null;
			PreparedStatement ps = null;
			ResultSet rs = null;
			
			try {
				conn = ds.getConnection();
				String sql = "SELECT * FROM `UserAccount` WHERE userid like ? ";
				ps=conn.prepareStatement(sql);
				ps.setString(1,id);
				rs = ps.executeQuery();
				while(rs.next()) {
					String fname= rs.getString(2);
					String lname= rs.getString(3);
					String email= rs.getString(4);
					String add= rs.getString(5);
					String pCode= rs.getString(6);
					String birth= rs.getString(7);
					String pass= rs.getString(8);
					int sin= rs.getInt(9);
					double amt = rs.getDouble(10);
					u = new User(id,fname,lname,email,add,pCode,birth,pass,sin,amt);
					
				}
				}
			
			catch(SQLException e) {  
				e.printStackTrace();
			}
			finally {
				close(conn,ps,rs);
			}
			return u;
			
		}
		
		//gets all users for admin
		public ArrayList<User> getTheUserList() throws SQLException {
			ArrayList<User> users = new ArrayList<User>();
			Connection conn =null;
			PreparedStatement ps = null;
			ResultSet rs = null;
			 try {
				 conn = ds.getConnection();
				 String sql = "SELECT * FROM `useraccount` ";
				 ps = conn.prepareStatement(sql);
				 rs=ps.executeQuery();
				 while(rs.next()) {
					 String id =rs.getString(1);
						String fname =rs.getString(2);
						String lname =rs.getString(3);
						String email =rs.getString(4);
						String ad =rs.getString(5);
						String pcode=rs.getString(6);
						String birth =rs.getString(7);
						String pass =rs.getString(8);
						int sin =rs.getInt(9);
						double amttotal =rs.getDouble(10);
						User u = new User(id,fname,lname,email,ad,pcode,birth,pass,sin,amttotal);
						users.add(u);
						
				 }
			 }
			 catch(SQLException e) {  
					e.printStackTrace();
				}
				finally {
					close(conn,ps,null);
				}
			return users;
		}
		// it refreshes user account total
		public void refereshUsers() throws SQLException {
			Connection conn =null;
			PreparedStatement ps = null;
			
			
			try {
				conn = ds.getConnection();
				String sql = "Update useraccount a set accounttotal = (select sum(amount) from bankaccounts b group by userid Having a.userid = b.userid ) ; ";
				ps = conn.prepareStatement(sql);
				ps.execute();
				
			}
			catch(SQLException e) {  
				e.printStackTrace();
			}
			finally {
				close(conn,ps,null);
			}
		}
	// adding a new account . 
	public void addNewAccount(Account acc,User u)throws SQLException {
		Connection conn =null;
		PreparedStatement ps = null;
		try {
			
			conn = ds.getConnection();
			String sql = "INSERT into`BankAccounts` VALUES(?,?,?,?,?)";
			ps=conn.prepareStatement(sql);
			ps.setString(1,acc.getId());
			ps.setString(2,u.getId());
			ps.setString(3,acc.getType());
			ps.setDouble(4, acc.getAmt());
			ps.setDate(5,acc.getDate());
			ps.executeUpdate();
		}
		catch(SQLException e) {  
			e.printStackTrace();
		}
		finally {
			close(conn,ps,null);
		}
		
		
	}
	// gets the account for the user with a specific type
	public ArrayList<Account> getTheAccountList(String id,String type) throws SQLException {
		ArrayList<Account> accS = new ArrayList<Account>();
		Connection conn =null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		 try {
			 conn = ds.getConnection();
			 String sql = "SELECT * FROM `bankaccounts` WHERE userid = ? and type = ?";
			 ps = conn.prepareStatement(sql);
			 ps.setString(1,id);
			 ps.setString(2,type);
			 rs=ps.executeQuery();
			 while(rs.next()) {
				 String Accid = rs.getString(1);
				 double amount = rs.getDouble(4);
				 Date date = rs.getDate(5);
				 Account a = new Account(Accid,id,type,amount,date);
				 accS.add(a);
			 }
		 }
		 catch(SQLException e) {  
				e.printStackTrace();
			}
			finally {
				close(conn,ps,null);
			}
		return accS;
	}
	// returns a single account
	public Account getTheAccount(String id) throws SQLException {
		Account a = null;
		Connection conn =null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		 try {
			 conn = ds.getConnection();
			 String sql = "SELECT * FROM `bankaccounts` WHERE accountid = ?";
			 ps = conn.prepareStatement(sql);
			 ps.setString(1,id);
			 rs=ps.executeQuery();
			 while(rs.next()) {
				
				 String uid = rs.getString(2);
				 String type = rs.getString(3);
				 double amount = rs.getDouble(4);
				 Date date = rs.getDate(5);
				 a = new Account(id,uid,type,amount,date);
				 
			 }
		 }
		 catch(SQLException e) {  
				e.printStackTrace();
			}
			finally {
				close(conn,ps,null);
			}
		return a;
	}
	// deposite
	public void deposite(String accountId,Double amt)throws SQLException{
		Connection conn =null;
		PreparedStatement ps = null;
		
		 try {
			 conn = ds.getConnection();
			 String sql = "Update bankaccounts set amount = amount + ? where accountid = ?";
			 ps = conn.prepareStatement(sql);
			 ps.setDouble(1,amt);
			 ps.setString(2,accountId);
			 ps.executeUpdate();
			 }
		 catch(SQLException e) {  
			e.printStackTrace();
	}
	finally {
		close(conn,ps,null);
	}
		 
	}
	//withdraw
	public double withdraw(String accountId,Double amt)throws SQLException{
		Connection conn =null;
		PreparedStatement ps = null;
		
		 try {
			 conn = ds.getConnection();
			 String sql = "Update bankaccounts set amount = amount - ? where accountid = ?";
			 ps = conn.prepareStatement(sql);
			 ps.setDouble(1,amt);
			 ps.setString(2,accountId);
			 ps.executeUpdate();
			 }
		 catch(SQLException e) {  
			e.printStackTrace();
	}
	finally {
		close(conn,ps,null);
	}
		return amt; 
	}
	// transfer
	public void transfer(String givingId,String recievingId,double amt) throws SQLException{
		deposite(recievingId,withdraw(givingId,amt));
	}
	
	//Transaction
	public void addToTranscationHistory(String givingId,String recievingId,double amt,Date date) throws SQLException{
		Connection conn =null;
		PreparedStatement ps = null;
		
		 try {
			 conn = ds.getConnection();
			 String sql = "INSERT INTO transactions(givingId,RecievingId,amt,dateTransfered) VALUES (?,?,?,?)";
			 ps = conn.prepareStatement(sql);
			 ps.setString(1,givingId);
			 ps.setString(2,recievingId);
			 ps.setDouble(3,amt);
			 ps.setDate(4,date);
			 ps.executeUpdate();
			 }
		 catch(SQLException e) {  
			e.printStackTrace();
	}
	finally {
		close(conn,ps,null);
	}
	}
	//recieved history
	public ArrayList<transaction> recievedHistory(String id)  throws SQLException{
		Connection conn =null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<transaction> trs = new ArrayList<transaction>();
		 try {
			 conn = ds.getConnection();
			 String sql = "select t.givingId,t.recievingId,t.amt,t.dateTransfered from transactions t \n" + 
			 		"inner join bankaccounts b on t.recievingId = b.accountId where b.accountId \n" + 
			 		"in (select b.accountId from bankaccounts b where userId like ?)";
			 ps = conn.prepareStatement(sql);
			 ps.setString(1,id);
			 rs = ps.executeQuery();
			 while(rs.next()) {
				 transaction t = new transaction(rs.getString(1),rs.getString(2),rs.getDouble(3),rs.getDate(4));
				 trs.add(t);
			 }
			 
			 }
		 catch(SQLException e) {  
			e.printStackTrace();
	}
	finally {
		close(conn,ps,rs);
	}
		 return trs;
	}
	// sent history
	public ArrayList<transaction> sentHistory(String id)  throws SQLException{
		Connection conn =null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<transaction> trs = new ArrayList<transaction>();
		 try {
			 conn = ds.getConnection();
			 String sql = "select t.givingId,t.recievingId,t.amt,t.dateTransfered from transactions t \n" + 
			 		"inner join bankaccounts b on t.givingId = b.accountId where b.accountId \n" + 
			 		"in (select b.accountId from bankaccounts b where userId like ?)";
			 ps = conn.prepareStatement(sql);
			 ps.setString(1,id);
			 rs = ps.executeQuery();
			 while(rs.next()) {
				 transaction t = new transaction(rs.getString(1),rs.getString(2),rs.getDouble(3),rs.getDate(4));
				 trs.add(t);
			 }
			 
			 }
		 catch(SQLException e) {  
			e.printStackTrace();
	}
	finally {
		close(conn,ps,rs);
	}
		 return trs;
	}

// close	
	private void close(Connection conn, PreparedStatement ps, ResultSet rs) throws SQLException {
		if(conn!=null)
			conn.close();
		if(rs!=null)
			rs.close();
		if(ps!=null)
			ps.close();
		
	}
	
}

