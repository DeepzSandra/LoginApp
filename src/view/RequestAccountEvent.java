package view;

import java.util.EventObject;

import model.Account;

public class RequestAccountEvent extends EventObject{
	private Account account;
	
	public RequestAccountEvent(Object source){
		super(source);
	}
	
	public RequestAccountEvent(Object source,Account account){
		super(source);
		this.account = account;
	}	
	
	public Account getAccount(){
		return account;
	}
	
	public String toString(){
		return account.toString();
	}
}
