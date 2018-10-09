package com.ipartek.formacion.ejemplos.perros.accesodatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import com.ipartek.formacion.ejemplos.perros.modelos.Usuario;

public class UsuariosMySQLDAO implements CrudAble<Usuario> {
	private static final String urlBdd = "jdbc:mysql://localhost:3307/ipartek?serverTimezone=UTC&useSSL=false&characterEncoding=UTF-8";
	private static final String usuarioBdd = "root";
	private static final String passwordBdd = "admin";

	// SINGLETON
	private UsuariosMySQLDAO() {
	}

	private static final UsuariosMySQLDAO instancia = new UsuariosMySQLDAO();

	public static UsuariosMySQLDAO getInstance() {
		return instancia;
	}
	// FIN SINGLETON

	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			throw new AccesoDatosException("No se ha encontrado el driver de MySQL", e);
		}
	}

	public Usuario getByNick(String nick) {
		Usuario usuario = null;

		try (Connection conn = DriverManager.getConnection(urlBdd, usuarioBdd, passwordBdd)) {

			String sql = "SELECT * FROM usuarios_perros WHERE nick=?";

			try (PreparedStatement pst = conn.prepareStatement(sql)) {

				pst.setString(1, nick);
				
				try (ResultSet rs = pst.executeQuery()) {
					if (rs.next()) {
						usuario = new Usuario(rs.getLong("id"), rs.getString("nick"), rs.getString("password"));
					}
				} catch (Exception e) {
					throw new AccesoDatosException("Error en el resultset", e);
				}
			} catch (Exception e) {
				throw new AccesoDatosException("Error en la sentencia", e);
			}

		} catch (Exception e) {
			throw new AccesoDatosException("Error en la sentencia", e);
		}

		return usuario;
	}

	@Override
	public List<Usuario> getAll() {
		throw new AccesoDatosException("NO IMPLEMENTADO");
	}

	@Override
	public int insert(Usuario tipo) {
		throw new AccesoDatosException("NO IMPLEMENTADO");
	}

	@Override
	public int update(Usuario tipo) {
		throw new AccesoDatosException("NO IMPLEMENTADO");
	}

	@Override
	public int delete(Long id) {
		throw new AccesoDatosException("NO IMPLEMENTADO");
	}

}
