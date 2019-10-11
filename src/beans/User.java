package beans;

import javax.faces.bean.ManagedBean; 
import javax.faces.bean.ViewScoped;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
/**
 * 
 * @author noahv and Jason Stine
 *
 */
@ManagedBean 
@ViewScoped 
public class User {
	
	// first name cannot be empty or less than 3 or bigger than 15
	@NotNull(message = "Please enter a first name")
	@Size(min = 3, max = 15, message = "first name does not meet size requirements") 
	private String username;
	
	// last name cannot be empty or less than 3 or bigger than 15
	@NotNull(message = "Please enter a last name")
	@Size(min = 3, max = 15, message = "Last name does not meet size requirements")
	private String password;
	
	// email cannot ne empty or less then 3 or bigger than 30
	@NotNull(message ="Please enter a email")
	@Size(min = 3, max = 30, message = "Email does not meet size requirements")
	private String email;
	
	//phone number cannot be empty of less then 7 or bigger then 11
	// this takes into account not entering area code, or adding international code
	@NotNull(message= "Please enter a phone number")
	@Size(min = 7, max = 11, message = " Phone number does not meet size requirements")
	private String phoneNumber;
	
	@NotNull(message= "Please enter a user code")
	private int userCode;
	
	/**
	 * basic user constructor
	 */
	public User() {
		this.username = "";
		this.password = "";
		this.email = "";
		this.phoneNumber = "";
		this.userCode = 0000;
	}
	

	/**
	 * 
	 * @param username
	 * @param password
	 * @param email
	 * @param phoneNumber
	 * @param userCode
	 */
	public User(String username, String password, String email, String phoneNumber, int userCode) {
		super();
		this.username = username;
		this.password = password;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.userCode = userCode;
	}



	// getters and setters 
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPhoneNumber() {
		return phoneNumber;
	}


	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}


	public int getUserCode() {
		return userCode;
	}


	public void setUserCode(int userCode) {
		this.userCode = userCode;
	}
	
	
	
	

}
