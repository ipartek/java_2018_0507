package com.ipartek.formacion.ong.accesoadatos;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

import com.ipartek.formacion.ong.modelos.Usuario;

public class UsuarioTreeMapDAO implements CrudAble<Usuario> {

	//PRINCIPIO SINGLETON
	private static final UsuarioTreeMapDAO dao = new UsuarioTreeMapDAO();
	
	private UsuarioTreeMapDAO() {}
	
	public static UsuarioTreeMapDAO getInstance() { return dao; }
	//FIN SINGLETON
	
	//CONSTRUCTOR ESTÁTICO
	static {
		usuarios = new TreeMap<>();
		dao.insert(new Usuario(0, "scobby", "galletas"));
	}
	//FIN
	
	private static TreeMap<Long, Usuario> usuarios;
	
	private Long idUltimo = 0L;
	
	
	//validar usuario
	public static Usuario validarUsuario(Usuario usuario) {
		for (Usuario u : UsuarioTreeMapDAO.getInstance().getAll() ) {
			
			if (u.getNombre().equals(usuario.getNombre()) 
					&& u.getPassword().equals(usuario.getPassword())  ) {
				return u;
			}		
		}
		return null;
	}
	
	
	@Override
	public List<Usuario> getAll() {
		return new ArrayList<Usuario>(usuarios.values());
	}

	@Override
	public Usuario getById(long id) {
		return usuarios.get(id);
	}

	@Override
	public void insert(Usuario usuario) {
		//ID AUTONUMERICO
		Long id = ++idUltimo;
		usuario.setId(id);

		usuarios.put(usuario.getId(), usuario);
	}

	@Override
	public void update(Usuario usuario) {
		if(!usuarios.containsKey(usuario.getId())) {
			throw new AccesoDatos("Id no existente");
		}
		usuarios.put(usuario.getId(), usuario);
	}

	@Override
	public void delete(long id) {
		if(!usuarios.containsKey(id)) {
			throw new AccesoDatos("Id no existente");
		}
		usuarios.remove(id);
	}

}
