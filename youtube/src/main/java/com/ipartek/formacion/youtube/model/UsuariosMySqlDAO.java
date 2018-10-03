package com.ipartek.formacion.youtube.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ipartek.formacion.youtube.Usuarios;

public class UsuariosMySqlDAO implements CrudAble<Usuarios> {
	String url = "jdbc:mysql://localhost:3307/ipartek?serverTimezone=UTC&useSSL=false";
	String usuario = "root";
	String password = "admin";

	private static UsuariosMySqlDAO INSTANCE = null;

	public static synchronized UsuariosMySqlDAO getInstance() throws ClassNotFoundException {
		if (INSTANCE == null) {
			Class.forName("com.mysql.cj.jdbc.Driver");// registrar un driver que necesitaba sql
			INSTANCE = new UsuariosMySqlDAO();
		}

		return INSTANCE;
	}

	@Override
	public boolean insert(Usuarios pojo) {
		try (Connection con = DriverManager.getConnection(url, usuario, password)) {
			String sql = "INSERT INTO usuarios (email, password) VALUES (?, ?)";

			try (PreparedStatement pst = con.prepareStatement(sql)) {
				pst.setString(1, pojo.getEmail());
				pst.setString(2, pojo.getPassword());

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
	public List<Usuarios> getAll() {
		ArrayList<Usuarios> users = new ArrayList<>();

		try (Connection conn = DriverManager.getConnection(url, usuario, password)) {
			String sql = "SELECT id, email, password FROM usuarios";

			try (PreparedStatement pst = conn.prepareStatement(sql)) {

				try (ResultSet rs = pst.executeQuery()) {
					while (rs.next()) {
						users.add(new Usuarios(rs.getString("email"), rs.getString("password")));
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

		return users;

	}

	@Override
	public Usuarios getById(String id) {
		Usuarios user = null;

		try (Connection conn = DriverManager.getConnection(url, usuario, password)) {

			String sql = "SELECT id, email, password FROM usuarios WHERE id = ?";

			try (PreparedStatement pst = conn.prepareStatement(sql)) {

				pst.setString(1, id);

				try (ResultSet rs = pst.executeQuery()) {
					if (rs.next()) {
						user = new Usuarios((rs.getLong("id")), rs.getString("email"), rs.getString("password"));
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
	public boolean update(Usuarios pojo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(String id) {
		// TODO Auto-generated method stub
		return false;
	}

	// Metodo para consultar si un email y contraseñan pertenecen a una cuenta
	// registrada
	public boolean isAcountExists(String email, String password) throws SQLException {

		try (Connection con = DriverManager.getConnection(url, usuario, password)) {
			  String sql = "SELECT * FROM usuarios WHERE email='"+email+"' AND password='"+password+"'";

			try (PreparedStatement ps = con.prepareStatement(sql)) {
				ResultSet rs = ps.executeQuery();

				return rs.next();

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

	}

	public String getNameByEmail(String email) throws SQLException {

		try (Connection conn = DriverManager.getConnection(url, usuario, password)) {

			String sql = "SELECT * FROM usuarios WHERE email='" + email + "'";

			try (PreparedStatement ps = conn.prepareStatement(sql);) {

				try (ResultSet rs = ps.executeQuery();) {
					if (rs.next()) {
						return rs.getString("email");
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

		return null;
	}

}
