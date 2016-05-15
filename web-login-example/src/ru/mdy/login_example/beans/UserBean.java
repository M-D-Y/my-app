package ru.mdy.login_example.beans;

public class UserBean {
	
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private boolean logged;
    private String action;
 
	
	

	/**
	 * @return the logged
	 */
	public boolean isLogged() {
		return logged;
	}

	/**
	 * @param logged the logged to set
	 */
	public void setLogged(boolean logged) {
		this.logged = logged;
	}

	public String getFirstName() {
       return firstName;
	}

    public void setFirstName(String newFirstName) {
       firstName = newFirstName;
	}

	
    public String getLastName() {
       return lastName;
			}

    public void setLastName(String newLastName) {
       lastName = newLastName;
			}
			

    public String getPassword() {
       return password;
	}

    public void setPassword(String newPassword) {
       password = newPassword;
	}
	
			
    public String getUsername() {
       return username;
			}

    public void setUserName(String newUsername) {
       username = newUsername;
			}

	/**
	 * @return the action
	 */
	public String getAction() {
		return action;
	}

	/**
	 * @param action the action to set
	 */
	public void setAction(String action) {
		this.action = action;
	}

}