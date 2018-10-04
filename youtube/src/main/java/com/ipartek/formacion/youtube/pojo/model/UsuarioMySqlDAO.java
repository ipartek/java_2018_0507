package com.ipartek.formacion.youtube.pojo.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ipartek.formacion.youtube.pojo.Usuario;

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

	@Override
	public boolean insert(Usuario pojo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Usuario> getAll() {
		ArrayList<Usuario> usuarios = new ArrayList<>();

		try (Connection conn = DriverManager.getConnection(url, usuario, password)) {
			String sql = "SELECT * FROM usuarios";

			try (PreparedStatement pst = conn.prepareStatement(sql)) {

				try (ResultSet rs = pst.executeQuery()) {
					while (rs.next()) {
						usuarios.add(new Usuario(rs.getLong("id"), rs.getString("nombre"), rs.getString("usuario")));
					}
				} catch (Exception e) {
					throw new AccesoDatosException(e.getMessage(), e);
				}
			} catch (SQLException e) {
				throw new AccesoDatosException(e.getMessage(), e);
			}

		} catch (SQLException e) {
			throw new AccesoDatosException(e.getMessage(), e);
		}

		return usuarios;
	}

	@Override
	public Usuario getById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean update(Usuario pojo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(String id) {
		// TODO Auto-generated method stub
		return false;
	}


}