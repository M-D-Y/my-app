/**
 * @since 12 апр. 2016 г.
 */
package ru.mdy.animals;

import ru.mdy.clinic.Client;

/**
 * @author comdmura
 *
 */
public abstract class Pet implements Animal {

	private String name;
	private Client owner;

	/*
	 * (non-Javadoc)
	 * 
	 * @see ru.mdy.animals.Animal#setName(java.lang.String)
	 */
	@Override
	public void setName(final String name) {
		if (name != null && !name.isEmpty())
			this.name = name;
		else
			this.name = "Unknown";
		// throw new IllegalArgumentException("Argument is empty or null: " +
		// name);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ru.mdy.animals.Animal#getName()
	 */
	@Override
	public String getName() {
		return this.name;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ru.mdy.animals.Animal#setOwner(ru.mdy.clinic.Client)
	 */
	@Override
	public void setOwner(Client client) {
		this.owner = client;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ru.mdy.animals.Animal#getOwner()
	 */
	@Override
	public Client getOwner() {
		return owner;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ru.mdy.animals.Animal#getOwnerInfo()
	 */
	@Override
	public String getOwnerInfo() {
		return isOrphanAnimal() ? "Unknown" : owner.getInfo();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ru.mdy.animals.Animal#makeSound()
	 */
	@Override
	public String makeSound() {
		return "";
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ru.mdy.animals.Animal#isOrphanAnimal()
	 */
	public boolean isOrphanAnimal() {
		return owner == null;
	}

}
