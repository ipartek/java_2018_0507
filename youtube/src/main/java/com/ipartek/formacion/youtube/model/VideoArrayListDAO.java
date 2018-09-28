package com.ipartek.formacion.youtube.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.ipartek.formacion.youtube.Video;

public class VideoArrayListDAO implements CrudAble<Video> {

	private static VideoArrayListDAO INSTANCE = null;
	private static List<Video> videos = null;
	String url = "jdbc:mysql://localhost:3307/ipartek?serverTimezone=UTC&useSSL=false";
	static String usuario = "root";
	static String password = "admin";
	
	
	private VideoArrayListDAO() {
		videos = new ArrayList<Video>();
		try (Connection conn = DriverManager.getConnection(url, usuario, password)) {
			try (Statement stmt = conn.createStatement()) {
				String sql = "SELECT id, codigo, titulo FROM videoyoutube";
				try (ResultSet rs = stmt.executeQuery(sql)) {			
					while (rs.next()) {
						String id = rs.getString("id");
						String nombre = rs.getString("nombre");
						Video vid = new Video(id, nombre);
						videos.add(vid);
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
	}

	public static synchronized VideoArrayListDAO getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new VideoArrayListDAO();
		}

		return INSTANCE;
	}

	@Override
	public boolean insert(Video pojo) {
		return videos.add(pojo);
	}

	@Override
	public List<Video> getAll() {
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

}
