package by.htp.equipment.entity;

public class User {
	
	private Long userId;
	private String  login;
	private String password;
	private boolean role;
	
	private String firstName;
	private String name;
	private String secondName;
	private String passport;
	
	public User() {
		
	}
	
	public User(Long userId, String login, String password, boolean role) {
		super();
		this.userId = userId;
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
	
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getSecondName() {
		return secondName;
	}

	public void setSecondName(String secondName) {
		this.secondName = secondName;
	}

	public String getPassport() {
		return passport;
	}

	public void setPassport(String passport) {
		this.passport = passport;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}
}
