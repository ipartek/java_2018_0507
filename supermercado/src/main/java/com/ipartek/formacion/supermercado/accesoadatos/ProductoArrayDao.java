package com.ipartek.formacion.supermercado.accesoadatos;

import java.util.ArrayList;
import java.util.List;
import com.ipartek.formacion.supermercado.modelos.Producto;

public class ProductoArrayDao implements CrudAble<Producto> {
	List <Producto> productos=new ArrayList<>();
	private static ProductoArrayDao INSTANCE;
	private ProductoArrayDao() {
		
	}
	public static synchronized ProductoArrayDao getInstance() {

		if (INSTANCE == null) {
			INSTANCE = new ProductoArrayDao();
		}

		return INSTANCE;
	}
	public List<Producto> getAll() {
		// TODO Auto-generated method stub
		return productos;
	}

	public Producto getById(long id) {
		// TODO Auto-generated method stub
		Producto art=null;
		for(Producto a:productos)
			if(a.getId()==id)
			{
				return a;
				
			}
		return art;
		}

	public boolean insert(Producto pojo) {
		// TODO Auto-generated method stub
		if(pojo!=null)
			productos.add(pojo);
		return false;
	}

	public boolean update(Producto pojo) {
		// TODO Auto-generated method stub
		if(pojo!=null)
			for(int i=0;i<productos.size();i++) {
				if(productos.get(i).equals(pojo))
					productos.add(i, pojo);
			}
		return false;
	}

	public boolean delete(long id) {
		// TODO Auto-generated method stub
		
			for(int i=0;i<productos.size();i++) {
				if(productos.get(i).getId()==id)
					productos.remove(i);
					}
				return false;
			}
	

}