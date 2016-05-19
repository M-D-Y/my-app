package data.beans;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * TODO: comments
 * 
 * @author admin
 *
 * @since 19 мая 2016 г.
 */
public class BeanFactory {
	private List<?> beanList;
	private Class beanClass;

	public <clazz> BeanFactory(Class clazz) {
		this.beanList = new ArrayList<clazz>();
		beanClass = clazz;
	}

	public List<?> getList() {
		return beanList;
	}

	public void add(ResultSet resultSet) {
		ResultSetMetaData meta;
		try {
			meta = resultSet.getMetaData();

			while (resultSet.next()) {
				// Сохраняем всё в Bean

				for (int i = 1; i <= meta.getColumnCount(); i++) {
					String column = meta.getColumnName(i);
					try {
						TransferBean bean =  (TransferBean) beanClass.newInstance();
						bean.setProperty(column, resultSet.getString(column));
					} catch (InstantiationException | IllegalAccessException e) {
						e.printStackTrace();
					}

				}
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}

	}

}
