package com.ipartek.formacion.youtube.accesodatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.ipartek.formacion.biblioteca.Utils;
import com.ipartek.formacion.youtube.model.Usuario;

public class UsuarioMySqlDAO implements CrudAble<Usuario> {
	private String urlBD;
	private String usuarioBD;
	private String passwordBD;

	private static UsuarioMySqlDAO INSTANCE = null;

	public static synchronized UsuarioMySqlDAO getInstance() throws ClassNotFoundException {
		if (INSTANCE == null) {
			Class.forName("com.mysql.cj.jdbc.Driver");
			INSTANCE = new UsuarioMySqlDAO();
		}

		Properties prop = Utils.leerPropiedades("youtube.properties");
		
		INSTANCE.urlBD = prop.getProperty("url");
		INSTANCE.usuarioBD = prop.getProperty("usuario");
		INSTANCE.passwordBD = prop.getProperty("password");
		
		return INSTANCE;
	}

	public Usuario getByEmail(String email) {
		Usuario usuario = null;

		try (Connection conn = DriverManager.getConnection(urlBD, usuarioBD, passwordBD)) {

			String sql = "SELECT id, email, password FROM usuarios WHERE email = ?";

			try (PreparedStatement pst = conn.prepareStatement(sql)) {

				pst.setString(1, email);

				try (ResultSet rs = pst.executeQuery()) {
					if (rs.next()) {
						usuario = new Usuario(rs.getLong("id"), rs.getString("email"), rs.getString("password"));
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

		return usuario;
	}
	
	@Override
	public boolean insert(Usuario pojo) {
		throw new AccesoDatosException("NO IMPLEMENTADO");
	}

	@Override
	public List<Usuario> getAll() {
		List<Usuario> usuarios = new ArrayList<Usuario>();

		try (Connection conn = DriverManager.getConnection(urlBD, usuarioBD, passwordBD)) {

			String sql = "SELECT id, email, password FROM usuarios";

			try (PreparedStatement pst = conn.prepareStatement(sql)) {

				try (ResultSet rs = pst.executeQuery()) {
					Usuario usuario = null;
					
					while (rs.next()) {
						usuario = new Usuario(rs.getLong("id"), rs.getString("email"), rs.getString("password"));
						usuarios.add(usuario);
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

		return usuarios;
	}

	@Override
	public Usuario getById(String id) {
		throw new AccesoDatosException("NO IMPLEMENTADO");
	}

	@Override
	public boolean update(Usuario pojo) {
		throw new AccesoDatosException("NO IMPLEMENTADO");
	}

	@Override
	public boolean delete(String id) {
		throw new AccesoDatosException("NO IMPLEMENTADO");
	}

}
