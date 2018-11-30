package com.ipartek.examen.modelo;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

class CargaFichero {

	public static void main(String[] args) {

		String url = "jdbc:mysql://localhost:3307/personas?serverTimezone=UTC&useSSL=false";
		String usuario = "root";
		String password = "admin";
		
		

		try (Connection conn = DriverManager.getConnection(url, usuario, password)) {
			String[] datos= new String[11000];
			String cadena;
			String sql = "INSERT INTO gente (nombre,apellido1, direccion, portal, email, dni, puesto)"
					+ "VALUES (?,?,?,?,?,?,?)";
			
			FileReader f = new FileReader("personas.txt");
			BufferedReader b = new BufferedReader(f);
			while ((cadena = b.readLine()) != null) {
				
				String nombre;
				String apellido1;
				String direccion;
				int nPortal;
				String email;
				String dni;
				String puesto;
				datos = cadena.split(",");
				nombre = datos[0];
				apellido1 = datos[1];
				direccion = datos[2];
				nPortal = Integer.parseInt(datos[3]);
				email = datos[4];
				dni = datos[5];
				puesto = datos[6];
				
				PreparedStatement pst = conn.prepareStatement(sql);
				pst.setString(1, nombre);
				pst.setString(2, apellido1);
				pst.setString(3, direccion);
				pst.setInt(4, nPortal);
				pst.setString(5, email);
				pst.setString(6, dni);
				pst.setString(7, puesto);
				
				pst.executeUpdate();
			
			}
			b.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}

	}

}
