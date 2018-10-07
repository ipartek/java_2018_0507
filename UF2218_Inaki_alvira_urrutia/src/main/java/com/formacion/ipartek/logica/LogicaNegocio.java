package com.formacion.ipartek.logica;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import com.formacion.ipartek.accesoaDatos.LibroElecDao;
import com.formacion.ipartek.pojo.HojaLibro;
import com.formacion.ipartek.pojo.Usuario;

public class LogicaNegocio {

	public static boolean validarUsuario(Usuario usuario, ArrayList<Usuario> usuarios, HttpServletRequest request) {

		// TODO Auto-generated method stub
		// llamar dao
		// consultar por email
		// compara password
		for (int i = 0; i < usuarios.size(); i++) {
			if (usuarios.get(i).getUsuario().equalsIgnoreCase(usuario.getUsuario())
					&& usuarios.get(i).getPassword().equalsIgnoreCase(usuario.getPassword())) {
				request.getSession().setAttribute("usuario", usuarios.get(i));
				System.out.println("correcto login");
				return true;
			}
		}
		for (int i = 0; i < usuarios.size(); i++) {
			if (!usuarios.get(i).getUsuario().equalsIgnoreCase(usuario.getUsuario())) {
				usuario.setErrorEmail("usuario incorrecto");
			} else {
				usuario.setErrorEmail("");
				break;
			}
			if (!usuarios.get(i).getPassword().equalsIgnoreCase(usuario.getPassword())) {
				usuario.setErrorPassword("password inco");
			} else {
				usuario.setErrorPassword("");
				break;
			}
		}
		return false;
	}

	public static List<HojaLibro> getPorRangos(int i) {
		i = i * 1;
		ArrayList<HojaLibro> empaquetado = new ArrayList<HojaLibro>();
			for (int h = 0; h < 6; h++, i++) {
				empaquetado.add(LibroElecDao.getInstance().getById(i));
			}
		
		return empaquetado;
	}


	public static void buscaPal(String palabra,HttpServletRequest request){
		ArrayList<String> pagsCoincidencia=new ArrayList<String>();
		for(int i=0;i<LibroElecDao.getInstance().getAll().size();i++) {
			for(int h=0;h<LibroElecDao.getInstance().getAll().get(i).getTextoHoja().length();h++) {
				if(LibroElecDao.getInstance().getAll().get(i).getTextoHoja().contains(palabra)) {
					pagsCoincidencia.add("page="+i);
					break;
				}
			}
		}
		request.setAttribute("coincidencias", pagsCoincidencia);
	}
	public static void insertarHoja(HojaLibro art) {
		LibroElecDao.getInstance().insert(art);
	}
	public static HojaLibro obtenerPagina(int pagina) {
		return LibroElecDao.getInstance().getAll().get(pagina);
		
	}
	 public static void devolverTamanoLibro(HttpServletRequest request) {
		 request.setAttribute("tamanoLibro",  LibroElecDao.getInstance().getAll().size()-1);
	 }
	public static List<HojaLibro> obtenerHojas() {
		return LibroElecDao.getInstance().getAll();
	}
	

}
