package com.ipartek.pabloDAO.paginaExamen.controladores;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.pabloDAO.paginaExamen.accesodatos.CrudAble;
import com.ipartek.pabloDAO.paginaExamen.accesodatos.PerroMapDAO;
import com.ipartek.pabloDAO.paginaExamen.modelos.Perro;

@WebServlet("/admin/perro")
public class PerroAdminServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//MOSTRAR PANTALLA
		String accion = request.getParameter("accion");
		String id = request.getParameter("id");

//		if (accion == null) {
//			throw new ControladorException("No se admite una peticion que no tenga accion");
//		}

		CrudAble<Perro> dao = PerroMapDAO.getInstance();
		//UsuarioTreeMapDAO dao = UsuarioTreeMapDAO.getInstance();
		
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
			throw new RuntimeException("No se admite el tipo de peticion enviada");
		}

		request.setAttribute("accion", accion);
		request.getRequestDispatcher("/WEB-INF/admin/perro.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//PROCESAR OPCION SELECCIONADA
		String accion = request.getParameter("accion");
		String id = request.getParameter("id");

//		if (accion == null) {
//			throw new ControladorException("No se admite una peticion que no tenga accion");
//		}

		CrudAble<Perro> dao = PerroMapDAO.getInstance();
		//UsuarioTreeMapDAO dao = UsuarioTreeMapDAO.getInstance();
		
		long longId;
		String nombre = request.getParameter("nombre");
		int edad = Integer.parseInt(request.getParameter("edad"));
		String raza = request.getParameter("raza");
		int peso = Integer.parseInt(request.getParameter("peso"));
		boolean apadrinado = Boolean.parseBoolean(request.getParameter("apadrinado"));
		String chip = request.getParameter("chip");
		
		Perro perro;
		String mensaje = "";
		
		switch (accion) {
		case "insert":
			perro = new Perro(nombre, edad, raza, peso, apadrinado, chip);
			dao.insert(perro);
			mensaje = "Insercion correcta del perro " + perro.getNombre();
			break;
		case "update":
			longId = extraerId(id);
			perro = new Perro(longId, nombre, edad, raza, peso, apadrinado, chip);
			dao.update(perro);
			mensaje = "Actualizacion correcta del perro " + perro.getNombre();
			break;
		case "delete":
			longId = extraerId(id);
			dao.delete(longId);
			mensaje = "Borrado correcto del perro " + longId;
			perro = dao.getById(longId);
			request.setAttribute("perro", perro);
			break;
		default:
			throw new RuntimeException("No se admite el tipo de peticion enviada");
		}

		request.setAttribute("mensaje", mensaje);
		request.getRequestDispatcher("/admin/index").forward(request, response);
	}

	private long extraerId(String id) {
		long longId;
		
		if(id == null) {
			throw new RuntimeException("No se ha pasado el id");
		}
		
		try {
			longId = Long.parseLong(id);
		} catch (NumberFormatException e) {
			throw new RuntimeException("El id no era numerico", e);
		}
		return longId;
	}

}
