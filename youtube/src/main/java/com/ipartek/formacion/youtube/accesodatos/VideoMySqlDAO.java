package com.ipartek.formacion.youtube.accesodatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.ipartek.formacion.biblioteca.Utils;
import com.ipartek.formacion.youtube.Video;
import com.ipartek.formacion.youtube.model.Usuario;

public class VideoMySqlDAO implements CrudAble<Video> {
	private String urlBD;
	private String usuarioBD;
	private String passwordBD;

	private static VideoMySqlDAO INSTANCE = null;

	public static synchronized VideoMySqlDAO getInstance() throws ClassNotFoundException {
		if (INSTANCE == null) {
			Class.forName("com.mysql.cj.jdbc.Driver");
			INSTANCE = new VideoMySqlDAO();
		}

		Properties prop = Utils.leerPropiedades("youtube.properties");
		
		INSTANCE.urlBD = prop.getProperty("url");
		INSTANCE.usuarioBD = prop.getProperty("usuario");
		INSTANCE.passwordBD = prop.getProperty("password");
		
		return INSTANCE;
	}

	public List<Video> getAllByUsuario(Usuario usuario) {
		ArrayList<Video> videos = new ArrayList<>();

		try (Connection conn = DriverManager.getConnection(urlBD, usuarioBD, passwordBD)) {
			String sql = "SELECT id, idvideo, nombre  FROM videos WHERE id_usuario = ?";

			try (PreparedStatement pst = conn.prepareStatement(sql)) {
				
				pst.setLong(1, usuario.getId());
				
				try (ResultSet rs = pst.executeQuery()) {
					
					while (rs.next()) {
						videos.add(new Video(rs.getLong("id"), rs.getString("idvideo"), rs.getString("nombre"), usuario));
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
	public boolean insert(Video pojo) {
		try (Connection con = DriverManager.getConnection(urlBD, usuarioBD, passwordBD)) {
			String sql = "INSERT INTO videos (idvideo, nombre, id_usuario) VALUES (?, ?, ?)";

			try (PreparedStatement pst = con.prepareStatement(sql)) {
				pst.setString(1, pojo.getIdVideo());
				pst.setString(2, pojo.getNombre());
				pst.setLong(3,  pojo.getUsuario().getId());

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
	public List<Video> getAll() {
		Usuario usuario = null;
		ArrayList<Video> videos = new ArrayList<>();

		try (Connection conn = DriverManager.getConnection(urlBD, usuarioBD, passwordBD)) {
			String sql = 
					"SELECT v.id, v.idvideo, v.nombre, v.id_usuario, u.email, u.password \n" + 
					"FROM videos v \n" + 
					"INNER JOIN usuarios u ON v.id_usuario = u.id";

			try (PreparedStatement pst = conn.prepareStatement(sql)) {

				try (ResultSet rs = pst.executeQuery()) {
					while (rs.next()) {
						usuario = new Usuario(rs.getLong("v.id_usuario"), rs.getString("u.email"), rs.getString("u.password"));
						videos.add(new Video(rs.getLong("id"), rs.getString("idvideo"), rs.getString("nombre"), usuario));
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
	public Video getById(String id) {
		Usuario usuario = null;
		Video video = null;

		try (Connection conn = DriverManager.getConnection(urlBD, usuarioBD, passwordBD)) {

			String sql = 
					"SELECT v.id, v.idvideo, v.nombre, v.id_usuario, u.email, u.password \n" + 
					"FROM videos v \n" + 
					"INNER JOIN usuarios u ON v.id_usuario = u.id \n" + 
					"WHERE v.id = ?";

			try (PreparedStatement pst = conn.prepareStatement(sql)) {

				pst.setString(1, id);

				try (ResultSet rs = pst.executeQuery()) {
					if (rs.next()) {
						usuario = new Usuario(rs.getLong("v.id_usuario"), rs.getString("u.email"), rs.getString("u.password"));
						video = new Video(rs.getLong("id"), rs.getString("idvideo"), rs.getString("nombre"), usuario);
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

		return video;
	}

	@Override
	public boolean update(Video pojo) {
		try (Connection con = DriverManager.getConnection(urlBD, usuarioBD, passwordBD)) {
			String sql = "UPDATE videos SET idvideo = ?, nombre = ? WHERE id = ?";

			try (PreparedStatement pst = con.prepareStatement(sql)) {
				pst.setString(1, pojo.getIdVideo());
				pst.setString(2, pojo.getNombre());
				pst.setLong(3, pojo.getId());

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
		try (Connection con = DriverManager.getConnection(urlBD, usuarioBD, passwordBD)) {
			String sql = "DELETE FROM videos WHERE id = ?";

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
