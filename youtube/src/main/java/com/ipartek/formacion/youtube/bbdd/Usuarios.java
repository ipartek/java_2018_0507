package com.ipartek.formacion.youtube.bbdd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class Usuarios {

	

	public static String url = "jdbc:mysql://localhost:3307/ipartek?serverTimezone=UTC&useSSL=false";
	//public static String url = "jdbc:mysql://localhost:3306/ipartek?serverTimezone=UTC&useSSL=false";
	
	public static String usuariobd = "root";
	public static String passwordbd = "admin";

//	public static String usuariobd = "Akasha";
//	public static String passwordbd = "Akasha1";

	
	private static String usuarioenbd;

	private static String passenbd;
	
	public static boolean comprobarUsuario(String email, String pass) {
		
		
		//System.out.println("En comprobar usuario con los datos "+email + " " + pass);
		try {
		Class.forName("com.mysql.jdbc.Driver");
		}catch(Exception e) {}
		/**/

		//select id from usuarios where email='javier@email.com' and password='yepa'
		
		try (Connection conn = DriverManager.getConnection(url, usuariobd, passwordbd)) {

			String sql = "SELECT id, email, password FROM usuarios WHERE email = ?";
			//String sql = "SELECT id, email, password FROM usuarios";

			try (PreparedStatement pst = conn.prepareStatement(sql)) {
				pst.setString(1, email);
				
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
						System.out.printf("AKI:   %s\t%s\t%s\n", rs.getLong("id"), rs.getString("email"), rs.getString("password"));
						
						Long idBD=rs.getLong("id");
						String emailbd=rs.getString("email");
						String passbd=rs.getString("password");
						
						//System.out.println(idBD + emailbd+passbd);
						if(email.equals(emailbd) && pass.equals(passbd)) {
							System.out.println("Mismo email");
							return true;
						}else {
							System.out.println("distintos");
							return false;
						}
						
					
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
		
		
		
		
		/**/
		
		

		return false;
		
		
	}

	private String user;

	public String getUser() {
		return user;
	}

	public static void setUser(String user) {
		user = user;
	}

	
}
