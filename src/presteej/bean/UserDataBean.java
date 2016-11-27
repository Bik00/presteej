package presteej.bean;

import java.sql.Timestamp;

public class UserDataBean {
	private String userId;
    private String userPassword;
    private String userName;
    private String userCellNo;
	private String mail1;
    private String mail2;
    private String Birthyy;
    private String Birthmm;
    private String Birthdd;
	private Timestamp userCreatedDate;
	
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserCellNo() {
		return userCellNo;
	}
	public void setUserCellNo(String userCellNo) {
		this.userCellNo = userCellNo;
	}
	public String getMail1() {
		return mail1;
	}
	public void setMail1(String mail1) {
		this.mail1 = mail1;
	}
	public String getMail2() {
		return mail2;
	}
	public void setMail2(String mail2) {
		this.mail2 = mail2;
	}
	public String getBirthyy() {
		return Birthyy;
	}
	public void setBirthyy(String birthyy) {
		Birthyy = birthyy;
	}
	public String getBirthmm() {
		return Birthmm;
	}
	public void setBirthmm(String birthmm) {
		Birthmm = birthmm;
	}
	public String getBirthdd() {
		return Birthdd;
	}
	public void setBirthdd(String birthdd) {
		Birthdd = birthdd;
	}
	
    public Timestamp getUserCreatedDate() {
		return userCreatedDate;
	}
	public void setUserCreatedDate(Timestamp userCreatedDate) {
		this.userCreatedDate = userCreatedDate;
	}
}