package conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import conexion.*;
import modelo.Usuario;

public class UsuarioMySqlDAO implements CrudAble<Usuario> {

	String url = "jdbc:mysql://localhost:3307/youtube?serverTimezone=UTC&useSSL=false";
	String user = "root";
	String password = "admin";

	private static UsuarioMySqlDAO INSTANCE = null;

	public static synchronized UsuarioMySqlDAO getInstance() throws ClassNotFoundException {
		if (INSTANCE == null) {
			Class.forName("com.mysql.cj.jdbc.Driver");
			INSTANCE = new UsuarioMySqlDAO();
		}

		return INSTANCE;
	}
	
	
	@Override
	public boolean insert(Usuario pojo) {
		// TODO Auto-generated method stub
		try (Connection con = DriverManager.getConnection(url, user, password)) {
			String sql = "INSERT INTO usuarios (nombre,password,email) VALUES (?, ?, ?)";

			try (PreparedStatement pst = con.prepareStatement(sql)) {
				pst.setString(1,pojo.getNombre());
				pst.setString(2,pojo.getPassword());
				pst.setString(3,pojo.getEmail());

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
	public List<Usuario> getAll() {
		// TODO Auto-generated method stub
		ArrayList<Usuario> usuarios = new ArrayList<>();

		try (Connection conn = DriverManager.getConnection(url, user, password)) {
			String sql = "SELECT id,email,nombre,password FROM usuarios";

			try (PreparedStatement pst = conn.prepareStatement(sql)) {

				try (ResultSet rs = pst.executeQuery()) {
					while (rs.next()) {
						usuarios.add(new Usuario( rs.getString("nombre"), rs.getString("password"),rs.getString("email")));
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
		
		Usuario usuario= null;

		try (Connection conn = DriverManager.getConnection(url, user, password)) {

			String sql = "SELECT id, nombre, password,email FROM videos WHERE id = ?";

			try (PreparedStatement pst = conn.prepareStatement(sql)) {

				pst.setString(1, id);

				try (ResultSet rs = pst.executeQuery()) {
					if (rs.next()) {
						usuario = new Usuario(rs.getLong("id"), rs.getString("nombre"), rs.getString("password"),rs.getString("email"));
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


