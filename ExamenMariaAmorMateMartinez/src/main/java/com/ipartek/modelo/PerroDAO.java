package com.ipartek.modelo;

import java.util.ArrayList;
import java.util.List;

import com.ipartek.pojo.Chip;
import com.ipartek.pojo.Perro;

public class PerroDAO implements CrudAble<Perro> {

	List<Perro> perros = new ArrayList<Perro>();
	private static PerroDAO INSTANCE;

	private PerroDAO() {

	}

	public static synchronized PerroDAO getInstance() {

		if (INSTANCE == null) {
			INSTANCE = new PerroDAO();
			
			//user admin
			//Perro perro = new Perro(0L,"scobby", "galletas");
			//INSTANCE.perros.add(perro);
			
			
			//carga de perros por defecto
			Perro perro2 = new Perro(1L, "chuli", "Ken", 7,"Beagle",50, true, new Chip("22-22-2018",0.5, 8.7));
			INSTANCE.perros.add(perro2);
			
			Perro perro3 = new Perro(2L, "chuli", "black", 2,"bulldog",45, true, new Chip("33-33-2016",0.4, 8.9));
			INSTANCE.perros.add(perro3);
			
			Perro perro4 = new Perro(3L, "chuli", "casi", 2,"Pastor Aleman",70, true, new Chip("33-33-2017",8.9, 8.9));
			INSTANCE.perros.add(perro4);
			
			Perro perro5 = new Perro(3L, "chuli", "roko", 2,"bulldog",80, false, new Chip("33-33-2015",0.5, 5.9));
			INSTANCE.perros.add(perro5);
			
		}

		return INSTANCE;
	}

	public List<Perro> getAll() {
		// TODO Auto-generated method stub
		return perros;
	}

	public Perro getById(long id) {
		// TODO Auto-generated method stub
		Perro perro = null;
		for (Perro p : perros)
			if (p.getId() == id) {
				return p;

			}
		return perro;
	}

	public boolean insert(Perro pojo) {
		// TODO Auto-generated method stub
		if (pojo != null) {
			perros.add(pojo);
			return true;
		}
		return false;
	}

	public boolean update(Perro pojo) {
		// TODO Auto-generated method stub
		if (pojo != null)
			for (int i = 0; i < perros.size(); i++) {
				if (perros.get(i).getId() == pojo.getId()) {
					perros.get(i).setNombre(pojo.getNombre());
					perros.get(i).setPassword(pojo.getPassword());
					perros.get(i).setId(pojo.getId());
					perros.get(i).setEdad(pojo.getEdad());
					perros.get(i).setRaza(pojo.getRaza());
					perros.get(i).setPeso(pojo.getPeso());
					perros.get(i).setApadrinado(pojo.isApadrinado());
					perros.get(i).setChip(pojo.getChip());
				}
			}
		return false;
	}

	public boolean delete(long id) {
		// TODO Auto-generated method stub

		for (int i = 0; i < perros.size(); i++) {
			if (perros.get(i).getId() == id) {
				perros.remove(i);
				return true;
			}
		}
		return false;
	}

}