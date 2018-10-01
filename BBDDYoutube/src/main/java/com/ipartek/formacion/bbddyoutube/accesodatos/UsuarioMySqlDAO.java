package com.ipartek.formacion.bbddyoutube.accesodatos;

import java.util.ArrayList;
import java.util.List;

import java.sql.*;
import com.ipartek.formacion.bbddyoutube.pojos.Usuario;

public class UsuarioMySqlDAO implements CrudAble<Video> {

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
		String sql = "INSERT INTO videos (idVideo,nombre) VALUES (?,?)";	
		boolean result = false;
		Connection conn = getConnection();
		try (PreparedStatement pst = conn.prepareStatement(sql);){
			pst.setString(1, pojo.getIdVideo());
			pst.setString(2, pojo.getNombre());
			
			int numFilas = pst.executeUpdate();
			
			if (numFilas != 1) {
				result = false;
			}else {
				result = true;
			}
		} catch (SQLException e) {
			System.out.println("ERROR AL CREAR LA SENTENCIA DE INSERT");
			result = false;
		}finally {
			closeConnection(conn);
			return result;
		}
	}

	@SuppressWarnings({ "finally" })
	@Override
	public List<Video> getAll() {
		// SELECT ALL FROM TABLA
		String sql = "SELECT * FROM videos";	
		ArrayList<Video> videos = new ArrayList<Video>();
		Connection conn = getConnection();
		
		try (PreparedStatement pst = conn.prepareStatement(sql)) {
			try(ResultSet rs = pst.executeQuery()){
				while (rs.next()) {
					videos.add(new Video(rs.getLong("id"),rs.getString("idVideo"), rs.getString("nombre")));
				}
			}catch (Exception e) {
				System.out.println("ERROR AL CREAR EL RESULTSET DE GET ALL: " + e.getMessage());
				e.printStackTrace();
			}
		} catch (SQLException e) {
			System.out.println("ERROR AL CREAR LA SENTENCIA");
		}finally {
			closeConnection(conn);
			return videos;
		}
	}

	@SuppressWarnings({ "finally" })
	@Override
	public Video getById(String idVideo) {
		String sql = "SELECT idVideo, nombre FROM videos WHERE idVideo = ?";	
		Video video = null;
		Connection conn = getConnection();
		
		try (PreparedStatement pst = conn.prepareStatement(sql)) {
			pst.setString(1, idVideo);
			try(ResultSet rs = pst.executeQuery()){
				if (rs.next()) {
					video = new Video(rs.getLong("id"),rs.getString("idVideo"), rs.getString("nombre"));
				}else {
					return null;
				}
			}catch (Exception e) {
				System.out.println("ERROR AL CREAR EL RESULTSET DE GET BY ID");
			}
		} catch (SQLException e) {
			System.out.println("ERROR AL CREAR LA SENTENCIA");
		}finally {
			closeConnection(conn);
			return video;
		}
	}

	@SuppressWarnings("finally")
	@Override
	public boolean update(Video pojo) {
		String sql = "UPDATE videos SET nombre = ? WHERE idVideo = ?";	
		boolean result = false;
		Connection conn = getConnection();
		try (PreparedStatement pst = conn.prepareStatement(sql);){
			pst.setString(1, pojo.getNombre());
			pst.setString(2, pojo.getIdVideo());
			
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
	@Override
	public boolean delete(String idVideo) {
		String sql = "DELETE FROM videos WHERE idVideo = ?";	
		boolean result = false;
		Connection conn = getConnection();
		try (PreparedStatement pst = conn.prepareStatement(sql);){
			pst.setString(1, idVideo);
			
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

	@Override
	public Video getById(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean delete(long id) {
		// TODO Auto-generated method stub
		return false;
	}
}
