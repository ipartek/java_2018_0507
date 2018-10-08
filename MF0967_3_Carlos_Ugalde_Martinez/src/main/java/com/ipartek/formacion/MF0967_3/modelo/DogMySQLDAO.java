package com.ipartek.formacion.MF0967_3.modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.ipartek.formacion.MF0967_3.pojo.Dog;

public class DogMySQLDAO implements CrudAble<Dog>{
	private static DogMySQLDAO INSTANCE = null;
	String url = "jdbc:mysql://localhost:3307/ipartek?serverTimezone=UTC&useSSL=false";
	static String usuario = "root";
	static String password = "admin";
	
	public static synchronized DogMySQLDAO getInstance() throws ClassNotFoundException {
		if (INSTANCE == null) {
			Class.forName("com.mysql.cj.jdbc.Driver");
			INSTANCE = new DogMySQLDAO();
		}
		return INSTANCE;
	}

	@Override
	public boolean insert(Dog pojo) {
try (Connection conn = DriverManager.getConnection(url, usuario, password)) {
			String sql = "INSERT INTO dogs (nombre, edad, raza, chip, latitud, longitud, peso, apadrinado) VALUES (?, ?, ?, ?, ?, ?, ?, ?);";
			try (PreparedStatement prs = conn.prepareStatement(sql)) {
				prs.setString(1, pojo.getNombre());
				prs.setInt(2, pojo.getEdad());
				prs.setString(3,pojo.getRaza());
				prs.setString(4,pojo.getChip());
				prs.setDouble(5, pojo.getLatitud());
				prs.setDouble(6, pojo.getLongitud());
				prs.setDouble(7, pojo.getPeso());
				prs.setInt(8, pojo.getApadrinado());
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

		return true;
	}

	@Override
	public List<Dog> getAll() {
		ArrayList<Dog> dogs = new ArrayList<>();
		try (Connection conn = DriverManager.getConnection(url, usuario, password)) {
			try (Statement stmt = conn.createStatement()) {
				String sql = "SELECT * FROM dogs";
				try (ResultSet rs = stmt.executeQuery(sql)) {			
					while (rs.next()) {
						int id = rs.getInt("id");
						String nombre = rs.getString("nombre");
						int edad = rs.getInt("edad");
						String raza = rs.getString("raza");
						String chip= rs.getString("chip");
						double latitud = rs.getDouble("latitud");
						double longitud = rs.getDouble("longitud");
						double peso = rs.getDouble("peso");
						int apadrinado = rs.getInt("apadrinado");
						
						dogs.add(new Dog(id, nombre, edad, raza, peso, chip, apadrinado, latitud, longitud));
					}
				} catch (Exception e) {
					System.out.println("ERROR AL CREAR EL RESULTSET");
					throw new AccesoDatosException(e.getMessage(), e);
				}
			} catch (Exception  e) {
				System.out.println("ERROR AL CREAR LA SENTENCIA");
				throw new AccesoDatosException(e.getMessage(), e);
			}
		} catch (SQLException e) {
			System.out.println("ERROR DE CONEXION");
			System.out.println(e.getMessage());
			throw new AccesoDatosException(e.getMessage(), e);
		}
		return dogs;
	}

	@Override
	public Dog getById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean update(Dog pojo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(String id) {
		// TODO Auto-generated method stub
		return false;
	}
}
