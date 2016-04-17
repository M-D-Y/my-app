/**
 * TODO: comments
 */
package ru.lessons.lesson_4;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/**
 * TODO: comments
 * 
 * @author admin
 *
 * @since 17 апр. 2016 г.
 */
public class UserRunner {

	public static void main(String... args) {
		// List<User> users = new ArrayList<User>();

		/*
		 * Set<User> users = new HashSet<User>();
		 * 
		 * users.add(new User("1", "first")); users.add(new User("2",
		 * "second")); users.add(new User("1", "first")); for(User user :
		 * users){ System.out.println(user.toString()); }
		 */

		Map<String, User> users = new HashMap<String, User>();
		users.put("1", new User("1", "first"));
		users.put("2", new User("2", "second"));
		users.put("1", new User("1", "first"));
		for (Entry<String, User> user : users.entrySet()) {
			System.out.println(user.toString());

		}
	}
}