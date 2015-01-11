package controller;

import java.sql.SQLException;

import model.Account;
import model.Database;
import model.FreeAccount;

public class Controller {
	
	private Database db = new Database();
	
	public Controller(){
		
	}
	
	
	public void connect() throws Exception{
		db.connect();
	}
	
	public void disconnect(){
		db.disconnect();
	}
	
	public boolean isExistingAccount(Account account){
		boolean w = db.isAccountTaken(account);
		System.out.println("isExistingAccount ="+w);
		return w;
	}
	
	public boolean isValidLogin(Account account){
		boolean w = db.isValidLogin(account);
		System.out.println("isValidLogin ="+w);
		return w;

	}
	
	public void addAccount(Account account){
		try {
			db.addAccount(account);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
}
