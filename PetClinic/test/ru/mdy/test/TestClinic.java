/**
 * 
 */
package ru.mdy.test;

import org.junit.Test;

import ru.mdy.animals.Animal;
import ru.mdy.animals.Cat;
import ru.mdy.animals.Dog;
import ru.mdy.clinic.Client;
import ru.mdy.clinic.Clinic;

/**
 * @author admin
 *
 * @since 5 апр. 2016 г.
 */
public class TestClinic {

	@Test
	public void test() {
		//fail("Not yet implemented");
		Clinic clinic = new Clinic("My first animals clinic.");
		assertTrue (clinic.addClient(null), NullPointerException);
		Client cl = new Client(clinic.getNewClientID(), "Piter", new Animal[]{new Cat("Tom"), new Dog("Pit")});
	}

}
