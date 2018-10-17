package com.ipartek.formacion.youtube.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.ipartek.formacion.youtube.Usuario;
import com.ipartek.formacion.youtube.Video;


public class UsuariosMySQLDAO implements CrudAble<Usuario>{
	private static UsuariosMySQLDAO INSTANCE = null;
	String url = "jdbc:mysql://localhost:3307/videoyoutube?serverTimezone=UTC&useSSL=false";
	static String usuario = "root";
	static String password = "admin";
	
	public static synchronized UsuariosMySQLDAO getInstance() throws ClassNotFoundException {
		if (INSTANCE == null) {
			Class.forName("com.mysql.cj.jdbc.Driver");
			INSTANCE = new UsuariosMySQLDAO();
		}
		return INSTANCE;
	}
	@Override
	public boolean insert(Usuario pojo) {
		// TODO Usuario Insert
		return false;
	}
	@Override
	public List<Usuario> getAll() {
		ArrayList<Usuario> usuarios = new ArrayList<>();
		try (Connection conn = DriverManager.getConnection(url, usuario, password)) {
			try (Statement stmt = conn.createStatement()) {
				String sql = "SELECT id, email, password FROM usuarios";
				try (ResultSet rs = stmt.executeQuery(sql)) {			
					while (rs.next()) {
						int id = rs.getInt("id");
						String email = rs.getString("email");
						String password = rs.getString("password");
						
						usuarios.add(new Usuario(id, email, password));
					}
				} catch (Exception e) {
					System.out.println("ERROR AL CREAR EL RESULTSET");
				}
			} catch (Exception  e) {
				System.out.println("ERROR AL CREAR LA SENTENCIA");
			}
		} catch (SQLException e) {
			System.out.println("ERROR DE CONEXION");
			System.out.println(e.getMessage());
		}
		return usuarios;
	}
	@Override
	public Usuario getById(String id) {
		Usuario user = null;
		try (Connection conn = DriverManager.getConnection(url, usuario, password)) {
			String sql = "SELECT id, email, password FROM videos WHERE id = ?";

			try (PreparedStatement pst = conn.prepareStatement(sql)) {

				pst.setString(1, id);

				try (ResultSet rs = pst.executeQuery()) {
					if (rs.next()) {
						user = new Usuario(rs.getInt("id"), rs.getString("email"), rs.getString("password"));
					} else {
						return null;
					}
				} catch (SQLException e) {
					//throw new AccesoDatosException(e.getMessage(), e);
				}
			} catch (Exception e) {
				//throw new AccesoDatosException(e.getMessage(), e);
			}

		} catch (SQLException e) {
			//throw new AccesoDatosException(e.getMessage(), e);
		}

return user;
	}
	@Override
	public boolean update(Usuario pojo) {
		// TODO Usuario update
		return false;
	}
	@Override
	public boolean delete(String id) {
		// TODO usuario delete
		return false;
	}

}
