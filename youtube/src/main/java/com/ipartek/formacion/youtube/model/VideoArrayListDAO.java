package com.ipartek.formacion.youtube.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.ipartek.formacion.youtube.Video;

public class VideoArrayListDAO implements CrudAble<Video> {

	private static VideoArrayListDAO INSTANCE = null;
	private static List<Video> videos = null;
	String url = "jdbc:mysql://localhost:3307/ipartek?serverTimezone=UTC&useSSL=false";
	String usuario = "root";
	String password = "admin";
	ArrayList<Video> lista=new ArrayList();
	private VideoArrayListDAO() {
		
	}

	@Override
	public boolean insert(Video pojo) {
		try (Connection conn = DriverManager.getConnection(url, usuario, password)) {
			String sql="INSERT INTO ipartek.video (idvideo,nombre) VALUES (?,?)";
		try (PreparedStatement pst = conn.prepareStatement(sql)) {
			pst.setString(1, pojo.getId());
			pst.setString(2, pojo.getNombre());
			try {
				pst.executeQuery();
				return true;
			
			}catch(Exception e) {
				System.out.println("no se ha producido introducir el video.");
				return false;
			}
		
		}catch(Exception e) {
			return false;
		}
	}catch(Exception e) {
		return false;
	}
	}

	@Override
	public List<Video> getAll(){
		
		Video k=new Video();
		try (Connection conn = DriverManager.getConnection(url, usuario, password)) {
			String sql = "SELECT * FROM ipartek.video";
		try (PreparedStatement pst = conn.prepareStatement(sql)) {				
				ResultSet result1=pst.executeQuery();
				while(result1.next()){
					String nombre= result1.getString("titulo");
					String id=result1.getString("idvideo");
					k.setId(id);
					k.setNombre(nombre);
					lista.add(k);
					}
			}catch(Exception e) {
				e.getMessage();
			}
		}catch(Exception e) {
			e.getMessage();
		}
		return lista;
	}

	@Override
	public Video getById(String id) {
		Video k=new Video();
		try (Connection conn = DriverManager.getConnection(url, usuario, password)) {
			String sql = "SELECT * FROM ipartek.video where idvideo=?";
		try (PreparedStatement pst = conn.prepareStatement(sql)) {
				pst.setString(1, id);
				ResultSet result1=pst.executeQuery();
				String nombre2= result1.getString("titulo");
				String id2=result1.getString("idvideo");
					
					k.setId(id2);
					k.setNombre(nombre2);
			}catch(Exception e) {
				e.getMessage();
			}
		}catch(Exception e) {
			e.getMessage();
		}
		return k;
	}

	@Override
	public boolean update(Video pojo) {
		try (Connection conn = DriverManager.getConnection(url, usuario, password)) {
			String sql="update INTO ipartek.video (nombre) VALUES (?) where idvideo=?";
		try (PreparedStatement pst = conn.prepareStatement(sql)) {
			pst.setString(1, pojo.getNombre());
			pst.setString(2, pojo.getId());
			try {
				pst.executeQuery();
				return true;
			
			}catch(Exception e) {
				System.out.println("no se ha producido introducir el video.");
				e.getMessage();
				return false;
			}
		
		}catch(Exception e) {
			e.getMessage();
			return false;
		}
	}catch(Exception e) {
		return false;
	}
	}

	@Override
	public boolean delete(String id) {
		try (Connection conn = DriverManager.getConnection(url, usuario, password)) {
			String sql="delete * from ipartek.video where idvideo=?";
		try (PreparedStatement pst = conn.prepareStatement(sql)) {
			pst.setString(1, id);
			
			try {
				pst.executeQuery();
				return true;
			
			}catch(Exception e) {
				System.out.println("no se ha producido borrar el video.");
				e.getMessage();
				return false;
			}
		
		}catch(Exception e) {
			e.getMessage();
			return false;
		}
	}catch(Exception e) {
		return false;
	}
	

	}

}
