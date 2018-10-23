package com.ipartek.formacion.youtube.accesodatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;

import com.ipartek.formacion.biblioteca.Utils;
import com.ipartek.formacion.youtube.model.Comentario;

public class ComentarioMySqlDAO implements CrudAble<Comentario> {
	private String urlBD;
	private String usuarioBD;
	private String passwordBD;

	private static ComentarioMySqlDAO INSTANCE = null;

	public static synchronized ComentarioMySqlDAO getInstance() throws ClassNotFoundException {
		if (INSTANCE == null) {
			Class.forName("com.mysql.cj.jdbc.Driver");
			INSTANCE = new ComentarioMySqlDAO();
		}

		Properties prop = Utils.leerPropiedades("youtube.properties");

		INSTANCE.urlBD = prop.getProperty("url");
		INSTANCE.usuarioBD = prop.getProperty("usuario");
		INSTANCE.passwordBD = prop.getProperty("password");

		return INSTANCE;
	}

	@Override
	public boolean insert(Comentario pojo) {
		try (Connection con = DriverManager.getConnection(urlBD, usuarioBD, passwordBD)) {
			String sql = "INSERT INTO comentarios (fecha, id_usuarios, id_videos, texto) VALUES (?, ?, ?, ?)";

			try (PreparedStatement pst = con.prepareStatement(sql)) {
				
				pst.setTimestamp(1, new java.sql.Timestamp(pojo.getFecha().getTime()));
				pst.setLong(2, pojo.getUsuario().getId());
				pst.setLong(3, pojo.getVideo().getId());
				pst.setString(4,  pojo.getTexto());

				int numFilas = pst.executeUpdate();

				if (numFilas != 1) {
					return false;
				}

			} catch (SQLException e) {
				throw new AccesoDatosException(e.getMessage(), e);
			}
		} catch (SQLException e) {
			throw new AccesoDatosException(e.getMessage(), e);
		}

		return true;
	}

	@Override
	public List<Comentario> getAll() {
		throw new AccesoDatosException("NO IMPLEMENTADO");
	}

	@Override
	public Comentario getById(String id) {
		throw new AccesoDatosException("NO IMPLEMENTADO");
	}

	@Override
	public boolean update(Comentario pojo) {
		throw new AccesoDatosException("NO IMPLEMENTADO");
	}

	@Override
	public boolean delete(String id) {
		throw new AccesoDatosException("NO IMPLEMENTADO");
	}

}
