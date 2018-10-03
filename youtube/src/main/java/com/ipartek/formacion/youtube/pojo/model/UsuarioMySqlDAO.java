package com.ipartek.formacion.youtube.pojo.model;

import java.util.List;

import com.ipartek.formacion.youtube.pojo.Usuario;

public class UsuarioMySqlDAO implements CrudAble<Usuario> {

	private static UsuarioMySqlDAO INSTANCE = null;
	
	String url = "jdbc:mysql://localhost:3307/ipartek?serverTimezone=UTC&useSSL=false";
	String usuario = "root";
	String password = "admin";

	public static synchronized UsuarioMySqlDAO getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new UsuarioMySqlDAO();
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				System.out.println("ERROR AL CARGAR EL DRIVER DE JDBC");
				e.printStackTrace();
			}
		}
		return INSTANCE;
	}

	@Override
	public boolean insert(Usuario pojo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Usuario> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Usuario getById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean update(Usuario pojo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(String id) {
		// TODO Auto-generated method stub
		return false;
	}


}