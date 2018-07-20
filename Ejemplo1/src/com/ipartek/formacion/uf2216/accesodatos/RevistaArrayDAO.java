package com.ipartek.formacion.uf2216.accesodatos;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.ipartek.formacion.uf2216.pojo.Revista;

public class RevistaArrayDAO implements CrudAble<Revista> {

	private List<Revista> revistas = new ArrayList<>();

	private static RevistaArrayDAO INSTANCE;

	private RevistaArrayDAO() {
	}

	public static synchronized RevistaArrayDAO getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new RevistaArrayDAO();
		}
		return INSTANCE;
	}

	@Override
	public List<Revista> getAll() {
		return revistas;
	}

	@Override
	public Revista getById(long id) {
		Revista resul = null;
		// foreach
		for (Revista revistaIteracion : revistas) {
			if (id == revistaIteracion.getId()) {
				resul = revistaIteracion;
				break;
			}
		}
		return resul;
	}

	@Override
	public boolean insert(Revista revista) {
		boolean resul = false;

		if (revista != null) {
			resul = revistas.add(revista);
		}
		return resul;
	}

	@Override
	public boolean update(Revista revistaUpdate) {
		boolean resul = false;
		Revista revistaIteracion = null;
		int i = 0;
		if (revistaUpdate != null) {
			// Iterator
			Iterator<Revista> it = revistas.iterator();
			while (it.hasNext()) {
				revistaIteracion = it.next();
				if (revistaIteracion.getId() == revistaUpdate.getId()) {
					revistas.set(i, revistaUpdate);
					resul = true;
					break;
				}
				i++;
			}
		}
		return resul;
	}

	@Override
	public boolean delete(long id) {
		boolean resul = false;

		Revista vIteracion = null;

		// buscar revista a eliminar
		for (int i = 0; i < revistas.size(); i++) {

			vIteracion = revistas.get(i); // revista sobre el que iteramos

			if (id == vIteracion.getId()) { // revista encontrado
				resul = revistas.remove(vIteracion);
				break;
			}
		}

		return resul;
	}

}