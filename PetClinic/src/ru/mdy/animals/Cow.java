/**
 * Cow implementation
 */
package ru.mdy.animals;

import ru.mdy.clinic.Client;

/**
 * @author admin
 * 
 *         Dog realization
 * @since 4 апр. 2016 г.
 */
public class Cow extends Pet{

	/**
	 * 
	 * @param name
	 *            the name of cat
	 */
	public Cow(final String name) {
		setName(name);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ru.mdy.animals.Animal#makeSound()
	 */
	@Override
	public String makeSound() {
		return AnimalSounds.Cow.getSound();
	}


}