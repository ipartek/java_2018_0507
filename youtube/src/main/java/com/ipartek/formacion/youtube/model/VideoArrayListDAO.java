package com.ipartek.formacion.youtube.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ipartek.formacion.youtube.Video;

public class VideoArrayListDAO implements CrudAble<Video> {

	private static VideoArrayListDAO INSTANCE = null;
	private static List<Video> videos = new ArrayList<Video>();

	
	public static String url = "jdbc:mysql://localhost:3307/ipartek?serverTimezone=UTC&useSSL=false";
	
	public static String usuario = "root";
	public static String password = "admin";
	//public static String usuario = "Akasha";
	//public static String password = "Akasha1";
	
	
	private VideoArrayListDAO() {
		videos = new ArrayList<Video>();
		try {
//			videos.add(new Video("LPDhuthFD98", "Surf Search Spot 2 0 video promo"));
//			videos.add(new Video("a9WnQFI8jQU", "Betagarri - Sweet Mary"));
//			videos.add(new Video("0sLK1SKfItM", "Su Ta Gar - Begira"));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static synchronized VideoArrayListDAO getInstance() throws ClassNotFoundException {
		if (INSTANCE == null) {
			INSTANCE = new VideoArrayListDAO();
		}
		Class.forName("com.mysql.jdbc.Driver");
		return INSTANCE;
	}

	@Override
	public boolean insert(Video pojo) {
		System.out.println("VideoArrayListDAO Añadir");
		
		try (Connection conn = DriverManager.getConnection(url, usuario, password)) {
			Class.forName("com.mysql.jdbc.Driver");
			String sql = "insert into videos(idvideo,nombre,id_usuario) values(?,?,?);";
			//String sql = "insert into videos(idvideo,nombre) values(?,?)";
	
			System.out.println("AKI");
			
			try (PreparedStatement pst = conn.prepareStatement(sql)) {
				//System.out.println("getL:"+pojo.getL());
				//System.out.println("getID"+pojo.getId());
				//System.out.println("getNombre"+pojo.getNombre());
				
				pst.setString(1, pojo.getId());
				pst.setString(2,pojo.getNombre());
				pst.setString(3, "1");//TODO:Usuario provisional
				
				//pst.executeUpdate();
				//System.out.println("SQL:"+sql);
				//System.out.println("AKI3");
			      
			     pst.executeUpdate();
			     System.out.println("Insertados datos: ID: "+pojo.getId()+" Nombre: "+pojo.getNombre());
				
				conn.close();
			
			} catch (Exception e) {
				System.out.println("ERROR AL CREAR LA SENTENCIA");
				e.printStackTrace();
			} 
			
		} catch (SQLException e) {
			System.out.println("ERROR DE CONEXION");
			System.out.println(e.getMessage());
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
				
		
		return videos.add(pojo);
	}

	
	public static void main(String args[]) {
		VideoArrayListDAO vardo=new VideoArrayListDAO();
		vardo.getAll();
	}
	@Override
	public List<Video> getAll() {
		
		
		try (Connection conn = DriverManager.getConnection(url, usuario, password)) {

			String sql = "SELECT id,idvideo, nombre FROM videos";
		

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
						//System.out.printf("HOlA %s\t%s\t%s\n", rs.getLong("id"), rs.getString("idvideo"), rs.getString("nombre"));
						Video vid=new Video(rs.getLong("id"), rs.getString("idvideo"), rs.getString("nombre"));
						videos.add(vid);
					
					}
					
					return videos;
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
		
		
		
		
		//
		return videos;
	}

	@Override
	public Video getById(String id) {
		Video resul = null;
		if (id != null) {
			for (Video v : videos) {
				if (id.equals(v.getId())) {
					resul = v;
				}
			}
		}
		return resul;
	}

	@Override
	public boolean update(Video pojo) {
		
		
		pojo.getNombre();
		try(Connection con = DriverManager.getConnection(url, usuario, password)) {
			long idl = 2;
			String nombre = "nombrevideoActu";
			
			String sql = "UPDATE videos SET nombre = ? WHERE id = ?";
			
			try(PreparedStatement pst = con.prepareStatement(sql)) {
				pst.setLong(2, idl);
				pst.setString(1, nombre);
				
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
		return false;
	}

	@Override
	public boolean delete(String id) {
		boolean resul = false;
		Video v = null;
		if ( id != null ) { 
			for (int i = 0; i < videos.size(); i++) {
				v = videos.get(i); 
				if (id.equals(v.getId()) ) { 
					resul = videos.remove(v);
					break;
				}
			}
		}	
		return resul;
	}
	
	public static ResultSet conectBD() {
		
		String id = "2";
		String email = "admin@email.com";
		
		try (Connection conn = DriverManager.getConnection(url, usuario, password)) {
			Class.forName("com.mysql.jdbc.Driver");
			String sql = "SELECT id, nombre FROM videos WHERE id = ?";
		
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
						System.out.printf("%s\t%s\t%s\n", rs.getString("id"),rs.getLong("idvideo"), rs.getString("nombre"));
						new Video(rs.getLong("idvideo"),rs.getString("id"), rs.getString("nombre"));
						
					}
				} catch (Exception e) {
					System.out.println("ERROR AL CREAR EL RESULTSET");
				} 
			} catch (Exception e) {
				System.out.println("ERROR AL CREAR LA SENTENCIA");
			} 
			
		} catch (SQLException e) {
			System.out.println("ERROR DE CONEXION");
			System.out.println(e.getMessage());} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
//	} catch (ClassNotFoundException e1) {
//		e1.printStackTrace();
//	}
		return null;
	}
	
	public static List getListBD() {
		List lista = null;
		
		try (Connection conn = DriverManager.getConnection(url, usuario, password)) {
			//Class.forName("com.mysql.jdbc.Driver");
			String sql = "SELECT id,idvideo, nombre FROM videos";
		
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
						lista.add(new Video(rs.getLong("id"), rs.getString("idvideo"),rs.getString("nombre")));
						//System.out.printf("%s\t%s\t%s\n", rs.getLong("id"), rs.getString("idvideo"),rs.getString("nombre"));
					
					
					
					}
					return lista;
					
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
		return lista;
		
		
	}
	
	
//	public static void updateBBDD() {
//		
//		try(Connection con = DriverManager.getConnection(url, usuario, password)) {
//			long idl = 2;
//			String nombre = "nombrevideoActu";
//			
//			String sql = "UPDATE videos SET nombre = ? WHERE id = ?";
//			
//			try(PreparedStatement pst = con.prepareStatement(sql)) {
//				pst.setLong(2, idl);
//				pst.setString(1, nombre);
//				
//				int numFilas = pst.executeUpdate();
//				
//				if(numFilas != 1) {
//					System.out.println("El número de filas modificado ha sido " + numFilas);
//				}
//				
//			} catch (SQLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
}
