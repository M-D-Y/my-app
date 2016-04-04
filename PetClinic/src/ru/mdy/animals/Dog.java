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
		this.name = (name.isEmpty()) ? "Unknown" : name;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ru.mdy.animals.Animal#GetName()
	 */
	@Override
	public String GetName() {
		return this.name;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ru.mdy.animals.Animal#SetName(java.lang.String)
	 */
	@Override
	public void SetName(final String name) {
		this.name = (name.isEmpty()) ? "Unknown" : name;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ru.mdy.animals.Animal#makeSound()
	 */
	@Override
	public String makeSound() {
		return "Gav, gav";
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
		// TODO Auto-generated method stub
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
}
