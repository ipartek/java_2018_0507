package com.ipartek.formacion.youtube.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ipartek.formacion.youtube.Video;

public class VideoMySqlDAO implements CrudAble<Video> {
	String url = "jdbc:mysql://localhost:3307/ipartek?serverTimezone=UTC&useSSL=false";
	String usuario = "root";
	String password = "admin";

	private static VideoMySqlDAO INSTANCE = null;

	public static synchronized VideoMySqlDAO getInstance() throws ClassNotFoundException {
		if (INSTANCE == null) {
			Class.forName("com.mysql.cj.jdbc.Driver");//registrar un driver que necesitaba sql
			INSTANCE = new VideoMySqlDAO();
		}

		return INSTANCE;
	}

	@Override
	public boolean insert(Video pojo) {
		try (Connection con = DriverManager.getConnection(url, usuario, password)) {
			String sql = "INSERT INTO videos (idvideo, nombre) VALUES (?, ?)";

			try (PreparedStatement pst = con.prepareStatement(sql)) {
				pst.setString(1, pojo.getIdVideo());
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
	public List<Video> getAll() {
		ArrayList<Video> videos = new ArrayList<>();

		try (Connection conn = DriverManager.getConnection(url, usuario, password)) {
			String sql = "SELECT id, idvideo, nombre FROM videos";

			try (PreparedStatement pst = conn.prepareStatement(sql)) {

				try (ResultSet rs = pst.executeQuery()) {
					while (rs.next()) {
						videos.add(new Video(rs.getLong("id"), rs.getString("idvideo"), rs.getString("nombre")));
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
		Video video = null;

		try (Connection conn = DriverManager.getConnection(url, usuario, password)) {

			String sql = "SELECT id, idvideo, nombre FROM videos WHERE id = ?";

			try (PreparedStatement pst = conn.prepareStatement(sql)) {

				pst.setString(1, id);

				try (ResultSet rs = pst.executeQuery()) {
					if (rs.next()) {
						video = new Video(rs.getLong("id"), rs.getString("idvideo"), rs.getString("nombre"));
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
		try (Connection con = DriverManager.getConnection(url, usuario, password)) {
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
		try (Connection con = DriverManager.getConnection(url, usuario, password)) {
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
