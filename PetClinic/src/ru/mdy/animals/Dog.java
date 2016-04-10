/**
 * Dog implementation
 */
package ru.mdy.animals;

import ru.mdy.clinic.Client;

/**
 * @author admin
 * 
 *         Dog realization
 * @since 4 апр. 2016 г.
 */
public class Dog implements Animal {

	private String name;
	private Client owner;

	/**
	 * 
	 * @param name
	 *            the name of cat
	 */
	public Dog(final String name) {
		setName(name);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ru.mdy.animals.Animal#GetName()
	 */
	@Override
	public String getName() {
		return this.name;
	}

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
			//throw new IllegalArgumentException("Argument is empty or null: " + name);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ru.mdy.animals.Animal#makeSound()
	 */
	@Override
	public String makeSound() {
		return AnimalSounds.Dog.getSound();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ru.mdy.animals.Animal#isPredator()
	 */
	@Override
	public boolean isPredator() {
		return true;
	}

	/* (non-Javadoc)
	 * @see ru.mdy.animals.Animal#getCient()
	 */
	@Override
	public Client getOwner() {
		return owner;
	}
	
	/* (non-Javadoc)
	 * @see ru.mdy.animals.Animal#isOrphanAnimal()
	 */
	public boolean isOrphanAnimal() {
		return owner == null;
	}

	/* (non-Javadoc)
	 * @see ru.mdy.animals.Animal#setOwner(ru.mdy.clinic.Client)
	 */
	@Override
	public void setOwner(Client client) {
		this.owner = client;
		
	}

	/* (non-Javadoc)
	 * @see ru.mdy.animals.Animal#getOwnerInfo()
	 */
	@Override
	public String getOwnerInfo() {
		return isOrphanAnimal() ? "Unknown" : owner.getInfo();
	}
}
