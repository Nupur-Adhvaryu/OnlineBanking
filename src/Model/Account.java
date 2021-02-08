package Model;
import java.io.Serializable;
import java.sql.Date;
public class Account implements Serializable {
 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
 
 private String UserId;
 private String Id;
 private String type;
 private double amt;
 private Date dateCreated;
 private String[] s =  {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X",
			"Y", "Z"};
 // to create a new account
public Account(String type, double amt) {
	String id;
	 int p = (int)(Math.random()*s.length);
	  id = s[p];
	   for(int i = 1;i<10;i++) {
		   if(i%2==0) {
			   int j = (int)(Math.random()*s.length);
			   id = id +s[j];
		   }
		   else {
			 int j = (int)(Math.random()*9);
			id = id + j;
		   }
	   }
			   
	this.Id = id;	   
	this.type = type;
	this.amt = amt;
	java.util.Date uDate = new java.util.Date();
	this.dateCreated = new Date(uDate.getTime());
}
// to get the existing account
public Account(String id, String userId, String type, double amt, Date dateCreated) {
	this.Id = id;
	this.UserId = userId;
	this.type = type;
	this.amt = amt;
	this.dateCreated = dateCreated;
}
public String getType() {
	return type;
}
public void setType(String type) {
	this.type = type;
}
public double getAmt() {
	return amt;
}
public void setAmt(double amt) {
	this.amt = amt;
}
public String getId() {
	return this.Id;
}
 public Date getDate() {
	 return this.dateCreated;
 }
 
}
