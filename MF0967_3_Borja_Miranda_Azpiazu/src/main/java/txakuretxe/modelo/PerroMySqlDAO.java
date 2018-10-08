package txakuretxe.modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import txakuretxe.pojo.*;

public class PerroMySqlDAO implements CrudAble<Perro> {
	String url = "jdbc:mysql://localhost:3307/txakuretxe?serverTimezone=UTC&useSSL=false";
	String usuario = "root";
	String password = "admin";

	private static PerroMySqlDAO INSTANCE = null;

	public static synchronized PerroMySqlDAO getInstance() throws ClassNotFoundException {
		if (INSTANCE == null) {
			Class.forName("com.mysql.cj.jdbc.Driver");
			INSTANCE = new PerroMySqlDAO();
		}

		return INSTANCE;
	}

	@Override
	public boolean insert(Perro pojo) {
		try (Connection con = DriverManager.getConnection(url, usuario, password)) {
			String sql = "INSERT INTO perros (idperro, nombre,edad,raza,kg,apadrinado,nidentificacion,latitud,longitud) VALUES (?, ?,?,?,?,?,?,?,?)";
System.out.println(sql);
			try (PreparedStatement pst = con.prepareStatement(sql)) {
				pst.setString(1, pojo.getIdPerro());
				pst.setString(2, pojo.getNombre());
				pst.setString(3, pojo.getEdad());
				pst.setString(4, pojo.getRaza());
				pst.setString(5, pojo.getKg());
				pst.setBoolean(6,pojo.isApadrinado());
				pst.setString(7, pojo.getChip().getNidentificacion());
				pst.setString(8, pojo.getChip().getLatitud());
				pst.setString(9, pojo.getChip().getLongitud());

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
	public List<Perro> getAll() {
		ArrayList<Perro> perros = new ArrayList<>();

		try (Connection conn = DriverManager.getConnection(url, usuario, password)) {
			String sql = "SELECT idperro, nombre,edad,raza,kg,apadrinado,nidentificacion,latitud,longitud FROM perros";

			try (PreparedStatement pst = conn.prepareStatement(sql)) {

				try (ResultSet rs = pst.executeQuery()) {
					while (rs.next()) {
						perros.add(new Perro(rs.getString("idperro"),
								rs.getString("nombre"),
								rs.getString("edad"),
								rs.getString("raza"),
								rs.getString("kg"),
								rs.getBoolean("apadrinado"),
								new Chip(rs.getString("nidentificacion"),rs.getString("latitud"),rs.getString("longitud"))
								
								));
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

		return perros;

	}

	@Override
	public Perro getById(String id) {
		Perro perro= null;

		try (Connection conn = DriverManager.getConnection(url, usuario, password)) {

			String sql = "idperro, nombre,edad,raza,kg,apadrinado,nidentificacion,latitud,longitud FROM perros WHERE id = ?";

			try (PreparedStatement pst = conn.prepareStatement(sql)) {

				pst.setString(1, id);

				try (ResultSet rs = pst.executeQuery()) {
					if (rs.next()) {
						perro = new Perro(rs.getString("idperro"),
								rs.getString("nombre"),
								rs.getString("edad"),
								rs.getString("raza"),
								rs.getString("kg"),
								rs.getBoolean("apadrinado"),
								new Chip(rs.getString("nidentificacion"),rs.getString("latitud"),rs.getString("longitud"))
								
								);
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

		return perro;
	}

	@Override
	public boolean update(Perro pojo) {
		try (Connection con = DriverManager.getConnection(url, usuario, password)) {
			String sql = "UPDATE perros SET nombre = ? WHERE idperro = ?";

			try (PreparedStatement pst = con.prepareStatement(sql)) {
				
				//pst.setString(2, pojo.getIdLibro());
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
			String sql = "DELETE FROM perros WHERE idperro = ?";

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
