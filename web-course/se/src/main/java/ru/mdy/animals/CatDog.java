/**
 * 
 */
package ru.mdy.animals;

import ru.mdy.clinic.Client;

/**
 * @author admin
 *
 *
 */
public class CatDog implements Animal {

	private String name;
	private Client owner;
	private Cat cat;
	private Dog dog;

	/*
	 * (non-Javadoc)
	 * 
	 * @see ru.mdy.animals.Animal#getName()
	 */

	public String getName() {

		return name;
	}

	/**
	 * @param name
	 */
	public CatDog(String name) {
		setName(name);
		cat = new Cat(name);
		dog = new Dog(name);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ru.mdy.animals.Animal#setName(java.lang.String)
	 */
	
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
	
	public String makeSound() {
		return cat.makeSound() + dog.makeSound();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ru.mdy.animals.Animal#isPredator()
	 */
	
	public boolean isPredator() {
		return cat.isPredator() && dog.isPredator();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ru.mdy.animals.Animal#getOwner()
	 */
	
	public Client getOwner() {
		return this.owner;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ru.mdy.animals.Animal#getOwnerInfo()
	 */
	
	public String getOwnerInfo() {
		return isOrphanAnimal() ? "Unknown" : owner.getInfo();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ru.mdy.animals.Animal#setOwner(ru.mdy.clinic.Client)
	 */
	
	public void setOwner(Client client) {
		this.owner = client;
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