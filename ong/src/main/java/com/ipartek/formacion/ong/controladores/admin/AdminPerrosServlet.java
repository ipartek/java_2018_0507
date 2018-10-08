package com.ipartek.formacion.ong.controladores.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.ong.accesoadatos.CrudAble;
import com.ipartek.formacion.ong.accesoadatos.PerroTreeMapDAO;
import com.ipartek.formacion.ong.modelos.Perro;

@WebServlet("/admin/perros")
public class AdminPerrosServlet extends HttpServlet {

	private static final String ADMIN_USUARIO_JSP = "/WEB-INF/admin/perro.jsp";
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//MOSTRAR PANTALLA
		String accion = request.getParameter("accion");
		String id = request.getParameter("id");

		if (accion == null) {
			throw new ControladorException("No se admite una petición que no tenga accion");
		}

		CrudAble<Perro> dao = PerroTreeMapDAO.getInstance();
		
		long longId;
		
		Perro perro;
		
		switch (accion) {
		case "insert":
			break;
		case "update":
		case "delete":
			longId = extraerId(id);
			
			perro = dao.getById(longId);
			request.setAttribute("perro", perro);
			break;
		default:
			throw new ControladorException("No se admite una petición que no sea insert, update o delete");
		}

		request.setAttribute("accion", accion);
		request.getRequestDispatcher(ADMIN_USUARIO_JSP).forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//PROCESAR OPCION SELECCIONADA
		
		String accion = request.getParameter("accion");
		String id = request.getParameter("id");
		Long idPerro = Long.parseLong(request.getParameter("id"));
		
		long longId;
		String nombre = request.getParameter("nombre");
		String raza = request.getParameter("raza");
		
		//Perro perro = (Perro)request.getSession().getAttribute("perro");
		//int edad = perro.getEdad();
		//float peso = perro.getPeso();
		
		request.getParameter("edad");
		
		int edad = Integer.parseInt(request.getParameter("edad"));
		float peso = Float.parseFloat(request.getParameter("peso"));
		//boolean apadrina= Boolean.parseBoolean(request.getParameter("apadrinado")); 
		
		String apadrinado = request.getParameter("apadrinado");
		String numIdent = request.getParameter("numIdent");
		String latitud = request.getParameter("latitud");
		String longitud = request.getParameter("longitud");

		if (accion == null) {
			throw new ControladorException("No se admite una petición que no tenga accion");
		}

		CrudAble<Perro> dao = PerroTreeMapDAO.getInstance();
		
		Perro perro;
		
		String mensaje = "";
		
		switch (accion) {
		case "insert":
			perro = new Perro(idPerro, nombre, raza, edad, peso, apadrinado, numIdent, latitud, longitud);
			/*if(!perro.isCorrecto()) {
				request.setAttribute("perro", perro);
				request.setAttribute("accion", accion);
				request.getRequestDispatcher(ADMIN_USUARIO_JSP).forward(request, response);
				return;
			}*/
			dao.insert(perro);
			mensaje = "Inserción correcta del perro " + perro.getNombre();
			break;
		case "update":
			longId = extraerId(id);
			perro = new Perro(longId, nombre, raza, edad, peso, apadrinado, numIdent, latitud, longitud);
			/*if(!perro.isCorrecto()) {
				request.setAttribute("perro", perro);
				request.setAttribute("accion", accion);
				request.getRequestDispatcher(ADMIN_USUARIO_JSP).forward(request, response);
				return;
			}*/
			dao.update(perro);
			mensaje = "Actualización correcta del perro " + perro.getNombre();
			break;
		case "delete":
			longId = extraerId(id);
			dao.delete(longId);
			mensaje = "Borrado correcto del perro id " + longId;
			
			perro = dao.getById(longId);
			request.setAttribute("perro", perro);
			break;
		default:
			throw new ControladorException("No se admite una petición que no sea insert, update o delete");
		}

		request.setAttribute("mensaje", mensaje);
		request.getRequestDispatcher("/admin/indexPerros").forward(request, response);
	}

	private long extraerId(String id) {
		long longId;
		
		if(id == null) {
			throw new ControladorException("Necesito un id");
		}
		
		try {
			longId = Long.parseLong(id);
		} catch (NumberFormatException e) {
			throw new ControladorException("El id no era numérico", e);
		}
		return longId;
	}

}
