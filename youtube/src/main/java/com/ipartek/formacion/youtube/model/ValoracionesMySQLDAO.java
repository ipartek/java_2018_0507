package com.ipartek.formacion.youtube.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ipartek.formacion.youtube.Valoracion;
import com.ipartek.formacion.youtube.Video;



public class ValoracionesMySQLDAO implements CrudAble<Valoracion> {

	private static ValoracionesMySQLDAO INSTANCE = null;
	String url = "jdbc:mysql://localhost:3307/videoyoutube?serverTimezone=UTC&useSSL=false";
	static String usuario = "root";
	static String password = "admin";

	public static synchronized ValoracionesMySQLDAO getInstance() throws ClassNotFoundException {
		if (INSTANCE == null) {
			Class.forName("com.mysql.cj.jdbc.Driver");
			INSTANCE = new ValoracionesMySQLDAO();
		}
		return INSTANCE;
	}

	@Override
	public boolean insert(Valoracion pojo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Valoracion> getAll() {
		/**
		 * No necesaria los comentarios siempre se van a buscar por Id
		 */
		return null;
	}

	@Override
	public Valoracion getById(String id) {
		Valoracion valoracion = new Valoracion();
		try (Connection conn = DriverManager.getConnection(url, usuario, password)) {
			String sql = "select v.nombre, avg(va.puntos) from valoraciones va inner join videos v on va.videoyoutube_id = v.id where videoyoutube_id = ?";
			try (PreparedStatement pst = conn.prepareStatement(sql)) {
				// Mirando que valor entra en el prepared statement
				pst.setInt(1, Integer.parseInt(id));

				try (ResultSet rs = pst.executeQuery()) {
					if (rs.next()) {
						valoracion = new Valoracion(rs.getInt("puntos"), rs.getInt("videoyoutube_id"), rs.getInt("usuario_id"));
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
			// throw new AccesoDatosException(e.getMessage(), e);
		}

		return valoracion;
	}

	@Override
	public boolean update(Valoracion pojo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(String id) {
		// TODO Auto-generated method stub
		return false;
	}


}
