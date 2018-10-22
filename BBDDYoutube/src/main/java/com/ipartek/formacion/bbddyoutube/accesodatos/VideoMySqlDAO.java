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
	
	public static synchronized VideoMySqlDAO getInstance() throws ClassNotFoundException {
		if (INSTANCE == null) {
			Class.forName("com.mysql.cj.jdbc.Driver");
			INSTANCE = new VideoMySqlDAO();
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
					videos.add(new Video(rs.getLong("idVideo"), rs.getString("idYoutube"), rs.getString("nombre"), rs.getString("descripcion"), rs.getLong("idUsuario")));
				}
			}catch (Exception e) {
				System.out.println("ERROR AL CREAR EL RESULTSET DE GET ALL: " + e.getMessage());
				e.printStackTrace();
			}
		} catch (SQLException e) {
			System.out.println("ERROR AL CREAR LA SENTENCIA DE GET ALL");
		}finally {
			if (conn!=null) UtilsDAO.closeConnection(conn);
			return videos;
		}
	}
	
	@SuppressWarnings("finally")
	public List<Video> getAllVideosAndUser() {
		String sql = "SELECT v.idVideo, v.idYoutube, v.nombre, v.descripcion, u.nombre FROM videos v " + 
				"JOIN usuarios u ON u.idUsuario = v.idUsuario " + 
				"ORDER BY v.idUsuario";
		ArrayList<Video> videos = new ArrayList<Video>();
		Connection conn = UtilsDAO.getConnection();
		
		try (PreparedStatement pst = conn.prepareStatement(sql)) {
			try(ResultSet rs = pst.executeQuery()){
				while (rs.next()) {
					videos.add(new Video(rs.getLong(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5)));
				}
			}catch (Exception e) {
				System.out.println("ERROR AL CREAR EL RESULTSET DE GET ALL: " + e.getMessage());
				e.printStackTrace();
			}
		} catch (SQLException e) {
			System.out.println("ERROR AL CREAR LA SENTENCIA DE GET ALL");
		}finally {
			if (conn!=null) UtilsDAO.closeConnection(conn);
			return videos;
		}
	}
	
	@SuppressWarnings("finally")
	public List<Video> getAllUserVideos(long idUsuario) {
		String sql = "SELECT idYoutube, nombre, descripcion FROM videos WHERE idUsuario= ?";
				
		ArrayList<Video> videos = new ArrayList<Video>();
		Connection conn = UtilsDAO.getConnection();
		
		try (PreparedStatement pst = conn.prepareStatement(sql)) {
			pst.setLong(1, idUsuario);
			try(ResultSet rs = pst.executeQuery()){
				while (rs.next()) {
					videos.add(new Video(rs.getString("idYoutube"), rs.getString("nombre"), rs.getString("descripcion")));
				}
			}catch (Exception e) {
				System.out.println("ERROR AL CREAR EL RESULTSET DE GET ALL BY USER: " + e.getMessage());
				e.printStackTrace();
			}
		} catch (SQLException e) {
			System.out.println("ERROR AL CREAR LA SENTENCIA DE GET ALL BY USER");
		}finally {
			if (conn!=null) UtilsDAO.closeConnection(conn);
			return videos;
		}
	}

	@SuppressWarnings("finally")
	@Override
	public Video getById(long idVideo) {
		String sql = "SELECT idVideo, idYoutube, nombre, descripcion, idUsuario FROM videos WHERE idVideo = ?";
		Video video = null;
		Connection conn = UtilsDAO.getConnection();
		
		try (PreparedStatement pst = conn.prepareStatement(sql)){
			pst.setLong(1, idVideo);
			try(ResultSet rs = pst.executeQuery()){
				if(rs.next()) {
					video = new Video(rs.getLong("idVideo"), rs.getString("idYoutube"), rs.getString("nombre"), rs.getString("descripcion"), rs.getLong("idUsuario"));
				}else {
					return null;
				}
			}catch (Exception e) {
				System.out.println("ERROR AL CREAR EL RESULTSET DE GET BY ID");
			}
		} catch (SQLException e) {
			System.out.println("ERROR AL CREAR LA SENTENCIA DE GET BY ID");
		}finally {
			if (conn!=null) UtilsDAO.closeConnection(conn);
			return video;
		}
	}

	@SuppressWarnings("finally")
	@Override
	public boolean insert(Video pojo) {
		String sql = "INSERT INTO videos (idYoutube,nombre,descripcion, idUsuario) VALUES (?,?,?,?)";	
		boolean result = false;
		Connection conn = UtilsDAO.getConnection();
		try (PreparedStatement pst = conn.prepareStatement(sql)){
			pst.setString(1, pojo.getIdVideo());
			pst.setString(2, pojo.getNombre());
			pst.setString(3, pojo.getDescripcion());
			pst.setLong(4, pojo.getIdUsuario());
			
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
			if (conn!=null) UtilsDAO.closeConnection(conn);
			return result;
		}
	}

	@SuppressWarnings("finally")
	@Override
	public boolean update(Video pojo) {
		String sql = "UPDATE videos SET idYoutube = ?, nombre = ?, descripcion = ?, idUsuario = ? WHERE idVideo = ?";	
		boolean result = false;
		Connection conn = UtilsDAO.getConnection();
		try (PreparedStatement pst = conn.prepareStatement(sql)){
			pst.setString(1, pojo.getIdVideo());
			pst.setString(2, pojo.getNombre());
			pst.setString(3, pojo.getDescripcion());
			pst.setLong(4, pojo.getIdUsuario());
			pst.setLong(5, pojo.getId());
			
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
			if (conn!=null) UtilsDAO.closeConnection(conn);
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
			if (conn!=null) UtilsDAO.closeConnection(conn);
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
			if (conn!=null) UtilsDAO.closeConnection(conn);
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
			if (conn!=null) UtilsDAO.closeConnection(conn);
			return id;
		}
	}

	@SuppressWarnings("finally")
	public Video getFirstVideo(Long idUser) {
		String sql = "SELECT idVideo, idYoutube, nombre, descripcion FROM videos WHERE idUsuario= ? LIMIT 1";
		Video video = null;
		Connection conn = UtilsDAO.getConnection();
		
		try (PreparedStatement pst = conn.prepareStatement(sql)){
			pst.setLong(1, idUser);
			try(ResultSet rs = pst.executeQuery()){
				if(rs.next()) {
					video = new Video(rs.getLong("idVideo"), rs.getString("idYoutube"), rs.getString("nombre"), rs.getString("descripcion"), idUser);
				}else {
					return null;
				}
			}catch (Exception e) {
				System.out.println("ERROR AL CREAR EL RESULTSET DE GET FIRST VIDEO");
			}
		} catch (SQLException e) {
			System.out.println("ERROR AL CREAR LA SENTENCIA DE GET FIRST VIDEO");
		}finally {
			if (conn!=null) UtilsDAO.closeConnection(conn);
			return video;
		}
	}
}
