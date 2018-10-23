package com.ipartek.formacion.bbddyoutube.accesodatos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ipartek.formacion.bbddyoutube.pojos.Comentario;
import com.ipartek.formacion.bbddyoutube.pojos.Video;

public class ComentarioMySqlDAO implements CrudAble<Comentario> {
	private static ComentarioMySqlDAO INSTANCE = null;

	public static synchronized ComentarioMySqlDAO getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new ComentarioMySqlDAO();
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				throw new AccesoDatosException(e.getMessage(), e);
			}
		}
		return INSTANCE;
	}

	@Override
	public List<Comentario> getAll() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public List<Comentario> getAllFromVideo(Video video){
		String sql = "SELECT c.*, u.nombre FROM comentarios c" +
		" JOIN usuarios u ON c.usuarios_idUsuario = u.idUsuario" +
		" WHERE videos_IdVideo = ?" + 
		" ORDER BY id DESC";
		ArrayList<Comentario> comentarios = new ArrayList<Comentario>();
		Connection conn = UtilsDAO.getConnection();
		
		try (PreparedStatement pst = conn.prepareStatement(sql)) {
			pst.setLong(1, video.getId());
			try(ResultSet rs = pst.executeQuery()){
				while (rs.next()) {
					comentarios.add(new Comentario(rs.getLong("id"), rs.getLong("videos_IdVideo"), rs.getLong("usuarios_IdUsuario"), rs.getString("comentario"), rs.getTimestamp("fecha"), rs.getString("nombre")));
				}
			}catch (Exception e) {
				throw new AccesoDatosException(e.getMessage(), e);
			}
		} catch (SQLException e) {
			throw new AccesoDatosException(e.getMessage(), e);
		}finally {
			if (conn!=null) UtilsDAO.closeConnection(conn);
		}
		return comentarios;
	}

	@Override
	public Comentario getById(long id) {
		String sql = "SELECT videos_IdVideo, usuarios_IdUsuario, comentario, fecha FROM comentarios WHERE id = ?";
		Comentario comentario = null;
		Connection conn = UtilsDAO.getConnection();
		
		try (PreparedStatement pst = conn.prepareStatement(sql)){
			pst.setLong(1, id);
			try(ResultSet rs = pst.executeQuery()){
				if(rs.next()) {
					comentario = new Comentario(id, rs.getLong("videos_IdVideo"), rs.getLong("usuarios_IdUsuario"), rs.getString("comentario"), rs.getTimestamp("fecha"));
				}else {
					return null;
				}
			}catch (Exception e) {
				throw new AccesoDatosException(e.getMessage(), e);
			}
		} catch (SQLException e) {
			throw new AccesoDatosException(e.getMessage(), e);
		}finally {
			if (conn!=null) UtilsDAO.closeConnection(conn);
		}
		return comentario;
	}

	@Override
	public boolean insert(Comentario pojo) {
		String sql = "INSERT INTO comentarios (videos_IdVideo, usuarios_IdUsuario, comentario, fecha) VALUES (?,?,?,?)";	
		boolean result = false;
		Connection conn = UtilsDAO.getConnection();
		try (PreparedStatement pst = conn.prepareStatement(sql)){
			pst.setLong(1, pojo.getIdVideo());
			pst.setLong(2, pojo.getIdUsuario());
			pst.setString(3, pojo.getTexto());
			pst.setTimestamp(4, new java.sql.Timestamp(pojo.getFecha().getTime()));
			
			int numFilas = pst.executeUpdate();
			
			if (numFilas != 1) {
				result = false;
			}else {
				result = true;
			}
		} catch (SQLException e) {
			result = false;
			throw new AccesoDatosException(e.getMessage(), e);
		}finally {
			if (conn!=null) UtilsDAO.closeConnection(conn);
		}
		
		return result;
	}

	@Override
	public boolean update(Comentario pojo) {
		String sql = "UPDATE comentarios SET videos_IdVideo = ?, usuarios_IdUsuario = ?, comentario = ?, fecha = ? WHERE id = ?";	
		boolean result = false;
		Connection conn = UtilsDAO.getConnection();
		try (PreparedStatement pst = conn.prepareStatement(sql)){
			pst.setLong(1, pojo.getIdVideo());
			pst.setLong(2, pojo.getIdUsuario());
			pst.setString(3, pojo.getTexto());
			pst.setTimestamp(4, new java.sql.Timestamp(pojo.getFecha().getTime()));
			pst.setLong(5, pojo.getId());
			
			int numFilas = pst.executeUpdate();
			
			if (numFilas != 1) {
				result = false;
			}else {
				result = true;
			}
		} catch (SQLException e) {
			result = false;
			throw new AccesoDatosException(e.getMessage(), e);
		}finally {
			if (conn!=null) UtilsDAO.closeConnection(conn);
		}
		return result;
	}

	@Override
	public boolean delete(long id) {
		String sql = "DELETE FROM comentarios WHERE id= ?";	
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
			result = false;
			throw new AccesoDatosException(e.getMessage(), e);
		}finally {
			if (conn!=null) UtilsDAO.closeConnection(conn);
		}
		return result;
	}

}