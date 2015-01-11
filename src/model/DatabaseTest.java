package model;

public class DatabaseTest {

	public static void main(String [] args) {
		Database db = new Database();
		String username = "user1";
		String password = "pass1";
		String firstName = "Susan";
		String lastName = "Jaicks";
		String email = "ak12ka@hotmail.com";
		
		FreeAccount fa = new FreeAccount(username,password,firstName,lastName,email);
		FreeAccount fa1= new FreeAccount("user2","pass2","David","Natta","1u3u32@hotmail.com");
		FreeAccount fa2= new FreeAccount("user3","pass3","Mark","Jue","dfads@hotmail.com");
		try {
			db.connect();
			//db.addFreeAccount(fa);
			db.addAccount(fa);
			db.addAccount(fa1);
			db.addAccount(fa2);
			db.displayDB();
			db.disconnect();
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}
}
