package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import modelos.Persona;

public class PersonaMySqlDAO implements CrudAble <Persona> {
	
	String url= "jdbc:mysql://localhost:3307/personas?serverTimezone=UTC&useSSL=false";
	String usuario = "root";
	String password = "admin";
	
	private static PersonaMySqlDAO INSTANCE = null;
	
	public static synchronized PersonaMySqlDAO getInstance() throws ClassNotFoundException {
		if (INSTANCE == null) {
			Class.forName("com.mysql.cj.jdbc.Driver");
			INSTANCE = new PersonaMySqlDAO();
		}
		
		return INSTANCE;
	}

	@Override
	public List<Persona> getAll() {
		ArrayList<Persona> personas = new ArrayList<>();
		
		try (Connection conn = DriverManager.getConnection(url, usuario, password)){
			String sql = "SELECT id, nombre, apellido, direccion, numeroD, email, dni, puesto FROM personas LIMIT 50";
			
			try(PreparedStatement pst = conn.prepareStatement(sql)){
				try(ResultSet rs = pst.executeQuery()){
					while (rs.next()) {
						personas.add(new Persona(rs.getLong("id"),rs.getString("nombre"),rs.getString("apellido"),rs.getString("direccion")
								,rs.getLong("numeroD"),rs.getString("email"),rs.getString("dni"),rs.getString("puesto")));
					}
				} catch(Exception e) {
					throw new AccesoDatosException(e.getMessage(), e);
				}
				
			}catch (SQLException e) {
				throw new AccesoDatosException(e.getMessage(), e);
			}
	}catch (SQLException e) {
		throw new AccesoDatosException(e.getMessage(), e);
	}
		return personas;
	}

	@Override
	public Persona getById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	
	
	@Override
	public void insert(Persona pojo) {
		try (Connection con = DriverManager.getConnection(url, usuario, password)) {
			String sql = "Insert into personas (nombre,apellido,direccion, numeroD, email, dni, puesto) VALUES (?,?,?,?,?,?,?)";
			
			try(PreparedStatement pst = con.prepareStatement(sql)){
				pst.setString(1, pojo.getNombre());
				pst.setString(2, pojo.getApellido());
				pst.setString(3, pojo.getDireccion());
				pst.setLong(4, pojo.getNumeroD());
				pst.setString(5, pojo.getEmail());
				pst.setString(6, pojo.getDni());
				pst.setString(7, pojo.getPuesto());
				
				
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
	public void update(Persona pojo) {
		try (Connection con = DriverManager.getConnection(url, usuario, password)) {
			String sql = "UPDATE personas SET nombre = ?, apellido = ?, direccion = ?, numeroD = ?, email = ?, dni = ?, puesto = ? WHERE id = ?";
			
			try(PreparedStatement pst = con.prepareStatement(sql)){
				pst.setString(1, pojo.getNombre());
				pst.setString(2, pojo.getApellido());
				pst.setString(3, pojo.getDireccion());
				pst.setLong(4, pojo.getNumeroD());
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

	@Override
	public boolean delete(String id) {
		// TODO Auto-generated method stub
		return false;
	}


}
