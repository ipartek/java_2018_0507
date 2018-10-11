package com.ipartek.formacion.ejemplos.librocompartido.pojos;

import java.sql.*;

public class App {
	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3307/ipartek?serverTimezone=UTC&useSSL=false";
		
		String usuario = "root";
		String password = "admin";
		
		String id = "2";
		String email = "admin@email.com";
		
		try (Connection conn = DriverManager.getConnection(url, usuario, password)) {

			String sql = "SELECT id, email, password FROM usuarios WHERE id = ?";
		
			try (PreparedStatement pst = conn.prepareStatement(sql)) {
				pst.setLong(1, Long.parseLong(id));
				//pst.setString(1, email);
				
				try (ResultSet rs = pst.executeQuery()) {

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
		
		try(Connection con = DriverManager.getConnection(url, usuario, password)) {
			long idl = 2;
			String contra = "nuevapassword";
			
			String sql = "UPDATE usuarios SET password = ? WHERE id = ?";
			
			try(PreparedStatement pst = con.prepareStatement(sql)) {
				pst.setLong(2, idl);
				pst.setString(1, contra);
				
				int numFilas = pst.executeUpdate();
				
				if(numFilas != 1) {
					System.out.println("El número de filas modificado ha sido " + numFilas);
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
