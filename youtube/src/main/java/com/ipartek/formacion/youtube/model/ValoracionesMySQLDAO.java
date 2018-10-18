package com.ipartek.formacion.youtube.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.ipartek.formacion.youtube.Valoracion;

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
		try (Connection conn = DriverManager.getConnection(url, usuario, password)) {
			String sql = "INSERt INTO valoraciones (puntos, videoyoutube_id, usuario_id) VALUES (?,?, 1);";
			try (PreparedStatement prs = conn.prepareStatement(sql)) {
				prs.setInt(1, pojo.getPuntos());
				prs.setInt(2, pojo.getVideoyoutube_id());
				prs.setInt(3,pojo.getUsuario_id());
				int numFilas = prs.executeUpdate();
				if (numFilas != 1) {
					return false;
				}
			} catch (SQLException e) {
				System.out.println(e.getMessage());
				e.printStackTrace();
				return false;
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			return false;
		}

		return true;
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
		return false;
	}

	@Override
	public boolean delete(String id) {
		return false;
	}


}
