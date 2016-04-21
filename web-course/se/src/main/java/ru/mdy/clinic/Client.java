/**
 * Pet clinic client's realization
 * 
 */
package ru.mdy.clinic;

/**
 * @author admin Pet clinic client's realization
 * @since 4 апр. 2016 г.
 */
public class Client {
	private String name;
	private String address;

	public Client(final String name) {
		super();
		setName(name);
		setAddress("Unknown");
	}

	public Client(final String name, final String address) {
		setName(name);
		setAddress(address);
	}

	public boolean equals(Client client) {
		boolean result = this.getName().equalsIgnoreCase(client.getName())
				&& this.getAddress().equalsIgnoreCase(client.getAddress());
		return result;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            set the name to client
	 */
	public void setName(final String name) {
		if (name != null && !name.isEmpty())
			this.name = name;
		else
			throw new IllegalArgumentException("Argument is empty or null: " + name);
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(final String address) {
		if (address != null && !address.isEmpty())
			this.address = address;
		else
			throw new IllegalArgumentException("Argument is empty or null: " + address);
	}

	public String getInfo() {
		return "Name = " + getName() + ", address = " + getAddress();
	}
}
