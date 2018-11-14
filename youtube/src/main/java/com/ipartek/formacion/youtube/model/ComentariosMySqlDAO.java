package com.ipartek.formacion.youtube.model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ipartek.formacion.youtube.Comentario;
import com.ipartek.formacion.youtube.accesodatos.AccesoDatosException;
import com.ipartek.formacion.youtube.accesodatos.CrudAble;

public class ComentariosMySqlDAO implements CrudAble<Comentario>{
	
	String url = "jdbc:mysql://localhost:3307/ipartek?serverTimezone=UTC&useSSL=false";
	String usuario = "root";
	String password = "admin";

	private static ComentariosMySqlDAO INSTANCE = null;

	public static synchronized ComentariosMySqlDAO getInstance() throws ClassNotFoundException {
		if (INSTANCE == null) {
			Class.forName("com.mysql.cj.jdbc.Driver");//registrar un driver que necesitaba sql
			INSTANCE = new ComentariosMySqlDAO();
		}

		return INSTANCE;
	}
	
	
	
	@Override
	public boolean insert(Comentario pojo) {
		try (Connection con = DriverManager.getConnection(url, usuario, password)) {
			String sql = "INSERT INTO comentarios (descripcion, fecha) VALUES (?, ?)";

			try (PreparedStatement pst = con.prepareStatement(sql)) {
				pst.setString(1, pojo.getDescripcion());
				pst.setDate(2, (Date) pojo.getFecha());

				int numFilas = pst.executeUpdate();

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
	
	public List<Comentario> getAllbyIdvideo(long id) {
		ArrayList<Comentario> comentarios = new ArrayList<>();

		try (Connection conn = DriverManager.getConnection(url, usuario, password)) {
			String sql = "select * from comentarios where videos_id =?";

			try (PreparedStatement pst = conn.prepareStatement(sql)) {
					pst.setLong(1,id);
				try (ResultSet rs = pst.executeQuery()) {
					while (rs.next()) {
						comentarios.add(new Comentario(rs.getLong("idComentario"), rs.getString("descripcion"), rs.getDate("fecha")));
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

		return comentarios;

	}
	
	public List<Comentario> ObtenerPrimerVideo() {
		
		ArrayList<Comentario> comentarios = new ArrayList<>();
		
		try (Connection conn = DriverManager.getConnection(url, usuario, password)) {
			String sql = "select * from comentarios where videos_id =1";

			try (PreparedStatement pst = conn.prepareStatement(sql)) {
					
				try (ResultSet rs = pst.executeQuery()) {
					while (rs.next()) {
						comentarios.add(new Comentario(rs.getLong("idComentario"), rs.getString("descripcion"), rs.getDate("fecha")));
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

		return comentarios;
		
	}
}
