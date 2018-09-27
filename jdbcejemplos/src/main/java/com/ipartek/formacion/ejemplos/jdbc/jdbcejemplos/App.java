package com.ipartek.formacion.ejemplos.jdbc.jdbcejemplos;

import java.sql.*;

public class App {
	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3307/ipartek?serverTimezone=UTC&useSSL=false";
		String usuario = "root";
		String password = "admin";

		Connection conn = null;
		try {
			conn = DriverManager.getConnection(url, usuario, password);

			Statement stmt = null;
			try {
				stmt = conn.createStatement();

				String sql = "SELECT id, email, password FROM usuarios";

				ResultSet rs = null;
				try {
					rs = stmt.executeQuery(sql);

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
				} finally {
					if(rs != null) {
						rs.close();
					}
				}
			} catch (Exception e) {
				System.out.println("ERROR AL CREAR LA SENTENCIA");
			} finally {
				if(stmt != null) {
					stmt.close();
				}
					
			}
			
		} catch (SQLException e) {
			System.out.println("ERROR DE CONEXION");
			System.out.println(e.getMessage());
		} finally {
			try {
				if(conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				System.out.println("ERROR EN CIERRE DE CONEXION");
			}
		}
	}
}
