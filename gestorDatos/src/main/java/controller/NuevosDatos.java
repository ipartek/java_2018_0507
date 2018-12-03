package controller;

import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;


public class NuevosDatos {

	public static void main(String[] args) {

		String url = "jdbc:mysql://localhost:3307/personas?serverTimezone=UTC&useSSL=false";
		String usuario = "root";
		String password = "admin";

		try (Connection con = DriverManager.getConnection(url, usuario, password)) {
			
			String[] tokens = new String[10000];
			String line;
			String sql = "INSERT INTO personas (nombre,apellido,direccion,numeroD,email,dni,puesto) VALUES "
					+ "(?,?,?,?,?,?,?)";
			
			FileReader file = new FileReader("personas.txt");
			BufferedReader buffer = new BufferedReader(file);
			
			try {
				while ((line = buffer.readLine()) != null) {
					
					String Nombre;
					String Apellido;
					String Direccion;
					Long NumeroD;
					String Email;
					String Dni;
					String Puesto;
					
					tokens = line.split(",");
					Nombre = tokens[0];
					Apellido = tokens[1];
					Direccion = tokens[2];
					NumeroD = Long.parseLong(tokens[3]);
					Email = tokens[4];
					Dni = tokens[5];
					Puesto = tokens[6];
					
					PreparedStatement pst = con.prepareStatement(sql);
					pst.setString(0, Nombre);
					pst.setString(1, Apellido);
					pst.setString(2, Direccion);
					pst.setLong(3, NumeroD);
					pst.setString(4, Email);
					pst.setString(5, Dni);
					pst.setString(6, Puesto);
					
					pst.executeUpdate();
				}
			} catch (Exception e) {
				throw new RuntimeException("Error en el bucle");
			}
			buffer.close();

		} catch (Exception e) {
			throw new RuntimeException("Erros insertando datos");
		}

	}

}
