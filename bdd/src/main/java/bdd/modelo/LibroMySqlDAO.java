package bdd.modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bdd.bdd.Libro;

public class LibroMySqlDAO implements CrudAble<Libro> {
	String url = "jdbc:mysql://localhost:3307/librotek?serverTimezone=UTC&useSSL=false";
	String usuario = "root";
	String password = "admin";

	private static LibroMySqlDAO INSTANCE = null;

	public static synchronized LibroMySqlDAO getInstance() throws ClassNotFoundException {
		if (INSTANCE == null) {
			Class.forName("com.mysql.cj.jdbc.Driver");
			INSTANCE = new LibroMySqlDAO();
		}

		return INSTANCE;
	}

	@Override
	public boolean insert(Libro pojo) {
		try (Connection con = DriverManager.getConnection(url, usuario, password)) {
			String sql = "INSERT INTO libros (idlibro, nombre) VALUES (?, ?)";
System.out.println(sql);
			try (PreparedStatement pst = con.prepareStatement(sql)) {
				pst.setString(1, pojo.getIdLibro());
				pst.setString(2, pojo.getNombre());

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
	public List<Libro> getAll() {
		ArrayList<Libro> videos = new ArrayList<>();

		try (Connection conn = DriverManager.getConnection(url, usuario, password)) {
			String sql = "SELECT idlibro, nombre FROM libros";

			try (PreparedStatement pst = conn.prepareStatement(sql)) {

				try (ResultSet rs = pst.executeQuery()) {
					while (rs.next()) {
						videos.add(new Libro(rs.getString("idlibro"),  rs.getString("nombre")));
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

		return videos;

	}

	@Override
	public Libro getById(String id) {
		Libro libro= null;

		try (Connection conn = DriverManager.getConnection(url, usuario, password)) {

			String sql = "SELECT idlibro, nombre FROM videos WHERE id = ?";

			try (PreparedStatement pst = conn.prepareStatement(sql)) {

				pst.setString(1, id);

				try (ResultSet rs = pst.executeQuery()) {
					if (rs.next()) {
						libro = new Libro(rs.getString("idlibro"),  rs.getString("nombre"));
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

		return libro;
	}

	@Override
	public boolean update(Libro pojo) {
		try (Connection con = DriverManager.getConnection(url, usuario, password)) {
			String sql = "UPDATE libros SET nombre = ? WHERE idlibro = ?";

			try (PreparedStatement pst = con.prepareStatement(sql)) {
				
				pst.setString(2, pojo.getIdLibro());
				pst.setString(1, pojo.getNombre());
					
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
	public boolean delete(String id) {
		try (Connection con = DriverManager.getConnection(url, usuario, password)) {
			String sql = "DELETE FROM libros WHERE idlibro = ?";

			try (PreparedStatement pst = con.prepareStatement(sql)) {
				pst.setString(1, id);

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

}
