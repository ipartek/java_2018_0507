package com.ipartek.formacion.bbddyoutube.accesodatos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ipartek.formacion.bbddyoutube.pojos.Usuario;
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
					videos.add(new Video(rs.getLong("idVideo"), rs.getString("idYoutube"), rs.getString("nombre")));
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
	@Override
	public Video getById(long idVideo) {
		String sql = "SELECT idYoutube, nombre FROM videos WHERE idVideo = ?";
		Video video = null;
		Connection conn = UtilsDAO.getConnection();
		
		try (PreparedStatement pst = conn.prepareStatement(sql)){
			pst.setLong(1, idVideo);
			try(ResultSet rs = pst.executeQuery()){
				if(rs.next()) {
					video = new Video(rs.getLong("idVideo"), rs.getString("idYoutube"), rs.getString("nombre"));
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
		String sql = "INSERT INTO videos (idYoutube,nombre) VALUES (?,?)";	
		boolean result = false;
		Connection conn = UtilsDAO.getConnection();
		try (PreparedStatement pst = conn.prepareStatement(sql)){
			pst.setString(1, pojo.getIdVideo());
			pst.setString(2, pojo.getNombre());
			
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
		String sql = "UPDATE videos SET idYoutube = ?, nombre = ? WHERE id = ?";	
		boolean result = false;
		Connection conn = UtilsDAO.getConnection();
		try (PreparedStatement pst = conn.prepareStatement(sql)){
			pst.setString(1, pojo.getIdVideo());
			pst.setString(2, pojo.getNombre());
			pst.setLong(3, pojo.getId());
			
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
	public boolean insertIntoUser(Video pojo, long userId) {
		String sql = "INSERT INTO usuariosvideos (idUsuario,idVideo) VALUES (?,?)";	
		boolean result = false;
		Connection conn = UtilsDAO.getConnection();
		try (PreparedStatement pst = conn.prepareStatement(sql)){
			pst.setLong(1, userId);
			pst.setLong(2, pojo.getId());
			
			int numFilas = pst.executeUpdate();
			
			if (numFilas != 1) {
				result = false;
			}else {
				result = true;
			}
		} catch (SQLException e) {
			System.out.println("ERROR AL CREAR LA SENTENCIA DE INSERT VIDEO INTO USER");
			result = false;
		}finally {
			UtilsDAO.closeConnection(conn);
			return result;
		}
	}
	@SuppressWarnings("finally")
	public Long getVideoId(String idVideo) {
		String sql = "SELECT idVideo FROM videos "
				+ "WHERE idYoutube = ?";
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

	public boolean searchInUser(Long idVideo, Long idUsuario) {
		String sql = "SELECT * FROM usuariosvideos WHERE idUsuario= ? AND idVideo = ?";
		Connection conn = UtilsDAO.getConnection();
		boolean result = false;
		
		try (PreparedStatement pst = conn.prepareStatement(sql)){
			pst.setLong(1, idUsuario);
			pst.setLong(1, idVideo);
			try(ResultSet rs = pst.executeQuery()){
				if(rs.next()) {
					result = true;
				}
			}catch (Exception e) {
				System.out.println("ERROR AL CREAR EL RESULTSET DE GET BY ID");
			}
		} catch (SQLException e) {
			System.out.println("ERROR AL CREAR LA SENTENCIA DE GET BY ID");
		}finally {
			UtilsDAO.closeConnection(conn);
		}
		return result;
	}
}
