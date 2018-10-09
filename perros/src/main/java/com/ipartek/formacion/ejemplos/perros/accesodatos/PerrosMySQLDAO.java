package com.ipartek.formacion.ejemplos.perros.accesodatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.ipartek.formacion.ejemplos.perros.modelos.Chip;
import com.ipartek.formacion.ejemplos.perros.modelos.Perro;

public class PerrosMySQLDAO implements CrudAble<Perro> {
	private static final String url = "jdbc:mysql://localhost:3307/ipartek?serverTimezone=UTC&useSSL=false&characterEncoding=UTF-8";
	private static final String usuario = "root";
	private static final String password = "admin";
	
	//SINGLETON
	private PerrosMySQLDAO() {}
	
	private static final PerrosMySQLDAO instancia = new PerrosMySQLDAO();
	
	public static PerrosMySQLDAO getInstance() { return instancia; }
	//FIN SINGLETON

	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			throw new AccesoDatosException("No se ha encontrado el driver de MySQL", e);
		}
	}
	@Override
	public List<Perro> getAll() {
		ArrayList<Perro> perros = new ArrayList<>();
		
		try (Connection conn = DriverManager.getConnection(url, usuario, password)) {

			String sql = "SELECT * FROM perros";

			try (PreparedStatement pst = conn.prepareStatement(sql)) {
				
				try (ResultSet rs = pst.executeQuery()) {
					Perro perro;
					Chip chip;
					
					while (rs.next()) {
						chip = new Chip(-1L, rs.getString("chip_identificacion"), rs.getBigDecimal("chip_latitud"), rs.getBigDecimal("chip_longitud"));
						perro = new Perro(rs.getLong("id"), rs.getString("nombre"), rs.getInt("edad"), rs.getString("raza"), rs.getDouble("peso"), chip, rs.getBoolean("apadrinado"));
						
						perros.add(perro);
					}
				} catch (Exception e) {
					throw new AccesoDatosException("Error en el resultset", e);
				} 
			} catch (Exception e) {
				throw new AccesoDatosException("Error en la sentencia", e);
			} 
			
		} catch (Exception e) {
			throw new AccesoDatosException("Error en la sentencia", e);
		}
		
		return perros;
	}

	@Override
	public int insert(Perro perro) {
		int numFilas;
		
		try (Connection conn = DriverManager.getConnection(url, usuario, password)) {

			String sql = "INSERT INTO perros "
					+ "(nombre, edad, peso, raza, apadrinado, chip_identificacion, chip_latitud, chip_longitud) VALUES "
					+ "(?, ?, ?, ?, ?, ?, ?, ?)";

			try (PreparedStatement pst = conn.prepareStatement(sql)) {
				pst.setString(1, perro.getNombre());
				pst.setInt(2, perro.getEdad());
				pst.setDouble(3, perro.getPeso());
				pst.setString(4, perro.getRaza());
				pst.setBoolean(5, perro.isApadrinado());
				pst.setString(6, perro.getChip().getIdentificacion());
				pst.setBigDecimal(7, perro.getChip().getLatitud());
				pst.setBigDecimal(8, perro.getChip().getLongitud());
				
				numFilas = pst.executeUpdate();
				
				if(numFilas != 1) {
					throw new AccesoDatosException("Se ha cambiado menos o más de una fila");
				}
			} catch (Exception e) {
				throw new AccesoDatosException("Error en la sentencia", e);
			} 
			
		} catch (Exception e) {
			throw new AccesoDatosException("Error en la sentencia", e);
		}
		
		return numFilas;
	}

	@Override
	public int update(Perro tipo) {
		throw new AccesoDatosException("NO IMPLEMENTADO");
	}

	@Override
	public int delete(Long id) {
		throw new AccesoDatosException("NO IMPLEMENTADO");
	}
	
	
}
