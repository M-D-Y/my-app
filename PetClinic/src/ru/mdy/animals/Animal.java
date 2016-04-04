package ru.mdy.animals;

import ru.mdy.clinic.Client;

/**
 *  Class for any animals
 */

/**
 * Interface for create any animals
 * 
 * @author admin
 *
 * @since 4 апр. 2016 г.
 */
public interface Animal {
	/**
	 * 
	 * @return animal name
	 */
	public String GetName();

	/**
	 * 
	 * @param name
	 *            of animal
	 */
	public void SetName(String name);

	/**
	 * 
	 * @return animals sound
	 */
	public String makeSound();

	/**
	 * 
	 * @return true when animal is predator
	 */
	public boolean isPredator();

	/**
	 * 
	 * @return Owner for current animal
	 */
	public Client getOwner();

	/**
	 * 
	 * @return 
	 * @return Owner for current animal
	 */
	public void setOwner(Client client);

	/**
	 * 
	 * @return true if animal has owner
	 */
	public boolean isOrphanAnimal();

}
