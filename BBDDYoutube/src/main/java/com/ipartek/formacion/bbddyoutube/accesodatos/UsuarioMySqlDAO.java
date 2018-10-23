package com.ipartek.formacion.bbddyoutube.accesodatos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ipartek.formacion.bbddyoutube.pojos.Usuario;

public class UsuarioMySqlDAO implements CrudAble<Usuario> {

	private static UsuarioMySqlDAO INSTANCE = null;

	public static synchronized UsuarioMySqlDAO getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new UsuarioMySqlDAO();
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				throw new AccesoDatosException(e.getMessage(), e);
			}
		}
		return INSTANCE;
	}
	
	@Override
	public boolean insert(Usuario pojo) {
		String sql = "INSERT INTO usuarios (nombre,password) VALUES (?,?)";	
		boolean result = false;
		Connection conn = UtilsDAO.getConnection();
		try (PreparedStatement pst = conn.prepareStatement(sql)){
			pst.setString(1, pojo.getNombre());
			pst.setString(2, pojo.getPassword());
			
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
	public List<Usuario> getAll() {
		String sql = "SELECT * FROM usuarios";	
		ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
		Connection conn = UtilsDAO.getConnection();
		
		try (PreparedStatement pst = conn.prepareStatement(sql)) {
			try(ResultSet rs = pst.executeQuery()){
				while (rs.next()) {
					usuarios.add(new Usuario(rs.getLong("idUsuario"), rs.getString("nombre"), rs.getString("password")));
				}
			}catch (Exception e) {
				throw new AccesoDatosException(e.getMessage(), e);
			}
		} catch (SQLException e) {
			throw new AccesoDatosException(e.getMessage(), e);
		}finally {
			if (conn!=null) UtilsDAO.closeConnection(conn);
		}
		return usuarios;
	}

	@Override
	public Usuario getById(long idUsuario) {
		String sql = "SELECT idUsuario, nombre, password FROM usuarios WHERE idUsuario = ?";	
		Usuario usuario = null;
		Connection conn = UtilsDAO.getConnection();
		
		try (PreparedStatement pst = conn.prepareStatement(sql)) {
			pst.setLong(1, idUsuario);
			try(ResultSet rs = pst.executeQuery()){
				if (rs.next()) {
					usuario = new Usuario(rs.getLong("idUsuario"),rs.getString("nombre"), rs.getString("password"));
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
		return usuario;
	}

	@Override
	public boolean update(Usuario pojo) {
		String sql = "UPDATE usuarios SET nombre = ?, password = ? WHERE idUsuario = ?";	
		boolean result = false;
		Connection conn = UtilsDAO.getConnection();
		try (PreparedStatement pst = conn.prepareStatement(sql)){
			pst.setString(1, pojo.getNombre());
			pst.setString(2, pojo.getPassword());
			pst.setLong(3, pojo.getId());
			
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

	public boolean delete(long idUsuario) {
		String sql = "DELETE FROM usuarios WHERE idUsuario = ?";	
		boolean result = false;
		Connection conn = UtilsDAO.getConnection();
		try (PreparedStatement pst = conn.prepareStatement(sql)){
			pst.setLong(1, idUsuario);
			
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
	
	public long getUserId(Usuario user) {
		String sql = "SELECT idUsuario FROM usuarios "
				+ "WHERE nombre = ? AND password = ?";
		Long userId = null;
		Connection conn = UtilsDAO.getConnection();
		
		try (PreparedStatement pst = conn.prepareStatement(sql)) {
			pst.setString(1, user.getNombre());
			pst.setString(2, user.getPassword());
			try(ResultSet rs = pst.executeQuery()){
				if (rs.next()) {
					userId = rs.getLong("idUsuario");
				}
			}catch (Exception e) {
				throw new AccesoDatosException(e.getMessage(), e);
			}
		}catch (SQLException e) {
			throw new AccesoDatosException(e.getMessage(), e);
		}finally {
			if (conn!=null) UtilsDAO.closeConnection(conn);
		}
		return userId;
	}
}
