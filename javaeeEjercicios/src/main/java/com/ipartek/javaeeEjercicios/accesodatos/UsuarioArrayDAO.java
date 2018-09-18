package com.ipartek.javaeeEjercicios.accesodatos;

import java.util.List;

import com.ipartek.javaeeEjercicios.pojos.Usuario;

public class UsuarioArrayDAO implements CrudAble<Usuario>{
	private List<Usuario> usuarios;
	private static UsuarioArrayDAO INSTANCE;
	private UsuarioArrayDAO() {
			
		}
	public static synchronized UsuarioArrayDAO getInstance() {

		if (INSTANCE == null) {
			INSTANCE = new UsuarioArrayDAO();
		}

		return INSTANCE;
	}
	public List<Usuario> getAll() {
		// TODO Auto-generated method stub
		return usuarios;
	}

	@Override
	public Usuario getById(long id) {
		// TODO Auto-generated method stub
		Usuario user=null;
		for(Usuario u:usuarios)
			if(u.getId()==id)
			{
				return u;
				
			}
		return user;
		
	}

	@Override
	public boolean insert(Usuario pojo) {
		// TODO Auto-generated method stub
		if(pojo!=null)
			usuarios.add(pojo);
		return false;
	}

	@Override
	public boolean update(Usuario pojo) {
		// TODO Auto-generated method stub
		if(pojo!=null)
			for(int i=0;i<usuarios.size();i++) {
				if(usuarios.get(i).equals(pojo))
					usuarios.add(i, pojo);
			}
		return false;
	}

	@Override
	public boolean delete(long id) {
		// TODO Auto-generated method stub
		for(int i=0;i<usuarios.size();i++) {
			if(usuarios.get(i).getId()==id)
				usuarios.remove(i);
				}
			return false;
		}
	

}