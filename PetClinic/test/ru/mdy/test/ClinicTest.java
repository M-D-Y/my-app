/**
 * 
 */
package ru.mdy.test;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import java.util.List;

import ru.mdy.animals.*;
import ru.mdy.clinic.*;

/**
 * @author admin
 *
 * @since 5 апр. 2016 г.
 */
public class ClinicTest {
	private Clinic clinic;
	private final String CLINIC_NAME = "My first animals clinic.";

	@Before
	public void createClinic() {
		clinic = new Clinic(CLINIC_NAME);
		assertEquals(clinic.getName(), CLINIC_NAME);
	}

	@Test(expected = NullPointerException.class)
	public void addAnimalTest() {
		clinic.addAnimal(null);
	}

	@Test
	public void test() {

		clinic.addAnimal(new Client("Piter"), new Cat("Murka"));
		clinic.addAnimal(new Client("Ann", "Tomsk"), new Animal[] { new Cat("Tom"), new Dog("Pit") });
		clinic.addClient(new Client("Mary"));
		clinic.addAnimal(null, new Cow("Mumu"));
		clinic.addAnimal(new Client("Bob"), new Cat("Malfi"));
		clinic.addAnimal(new Client("Richi"), new Cat("Tom"));
		Client client = new Client("Martin");
		clinic.addClient(client);
		clinic.addAnimal(client, new Dog("Bobby"));
		client = new Client("Martin", "Moscow");
		clinic.addClient(client);
		
		// check find clients by name
		assertEquals(clinic.findClientsByName("Jhon").size(), 0);
		assertEquals(clinic.findClientsByName("Martin").size(), 2);

		// check find clients by name and address
		assertEquals(clinic.findClients("Ann", null).size(), 1);
		List<Client> foundClients = clinic.findClients("Ann", "Tomsk");
		assertEquals(foundClients.size(), 1);

		// check rename client
		Client clientForRename = foundClients.get(0);
		clientForRename.setName("Elizabet");
		assertEquals(clientForRename.getName(), "Elizabet");

		// check find animals by name
		assertEquals(clinic.findAnimalsByName("Piggi").size(), 0);
		assertEquals(clinic.findAnimalsByName("Tom").size(), 2);

		// check find animals by name and owner
		assertEquals(clinic.findAnimalsByNameAndOwner("Mumu", null).size(), 1);
		List<Animal> foundedAnimals = clinic.findAnimalsByNameAndOwner("Tom", "Richi");
		assertEquals(foundedAnimals.size(), 1);
		// check rename animal
		Animal animal = foundedAnimals.get(0);
		animal.setName("Thomas");
		assertEquals(animal.getName(), "Thomas");
		
		System.out.println("Clients list befor deletion Piter:\n" + clinic.getClientsInfo());
		clinic.removeClient("Piter");
		System.out.println("Clients list after deletion Piter:\n" + clinic.getClientsInfo());
		
		System.out.println("Animals list:\n" + clinic.getAnimalsInfo());
	}
}
