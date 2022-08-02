
/**
 * I declare that this code was written by me.
 * I will not copy or allow others to copy my code.
 * I understand that copying code is considered as plagiarism.
 *
 * 21041399, Aug 2, 2022 12:14:56 PM
 */

public class admin_Class {

	private String name;
	private String role;
	private String email;
	private String password;
	private String status;

	public admin_Class(String name, String role, String email, String password, String status) {
		this.name = name;
		this.role = role;
		this.email = email;
		this.password = password;
		this.status = status;
	}
	
	public admin_Class(String name, String role, String email, String password) {
		this.name = name;
		this.role = role;
		this.email = email;
		this.password = password;
		this.status = "New";
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	public String getRole() {
		return role;
	}


	public void setRole(String role) {
		this.role = role;
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	
	
	
}
