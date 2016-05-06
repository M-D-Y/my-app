package ru.mdy.login_example.test;

import org.junit.Test;

import junit.framework.TestCase;
import ru.mdy.login_example.beans.UserBean;
import ru.mdy.login_example.db.UserDAO;


public class TestDataBase extends TestCase {

	@Test
	public final void testLogin() {
		UserBean bean = new UserBean();
		bean.setUserName("login_example");
		bean.setPassword("login_example");
		bean = UserDAO.login(bean);
		assertEquals(true, bean.isValid());
	}

}
