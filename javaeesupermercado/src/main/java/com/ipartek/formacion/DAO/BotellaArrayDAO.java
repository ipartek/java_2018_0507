package com.ipartek.formacion.DAO;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.ipartek.formacion.pojo.supermercado.Botella;

public class BotellaArrayDAO implements CrudAble <Botella> {
		
	private List<Botella> botellas = new ArrayList<>();
	
	private static BotellaArrayDAO INSTANCE;
	
	private BotellaArrayDAO() {
		
		
	}
	
	public static synchronized BotellaArrayDAO getInstance() { //es recomendable crearlo siempre. Es para no saturar el servidor
													
		if (INSTANCE == null) {
			INSTANCE = new BotellaArrayDAO(); //para que haga minimo un new del DAO y SOLO uno, no mas
		}									//de ahi el synchronized, para que no te deje crear mas objetos DAO

		return INSTANCE;
	}
	
	@Override
	public List<Botella> getAll() {
		return botellas;
		
	}
	
	@Override
	public Botella getById(long id) {
		Botella resul = null;
		
		for (Botella i : botellas) {
			if ( id == i.getId() ) {
				resul = i;
				break;
			}
		}
		return resul;
	}
	
	@Override
	public boolean insert(Botella bot) {
		boolean resul = false;

		if (bot != null) {
			resul = botellas.add(bot);
		}
		return resul;
	}
	
	@Override
	public boolean delete(long id) {
		
		boolean resul = false;
		
		Botella vIteracion = null;
		
		//buscar video a eliminar
		for (int i = 0; i < botellas.size(); i++) {
			
			vIteracion = botellas.get(i);   //video sobre el que iteramos
			
			if ( id == vIteracion.getId() ) {    // video encontrado
				resul = botellas.remove(vIteracion);
				break;
			}
		}
		
		return resul;
	}
	
	@Override
	public boolean update(Botella actualizarBo) {
		boolean resul = false;
		Botella botellaIteracion = null;
		int i = 0;
		if ( actualizarBo != null ) {
			//Iterator		
			Iterator<Botella> it = botellas.iterator();
			while( it.hasNext() ) {
				botellaIteracion = it.next();
				if ( botellaIteracion.getId() == actualizarBo.getId() ) {
					botellas.set(i, actualizarBo);
					resul = true;
					break;					
				}	
				i++;
			}		
		}	
		return resul;
	}


}
