package com.coforge;

public class User {
private String userId;
private String email;
private String password;
private String mobile;
private String uname;
public User(String userId, String uname,String password, String email, String mobile) {
	super();
	this.userId = userId;
	this.uname = uname;
	this.email = email;
	this.password = password;
	this.mobile = mobile;
}
public String getUname() {
	return uname;
}
public void setUname(String uname) {
	this.uname = uname;
}
public String getUserId() {
	return userId;
}
public void setUserId(String userId) {
	this.userId = userId;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public String getMobile() {
	return mobile;
}
public void setMobile(String mobile) {
	this.mobile = mobile;
}

}
