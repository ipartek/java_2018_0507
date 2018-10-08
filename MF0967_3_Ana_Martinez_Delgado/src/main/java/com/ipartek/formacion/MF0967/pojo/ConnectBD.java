package com.ipartek.formacion.MF0967.pojo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class ConnectBD {
	public static void main(String args[]) {
		//checkUsuarioenBD("scobby", "galletas");
		getPerrosfromDB();
	}

	public static boolean checkUsuarioenBD(String nick, String password) {
		//System.out.println("Checkusuario"+nick + " "+password);
		String usuarioparalogin=null;
		String passparalogin=null;
		String url = "jdbc:mysql://localhost:3307/ipartek?serverTimezone=UTC&useSSL=false";
		
		//System.out.println("En checkUsuarioenBD");
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		String usuariobd = "root";
		String passwordbd = "admin";
		
	
		try (Connection conn = DriverManager.getConnection(url, usuariobd, passwordbd)) {
			nick="scobby";
			String sql = "SELECT * FROM usuariosperros WHERE nick = ?";
		
	
			try (PreparedStatement pst = conn.prepareStatement(sql)) {
			
				pst.setString(1,nick);
			
				
				try (ResultSet rs = pst.executeQuery()) {
					
					while (rs.next()) {
						usuarioparalogin=rs.getString("nick");
						passparalogin=rs.getString("password");
					}
					if(passparalogin.equals(password)) {
						//System.out.println("mismapass");
						System.out.println("Password OK");
						return true;
					}else {
						//System.out.println("Password erronea");
						return false;
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
		return false;
}

	public static ResultSet getPerrosfromDB() {
		
		
		
		String url = "jdbc:mysql://localhost:3307/ipartek?serverTimezone=UTC&useSSL=false";
		String usuario = "root";
		String password = "admin";

		//String id = "2";
		String email = "admin@email.com";
		
		try (Connection conn = DriverManager.getConnection(url, usuario, password)) {

			//String sql = "SELECT id, email, password FROM usuarios WHERE id = ?";
			String sql = "SELECT nombre, edad, raza, peso, apadrinado, chip FROM perrosenbd";

			try (PreparedStatement pst = conn.prepareStatement(sql)) {
			
				
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
						
						System.out.println(rs.getString("nombre")+" " +rs.getInt("edad")+" " +
								rs.getString("raza")+" " +rs.getString("peso")+" " +rs.getString("apadrinado")+" " +rs.getString("chip"));
					
					}
					return rs;
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
		return null;
		
		
		
	}
	public static boolean savePerrosatDB(Perro perro) {
		
		
	
			String url = "jdbc:mysql://localhost:3307/ipartek?serverTimezone=UTC&useSSL=false";
		
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
			
		
			String usuario = "root";
			String password = "admin";
		

			try(Connection con = DriverManager.getConnection(url, usuario, password)) {
							
				String sql = "INSERT INTO perrosenbd (NOMBRE,EDAD,RAZA,PESO,APADRINADO,CHIP) VALUES (?,?,?,?,?,?)";
				
				try(PreparedStatement pst = con.prepareStatement(sql)) {
					pst.setString(1, perro.getNombreperro());
					pst.setInt(2, perro.getEdadperro());
					pst.setString(3, perro.getRazaperro());
					pst.setLong(4, (long) perro.getPeso());
					pst.setString(5,perro.isApadrinado());
					pst.setString(6, perro.getChip());
					
					int numFilas = pst.executeUpdate();
					
					if(numFilas > 0) {
						System.out.println("El numero de filas modificado ha sido " + numFilas);
					}
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		return false;
	}

}