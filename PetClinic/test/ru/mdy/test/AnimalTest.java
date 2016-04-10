/**
 * 
 */
package ru.mdy.test;

import org.junit.Test;
import static org.junit.Assert.*;

import java.lang.reflect.InvocationTargetException;

import ru.mdy.animals.*;
import ru.mdy.clinic.Client;

/**
 * @author admin
 *
 */
public class AnimalTest {

	@Test
	public void animalClassesTest() throws InstantiationException, IllegalAccessException, ClassNotFoundException,
			IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		Class<?>[] animals = { Cat.class, Dog.class, Cow.class, CatDog.class };
		for (Class<?> clazz : animals) {
			Object o = Class.forName(clazz.getName()).getConstructor(String.class).newInstance(clazz.getName());
			assertNotNull(o);
			assertEquals(o.getClass(), clazz);
			// checking name passed by constructor
			Animal animalObject = (Animal) o;
			assertEquals(animalObject.getName(), clazz.getName());
			// checking rename method
			String newName = clazz.getName() + " - renamed!";
			animalObject.setName(newName);
			assertEquals(animalObject.getName(), newName);
			// checking to set the owner
			Client client = new Client(getClass().getName());
			animalObject.setOwner(client);
			assertEquals(animalObject.getOwner(), client);

			// System.out.println(AnimalSounds.Cat.getSound());
			for (AnimalSounds sound : AnimalSounds.values()) {
				if (sound.name().equalsIgnoreCase(animalObject.getClass().getName()))
					assertEquals(animalObject.makeSound(), sound.getSound());
			}

		}
	}

}
