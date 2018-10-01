package com.ipartek.formacion.youtube.model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.ipartek.formacion.youtube.Video;

public class VideoArrayListDAO implements CrudAble<Video> {

	private static VideoArrayListDAO INSTANCE = null;
	private static List<Video> videos = null;

	private String url = "jdbc:mysql://localhost:3307/ipartek?serverTimezone=UTC&useSSL=false";
	private String usuario = "root";
	private String password = "admin";

	private VideoArrayListDAO() {
		videos = new ArrayList<Video>();
		try {
			videos.add(new Video("LPDhuthFD98", "Surf Search Spot 2 0 video promo"));
			videos.add(new Video("a9WnQFI8jQU", "Betagarri - Sweet Mary"));
			videos.add(new Video("0sLK1SKfItM", "Su Ta Gar - Begira"));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static synchronized VideoArrayListDAO getInstance() {
		if (INSTANCE == null) {

			try {
				Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException e) {

				e.printStackTrace();
			}
			INSTANCE = new VideoArrayListDAO();

		}

		return INSTANCE;
	}

	@Override
	public boolean insert(Video pojo) {
		// return videos.add(pojo);

		try (Connection conn = DriverManager.getConnection(url, usuario, password)) {

			String sql = "INSERT INTO videos values (?,?)";

			try (PreparedStatement pst = conn.prepareStatement(sql)) {

				pst.setString(1, pojo.getId());
				pst.setString(2, pojo.getNombre());

				pst.executeUpdate();

			} catch (Exception e) {
				System.out.println("ERROR AL CREAR LA SENTENCIA");
				return false;
			}

		} catch (SQLException e) {
			System.out.println("ERROR DE CONEXION");
			System.out.println(e.getMessage());
			return false;
		}

		return true;
	}

	@Override
	public List<Video> getAll() {
		/*
		 * return videos; }
		 * 
		 * @Override public Video getById(String id) { Video resul = null; if (id !=
		 * null) { for (Video v : videos) { if (id.equals(v.getId())) { resul = v; } } }
		 * return resul;
		 */
		ArrayList<Video> videos = new ArrayList<Video>();
		
		try (Connection conn = DriverManager.getConnection(url, usuario, password)) {

			String sql = "SELECT * FROM videos";

			try (Statement stmt = conn.createStatement()) {

				try (ResultSet rs = stmt.executeQuery(sql)) {

					while (rs.next()) {
						System.out.printf( rs.getString("id"), rs.getString("nombre"));
						videos.add(new Video(rs.getString("id"), rs.getString("nombre")));
					}
				} catch (Exception e) {
					System.out.println("ERROR AL CREAR EL RESULTSET:" + e.getMessage());
					e.printStackTrace();

				}
			} catch (Exception e) {
				System.out.println("ERROR AL CREAR LA SENTENCIA");
			}

		} catch (SQLException e) {
			System.out.println("ERROR DE CONEXION");
			System.out.println(e.getMessage());
		}
		return videos;
	}

	@Override
	public boolean update(Video pojo) {

		try (Connection con = DriverManager.getConnection(url, usuario, password)) {

			String sql = "UPDATE videos SET nombre = ? WHERE id = ?";

			try (PreparedStatement pst = con.prepareStatement(sql)) {

				pst.setString(1, pojo.getNombre());
				pst.setString(2, pojo.getId());

				int numFilas = pst.executeUpdate();

				if (numFilas != 1) {
					System.out.println("El número de filas modificado ha sido " + numFilas);

				}

			} catch (SQLException e) {

				System.out.println("ERROR AL CREAR LA SENTENCIA");
				return false;

			}
		} catch (SQLException e) {
			System.out.println("ERROR DE CONEXION");
			System.out.println(e.getMessage());
			return false;
		}

		return true;
	}

	@Override
	public boolean delete(String id) {
	  /*boolean resul = false;
		Video v = null;
		if (id != null) {
			for (int i = 0; i < videos.size(); i++) {
				v = videos.get(i);
				if (id.equals(v.getId())) {
					resul = videos.remove(v);
					break;
				}
			}
		}
		return resul;*/
		
		try (Connection con = DriverManager.getConnection(url, usuario, password)) {

			String sql = "DELETE id, nombre FROM videos WHERE id = ?";

			try (PreparedStatement pst = con.prepareStatement(sql)) {

				pst.setString(1,id);
				

				int numFilas = pst.executeUpdate();

				if (numFilas != 1) {
					System.out.println("El número de filas modificado ha sido " + numFilas);

				}

			} catch (SQLException e) {

				System.out.println("ERROR AL CREAR LA SENTENCIA");
				return false;

			}
		} catch (SQLException e) {
			System.out.println("ERROR DE CONEXION");
			System.out.println(e.getMessage());
			return false;
		}

		return true;
	}

	@Override
	public Video getById(String id) {
		
		Video videos = new Video();
		
		
		try (Connection con = DriverManager.getConnection(url, usuario, password)) {

			String sql = "SELECT id, nombre from videos WHERE id = ?";

			try (PreparedStatement pst = con.prepareStatement(sql)) {

				pst.setString(1, id);
				

				int numFilas = pst.executeUpdate();

				if (numFilas != 1) {
					System.out.println("El número de filas modificado ha sido " + numFilas);

				}

			} catch (SQLException e) {

				System.out.println("ERROR AL CREAR LA SENTENCIA");
			
			}
		} catch (SQLException e) {
			System.out.println("ERROR DE CONEXION");
			System.out.println(e.getMessage());
		
		}

		return videos;
	}

}
