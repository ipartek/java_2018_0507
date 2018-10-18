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
				System.out.println("ERROR AL CARGAR EL DRIVER DE JDBC");
				e.printStackTrace();
			}
		}
		return INSTANCE;
	}

	@Override
	public List<Comentario> getAll() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@SuppressWarnings("finally")
	public List<Comentario> getAllFromVideo(Video video){
		String sql = "SELECT c.*, u.nombre FROM comentarios c" +
		" JOIN usuarios u ON c.usuarios_idUsuario = u.idUsuario" +
		" WHERE videos_IdVideo = ?";
		ArrayList<Comentario> comentarios = new ArrayList<Comentario>();
		Connection conn = UtilsDAO.getConnection();
		
		try (PreparedStatement pst = conn.prepareStatement(sql)) {
			pst.setLong(1, video.getId());
			try(ResultSet rs = pst.executeQuery()){
				while (rs.next()) {
					comentarios.add(new Comentario(rs.getLong("id"), rs.getString("videos_IdVideo"), rs.getLong("usuarios_IdUsuario"), rs.getString("comentario"), rs.getDate("fecha"), rs.getString("nombre")));
				}
			}catch (Exception e) {
				System.out.println("ERROR AL CREAR EL RESULTSET DE GET ALL FROM VIDEO: " + e.getMessage());
				e.printStackTrace();
			}
		} catch (SQLException e) {
			System.out.println("ERROR AL CREAR LA SENTENCIA DE GET ALL FROM VIDEO");
		}finally {
			if (conn!=null) UtilsDAO.closeConnection(conn);
			return comentarios;
		}
	}

	@SuppressWarnings("finally")
	@Override
	public Comentario getById(long id) {
		String sql = "SELECT videos_IdVideo, usuarios_IdUsuario, comentario, fecha FROM comentarios WHERE id = ?";
		Comentario comentario = null;
		Connection conn = UtilsDAO.getConnection();
		
		try (PreparedStatement pst = conn.prepareStatement(sql)){
			pst.setLong(1, id);
			try(ResultSet rs = pst.executeQuery()){
				if(rs.next()) {
					comentario = new Comentario(id, rs.getString("videos_IdVideo"), rs.getLong("usuarios_IdUsuario"), rs.getString("comentario"), rs.getDate("fecha"));
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
			return comentario;
		}
	}

	@SuppressWarnings("finally")
	@Override
	public boolean insert(Comentario pojo) {
		String sql = "INSERT INTO comentarios (videos_IdVideo, usuarios_IdUsuario, comentario, fecha) VALUES (?,?,?,?)";	
		boolean result = false;
		Connection conn = UtilsDAO.getConnection();
		try (PreparedStatement pst = conn.prepareStatement(sql)){
			pst.setString(1, pojo.getIdVideo());
			pst.setLong(2, pojo.getIdUsuario());
			pst.setString(3, pojo.getTexto());
			pst.setDate(4, (java.sql.Date) pojo.getFecha());
			
			int numFilas = pst.executeUpdate();
			
			if (numFilas != 1) {
				result = false;
			}else {
				result = true;
			}
		} catch (SQLException e) {
			System.out.println("ERROR AL CREAR LA SENTENCIA DE INSERT COMENTARIO");
			result = false;
		}finally {
			if (conn!=null) UtilsDAO.closeConnection(conn);
			return result;
		}
	}

	@SuppressWarnings("finally")
	@Override
	public boolean update(Comentario pojo) {
		String sql = "UPDATE comentarios SET videos_IdVideo = ?, usuarios_IdUsuario = ?, comentario = ?, fecha = ? WHERE id = ?";	
		boolean result = false;
		Connection conn = UtilsDAO.getConnection();
		try (PreparedStatement pst = conn.prepareStatement(sql)){
			pst.setString(1, pojo.getIdVideo());
			pst.setLong(2, pojo.getIdUsuario());
			pst.setString(3, pojo.getTexto());
			pst.setDate(4, (java.sql.Date) pojo.getFecha());
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
			System.out.println("ERROR AL CREAR LA SENTENCIA DE DELETE");
			result = false;
		}finally {
			if (conn!=null) UtilsDAO.closeConnection(conn);
			return result;
		}
	}

}