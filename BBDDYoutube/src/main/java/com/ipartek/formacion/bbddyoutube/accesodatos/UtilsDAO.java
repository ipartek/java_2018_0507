package com.ipartek.formacion.bbddyoutube.accesodatos;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.io.IOException;

public class UtilsDAO {

	public static Connection getConnection() {
		Connection con = null;
		try {
			Properties prop = leerPropiedades("youtube.properties");

			con = DriverManager.getConnection( prop.getProperty("url"), prop.getProperty("usuario"), prop.getProperty("password"));
		} catch (SQLException e) {
			throw new AccesoDatosException(e.getMessage(), e);
		}
		return con;
	}
	
	public static void closeConnection(Connection con) {
		try {
			con.close();
		} catch (SQLException e) {
			throw new AccesoDatosException(e.getMessage(), e);
		}
	}
	
	public static Properties leerPropiedades(String filename) {
		try {
			
			InputStream input = UtilsDAO.class.getClassLoader().getResourceAsStream(filename);
			
			if(input==null){
				throw new BibliotecaException("No se ha podido leer el fichero " + filename);
			}

			//load a properties file from class path, inside static method
			Properties prop = new Properties();
			
			prop.load(input);

			return prop;
		} catch (IOException e) {
			throw new BibliotecaException("No se ha podido leer el fichero", e);
		}
	}
}
