package com.ipartek.formacion.ejemplos.jdbc.jdbcejemplos;

import java.sql.*;

public class App {
	public static void main(String[] args) throws SQLException {
		String url = "jdbc:mysql://localhost:3307/ipartek?serverTimezone=UTC&useSSL=false";
		String usuario = "root";
		String password = "admin";

		Connection conn = DriverManager.getConnection(url, usuario, password);
		Statement stmt = conn.createStatement();

		String sql = "SELECT id, email, password FROM usuarios";

		ResultSet rs = stmt.executeQuery(sql);
		
		//Columnas desde metadatos
		ResultSetMetaData rsmd = rs.getMetaData();
		int columnas = rsmd.getColumnCount();
		
		for(int i = 1; i <= columnas; i++) {
			System.out.print(rsmd.getColumnName(i) + '\t');
		}
		
		System.out.println();
		//Fin
		
		while (rs.next()) {
			System.out.printf("%s\t%s\t%s\n", rs.getLong("id"), rs.getString("email"), rs.getString("contra"));
		}
		
		rs.close();
		stmt.close();
		conn.close();
	}
}
