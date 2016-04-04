/**
 * 
 */
package ru.mdy.test;

import org.junit.Test;

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
		clinic.addClient(null);
	}

}
