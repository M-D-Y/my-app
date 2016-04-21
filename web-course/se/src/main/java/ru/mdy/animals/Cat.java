/**
 *  Cat implementaion
 */
package ru.mdy.animals;

import ru.mdy.clinic.Client;

/**
 * @author admin
 * 
 *         Cat realization
 * @since 4 апр. 2016 г.
 */
public class Cat extends Pet {

	/**
	 * 
	 * @param name
	 *            the name of cat
	 */
	public Cat(final String name) {
		setName(name);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ru.mdy.animals.Animal#makeSound()
	 */
	@Override
	public String makeSound() {
		return AnimalSounds.Cat.getSound();
	}

	

}
