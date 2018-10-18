package com.ipartek.formacion.youtube.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.ipartek.formacion.youtube.Comentario;

public class ComentariosMySQLDAO implements CrudAble<Comentario> {

	
	private static ComentariosMySQLDAO INSTANCE = null;
	String url = "jdbc:mysql://localhost:3307/videoyoutube?serverTimezone=UTC&useSSL=false";
	static String usuario = "root";
	static String password = "admin";

	public static synchronized ComentariosMySQLDAO getInstance() throws ClassNotFoundException {
		if (INSTANCE == null) {
			Class.forName("com.mysql.cj.jdbc.Driver");
			INSTANCE = new ComentariosMySQLDAO();
		}
		return INSTANCE;
	}

	@Override
	public boolean insert(Comentario pojo) {
		try (Connection conn = DriverManager.getConnection(url, usuario, password)) {
			String sql = "INSERt INTO Comentarios (texto, videoyoutube_id, usuario_id, fecha) VALUES (?,?, 1);";
			try (PreparedStatement prs = conn.prepareStatement(sql)) {
				prs.setString(1, pojo.getTexto());
				prs.setInt(2, pojo.getVideoyoutube_id());
				prs.setInt(3,pojo.getUsuario_id());
				
				prs.setDate(3,pojo.getFecha());
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
	public List<Comentario> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Comentario getById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean update(Comentario pojo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(String id) {
		// TODO Auto-generated method stub
		return false;
	}
	
}
