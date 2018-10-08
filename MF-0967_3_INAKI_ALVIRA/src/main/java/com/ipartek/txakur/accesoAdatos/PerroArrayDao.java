package com.ipartek.txakur.accesoAdatos;

import java.util.ArrayList;
import java.util.List;

import com.ipartek.txakur.pojo.Perro;
import com.ipartek.txakur.pojo.Usuario;

public class PerroArrayDao implements CrudAble<Perro> {
	private List<Perro> perros=new ArrayList<>();
	private static PerroArrayDao INSTANCE;
	private PerroArrayDao() {
			
		}
	public static synchronized PerroArrayDao getInstance() {

		if (INSTANCE == null) {
			INSTANCE = new PerroArrayDao();
		}

		return INSTANCE;
	}
	public List<Perro> getAll() {
		// TODO Auto-generated method stub
		return perros;
	}

	@Override
	public Perro getById(long id) {
		// TODO Auto-generated method stub
		Perro per=null;
		for(Perro p:perros)
			if(p.getId()==id)
			{
				return p;
				
			}
		return per;
		
	}

	@Override
	public boolean insert(Perro pojo) {
		// TODO Auto-generated method stub
		if(pojo!=null)
			perros.add(pojo);
		return false;
	}

	@Override
	public boolean update(Perro pojo) {
		// TODO Auto-generated method stub
		if(pojo!=null)
			for(int i=0;i<perros.size();i++) {
				if(perros.get(i).equals(pojo))
					perros.add(i, pojo);
			}
		return false;
	}

	@Override
	public boolean delete(long id) {
		// TODO Auto-generated method stub
		for(int i=0;i<perros.size();i++) {
			if(perros.get(i).getId()==id)
				perros.remove(i);
				}
			return false;
		}
	
}
