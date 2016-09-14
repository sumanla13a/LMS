package edu.mum.cs.cs401.entity;

public class User {
	private String userName;
	private String password;
	private String fullName;
	private String role;
	
	public User(){}
	
	public User(String userName, String password, String fullName, String role) {
		super();
		this.userName = userName;
		this.password = password;
		this.fullName = fullName;
		this.role = role;
	}
	
	public boolean hasRole(String role){
		return getRole().contains(role);
	}

	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	@Override
	public String toString() {
		return "User [userName=" + userName + ", fullName=" + fullName + ", role=" + role + "]";
	}
}
