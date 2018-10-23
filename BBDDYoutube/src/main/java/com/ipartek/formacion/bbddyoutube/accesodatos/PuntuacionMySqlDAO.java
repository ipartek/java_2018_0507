package com.ipartek.formacion.bbddyoutube.accesodatos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.ipartek.formacion.bbddyoutube.pojos.Puntuacion;

public class PuntuacionMySqlDAO implements CrudAble<Puntuacion>{
	private static PuntuacionMySqlDAO INSTANCE = null;

	public static synchronized PuntuacionMySqlDAO getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new PuntuacionMySqlDAO();
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				throw new AccesoDatosException(e.getMessage(), e);
			}
		}
		return INSTANCE;
	}

	public int getPuntosById(long id) {
		String sql = "SELECT AVG(puntuacion) FROM puntuaciones WHERE videos_idVideo = ?";
		int media = 0;
		Connection conn = UtilsDAO.getConnection();
		
		try (PreparedStatement pst = conn.prepareStatement(sql)){
			pst.setLong(1, id);
			try(ResultSet rs = pst.executeQuery()){
				if(rs.next()) {
					media = rs.getInt(1);
				}
			}catch (Exception e) {
				throw new AccesoDatosException(e.getMessage(), e);
			}
		} catch (SQLException e) {
			throw new AccesoDatosException(e.getMessage(), e);
		}finally {
			if (conn!=null) UtilsDAO.closeConnection(conn);
		}
		return media;
	}
	
	@Override
	public List<Puntuacion> getAll() {
		throw new AccesoDatosException("TO BE IMPLEMENTED");
	}

	@Override
	public Puntuacion getById(long id) {
		throw new AccesoDatosException("TO BE IMPLEMENTED");
	}

	@Override
	public boolean insert(Puntuacion pojo) {
		String sql = "INSERT INTO puntuaciones (usuarios_idUsuario, videos_IdVideo, puntuacion) VALUES (?,?,?)";	
		boolean result = false;
		Connection conn = UtilsDAO.getConnection();
		try (PreparedStatement pst = conn.prepareStatement(sql)){
			pst.setLong(1, pojo.getIdUsuario());
			pst.setLong(2, pojo.getIdVideo());
			pst.setInt(3, pojo.getPuntos());
			
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
	public boolean update(Puntuacion pojo) {
		throw new AccesoDatosException("TO BE IMPLEMENTED");
	}

	@Override
	public boolean delete(long id) {
		throw new AccesoDatosException("TO BE IMPLEMENTED");
	}
}
