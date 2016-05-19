package data.beans;

public class MessageBean implements TransferBean {
	private String id;
	private String message;

	public MessageBean() {
		super();
	}

	public MessageBean(String id, String message) {
		this.id = id;
		this.message = message;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see data.beans.TransferBean#add(java.lang.String, java.lang.String)
	 */
	@Override
	public void setProperty(String propertyName, String propertyValue) {
		switch (propertyName) {
		case "id":
			setId(propertyValue);
			break;
		case "message":
			setMessage(propertyValue);
			break;
		}
	}

}
