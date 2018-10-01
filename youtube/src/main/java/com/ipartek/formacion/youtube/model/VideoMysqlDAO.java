package com.ipartek.formacion.youtube.model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.ipartek.formacion.youtube.Video;

public class VideoMysqlDAO implements CrudAble<Video> {

	String url = "jdbc:mysql://localhost:3307/ipartek?serverTimezone=UTC&useSSL=false";
	String usuario = "root";
	String password = "admin";

	private static VideoMysqlDAO INSTANCE = null;
	private static List<Video> videos = null;

	private VideoMysqlDAO() {
		videos = new ArrayList<Video>();
		try {
			videos.add(new Video("LPDhuthFD98", "Surf Search Spot 2 0 video promo"));
			videos.add(new Video("a9WnQFI8jQU", "Betagarri - Sweet Mary"));
			videos.add(new Video("0sLK1SKfItM", "Su Ta Gar - Begira"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static synchronized VideoMysqlDAO getInstance() throws ClassNotFoundException {
		
		if (INSTANCE == null) {
			Class.forName("com.mysql.jdbc.Driver");
			INSTANCE = new VideoMysqlDAO();
		}

		return INSTANCE;
	}

	@Override
	public boolean insert(Video pojo) {

		try (Connection conn = DriverManager.getConnection(url, usuario, password)) {
			String sql = "INSERT INTO videos VALUES (?, ?)";

			try (PreparedStatement pst = conn.prepareStatement(sql)) { //prepareStatement con ?
				pst.setString(1, pojo.getId());
				pst.setString(2, pojo.getNombre());

				pst.executeUpdate();

			} catch (Exception e) {
				System.out.println("ERROR AL CREAR LA SENTENCIA");
				return false;
			}

		} catch (Exception e) {
			System.out.println("ERROR DE CONEXION");
			System.out.println(e.getMessage());
			
			
			return false;
		}
		return true;
	}

	@Override
	public List<Video> getAll() {

		ArrayList<Video> videos = new ArrayList<Video>();

		try (Connection conn = DriverManager.getConnection(url, usuario, password)) {

			String sql = "SELECT * FROM videos";

			try (Statement stmt = conn.createStatement()) { //createStatement sin ?

				try (ResultSet rs = stmt.executeQuery(sql)){

					while (rs.next()) {
						videos.add(new Video(rs.getString("id"), rs.getString("nombre")));
					}

				}
			} catch (SQLException e) {
				System.out.println("ERROR AL CREAR EL RESULTSET");
			}

		} catch (Exception e) {
			System.out.println("ERROR DE CONEXION");
			System.out.println(e.getMessage());
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
