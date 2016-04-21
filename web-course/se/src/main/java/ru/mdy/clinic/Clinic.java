/**
 * 
 */
package ru.mdy.clinic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
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
		this.setName(name);
	}

	private List<Animal> animals = new ArrayList<Animal>();

	public List<Animal> getAnimals() {
		return animals;
	}

	public List<Client> getClients() {
		return clients;
	}

	private List<Client> clients = new ArrayList<Client>();

	/**
	 * add new client to clinic
	 * 
	 * @param id
	 * @param client
	 * @return added client
	 */
	public Client addClient(Client client) {
		Client result = null;
		if (client == null)
			throw new NullPointerException("Client must not been null");
		else {
			if (this.clients.add(client) == true)
				result = client;
		}
		return result;
	}

	/**
	 * 
	 * @param id
	 * @return client for id at parameter
	 */
	public Client getClient(int id) {
		return this.clients.get(id);
	}

	/**
	 * 
	 * @param client
	 * @param animals
	 */
	public void addAnimal(Client client, Animal[] animals) {
		if (client != null) {
			int idx = clients.indexOf(client);
			if (idx >= 0 || clients.add(client))
				for (Animal animal : animals)
					animal.setOwner(client);
		}
		addAnimals(animals);
	}

	/**
	 * 
	 * @param client
	 * @param animal
	 */
	public void addAnimal(Client client, Animal animal) {
		if (client != null) {
			int idx = clients.indexOf(client);
			if (idx >= 0 || clients.add(client))
				animal.setOwner(client);
		}
		addAnimal(animal);
	}

	/**
	 * 
	 * @param animals
	 */
	public void addAnimals(Animal[] animals) {
		this.animals.addAll(Arrays.asList(animals));
	}

	/**
	 * 
	 * @param animal
	 * @return
	 */
	public Animal addAnimal(Animal animal) {
		Animal result = null;
		if (animal == null)
			throw new NullPointerException("Animal must not been null");
		else {
			if (animals.add(animal) == true)
				result = animal;
		}
		return result;
	}

	/**
	 * 
	 * @return fullfiled list of registered animals in clinic
	 */
	public String getAnimalsInfo() {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < animals.size(); i++) {
			Animal animal = animals.get(i);
			sb.append("№ = " + i + ", class = " + animal.getClass().getName() + ", name = " + animal.getName()
					+ ", owner = " + animal.getOwnerInfo() + "\n");
		}
		return sb.toString();

	}

	public String getClientsInfo() {
		StringBuilder sb = new StringBuilder();
		Iterator<Client> it = clients.iterator();
		int i = 0;
		while (it.hasNext()) {
			Client client = it.next();
			sb.append("№ = " + ++i + ", name = " + client.getName() + ", address = " + client.getAddress() + "\n");
		}
		return sb.toString();

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	/**
	 * 
	 * @param name
	 *            that only will be searched in list of clients
	 * @return list of founded client names
	 */
	public List<Client> findClientsByName(final String name) {
		return findClients(name, null);
	}

	/**
	 * 
	 * @param name,
	 * @param address
	 *            that will be searched in list of clients
	 * @return list of founded client names
	 */
	public List<Client> findClients(final String name, final String address) {
		boolean addressExists = address != null && !address.isEmpty();
		List<Client> results = new ArrayList<Client>();
		Iterator<Client> it = clients.iterator();
		while (it.hasNext()) {
			Client client = it.next();
			if (addressExists) {
				if (client.equals(new Client(name, address)))
					results.add(client);
			} else {
				if (client.getName().equalsIgnoreCase(name))
					results.add(client);
			}
		}
		return results;
	}

	/**
	 * 
	 * @param name
	 *            that will be searched in list of animals
	 * @return list of founded animal names
	 */
	public List<Animal> findAnimalsByName(final String name) {
		return findAnimalsByNameAndOwner(name, null);
	}

	/**
	 * 
	 * @param name
	 *            that will be searched in list of animals
	 * @return list of founded animal names
	 */
	public List<Animal> findAnimalsByNameAndOwner(final String animalName, String ownerName) {
		boolean ownerExists = ownerName != null && !ownerName.isEmpty();
		List<Animal> results = new ArrayList<Animal>();
		Iterator<Animal> it = animals.iterator();
		while (it.hasNext()) {
			Animal animal = it.next();
			if (animal.getName().equalsIgnoreCase(animalName)) {
				if (ownerExists && animal.getOwner() != null) {
					Client owner = animal.getOwner();
					if (owner.getName().equalsIgnoreCase(ownerName))
						results.add(animal);
				} else
					results.add(animal);
			}
		}
		return results;
	}

	public boolean removeClient(String clientName) {
		boolean result = false;
		List<Client> clientsToRemove = findClientsByName(clientName);
		Client client = (clientsToRemove != null) ? clientsToRemove.get(0) : null;
		if (client != null){
			for(Animal animal : animals){
				if (animal.getOwner()!= null && animal.getOwner().equals(client)) animal.setOwner(null);
			}
			clients.remove(client);
			result = true;
		}
		return result;
	}
}
