package com.ipartek.formacion.bbddyoutube.accesodatos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ipartek.formacion.bbddyoutube.pojos.Video;

public class VideoMySqlDAO implements CrudAble<Video>{
	private static VideoMySqlDAO INSTANCE = null;
	
	public static synchronized VideoMySqlDAO getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new VideoMySqlDAO();
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				System.out.println("ERROR AL CARGAR EL DRIVER DE JDBC");
				e.printStackTrace();
			}
		}
		return INSTANCE;
	}

	@SuppressWarnings("finally")
	@Override
	public List<Video> getAll() {
		String sql = "SELECT * FROM videos";	
		ArrayList<Video> videos = new ArrayList<Video>();
		Connection conn = UtilsDAO.getConnection();
		
		try (PreparedStatement pst = conn.prepareStatement(sql)) {
			try(ResultSet rs = pst.executeQuery()){
				while (rs.next()) {
					videos.add(new Video(rs.getLong("idVideo"), rs.getString("idYoutube"), rs.getString("nombre"), rs.getLong("idUsuario")));
				}
			}catch (Exception e) {
				System.out.println("ERROR AL CREAR EL RESULTSET DE GET ALL: " + e.getMessage());
				e.printStackTrace();
			}
		} catch (SQLException e) {
			System.out.println("ERROR AL CREAR LA SENTENCIA DE GET ALL");
		}finally {
			UtilsDAO.closeConnection(conn);
			return videos;
		}
	}
	
	@SuppressWarnings("finally")
	public List<Video> getAllAndUsers() {
		String sql2 = "SELECT idVideo, idYoutube,v.nombre, u.nombre FROM videos v, usuarios u " + 
				"WHERE v.idUsuario = u.idUsuario";
		ArrayList<Video> videos = new ArrayList<Video>();
		Connection conn = UtilsDAO.getConnection();
		
		try (PreparedStatement pst = conn.prepareStatement(sql2)) {
			try(ResultSet rs = pst.executeQuery()){
				while (rs.next()) {
					videos.add(new Video(rs.getLong(1), rs.getString(2), rs.getString(3), rs.getString(4)));
				}
			}catch (Exception e) {
				System.out.println("ERROR AL CREAR EL RESULTSET DE GET ALL AND USERS: " + e.getMessage());
				e.printStackTrace();
			}
		} catch (SQLException e) {
			System.out.println("ERROR AL CREAR LA SENTENCIA DE GET ALL AND USERS");
		}finally {
			UtilsDAO.closeConnection(conn);
			return videos;
		}
	}

	@SuppressWarnings("finally")
	@Override
	public Video getById(long idVideo) {
		String sql = "SELECT idVideo, idYoutube, nombre, idUsuario FROM videos WHERE idVideo = ?";
		Video video = null;
		Connection conn = UtilsDAO.getConnection();
		
		try (PreparedStatement pst = conn.prepareStatement(sql)){
			pst.setLong(1, idVideo);
			try(ResultSet rs = pst.executeQuery()){
				if(rs.next()) {
					video = new Video(rs.getLong("idVideo"), rs.getString("idYoutube"), rs.getString("nombre"),rs.getLong("idUsuario"));
				}else {
					return null;
				}
			}catch (Exception e) {
				System.out.println("ERROR AL CREAR EL RESULTSET DE GET BY ID");
			}
		} catch (SQLException e) {
			System.out.println("ERROR AL CREAR LA SENTENCIA DE GET BY ID");
		}finally {
			UtilsDAO.closeConnection(conn);
			return video;
		}
	}

	@SuppressWarnings("finally")
	@Override
	public boolean insert(Video pojo) {
		String sql = "INSERT INTO videos (idYoutube,nombre,idUsuario) VALUES (?,?,?)";	
		boolean result = false;
		Connection conn = UtilsDAO.getConnection();
		try (PreparedStatement pst = conn.prepareStatement(sql)){
			pst.setString(1, pojo.getIdVideo());
			pst.setString(2, pojo.getNombre());
			pst.setLong(3, pojo.getIdUsuario());
			
			int numFilas = pst.executeUpdate();
			
			if (numFilas != 1) {
				result = false;
			}else {
				result = true;
			}
		} catch (SQLException e) {
			System.out.println("ERROR AL CREAR LA SENTENCIA DE INSERT VIDEO");
			result = false;
		}finally {
			UtilsDAO.closeConnection(conn);
			return result;
		}
	}

	@SuppressWarnings("finally")
	@Override
	public boolean update(Video pojo) {
		String sql = "UPDATE videos SET idYoutube = ?, nombre = ?, idUsuario = ? WHERE idVideo = ?";	
		boolean result = false;
		Connection conn = UtilsDAO.getConnection();
		try (PreparedStatement pst = conn.prepareStatement(sql)){
			pst.setString(1, pojo.getIdVideo());
			pst.setString(2, pojo.getNombre());
			pst.setLong(3, pojo.getIdUsuario());
			pst.setLong(4, pojo.getId());
			
			int numFilas = pst.executeUpdate();
			
			if (numFilas != 1) {
				result = false;
			}else {
				result = true;
			}
		} catch (SQLException e) {
			System.out.println("ERROR AL CREAR LA SENTENCIA DE UPDATE");
			result = false;
		}finally {
			UtilsDAO.closeConnection(conn);
			return result;
		}
	}

	@SuppressWarnings("finally")
	@Override
	public boolean delete(long id) {
		String sql = "DELETE FROM videos WHERE idVideo= ?";	
		boolean result = false;
		Connection conn = UtilsDAO.getConnection();
		try (PreparedStatement pst = conn.prepareStatement(sql)){
			pst.setLong(1, id);
			
			int numFilas = pst.executeUpdate();
			
			if (numFilas != 1) {
				result = false;
			}else {
				result = true;
			}
		} catch (SQLException e) {
			System.out.println("ERROR AL CREAR LA SENTENCIA DE DELETE");
			result = false;
		}finally {
			UtilsDAO.closeConnection(conn);
			return result;
		}
	}
	
	@SuppressWarnings("finally")
	public boolean deleteByUser(long id) {
		String sql = "DELETE FROM videos WHERE idUsuario = ?";	
		boolean result = false;
		Connection conn = UtilsDAO.getConnection();
		try (PreparedStatement pst = conn.prepareStatement(sql)){
			pst.setLong(1, id);
			
			int numFilas = pst.executeUpdate();
			
			if (numFilas != 1) {
				result = false;
			}else {
				result = true;
			}
		} catch (SQLException e) {
			System.out.println("ERROR AL CREAR LA SENTENCIA DE DELETE BY USER");
			result = false;
		}finally {
			UtilsDAO.closeConnection(conn);
			return result;
		}
	}
	
	@SuppressWarnings("finally")
	public Long getVideoId(String idVideo) {
		String sql = "SELECT idVideo FROM videos WHERE idYoutube = ?";
		Long id = null;
		Connection conn = UtilsDAO.getConnection();
		
		try (PreparedStatement pst = conn.prepareStatement(sql)) {
			pst.setString(1, idVideo);
			try(ResultSet rs = pst.executeQuery()){
				if (rs.next()) {
					id = rs.getLong("idVideo");
				}
			}catch (Exception e) {
				System.out.println("ERROR AL CREAR EL RESULTSET DE GET VIDEO ID: " + e.getMessage());
				e.printStackTrace();
			}
		}catch (SQLException e) {
			System.out.println("ERROR AL CREAR LA SENTENCIA DE GET VIDEO ID");
		}finally {
			UtilsDAO.closeConnection(conn);
			return id;
		}
	}
}
