package com.ipartek.formacion.bbddyoutube.accesodatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class UtilsDAO {
	private static String url = "jdbc:mysql://localhost:3307/ipartek?serverTimezone=UTC&useSSL=false";
	private static String usuario = "root";
	private static String password = "admin";
	
	public static Connection getConnection() {
		Connection con = null;
		try {
			con = DriverManager.getConnection(url, usuario, password);
		} catch (SQLException e) {
			System.out.println("ERROR AL CONECTARSE A LA BBDD");
			e.printStackTrace();
		}
		return con;
	}
	
	public static void closeConnection(Connection con) {
		try {
			con.close();
		} catch (SQLException e) {
			System.out.println("ERROR AL CERRAR LA CONEXION A LA BBDD");
			e.printStackTrace();
		}
	}
}
