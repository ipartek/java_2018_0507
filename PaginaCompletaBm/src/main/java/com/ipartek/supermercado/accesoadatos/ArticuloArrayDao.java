package com.ipartek.supermercado.accesoadatos;

import java.util.ArrayList;
import java.util.List;
import com.ipartek.supermercado.pojo.Articulo;

public class ArticuloArrayDao implements CrudAble<Articulo> {
	List <Articulo> articulos=new ArrayList<>();
	private static ArticuloArrayDao INSTANCE;
	private ArticuloArrayDao() {
		
	}
	public static synchronized ArticuloArrayDao getInstance() {

		if (INSTANCE == null) {
			INSTANCE = new ArticuloArrayDao();
		}

		return INSTANCE;
	}
	public List<Articulo> getAll() {
		// TODO Auto-generated method stub
		return articulos;
	}

	public Articulo getById(long id) {
		// TODO Auto-generated method stub
		Articulo art=null;
		for(Articulo a:articulos)
			if(a.getId()==id)
			{
				return a;
				
			}
		return art;
		}

	public boolean insert(Articulo pojo) {
		// TODO Auto-generated method stub
		if(pojo!=null)
			articulos.add(pojo);
		return false;
	}

	public boolean update(Articulo pojo) {
		// TODO Auto-generated method stub
		if(pojo!=null)
			for(int i=0;i<articulos.size();i++) {
				if(articulos.get(i).equals(pojo))
					articulos.add(i, pojo);
			}
		return false;
	}

	public boolean delete(long id) {
		// TODO Auto-generated method stub
		
			for(int i=0;i<articulos.size();i++) {
				if(articulos.get(i).getId()==id)
					articulos.remove(i);
					}
				return false;
			}
	

}
