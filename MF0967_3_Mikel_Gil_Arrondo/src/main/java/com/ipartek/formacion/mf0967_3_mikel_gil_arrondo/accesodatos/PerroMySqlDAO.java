package com.ipartek.formacion.mf0967_3_mikel_gil_arrondo.accesodatos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ipartek.formacion.mf0967_3_mikel_gil_arrondo.modelos.Chip;
import com.ipartek.formacion.mf0967_3_mikel_gil_arrondo.modelos.Perro;


public class PerroMySqlDAO implements CrudAble<Perro>{
	private static PerroMySqlDAO INSTANCE = null;
	
	public static synchronized PerroMySqlDAO getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new PerroMySqlDAO();
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				System.out.println("ERROR AL CARGAR EL DRIVER DE JDBC");
				e.printStackTrace();
			}
		}
		return INSTANCE;
	}

	@SuppressWarnings("finally")
	@Override
	public List<Perro> getAll() {
		String sql = "SELECT * FROM perros";	
		ArrayList<Perro> perros = new ArrayList<Perro>();
		Connection conn = UtilsDAO.getConnection();
		
		try (PreparedStatement pst = conn.prepareStatement(sql)) {
			try(ResultSet rs = pst.executeQuery()){
				while (rs.next()) {
					perros.add(new Perro(
							rs.getLong("idPerro"),
							rs.getString("nombre"),
							rs.getInt("edad"),
							rs.getString("raza"),
							rs.getInt("peso"),
							rs.getInt("apadrinado"),
							rs.getString("chip"),
							rs.getString("latitud"),
							rs.getString("longitud")));
				}
			}catch (Exception e) {
				System.out.println("ERROR AL CREAR EL RESULTSET DE GET ALL: " + e.getMessage());
				e.printStackTrace();
			}
		} catch (SQLException e) {
			System.out.println("ERROR AL CREAR LA SENTENCIA DE GET ALL");
		}finally {
			if (conn!=null) UtilsDAO.closeConnection(conn);
			return perros;
		}
	}

	@SuppressWarnings("finally")
	@Override
	public Perro getById(long idPerro) {
		String sql = "SELECT * FROM perros WHERE idPerro = ?";
		Perro perro = null;
		Connection conn = UtilsDAO.getConnection();
		
		try (PreparedStatement pst = conn.prepareStatement(sql)){
			pst.setLong(1, idPerro);
			try(ResultSet rs = pst.executeQuery()){
				if(rs.next()) {
					perro = new Perro(rs.getLong("idPerro"),
							rs.getString("nombre"),
							rs.getInt("edad"),
							rs.getString("raza"),
							rs.getInt("peso"),
							rs.getInt("apadrinado"),
							rs.getString("chip"),
							rs.getString("latitud"),
							rs.getString("longitud"));
				}else {
					return null;
				}
			}catch (Exception e) {
				System.out.println("ERROR AL CREAR EL RESULTSET DE GET BY ID");
			}
		} catch (SQLException e) {
			System.out.println("ERROR AL CREAR LA SENTENCIA DE GET BY ID");
		}finally {
			if (conn!=null) UtilsDAO.closeConnection(conn);
			return perro;
		}
	}

	@SuppressWarnings("finally")
	public boolean insert(Perro pojo, Chip chip) {
		String sql = "INSERT INTO perros (nombre,edad,raza,peso,apadrinado,chip,latitud,longitud) VALUES (?,?,?,?,?,?,?,?)";	
		boolean result = false;
		Connection conn = UtilsDAO.getConnection();
		try (PreparedStatement pst = conn.prepareStatement(sql)){
			pst.setString(1, pojo.getNombre());
			pst.setInt(2, pojo.getEdad());
			pst.setString(3, pojo.getRaza());
			pst.setInt(4, pojo.getPeso());
			pst.setInt(5, pojo.getApadrinado());
			pst.setString(6, chip.getChip());
			pst.setString(7, chip.getLatitud());
			pst.setString(8, chip.getLongitud());
			
			int numFilas = pst.executeUpdate();
			
			if (numFilas != 1) {
				result = false;
			}else {
				result = true;
			}
		} catch (SQLException e) {
			System.out.println("ERROR AL CREAR LA SENTENCIA DE INSERT PERRO");
			result = false;
		}finally {
			if (conn!=null) UtilsDAO.closeConnection(conn);
			return result;
		}
	}

	@SuppressWarnings("finally")
	public boolean update(Perro pojo, Chip chip) {
		String sql = "UPDATE perros SET nombre = ?, edad = ?, raza = ?, peso = ?, apadrinado = ?,chip = ?,latitud = ?, longitud = ? WHERE idPerro = ?";	
		boolean result = false;
		Connection conn = UtilsDAO.getConnection();
		try (PreparedStatement pst = conn.prepareStatement(sql)){
			pst.setString(1, pojo.getNombre());
			pst.setInt(2, pojo.getEdad());
			pst.setString(3, pojo.getRaza());
			pst.setInt(4, pojo.getPeso());
			pst.setInt(5, pojo.getApadrinado());
			pst.setString(6, chip.getChip());
			pst.setString(7, chip.getLatitud());
			pst.setString(8, chip.getLongitud());
			
			int numFilas = pst.executeUpdate();
			
			if (numFilas != 1) {
				result = false;
			}else {
				result = true;
			}
		} catch (SQLException e) {
			System.out.println("ERROR AL CREAR LA SENTENCIA DE UPDATE");
			result = false;
		}finally {
			if (conn!=null) UtilsDAO.closeConnection(conn);
			return result;
		}
	}

	@SuppressWarnings("finally")
	@Override
	public boolean delete(long id) {
		String sql = "DELETE FROM perros WHERE idPerro= ?";	
		boolean result = false;
		Connection conn = UtilsDAO.getConnection();
		try (PreparedStatement pst = conn.prepareStatement(sql)){
			pst.setLong(1, id);
			
			int numFilas = pst.executeUpdate();
			
			if (numFilas != 1) {
				result = false;
			}else {
				result = true;
			}
		} catch (SQLException e) {
			System.out.println("ERROR AL CREAR LA SENTENCIA DE DELETE");
			result = false;
		}finally {
			if (conn!=null) UtilsDAO.closeConnection(conn);
			return result;
		}
	}
	
	@SuppressWarnings("finally")
	@Override
	public Long countAll() {
		String sql = "SELECT count(*) FROM perros";
		Connection conn = UtilsDAO.getConnection();
		Long numRows = null;
		try (PreparedStatement pst = conn.prepareStatement(sql)){
			try (ResultSet rs = pst.executeQuery()){
				if(rs.next()) {
					numRows = rs.getLong("1");
				}
			}catch (Exception e) {
				System.out.println("ERROR AL CREAR EL RESULTSET DE COUNT ALL: " + e.getMessage());
				e.printStackTrace();
			}
		}catch (SQLException e) {
			System.out.println("ERROR AL CREAR LA SENTENCIA DE GET USER ID");
		}finally {
			if (conn!=null) UtilsDAO.closeConnection(conn);
			return numRows;
		}
	}

	@Override
	public boolean insert(Perro pojo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Perro pojo) {
		// TODO Auto-generated method stub
		return false;
	}
}
