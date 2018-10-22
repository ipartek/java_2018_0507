package com.ipartek.formacion.youtube.model;

import java.util.ArrayList;
import java.util.List;

import com.ipartek.formacion.youtube.Comentario;

public class ComentarioArrayListDAO implements CrudAble<Comentario> {

	private static ComentarioArrayListDAO INSTANCE = null;
	private static List<Comentario> comentarios = null;

	private ComentarioArrayListDAO() {
		comentarios = new ArrayList<Comentario>();
		try {
			comentarios.add(new Comentario("user", "Comment harcode"));
		
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static synchronized ComentarioArrayListDAO getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new ComentarioArrayListDAO();
		}

		return INSTANCE;
	}

	@Override
	public boolean insert(Comentario pojo) {
		return comentarios.add(pojo);
	}

	@Override
	public List<Comentario> getAll() {
		System.out.println("En ComentarioArrayListDAO.getAll");
		return comentarios;
	}

	@Override
	public Comentario getById(String id) {
		Comentario resul = null;
		if (id != null) {
			for (Comentario c : comentarios) {
				if (id.equals(c.getTexto())) {
					resul = c;
				}
			}
		}
		return resul;
	}

	@Override
	public boolean update(Comentario pojo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(String id) {
		boolean resul = false;
		Comentario c = null;
		if ( id != null ) { 
			for (int i = 0; i < comentarios.size(); i++) {
				c = comentarios.get(i); 
				if (id.equals(c.getTexto()) ) { 
					resul = comentarios.remove(c);
					break;
				}
			}
		}	
		return resul;
	}

}
