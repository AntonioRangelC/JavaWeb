
package dao;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import util.PropertiesFile;


public class DAOFactory {

	private static DAOFactory daoFactory = null;

	private DAOFactory() {
	}

	public static DAOFactory getInstance() {
		if (daoFactory == null) {
			daoFactory = new DAOFactory();
		}
		return daoFactory;
	}

	public IDAO getDAO(String daoClassName) throws DAOException {
	

		
		Class<?> daoClass;
		try {
			daoClass = Class.forName(daoClassName);

			
			IDAO result = (IDAO) daoClass.getDeclaredConstructor().newInstance();
			result.setConnection(getConnection());
			return result;
		} catch (InvocationTargetException | NoSuchMethodException | SecurityException | ClassNotFoundException
				| InstantiationException | IllegalAccessException e) {

			e.printStackTrace();
			throw new DAOException(e);
		}

	}

	private Connection getConnection() throws DAOException {
		PropertiesFile pf = new PropertiesFile();
		try {
			pf.load("conexoes.properties");
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		
		try {
			Class.forName(pf.getValue("DRIVER_CLASS"));
			String url = "jdbc:mysql://" + pf.getValue("SERVER_DATABASE") + ":" + pf.getValue("PORT_DATABASE") + "/"
					+ pf.getValue("NAME_DATABASE");
			String user = pf.getValue("USER");
			String pass = pf.getValue("PASS");
			System.out.println("url "+ url + "\n" + "driver class " + pf.getValue("DRIVER_CLASS") + "\n");
			Connection con = DriverManager.getConnection(url, user, pass);
			return con;
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println("Problema na getConnection DAOFactory");
			e.printStackTrace();
			throw new DAOException(e);

		}

	}
}
