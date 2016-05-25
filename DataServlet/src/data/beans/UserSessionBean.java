package data.beans;

public class UserSessionBean {
	private String targetAction;
	private String userName;

	public UserSessionBean(){
		setUserName("");
		setTargetAction("");
	}
	public String getTargetAction() {
		return targetAction;
	}

	public void setTargetAction(String targetAction) {
		this.targetAction = targetAction;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

}
