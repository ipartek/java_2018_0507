package com.ipartek.superonline.modelo;

import java.util.ArrayList;
import java.util.List;

import com.ipartek.superonline.modelo.CrudAble;
import com.ipartek.superonline.modelo.UsuarioDAO;
import com.ipartek.superonline.modelo.ProductoDAO;
import com.ipartek.superonline.pojo.Usuario;
import com.ipartek.superonline.pojo.Producto;


public class UsuarioDAO implements CrudAble<Usuario> {
	
	List <Usuario> usuarios=new ArrayList<Usuario>();
	private static UsuarioDAO INSTANCE;
	private UsuarioDAO() {
		
	}
	public static synchronized UsuarioDAO getInstance() {

		if (INSTANCE == null) {
			INSTANCE = new UsuarioDAO();
		}

		return INSTANCE;
	}
	public List<Usuario> getAll() {
		// TODO Auto-generated method stub
		return usuarios;
	}

	public Usuario getById(long id) {
		// TODO Auto-generated method stub
		Usuario user=null;
		for(Usuario u:usuarios)
			if(u.getID()==id)
			{
				return u;
				
			}
		return user;
		}

	public boolean insert(Usuario pojo) {
		// TODO Auto-generated method stub
		if(pojo!=null)
			usuarios.add(pojo);
		return false;
	}

	public boolean update(Usuario pojo) {
		// TODO Auto-generated method stub
		if(pojo!=null)
			for(int i=0;i<usuarios.size();i++) {
				if(usuarios.get(i).equals(pojo))
					usuarios.add(i, pojo);
			}
		return false;
	}

	public boolean delete(long id) {
		// TODO Auto-generated method stub
		
			for(int i=0;i<usuarios.size();i++) {
				if(usuarios.get(i).getID()==id)
					usuarios.remove(i);
					}
				return false;
			}
	

	
	

}
