package com.ipartek.formacion.youtube.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ipartek.formacion.youtube.Video;

public class VideoArrayListDAO implements CrudAble<Video> {

	String url = "jdbc:mysql://localhost:3307/ipartek?serverTimezone=UTC&useSSL=false";
	String usuario = "root";
	String password = "admin";

	private static VideoArrayListDAO INSTANCE = null;
	private static List<Video> videos = null;

	// private VideoArrayListDAO() {

	/*
	 * try { videos.add(new Video("LPDhuthFD98",
	 * "Surf Search Spot 2 0 video promo")); videos.add(new Video("a9WnQFI8jQU",
	 * "Betagarri - Sweet Mary")); videos.add(new Video("0sLK1SKfItM",
	 * "Su Ta Gar - Begira")); } catch (Exception e) { e.printStackTrace(); }
	 * 
	 * }
	 */

	public static synchronized VideoArrayListDAO getInstance() throws ClassNotFoundException {
		Class.forName("com.mysql.jdbc.Driver");
		if (INSTANCE == null) {
			INSTANCE = new VideoArrayListDAO();
		}

		return INSTANCE;
	}

	@Override
	public boolean insert(Video pojo) {

		try (Connection conn = DriverManager.getConnection(url, usuario, password)) {
			String sql = "INSERT INTO videos (id, nombre) VALUES (?, ?)";

			try (PreparedStatement pst = conn.prepareStatement(sql)) {
				pst.setString(1, pojo.getId());
				pst.setString(2, pojo.getNombre());

				int numFilas = pst.executeUpdate();

				if (numFilas != 1) {
					return false;
				}
			} catch (Exception e) {
				System.out.println("ERROR AL CREAR LA SENTENCIA");
			}

		} catch (Exception e) {
			System.out.println("ERROR DE CONEXION");
		}
		return videos.add(pojo);
	}

	@Override
	public List<Video> getAll() {

		String url = "jdbc:mysql://localhost:3307/ipartek?serverTimezone=UTC&useSSL=false";
		String usuario = "root";
		String password = "admin";

		videos = new ArrayList<Video>();

		try (Connection conn = DriverManager.getConnection(url, usuario, password)) {

			String sql = "SELECT id, nombre, FROM videos";

			try (PreparedStatement pst = conn.prepareStatement(sql)) {

				ResultSet rs = pst.executeQuery();

				while (rs.next()) {
					videos.add(new Video(rs.getString("id"), rs.getString("nombre")));
				}

			} catch (SQLException e) {
				System.out.println("ERROR AL METER DATOS EN ARRAY");
			}

		} catch (Exception e) {
			System.out.println("ERROR DE CONEXION");
		}
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
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(String id) {
		boolean resul = false;
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
		return resul;
	}

}
