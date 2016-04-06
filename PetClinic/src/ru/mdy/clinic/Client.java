/**
 * Pet clinic client's realization
 * 
 */
package ru.mdy.clinic;

import java.util.List;

import ru.mdy.animals.Animal;

/**
 * @author admin Pet clinic client's realization
 * @since 4 апр. 2016 г.
 */
public class Client {
	private final int clientID;
	private  String name;
	private List<Animal> animals;

	public Client(final int clientID, final String name) {
		this.clientID = clientID;
		this.name = name;
	}

	public Client(final int clientID, final String name, Animal[] animals) {
		this.clientID = clientID;
		this.name = name;
		if (animals != null && animals.length > 0)
			for (Animal a : animals) {
				this.addAnimal(a);
			}
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param newName
	 *            set the new name to client
	 */
	public void rename(String newName) {
		this.name = newName;
	}

	/**
	 * @return the animals
	 */
	public List<Animal> getAnimals() {
		return animals;
	}

	/**
	 * @param animals
	 *            the animals to set
	 */
	public void setAnimals(List<Animal> animals) {
		this.animals = animals;
	}

	/**
	 * 
	 * @param animal
	 *            for adding new animal
	 */

	public void addAnimal(Animal animal) {
		this.animals.add(animal);
		animal.setOwner(this);
	}

	/**
	 * @return the clientID
	 */
	public int getClientID() {
		return clientID;
	}
}
