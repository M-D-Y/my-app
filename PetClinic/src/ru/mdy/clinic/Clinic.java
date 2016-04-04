/**
 * 
 */
package ru.mdy.clinic;

import java.util.List;

import ru.mdy.animals.Animal;

/**
 * @author admin
 *
 * @since 4 апр. 2016 г.
 */
public class Clinic {
	private String name;

	/**
	 * @param name
	 *            of clinic
	 */
	public Clinic(String name) {
		super();
		this.name = name;
	}

	private List<Animal> animals;
	private List<Integer, Client> clients;

	public Client addClient(Client client) {
		this.clients.add(client);
		return client;
	}

	public void addAnimal(Animal animal) {

	}

}
