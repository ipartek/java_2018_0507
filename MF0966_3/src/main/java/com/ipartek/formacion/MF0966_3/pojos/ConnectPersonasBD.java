package com.ipartek.formacion.MF0966_3.pojos;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ConnectPersonasBD {
 
	static int maxPaginaNumero=0;
	
	public static void anadirRegistro(String nombre, String apellido, String calle
			
			,String numero,String email,String dni, String status
			) throws ClassNotFoundException {
		
		System.out.println("En añadir registro");
		
		
		String url = "jdbc:mysql://localhost:3307/MF0966_3?serverTimezone=UTC&useSSL=false";
		
		Class.forName("com.mysql.jdbc.Driver");
		
	
		String usuario = "root";
		String password = "admin";
		

		try(Connection con = DriverManager.getConnection(url, usuario, password)) {
						
			String sql = "INSERT INTO PERSONA (NOMBRE,APELLIDO1,CALLE,NUMERO,EMAIL,DNI,STATUS) VALUES (?,?,?,?,?,?,?)";
			
			try(PreparedStatement pst = con.prepareStatement(sql)) {
				pst.setString(1, nombre);
				pst.setString(2, apellido);
				pst.setString(3, calle);
				pst.setInt(4,Integer.parseInt(numero));
				pst.setString(5, email);
				pst.setString(6, dni);
				pst.setString(7, status);
				
					
				int numFilas = pst.executeUpdate();
				
				if(numFilas > 0) {
					System.out.println("Filas insertadas: " + numFilas);
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	public static List<Persona> buscarxDNI(String dni) {

		Array[] persona=new Array[8];
		System.out.println("En buscar dni");
		ArrayList<Persona> personadni = new ArrayList<Persona>();
		
		String url = "jdbc:mysql://localhost:3307/MF0966_3?serverTimezone=UTC&useSSL=false";
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	
		String usuario = "root";
		String password = "admin";
		

		try(Connection con = DriverManager.getConnection(url, usuario, password)) {
					System.out.println("buscando");	
			String sql = "select * from persona where dni=?";
			
			try(PreparedStatement pst = con.prepareStatement(sql)) {
				pst.setString(1, dni);
				
				
				ResultSet resultado = pst.executeQuery();
				
				
				while (resultado.next()) {
					System.out.println(resultado.getInt(1) + resultado.getString(2));
					personadni.add(new Persona(resultado.getInt(1),resultado.getString(2),resultado.getString(3),resultado.getString(4)
							,resultado.getInt(5),resultado.getString(6),resultado.getString(7),resultado.getString(8)));
				
					
					
					System.out.println("Persona encontrada");
				}
				
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return personadni;
		
	}
	
	
	//
	
	public static List<Persona> getAll() throws SQLException {
		
		System.out.println("En getAll");
			String url = "jdbc:mysql://localhost:3307/MF0966_3?serverTimezone=UTC&useSSL=false";
		
			try {
				Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
	
		String usuario = "root";
		String password = "admin";
	
		ArrayList<Persona> misPersonas = new ArrayList<Persona>();
		//String sql = "select * from persona";
		String sql="SELECT * FROM persona ORDER BY id DESC limit 50";
		try(Connection con = DriverManager.getConnection(url, usuario, password)) {
			try (CallableStatement pst = (CallableStatement) con.prepareCall(sql)) {
				
				try (ResultSet rs = pst.executeQuery()) {
					
					while (rs.next()) {						
						int id = rs.getInt("id");
						String nombre = rs.getString("nombre");
						String apellido1 = rs.getString("apellido1");
						String calle = rs.getString("calle");
						int numero = rs.getInt("numero");
						String email = rs.getString("email");
						String dni = rs.getString("dni");
						String status = rs.getString("status");
						misPersonas.add(new Persona(id,nombre, apellido1, calle, numero,email,dni,status));
						
						
					}

				} catch (Exception e) {
					System.out.println(e);
				}
			} catch (Exception e) {
				System.out.println("ERROR AL CREAR LA SENTENCIA");
			}

	
		return misPersonas;
		}
	}
}
