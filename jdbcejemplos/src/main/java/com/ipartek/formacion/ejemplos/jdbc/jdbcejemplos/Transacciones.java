package com.ipartek.formacion.ejemplos.jdbc.jdbcejemplos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Transacciones {

	private static final Long[] ids = { 8L, 9L };
	
	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3307/ipartek?serverTimezone=UTC&useSSL=false";
		String usuario = "root";
		String password = "admin";
		
		Connection con = null;
		
		try {
			con = DriverManager.getConnection(url, usuario, password);
			con.setAutoCommit(false);
			
			String sql = "DELETE FROM videos WHERE id = ?";
			
			PreparedStatement pst = con.prepareStatement(sql);
			
			for(Long id: ids) {
				pst.setLong(1, id);
				pst.executeUpdate();
			}
			
			sql = "SELECT COUNT(*) FROM videos";
			
			pst = con.prepareStatement(sql);
			
			ResultSet rs = pst.executeQuery();
			
			rs.next();
			
			System.out.println("Hay " + rs.getLong(1) + " videos");
			
			con.rollback(); // EN CÓDIGO REAL, AQUÍ HARÍAMOS con.commit(); en lugar de con.rollback();
			
			//Este resto de código sólo tiene sentido aquí para demostrar que el con.rollback() efectivamente era provisional y no definitivo
			rs = pst.executeQuery();
			
			rs.next();
			
			System.out.println("Hay " + rs.getLong(1) + " videos");
			
		} catch (SQLException e) {
			if(con != null)
				try {
					con.rollback();
				} catch (SQLException e1) {
					System.out.println("Error al hacer rollback");
					e1.printStackTrace();
				}
			e.printStackTrace();
		}
	}

}
