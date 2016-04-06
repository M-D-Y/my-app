/**
 * 
 */
package ru.mdy.clinic;

import java.util.HashMap;
import java.util.Iterator;

import ru.mdy.animals.Animal;

/**
 * @author admin
 *
 * @since 4 апр. 2016 г.
 */
public class Clinic {
	private String name;
	private int clientID = -1;
	private int animalID = -1;

	/**
	 * @param name
	 *            of clinic
	 */
	public Clinic(String name) {
		super();
		this.name = name;
	}

	private HashMap<Integer, Animal> animals;
	private HashMap<Integer, Client> clients;

	/**
	 * add new client to clinic
	 * 
	 * @param id
	 * @param client
	 * @return added client
	 */
	public Client addClient(Client client) {
		if (client == null) throw new NullPointerException("Client must not been null");
		this.clients.put(client.getClientID(), client);
		Iterator<Animal> it = client.getAnimals().iterator();
		while (it.hasNext()) {
			animals.put(getNewAnimalID(), it.next());
		}
		return client;
	}

	/**
	 * 
	 * @param id
	 * @return client for id at parameter
	 */
	public Client getClient(int id) {
		return this.clients.get(id);
	}

	public void addAnimal(Client client, Animal animal) {
		Client cl = this.clients.get(client.getClientID());
		if (cl != null)
			cl.addAnimal(animal);
		else
			throw new NullPointerException("Клиента: " + client.getName() + " не существует");
	}

	/**
	 * 
	 * @return generated new ID for client
	 */
	public int getNewClientID() {
		return ++clientID;
	}

	/**
	 * 
	 * @return generated new ID for client
	 */
	public int getNewAnimalID() {
		return ++animalID;
	}
}
