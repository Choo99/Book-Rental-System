package model;

/*
 * 
 */
public class User {

	private String name;
	private int userID;
	private String registerDate;
	private String phone;
	private String IC;
	private String password;
	private String role;

	// constructor
	public User() {
	}

	// All the setter and Getter
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public String getRegisterDate() {
		return registerDate;
	}

	public void setRegisterDate(String registerDate) {
		this.registerDate = registerDate;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getIC() {
		return IC;
	}

	public void setIC(String iC) {
		IC = iC;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

}
