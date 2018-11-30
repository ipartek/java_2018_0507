package com.ipartek.examen.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ipartek.examen.modelo.Gente;



public class GenteDAO implements CrudAble<Gente> {

	String url = "jdbc:mysql://localhost:3307/personas?serverTimezone=UTC&useSSL=false";
	String usuario = "root";
	String password = "admin";
	
	private static GenteDAO INSTANCE = null;

	public static synchronized GenteDAO getInstance() throws ClassNotFoundException {
		if (INSTANCE == null) {
			Class.forName("com.mysql.cj.jdbc.Driver");
			INSTANCE = new GenteDAO();
		}

		return INSTANCE;
	}
	
	@Override
	public List<Gente> getAll() {
		ArrayList<Gente> personas = new ArrayList<>();

		try (Connection conn = DriverManager.getConnection(url, usuario, password)) {
			String sql = "SELECT id, nombre, apellido1, direccion, portal, email, dni, puesto from gente ORDER BY id DESC LIMIT 50";

			try (PreparedStatement pst = conn.prepareStatement(sql)) {

				try (ResultSet rs = pst.executeQuery()) {
					while (rs.next()) {
						personas.add(new Gente(rs.getLong("id"),rs.getString("nombre"), rs.getString("apellido1"),rs.getString("direccion"),
								rs.getInt("portal"),rs.getString("email"),rs.getString("dni"),rs.getString("puesto")));
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

		return personas;
	}


	@Override
	public void insert(Gente pojo) {
		try (Connection con = DriverManager.getConnection(url, usuario, password)) {
			String sql = "INSERT INTO gente (nombre,apellido 1, direccion, portal, email, dni, puesto)"
					+ "VALUES (?,?,?,?,?,?,?)";

			try (PreparedStatement pst = con.prepareStatement(sql)) {
				pst.setString(1, pojo.getNombre());

				int numFilas = pst.executeUpdate();

				if (numFilas != 1) {
					throw new RuntimeException("Fallo en la inserccion de datos");
				}

			} catch (SQLException e) {
				throw new RuntimeException("Fallo en la inserccion de datos");
			}
		} catch (SQLException e) {
			throw new RuntimeException("Fallo en la inserccion de datos");
		}
		
	}

	@Override
	public void update(Gente pojo) {
		try (Connection con = DriverManager.getConnection(url, usuario, password)) {
			String sql = "UPDATE gente SET nombre = ?, apellido1 = ?, direccion = ?, portal=?, email=?,dni=?,puesto=? WHERE id = ?";
			
			try(PreparedStatement pst = con.prepareStatement(sql)){
				pst.setString(1, pojo.getNombre());
				pst.setString(2, pojo.getApellido());
				pst.setString(3, pojo.getDireccion());
				pst.setInt(4, pojo.getnPortal());
				pst.setString(5, pojo.getEmail());
				pst.setString(6, pojo.getDni());
				pst.setString(7, pojo.getPuesto());
				pst.setLong(8, pojo.getId());
				
				int numFilas = pst.executeUpdate();
				
				if (numFilas != 1) {
					throw new RuntimeException("Fallo en la actualizacion de datos");
				}
			} catch (SQLException e) {
				throw new RuntimeException("Fallo en la actualizacion de datos");
			}
		} catch (SQLException e) {
			throw new RuntimeException("Fallo en la a de datos");
		}
		
	}

}
