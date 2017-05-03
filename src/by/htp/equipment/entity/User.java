package by.htp.equipment.entity;

public class User {
	
	private String  login;
	private String password;
	private boolean role;
	
	public User() {
		
	}
	
	public User(String login, String password, boolean role) {
		super();
		this.login = login;
		this.password = password;
		this.role = role;
	}
	
	public boolean isRole() {
		return role;
	}

	public void setRole(boolean role) {
		this.role = role;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
