package com.ipartek.formacion.youtube.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.ipartek.formacion.youtube.Comentario;
import com.ipartek.formacion.youtube.Video;

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
	/*	try (Connection conn = DriverManager.getConnection(url, usuario, password)) {
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
*/
		return true;
	}

	@Override
	public List<Comentario> getAll() {
		ArrayList<Comentario> comentarios = new ArrayList<>();
		try (Connection conn = DriverManager.getConnection(url, usuario, password)) {
			String sql = "SELECT id, texto, videoyoutube_id, usuario_id, fecha FROM comentarios WHERE videoyoutube_id = ?";
			try (PreparedStatement prs = conn.prepareStatement(sql)) {
				try (ResultSet rs = prs.executeQuery(sql)) {
					while (rs.next()) {
						int id = rs.getInt("id");
						String texto = rs.getString("texto");
						int videoyoutube_id = rs.getInt("videoyoutube_id");
						int usuario_id = rs.getInt("usuario_id");
						Date fecha = rs.getDate("fecha");
						comentarios.add(new Comentario(id, texto, videoyoutube_id, usuario_id, fecha));
					}
				} catch (Exception e) {
					throw new AccesoDatosException(e.getMessage(), e);
					//System.out.println("ERROR AL CREAR EL RESULTSET");
				}
			} catch (Exception e) {
				throw new AccesoDatosException(e.getMessage(), e);
				//System.out.println("ERROR AL CREAR LA SENTENCIA");
			}
		} catch (SQLException e) {
			System.out.println("ERROR DE CONEXION");
			System.out.println(e.getMessage());
		}
		return comentarios;
	}

	@Override
	public Comentario getById(String id) {
		// Debe alterarse el Crudable para añadir la posibilidad de crear una lista de comentarios
		//la segunda opcion es alterar el getAll para que nos muestre los datos que queremos
		/*ArrayList<Comentario> comentarios = new ArrayList<>();
		try (Connection conn = DriverManager.getConnection(url, usuario, password)) {
			String sql = "SELECT id, texto, videoyoutube_id, usuario_id, fecha FROM videos WHERE videoyoutube_id = ?";
			try (PreparedStatement pst = conn.prepareStatement(sql)) {
				// Mirando que valor entra en el prepared statement
				pst.setInt(1, Integer.parseInt(id));

				try (ResultSet rs = pst.executeQuery()) {
					if (rs.next()) {
						comentarios.add(new Comentario(rs.getInt("id"), rs.getString("texto"), rs.getInt("videoyoutube_id"),
								rs.getInt("usuario_id"), rs.getDate("fecha")));
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

		return comentarios;*/
		return null;
	}

	@Override
	public boolean update(Comentario pojo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(String id) {
		boolean resul = false;
		try (Connection conn = DriverManager.getConnection(url, usuario, password)) {
			conn.setAutoCommit(false);
			String sql = "delete from comentarios where videoyoutube_id = ?";
			try (PreparedStatement prs = conn.prepareStatement(sql)) {
				prs.setString(1, id);
				int numFilas = prs.executeUpdate();
				if (numFilas != 1) {
					return false;
				}
				conn.commit();
			} catch (SQLException e) {
				conn.rollback();
				System.out.println(e.getMessage());
				System.out.println("ERROR DE CONEXION");
			}
		} catch (SQLException e) {
			System.out.println("ERROR DE CONEXION");
			System.out.println(e.getMessage());
		}
		return resul;
	}
	
	
}
