package com.ipartek.formacion.mf0967_3_mikel_gil_arrondo.controladores;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.mf0967_3_mikel_gil_arrondo.accesodatos.PerroMySqlDAO;
import com.ipartek.formacion.mf0967_3_mikel_gil_arrondo.logica.LogicaNegocio;
import com.ipartek.formacion.mf0967_3_mikel_gil_arrondo.modelos.Chip;
import com.ipartek.formacion.mf0967_3_mikel_gil_arrondo.modelos.Perro;


/**
 * Servlet implementation class AdministrarvideosServlet
 */
@WebServlet("/perros")
public class AdministrarPerrosServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String accion = request.getParameter("accion");
		String id = request.getParameter("id");
		
		if (accion == null) {
			throw new ControladorException("No se admite una peticion que no tenga accion");
		}
		
		PerroMySqlDAO dao = PerroMySqlDAO.getInstance();
		
		Long idL;
		Perro perro = null;
		
		switch (accion) {
			case "insertar":
				break;
			case "editar":
			case "borrar":
				idL = conversorLong(id);
				perro = dao.getById(idL);
				request.setAttribute("perro", perro);
				break;
			default:
				throw new ControladorException("No se admite una peticion que no sea insertar, editar o borrar");
		}
		
		request.setAttribute("perro", perro);
		request.setAttribute("accion", accion);
		request.getRequestDispatcher("/WEB-INF/admin/operacionesPerro.jsp").forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// PROCESAR LA OPCION SELECCIONADA
		String accion = request.getParameter("accion");
		String id = request.getParameter("id");
		
		if (accion == null) {
			throw new ControladorException("No se admite una peticion que no tenga accion");
		}
		
		PerroMySqlDAO dao = PerroMySqlDAO.getInstance();
		
		String nombre = request.getParameter("nombre");
		String edad = request.getParameter("edad");
		String raza = request.getParameter("raza");
		String peso = request.getParameter("peso");
		String apadrinado = request.getParameter("apadrinado");
		String chip = request.getParameter("chip");
		String latitud = request.getParameter("latitud");
		String longitud = request.getParameter("longitud");
		
		Long idL;
		int edadI;
		int pesoI;
		int apadrinadoI;

		Perro perro;
		String mensaje = "";
		
		switch (accion) {
			case "insertar":
				edadI = conversorInt(edad);
				pesoI = conversorInt(peso);
				apadrinadoI = conversorInt(apadrinado);
				perro = new Perro(nombre, edadI, raza, pesoI, apadrinadoI, new Chip(chip, latitud, longitud));
				if (LogicaNegocio.validarPerro(perro)) {
					dao.insert(perro);
					mensaje = "Inserción correcta del perro " + perro.getNombre();
				}else {
					mensaje = "ERROR al insertar el perro, hay que rellenar todos los campos.";
				}
				break;
				
			case "editar":
				idL = conversorLong(id);
				edadI = conversorInt(edad);
				pesoI = conversorInt(peso);
				apadrinadoI = conversorInt(apadrinado);
				perro = new Perro(idL,nombre, edadI, raza, pesoI, apadrinadoI, new Chip(chip, latitud, longitud));
				if (LogicaNegocio.validarPerro(perro)) {
					dao.update(perro);
					mensaje = "Actualización correcta del perro " + perro.getNombre();
				}else {
					mensaje = "ERROR al modificar el perro, hay que rellenar todos los campos.";
				}
				break;
				
			case "borrar":
				idL = conversorLong(id);
				dao.delete(idL);
				mensaje = "Borrado correcto del perro con id " + idL;
				break;
				
			default:
				throw new ControladorException("No se admite una peticion que no sea insertar, editar o borrar");
		}
		
		request.setAttribute("mensaje", mensaje);
		request.getRequestDispatcher("index").forward(request, response);
	}
	
	private int conversorInt(String num) {
		int numInt;
		
		if (num == null) {
			throw new ControladorException("Necesito un numero");
		}
		
		try {
			numInt = Integer.parseInt(num);
		} catch (NumberFormatException e) {
			throw new ControladorException("El numero no era numérico", e);
		}
		return numInt;
	}
	private long conversorLong(String num) {
		long numLong;
		
		if (num == null) {
			throw new ControladorException("Necesito un numero");
		}
		
		try {
			numLong = Integer.parseInt(num);
		} catch (NumberFormatException e) {
			throw new ControladorException("El numero no era numérico", e);
		}
		return numLong;
	}

}
