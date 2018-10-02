package com.ipartek.formacion.bbddyoutube.accesodatos;

import java.util.ArrayList;
import java.util.List;

import java.sql.*;
import com.ipartek.formacion.bbddyoutube.pojos.Usuario;
import com.ipartek.formacion.bbddyoutube.pojos.Video;

public class UsuarioMySqlDAO implements CrudAble<Usuario> {

	private static UsuarioMySqlDAO INSTANCE = null;
	
	String url = "jdbc:mysql://localhost:3307/ipartek?serverTimezone=UTC&useSSL=false";
	String usuario = "root";
	String password = "admin";

	public static synchronized UsuarioMySqlDAO getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new UsuarioMySqlDAO();
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				System.out.println("ERROR AL CARGAR EL DRIVER DE JDBC");
				e.printStackTrace();
			}
		}
		return INSTANCE;
	}
	
	public Connection getConnection() {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(url, usuario, password);
		} catch (SQLException e) {
			System.out.println("ERROR AL CONECTARSE A LA BBDD");
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
	public boolean insert(Usuario pojo) {
		// INSERTAR EN LA TABLA
		String sql = "INSERT INTO usuarios (nombre,password) VALUES (?,?)";	
		boolean result = false;
		Connection conn = getConnection();
		try (PreparedStatement pst = conn.prepareStatement(sql);){
			pst.setString(1, pojo.getNombre());
			pst.setString(2, pojo.getPassword());
			
			int numFilas = pst.executeUpdate();
			
			if (numFilas != 1) {
				result = false;
			}else {
				result = true;
			}
		} catch (SQLException e) {
			System.out.println("ERROR AL CREAR LA SENTENCIA DE INSERT USUARIO");
			result = false;
		}finally {
			closeConnection(conn);
			return result;
		}
	}

	@SuppressWarnings({ "finally" })
	@Override
	public List<Usuario> getAll() {
		String sql = "SELECT * FROM usuarios";	
		ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
		Connection conn = getConnection();
		
		try (PreparedStatement pst = conn.prepareStatement(sql)) {
			try(ResultSet rs = pst.executeQuery()){
				while (rs.next()) {
					usuarios.add(new Usuario(rs.getLong("idUsuario"), rs.getString("nombre"), rs.getString("password")));
				}
			}catch (Exception e) {
				System.out.println("ERROR AL CREAR EL RESULTSET DE GET ALL: " + e.getMessage());
				e.printStackTrace();
			}
		} catch (SQLException e) {
			System.out.println("ERROR AL CREAR LA SENTENCIA DE GET ALL");
		}finally {
			closeConnection(conn);
			return usuarios;
		}
	}

	@SuppressWarnings({ "finally" })
	@Override
	public Usuario getById(long idUsuario) {
		String sql = "SELECT nombre, password FROM usuarios WHERE idUsuario = ?";	
		Usuario usuario = null;
		Connection conn = getConnection();
		
		try (PreparedStatement pst = conn.prepareStatement(sql)) {
			pst.setLong(1, idUsuario);
			try(ResultSet rs = pst.executeQuery()){
				if (rs.next()) {
					usuario = new Usuario(rs.getLong("idUsuario"),rs.getString("nombre"), rs.getString("password"));
				}else {
					return null;
				}
			}catch (Exception e) {
				System.out.println("ERROR AL CREAR EL RESULTSET DE GET BY ID");
			}
		} catch (SQLException e) {
			System.out.println("ERROR AL CREAR LA SENTENCIA DE GET BY ID");
		}finally {
			closeConnection(conn);
			return usuario;
		}
	}

	@SuppressWarnings("finally")
	@Override
	public boolean update(Usuario pojo) {
		String sql = "UPDATE usuarios SET nombre = ?, password = ? WHERE idUsuario = ?";	
		boolean result = false;
		Connection conn = getConnection();
		try (PreparedStatement pst = conn.prepareStatement(sql);){
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
			System.out.println("ERROR AL CREAR LA SENTENCIA DE UPDATE");
			result = false;
		}finally {
			closeConnection(conn);
			return result;
		}
	}

	@SuppressWarnings("finally")
	public boolean delete(long idUsuario) {
		String sql = "DELETE FROM usuarios WHERE idUsuario = ?";	
		boolean result = false;
		Connection conn = getConnection();
		try (PreparedStatement pst = conn.prepareStatement(sql);){
			pst.setLong(1, idUsuario);
			
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
			closeConnection(conn);
			return result;
		}
	}
	
	@SuppressWarnings("finally")
	public long getUserId(Usuario user) {
		String sql = "SELECT idUsuario FROM usuarios "
				+ "WHERE nombre = ? AND password = ?";
		//Long userId = (long) 2;
		Long userId = null;
		Connection conn = getConnection();
		
		try (PreparedStatement pst = conn.prepareStatement(sql)) {
			pst.setString(1, user.getNombre());
			pst.setString(2, user.getPassword());
			try(ResultSet rs = pst.executeQuery()){
				if (rs.next()) {
					userId = rs.getLong("idUsuario");
				}
			}catch (Exception e) {
				System.out.println("ERROR AL CREAR EL RESULTSET DE GET USER ID: " + e.getMessage());
				e.printStackTrace();
			}
		}catch (SQLException e) {
			System.out.println("ERROR AL CREAR LA SENTENCIA DE GET USER ID");
		}finally {
			closeConnection(conn);
			return userId;
		}
	}
	
	@SuppressWarnings("finally")
	public List<Video> getAllUserVideos(long idVideo) {
		String sql = "SELECT v.idYoutube, v.nombre FROM videos v "
				+ "INNER JOIN usuariosvideos uv ON v.idVideo = uv.idVideo "
				+ "WHERE uv.idUsuario = ?";
				
		ArrayList<Video> videos = new ArrayList<Video>();
		Connection conn = getConnection();
		
		try (PreparedStatement pst = conn.prepareStatement(sql)) {
			pst.setLong(1, idVideo);
			try(ResultSet rs = pst.executeQuery()){
				while (rs.next()) {
					videos.add(new Video(rs.getString("idYoutube"), rs.getString("nombre")));
				}
			}catch (Exception e) {
				System.out.println("ERROR AL CREAR EL RESULTSET DE GET ALL BY USER: " + e.getMessage());
				e.printStackTrace();
			}
		} catch (SQLException e) {
			System.out.println("ERROR AL CREAR LA SENTENCIA DE GET ALL BY USER");
		}finally {
			closeConnection(conn);
			return videos;
		}
	}
}
