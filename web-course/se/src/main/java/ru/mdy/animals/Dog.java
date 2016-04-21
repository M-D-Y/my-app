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
public class Dog extends Pet {

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
	 * @see ru.mdy.animals.Animal#makeSound()
	 */
	@Override
	public String makeSound() {
		return AnimalSounds.Dog.getSound();
	}

}