package AccesoDatos;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;



import modelos.Usuario;

public class TreeMapDAO implements CrudAble<Usuario> {
	
	private static final TreeMapDAO dao = new TreeMapDAO();
	
	private TreeMapDAO() {
		
	}
	
	public static TreeMapDAO getInstance(){
		
		return dao;
	}
	
	static {
		for(long i = 1; i <= 10; i++) {
			dao.insert(new Usuario(0, "email" + i + "@email.com", "contra" + i));
		}
	}
	
	private TreeMap<Long, Usuario> ListaUsuarios = new TreeMap<>();
	private Long idUltimo = 0L;
	
	@Override
	public List<Usuario> getAll() {
		return new ArrayList<Usuario>(ListaUsuarios.values());
	}

	@Override
	public Usuario getById(long id) {
		return ListaUsuarios.get(id);
	}

	@Override
	public void insert(Usuario usu) {
		Long id = ++idUltimo;
		usu.setId(id);
		ListaUsuarios.put(usu.getId(), usu);
		
	}

	@Override
	public void update(Usuario usu) {
		if(!ListaUsuarios.containsKey(usu.getId())) {
			throw new AccesoDatos("Id no existente");
		}
		ListaUsuarios.put(usu.getId(), usu);
		
	}

	@Override
	public void delete(long id) {
		if(!ListaUsuarios.containsKey(id)) {
			throw new AccesoDatos("Id no existente");
		}
		ListaUsuarios.remove(id);
		
	}


	
	

}
