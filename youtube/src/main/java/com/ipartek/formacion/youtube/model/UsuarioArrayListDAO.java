package com.ipartek.formacion.youtube.model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import org.apache.taglibs.standard.tag.common.core.ForEachSupport;

import com.ipartek.formacion.youtube.Usuario;
import com.ipartek.formacion.youtube.Video;

public class UsuarioArrayListDAO implements CrudAble<Usuario> {

	private static UsuarioArrayListDAO INSTANCE = null;
	private static List<Usuario> usuarios = null;

	private String url = "jdbc:mysql://localhost:3307/ipartek?serverTimezone=UTC&useSSL=false";
	private String usuario = "root";
	private String password = "admin";

	private UsuarioArrayListDAO() {
		/*videos = new ArrayList<Video>();
		try {
			videos.add(new Video("LPDhuthFD98", "Surf Search Spot 2 0 video promo"));
			videos.add(new Video("a9WnQFI8jQU", "Betagarri - Sweet Mary"));
			videos.add(new Video("0sLK1SKfItM", "Su Ta Gar - Begira"));
		} catch (Exception e) {
			e.printStackTrace();
		}*/

	}

	public static synchronized UsuarioArrayListDAO getInstance() {
		if (INSTANCE == null) {

			try {
				Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException e) {

				e.printStackTrace();
			}
			INSTANCE = new UsuarioArrayListDAO();

		}

		return INSTANCE;
	}

	@Override
	public boolean insert(Usuario pojo) {
		// return videos.add(pojo);

		try (Connection conn = DriverManager.getConnection(url, usuario, password)) {

			String sql = "INSERT INTO usuarios values (?,?,?)";

			try (PreparedStatement pst = conn.prepareStatement(sql)) {

				pst.setLong(1, pojo.getId());
				pst.setString(2, pojo.getEmail());
				pst.setString(3, pojo.getPassword());
				

				pst.executeUpdate();

			} catch (Exception e) {
				System.out.println("ERROR AL CREAR LA SENTENCIA insert");
				System.out.println(e.getMessage());
				e.printStackTrace();
				return false;
			}

		} catch (SQLException e) {
			System.out.println("ERROR DE CONEXION insert");
			System.out.println(e.getMessage());
			e.printStackTrace();
			return false;
		}

		return true;
	}

	@Override
	public List<Usuario> getAll() {
		/*
		 * return videos; }
		 * 
		 * @Override public Video getById(String id) { Video resul = null; if (id !=
		 * null) { for (Video v : videos) { if (id.equals(v.getId())) { resul = v; } } }
		 * return resul;
		 */
		ArrayList<Usuario> usuarios = new ArrayList<Usuario>();

		try (Connection conn = DriverManager.getConnection(url, usuario, password)) {

			String sql = "SELECT * FROM usuarios";

			try (Statement stmt = conn.createStatement()) {

				try (ResultSet rs = stmt.executeQuery(sql)) {

					while (rs.next()) {
						// System.out.printf(rs.getString("id"), rs.getString("email"));
						usuarios.add(new Video(rs.getString("id"), rs.getString("email")));
					}
				} catch (Exception e) {
					System.out.println("ERROR AL CREAR EL RESULTSET:" + e.getMessage());
					e.printStackTrace();
				}
			} catch (Exception e) {
				System.out.println("ERROR AL CREAR LA SENTENCIA getall");
				System.out.println(e.getMessage());
				e.printStackTrace();
			}

		} catch (SQLException e) {
			System.out.println("ERROR DE CONEXION getall");
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		return usuarios;
	}

	@Override
	public boolean update(Usuario pojo) {

		try (Connection con = DriverManager.getConnection(url, usuario, password)) {

			String sql = "UPDATE usuarios SET email = ?, password = ? WHERE id = ?";

			try (PreparedStatement pst = con.prepareStatement(sql)) {

				pst.setString(1, pojo.getEmail());
				pst.setString(2, pojo.getPassword());
				pst.setLong(3, pojo.getId());

				int numFilas = pst.executeUpdate();

				if (numFilas != 1) {
					System.out.println("El número de filas modificado ha sido " + numFilas);

				}

			} catch (SQLException e) {

				System.out.println("ERROR AL CREAR LA SENTENCIA update");
				System.out.println(e.getMessage());
				e.printStackTrace();
				return false;

			}
		} catch (SQLException e) {
			System.out.println("ERROR DE CONEXION update");
			System.out.println(e.getMessage());
			e.printStackTrace();
			return false;
		}

		return true;
	}

	@Override
	public boolean delete(String id) {
		/*
		 * boolean resul = false; Video v = null; if (id != null) { for (int i = 0; i <
		 * videos.size(); i++) { v = videos.get(i); if (id.equals(v.getId())) { resul =
		 * videos.remove(v); break; } } } return resul;
		 */

		try (Connection con = DriverManager.getConnection(url, usuario, password)) {

			String sql = "DELETE FROM usuarios WHERE id = ?";

			try (PreparedStatement pst = con.prepareStatement(sql)) {

				pst.setString(1, id);

				int numFilas = pst.executeUpdate();

				if (numFilas != 1) {
					System.out.println("El número de filas modificado ha sido " + numFilas);

				}

			} catch (SQLException e) {

				System.out.println("ERROR AL CREAR LA SENTENCIA delete");
				System.out.println(e.getMessage());
				e.printStackTrace();
				return false;

			}
		} catch (SQLException e) {
			System.out.println("ERROR DE CONEXION delete");
			System.out.println(e.getMessage());
			e.printStackTrace();
			return false;
		}

		return true;
	}

	@Override
	public Usuario getById(String id) {

		Usuario user = null;

		try (Connection con = DriverManager.getConnection(url, usuario, password)) {

			String sql = "SELECT * from usuarios WHERE id = ?";

			try (PreparedStatement pst = con.prepareStatement(sql)) {

				try (ResultSet rs = pst.executeQuery(sql)) {

					if (rs.next()) {
						
						user = new Usuario();

						user.setId(rs.getLong("id"));
						user.setEmail(rs.getString("email"));
						user.setPassword(rs.getString("password"));
					}
				} catch (Exception e) {
					System.out.println("ERROR AL CREAR EL RESULTSET:" + e.getMessage());
					e.printStackTrace();

				}

			} catch (SQLException e) {

				System.out.println("ERROR AL CREAR LA SENTENCIA getById");
				System.out.println(e.getMessage());
				e.printStackTrace();

			}
		} catch (SQLException e) {
			System.out.println("ERROR DE CONEXION getById");
			System.out.println(e.getMessage());
			e.printStackTrace();

		}

		return user;
	}



}
