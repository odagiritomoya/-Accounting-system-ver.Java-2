package com.example.demo.security.login;

public class Form {
	private Integer userId;
	private String userName;
	private Integer companyId;
	private Integer companyName;
	private String authority;
	private String password;
	
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public Integer getCompanyId() {
		return companyId;
	}
	public void setCompanyId(Integer companyId) {
		this.companyId = companyId;
	}
	public Integer getCompanyName() {
		return companyName;
	}
	public void setCompanyName(Integer companyName) {
		this.companyName = companyName;
	}
	public String getAuthority() {
		return authority;
	}
	public void setAuthority(String authority) {
		this.authority = authority;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
