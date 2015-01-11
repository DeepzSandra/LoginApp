package model;

public class Account {
	private String username;
	private String password;
	private boolean member;//true if account=clubmember false if Freeaccount
	private int id;
	
	public Account(String username, String password,boolean member) {
		this.username = username;
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public boolean isMember(){
		return member;
	}
	
	
}
