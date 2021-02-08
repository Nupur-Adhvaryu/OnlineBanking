package Model;

import java.io.Serializable;
import java.sql.Date;

public class transaction implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String gId;
	private String rId;
	private Double amt;
	private Date dateCreated;
	
	
	public transaction(String gId, String rId, Double amt) {
		this.gId = gId;
		this.rId = rId;
		this.amt = amt;
		java.util.Date uDate = new java.util.Date();
		this.dateCreated = new Date(uDate.getTime());
	}
	public transaction(String gId, String rId, Double amt, Date dateCreated) {
		this.gId = gId;
		this.rId = rId;
		this.amt = amt;
		this.dateCreated = dateCreated;
	}



	public String getgId() {
		return gId;
	}



	public void setgId(String gId) {
		this.gId = gId;
	}



	public String getrId() {
		return rId;
	}



	public void setrId(String rId) {
		this.rId = rId;
	}



	public Double getAmt() {
		return amt;
	}



	public void setAmt(Double amt) {
		this.amt = amt;
	}



	public Date getDateCreated() {
		return dateCreated;
	}



	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}
	
}
