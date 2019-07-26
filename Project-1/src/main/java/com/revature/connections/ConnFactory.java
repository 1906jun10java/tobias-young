package com.revature.connections;

/*
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnFactory {
//singleton factory
	private static ConnFactory cf = new ConnFactory();

	private ConnFactory() {
		super();
	}

	public static synchronized ConnFactory getInstance() {
		if (cf == null)
			cf = new ConnFactory();
		return cf;
	}

	public Connection getConnection() {
		Connection conn = null;
		Properties prop = new Properties();
		try {
			InputStream stream = ConnFactory.class.getClassLoader().getResourceAsStream("database.properties");
			prop.load(stream);
			// prop.load(new FileReader("database.properties"));
			//Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(prop.getProperty("url"), prop.getProperty("usr"), prop.getProperty("password"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} /*catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		 catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}*/
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ConnFactory {
	
	public static Connection getConnectionFromFile(String filename) throws SQLException {
		Connection c = null;
		try {
		Properties prop = new Properties();
		InputStream in = ConnFactory.class.getClassLoader().getResourceAsStream(filename);
		prop.load(in);
			Class.forName("oracle.jdbc.driver.OracleDriver");
			c = DriverManager.getConnection(prop.getProperty("url"), prop.getProperty("usr"), prop.getProperty("password"));
		} catch(ClassNotFoundException ex) {
			ex.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return c;
	}

}
