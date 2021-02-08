package Model;

import java.io.Serializable;

public class User implements Serializable {
	private static final long serialVersionUID = 1L;
	private String id;
	private String fName;
	private String lName;
	private String email;
	private String add;
	private String pCode;
	private String birth;
	private String pass;
	private int sin;
	private double amt;
	public User() {}
	// to ,make a existing user
	public User(String id,String fName, String lName, String email, String add, String pCode, String birth, String pass,int sin,double a) {
		this.id= id;		   
		this.fName = fName;
		this.lName = lName;
		this.email = email;
		this.add = add;
		this.pCode = pCode;
		this.birth = birth;
		this.pass = pass;
		this.sin = sin;
		this.amt = a;
	}
	// to create a new user
	public User(String fName, String lName, String email, String add, String pCode, String birth, String pass,
			int sin,double a) {
		String id = fName;
		   for(int i = 1;i<10;i++) {
				 int j = (int)(Math.random()*9);
				id = id + j;
			   
		   }
		this.id= id;		   
		this.fName = fName;
		this.lName = lName;
		this.email = email;
		this.add = add;
		this.pCode = pCode;
		this.birth = birth;
		this.pass = pass;
		this.sin = sin;
		this.amt = a;
	}
	public void setId(String i) {
		this.id = i;
	}
	public String getId() {
		return this.id;
	}
	public String getfName() {
		return fName;
	}
	public void setfName(String fName) {
		this.fName = fName;
	}
	public String getlName() {
		return lName;
	}
	public void setlName(String lName) {
		this.lName = lName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAdd() {
		return add;
	}
	public void setAdd(String add) {
		this.add = add;
	}
	public String getpCode() {
		return pCode;
	}
	public void setpCode(String pCode) {
		this.pCode = pCode;
	}
	public String getBirth() {
		return birth;
	}
	public void setBirth(String birth) {
		this.birth = birth;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public int getSin() {
		return sin;
	}
	public void setSin(int sin) {
		this.sin = sin;
	}
	public double getAmt() {
		return amt;
	}
	public void setAmt(int amt) {
		this.amt = amt;
	}
	
	
	
	
}
