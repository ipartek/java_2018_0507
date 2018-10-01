package com.ipartek.formacion.youtube.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;

import com.ipartek.formacion.youtube.Video;

public class VideoArrayListDAO implements CrudAble<Video> {
	String url = "jdbc:mysql://localhost:3307/ipartek?serverTimezone=UTC&useSSL=false";
	String usuario = "root";
	String password = "admin";
	
	private VideoArrayListDAO() {

	}

	@Override
	public boolean insert(Video pojo) {

		String id = "";
	}

	@Override
	public List<Video> getAll() {
		
		
		List<Video> videos = new ArrayList<>();
		Video vi = new Video();
			
			try (Connection conn = DriverManager.getConnection(url, usuario, password)) {
				String sql ="SELECT id, nombre FROM videos";
				 try (Statement pst = conn.prepareStatement(sql)) {
				
				 }
			           try(ResultSet rs = pst.executeQuery()){
			            while(rs.next()) {
			                vi.setId(rs.getString("id"));
			                vi.setNombre(rs.getString("nombre"));
			                videos.add(vi);
			            	}
			} catch (Exception e) {
				  throw new AccesoDatosEception(e.getMessage(),e);
			}
	           
	        catch(Exception e) {
	               throw new AccesoDatosEception(e.getMessage(),e);
	        
	        }
			catch(SQLException e) {
				  throw new AccesoDatosEception(e.getMessage(),e);
        }
	return videos;
	}
	

	@Override
	public Video getById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean update(Video pojo) {
		long id;
		String nuevoNom;

		String sqlu = "UPDATE videos SET nombre = ? WHERE id = ?";

		try (PreparedStatement pst = conn.prepareStatement(sqlu)) {

			pst.setLong(2, id); // el 2 es a la interrogacion que hago referencia en la sentencia SQL arriba
			pst.setString(1, nuevoNom);

			int numFilas = pst.executeUpdate();

			if (numFilas != 1) {
				System.out.println("El número de filas modificado ha sido " + numFilas);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public boolean delete(String id) {
		// TODO Auto-generated method stub
		return false;
	}
