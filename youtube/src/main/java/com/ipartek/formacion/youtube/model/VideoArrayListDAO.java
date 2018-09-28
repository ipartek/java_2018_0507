package com.ipartek.formacion.youtube.model;

import java.util.List;

import java.sql.*;

import com.ipartek.formacion.youtube.Video;

public class VideoArrayListDAO implements CrudAble<Video> {

	private static VideoArrayListDAO INSTANCE = null;
	//private static List<Video> videos = null;
	
	String url = "jdbc:mysql://localhost:3307/ipartek?serverTimezone=UTC&useSSL=false";
	String usuario = "root";
	String password = "admin";

	/*private VideoArrayListDAO() {
		videos = new ArrayList<Video>();
		try {
			videos.add(new Video("LPDhuthFD98", "Surf Search Spot 2 0 video promo"));
			videos.add(new Video("a9WnQFI8jQU", "Betagarri - Sweet Mary"));
			videos.add(new Video("0sLK1SKfItM", "Su Ta Gar - Begira"));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}*/

	public static synchronized VideoArrayListDAO getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new VideoArrayListDAO();
		}

		return INSTANCE;
	}
	
	public Connection getConnection() {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(url, usuario, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return conn;
	}
	
	public void closeConnection(Connection con) {
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@SuppressWarnings("finally")
	@Override
	public boolean insert(Video pojo) {
		// INSERTAR EN LA TABLA
		String sql = "INSERT INTO videos (id,nombre) VALUES (?,?)";	
		boolean result = false;
		Connection conn = getConnection();
		try (PreparedStatement pst = conn.prepareStatement(sql);){
			pst.setString(1, pojo.getId());
			pst.setString(2, pojo.getNombre());
			
			int numFilas = pst.executeUpdate();
			
			if (numFilas != 1) {
				result = false;
			}else {
				result = true;
			}
		} catch (SQLException e) {
			System.out.println("ERROR AL CREAR LA SENTENCIA");
			result = false;
		}finally {
			closeConnection(conn);
			return result;
		}
	}

	@SuppressWarnings({ "null", "finally" })
	@Override
	public List<Video> getAll() {
		// SELECT ALL FROM TABLA
		String sql = "SELECT * FROM videos";	
		List<Video> videos = null;
		Connection conn = getConnection();
		
		try (PreparedStatement pst = conn.prepareStatement(sql)) {
			try(ResultSet rs = pst.executeQuery()){
				while (rs.next()) {
					videos.add(new Video(rs.getString(1), rs.getString(2)));
				}
			}catch (Exception e) {
				System.out.println("ERROR AL CREAR EL RESULTSET");
			}
		} catch (SQLException e) {
			System.out.println("ERROR AL CREAR LA SENTENCIA");
		}finally {
			closeConnection(conn);
			return videos;
		}
	}

	@SuppressWarnings({ "finally", "null" })
	@Override
	public Video getById(String id) {
		String sql = "SELECT id, nombre FROM videos WHERE id = ?";	
		Video video = null;
		Connection conn = getConnection();
		
		try (PreparedStatement pst = conn.prepareStatement(sql)) {
			pst.setString(1, id);
			try(ResultSet rs = pst.executeQuery()){
				while (rs.next()) {
					video.setId(rs.getString(1));
					video.setNombre(rs.getString(2));
				}
			}catch (Exception e) {
				System.out.println("ERROR AL CREAR EL RESULTSET");
			}
		} catch (SQLException e) {
			System.out.println("ERROR AL CREAR LA SENTENCIA");
		}finally {
			closeConnection(conn);
			return video;
		}
	}

	@Override
	public boolean update(Video pojo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(String id) {
		
		return false;
	}

}
