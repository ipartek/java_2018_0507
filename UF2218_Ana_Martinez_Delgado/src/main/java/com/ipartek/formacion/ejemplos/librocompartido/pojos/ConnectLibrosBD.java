package com.ipartek.formacion.ejemplos.librocompartido.pojos;

import java.sql.*;

public class ConnectLibrosBD {
 
	static int maxPaginaNumero=0;
	
	public static void anadirPaginaaBD(String autor, int numero, String contenido) throws ClassNotFoundException {
		String url = "jdbc:mysql://localhost:3307/ipartek?serverTimezone=UTC&useSSL=false";
		//String url = "jdbc:mysql://localhost:3306/ipartek?serverTimezone=UTC&useSSL=false";
		//System.out.println("En añadirpaginaBD");
		//System.out.println(autor + " " + numero + " "+contenido);
	
			Class.forName("com.mysql.jdbc.Driver");
		
	
		String usuario = "root";
		String password = "admin";
		//String usuario = "Akasha";
		//String password = "Akasha1";

		try(Connection con = DriverManager.getConnection(url, usuario, password)) {
						
			String sql = "INSERT INTO PAGINAS (NUMERO,AUTOR,CONTENIDO) VALUES (?,?,?)";
			
			try(PreparedStatement pst = con.prepareStatement(sql)) {
				pst.setLong(1, numero);
				pst.setString(2, autor);
				pst.setString(3, contenido);
				
				int numFilas = pst.executeUpdate();
				
				if(numFilas > 0) {
					System.out.println("El n�mero de filas modificado ha sido " + numFilas);
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
	public static String getNumeroPagina(int numeropagina) {
		System.out.println("En getpagina par acojer la pagina de la bd" + numeropagina);
		
		
		String url = "jdbc:mysql://localhost:3307/ipartek?serverTimezone=UTC&useSSL=false";
			//	String url = "jdbc:mysql://localhost:3306/ipartek?serverTimezone=UTC&useSSL=false";
			
				try {
					Class.forName("com.mysql.jdbc.Driver");
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			
				String usuario = "root";
				String password = "admin";
				//String usuario = "Akasha";
				//String password = "Akasha1";
			
				try(Connection con = DriverManager.getConnection(url, usuario, password)) {
								
					String sql = "select contenido from paginas where numero=?";
					
					try(PreparedStatement pst = con.prepareStatement(sql)) {
						pst.setInt(1, numeropagina);
						
						try (ResultSet rs = pst.executeQuery()) {

						

							while (rs.next()) {
								System.out.println("ESTE ES EL CONTENIDO DE LA PAGInA "+numeropagina);
								System.out.printf("%s\n", rs.getString("contenido"));
								
								return rs.getString("contenido");
								
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

		return "Pagina no encontrada";
		
		
	}
	public static int getNumPaginasBD() {
		String url = "jdbc:mysql://localhost:3307/ipartek?serverTimezone=UTC&useSSL=false";
		//String url = "jdbc:mysql://localhost:3306/ipartek?serverTimezone=UTC&useSSL=false";
		//System.out.println("En getNumPaginasBD");
	
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	
		String usuario = "root";
		String password = "admin";
		//String usuario = "Akasha";
		//String password = "Akasha1";
		int contador = 0;
		try(Connection con = DriverManager.getConnection(url, usuario, password)) {
						
			String sql = "select max(numero) from paginas";
			
			try(PreparedStatement pst = con.prepareStatement(sql)) {
				
				try {
				Statement stmt = con.createStatement();
				ResultSet rs = pst.executeQuery("select max(numero) from paginas");
				
				while (rs.next()) {
					maxPaginaNumero=rs.getInt(1);
				}
			
				} catch (SQLException e) {
				e.printStackTrace();
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return ++maxPaginaNumero;
		
	}
	
	public static String getContenidoPagina(int numeroPagina) {
		String url = "jdbc:mysql://localhost:3307/ipartek?serverTimezone=UTC&useSSL=false";
		//String url = "jdbc:mysql://localhost:3306/ipartek?serverTimezone=UTC&useSSL=false";
		System.out.println("En getContenidoPagina+pagina a buscar"+numeroPagina);
	
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	
		String usuario = "root";
		String password = "admin";
		//String usuario = "Akasha";
		//String password = "Akasha1";
		int contador = 0;
		String contenido="";
		try(Connection con = DriverManager.getConnection(url, usuario, password)) {
						
			String sql = "select contenido from paginas where numero="+numeroPagina;
			System.out.println("SQL: "+sql);
			try(PreparedStatement pst = con.prepareStatement(sql)) {
				
				
				ResultSet rs = pst.executeQuery(sql);
				
				while (rs.next()) {
					contenido=rs.getString(1);
					//System.out.println(rs.getString(1));
				}
			
				} catch (SQLException e) {
				e.printStackTrace();
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		
			}
		return contenido;
		
	}
	
	
}
