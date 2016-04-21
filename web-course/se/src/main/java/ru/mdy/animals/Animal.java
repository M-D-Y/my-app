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
	public String getName();

	/**
	 * 
	 * @param name
	 *            of animal
	 */
	public void setName(final String name);

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
	 * @return Owner name for current animal
	 */
	public String getOwnerInfo();

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
