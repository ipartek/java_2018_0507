package com.ipartek.formacion.ejemplos.jdbc.jdbcejemplos;

import java.sql.*;

public class App {
	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3307/ipartek?serverTimezone=UTC&useSSL=false";
		String usuario = "root";
		String password = "admin";

		try (Connection conn = DriverManager.getConnection(url, usuario, password)) {

			try (Statement stmt = conn.createStatement()) {

				String sql = "SELECT id, email, password FROM usuarios";

				try (ResultSet rs = stmt.executeQuery(sql)) {

					// Columnas desde metadatos
					ResultSetMetaData rsmd = rs.getMetaData();
					int columnas = rsmd.getColumnCount();

					for (int i = 1; i <= columnas; i++) {
						System.out.print(rsmd.getColumnName(i) + '\t');
					}

					System.out.println();
					// Fin

					while (rs.next()) {
						System.out.printf("%s\t%s\t%s\n", rs.getLong("id"), rs.getString("email"), rs.getString("password"));
					}
				} catch (Exception e) {
					System.out.println("ERROR AL CREAR EL RESULTSET");
				} 
			} catch (Exception e) {
				System.out.println("ERROR AL CREAR LA SENTENCIA");
			} 
			
		} catch (SQLException e) {
			System.out.println("ERROR DE CONEXION");
			System.out.println(e.getMessage());
		}
	}
}
