package com.ipartek.formacion.MF0967_3.modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.ipartek.formacion.MF0967_3.pojo.User;

public class UsuarioMySQLDAO implements CrudAble<User>{
	private static UsuarioMySQLDAO INSTANCE = null;
	String url = "jdbc:mysql://localhost:3307/ipartek?serverTimezone=UTC&useSSL=false";
	static String usuario = "root";
	static String password = "admin";
	
	public static synchronized UsuarioMySQLDAO getInstance() throws ClassNotFoundException {
		if (INSTANCE == null) {
			Class.forName("com.mysql.cj.jdbc.Driver");
			INSTANCE = new UsuarioMySQLDAO();
		}
		return INSTANCE;
	}
	
	@Override
	public boolean insert(User pojo) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public List<User> getAll() {
		ArrayList<User> usuarios = new ArrayList<>();
		try (Connection conn = DriverManager.getConnection(url, usuario, password)) {
			try (Statement stmt = conn.createStatement()) {
				String sql = "SELECT iduser, nombre, clave FROM users";
				try (ResultSet rs = stmt.executeQuery(sql)) {			
					while (rs.next()) {
						int idUser = rs.getInt("idUser");
						String nombre = rs.getString("nombre");
						String clave = rs.getString("clave");
						
						usuarios.add(new User(idUser, nombre, clave));
					}
				} catch (Exception e) {
					System.out.println("ERROR AL CREAR EL RESULTSET");
					throw new AccesoDatosException(e.getMessage(), e);
				}
			} catch (Exception  e) {
				System.out.println("ERROR AL CREAR LA SENTENCIA");
				throw new AccesoDatosException(e.getMessage(), e);
			}
		} catch (SQLException e) {
			System.out.println("ERROR DE CONEXION");
			System.out.println(e.getMessage());
			throw new AccesoDatosException(e.getMessage(), e);
		}
		return usuarios;
	}
	@Override
	public User getById(String id) {
		User user = null;
		try (Connection conn = DriverManager.getConnection(url, usuario, password)) {
			String sql = "SELECT iduser, nombre, clave FROM users WHERE iduser = ?";

			try (PreparedStatement pst = conn.prepareStatement(sql)) {

				pst.setString(1, id);

				try (ResultSet rs = pst.executeQuery()) {
					if (rs.next()) {
						user = new User(rs.getInt("iduser"), rs.getString("nombre"), rs.getString("clave"));
					} else {
						return null;
					}
				} catch (SQLException e) {
					throw new AccesoDatosException(e.getMessage(), e);
				}
			} catch (Exception e) {
				throw new AccesoDatosException(e.getMessage(), e);
			}

		} catch (SQLException e) {
			throw new AccesoDatosException(e.getMessage(), e);
		}
		return user;
	}
	@Override
	public boolean update(User pojo) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean delete(String id) {
		// TODO Auto-generated method stub
		return false;
	}
	
}
