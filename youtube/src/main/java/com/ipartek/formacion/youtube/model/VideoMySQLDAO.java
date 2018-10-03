package com.ipartek.formacion.youtube.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.ipartek.formacion.youtube.Video;

public class VideoMySQLDAO implements CrudAble<Video> {
	
	private static VideoMySQLDAO INSTANCE = null;
	String url = "jdbc:mysql://localhost:3307/ipartek?serverTimezone=UTC&useSSL=false";
	static String usuario = "root";
	static String password = "admin";
	
	public static synchronized VideoMySQLDAO getInstance() throws ClassNotFoundException {
		if (INSTANCE == null) {
			Class.forName("com.mysql.cj.jdbc.Driver");
			INSTANCE = new VideoMySQLDAO();
		}
		return INSTANCE;
	}
 
	@Override
	public List<Video> getAll() {
		ArrayList<Video> videos = new ArrayList<>();
		//System.out.println("Entro en el getAll");
		try (Connection conn = DriverManager.getConnection(url, usuario, password)) {
			//System.out.println("Entro en el getAll y hago la conexion");
			try (Statement stmt = conn.createStatement()) {
				//System.out.println("Entro en el getAll y ahora el statement");
				String sql = "SELECT id, codigo, nombre, idusuario FROM videoyotube";
				try (ResultSet rs = stmt.executeQuery(sql)) {			
					System.out.println("Entro en el getAll y ahora ejecuto la query");
					while (rs.next()) {
						int id = rs.getInt("id");
						String codigo = rs.getString("codigo");
						String nombre = rs.getString("nombre");
						int idUsuarios = rs.getInt("idusuarios");
						//Video vid = new Video(id, codigo,nombre);
						videos.add(new Video(id, codigo, nombre, idUsuarios));
					}
				} catch (Exception e) {
					System.out.println("ERROR AL CREAR EL RESULTSET");
				}
			} catch (Exception  e) {
				System.out.println("ERROR AL CREAR LA SENTENCIA");
			}
		} catch (SQLException e) {
			System.out.println("ERROR DE CONEXION");
			System.out.println(e.getMessage());
		}
		return videos;
	}
	
	@Override
	public boolean insert(Video pojo) {
		try (Connection conn = DriverManager.getConnection(url, usuario, password)) {
			//try (Statement stmt = conn.createStatement()) {
			//TODO Modify insert for adding idUsuario
				String sql = "INSERt INTO videoYotube (codigo, nombre, idusuario) VALUES (?,?, 1);";
				try(PreparedStatement prs = conn.prepareStatement(sql)){
					prs.setString(1, pojo.getCodigo());
					prs.setString(2,pojo.getNombre());
					//prs.setInt(3,pojo.getUsuario());
					int numFilas = prs.executeUpdate();
					if(numFilas!=1) {
						return false;
					}
				}catch(SQLException e) {
					System.out.println(e.getMessage());
					e.printStackTrace();
					return false;
				}
//			} catch (Exception  e) {
//				System.out.println("ERROR AL CREAR LA SENTENCIA");
//			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			return false;
		}

		
		return true	;
	}



	@Override
	public Video getById(String id) {
		Video video = null;

		try (Connection conn = DriverManager.getConnection(url, usuario, password)) {

			String sql = "SELECT id, idvideo, nombre FROM videos WHERE id = ?";

			try (PreparedStatement pst = conn.prepareStatement(sql)) {

				pst.setString(1, id);

				try (ResultSet rs = pst.executeQuery()) {
					if (rs.next()) {
						video = new Video(rs.getInt("id"), rs.getString("codigo"), rs.getString("nombre"));
					} else {
						return null;
					}
				} catch (SQLException e) {
					//throw new AccesoDatosException(e.getMessage(), e);
				}
			} catch (Exception e) {
				//throw new AccesoDatosException(e.getMessage(), e);
			}

		} catch (SQLException e) {
			//throw new AccesoDatosException(e.getMessage(), e);
		}

return video;
	}

	@Override
	public boolean update(Video pojo) {
		
		return false;
	}

	@Override
	public boolean delete(String id) {
		boolean resul = false;
		try (Connection conn = DriverManager.getConnection(url, usuario, password)) {
			//try (Statement stmt = conn.createStatement()) {
			System.out.println("Entro en el delete");
			System.out.println(id);
				String sql = "DELETE FROM videoyotube WHERE id = ?";
				try(PreparedStatement prs = conn.prepareStatement(sql)){
					prs.setString(1, id);
					int numFilas = prs.executeUpdate();
					if(numFilas!=1) {
						return false;
					}
				}catch(SQLException e) {
					System.out.println("ERROR DE CONEXION");
				}
//			} catch (Exception  e) {
//				System.out.println("ERROR AL CREAR LA SENTENCIA");
//			}
		} catch (SQLException e) {
			System.out.println("ERROR DE CONEXION");
			System.out.println(e.getMessage());
		}
		return resul;
	}

}
