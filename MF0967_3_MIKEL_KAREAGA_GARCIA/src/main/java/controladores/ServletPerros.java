package controladores;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controladores.ControladorException;

import accesoDatos.CrudAble;
import accesoDatos.PerroTreeMapDAO;
import modelo.Perro;

/**
 * Servlet implementation class ServletPerros
 */
@WebServlet("/admin/perros")
public class ServletPerros extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	String accion = request.getParameter("accion");
	String id = request.getParameter("id");
	
	if (accion == null) {
		throw new ControladorException("Error accion");
	}
	
	CrudAble<Perro> dao = PerroTreeMapDAO.getInstance();
		long longId;
		
		Perro perro;
		
		switch(accion) {
		case "insert":
			break;
		case "update":
		case "delete":
			longId = extraerId(id);
			perro = dao.getById(longId);
			request.setAttribute("perro", perro);
			break;
			default:
				throw new ControladorException("Solo se admiten insert, update y delete");
		}
		
		request.setAttribute("accion", accion);
		request.getRequestDispatcher("/WEB-INF/admin/perro.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String accion = request.getParameter("accion");
		String id = request.getParameter("id");
		
		if (accion == null) {
			throw new ControladorException("Error accion");
		}
		
		CrudAble<Perro> dao = PerroTreeMapDAO.getInstance();
		
		long longId;
		String nombre = request.getParameter("nombre");
		int edad = Integer.parseInt(request.getParameter("edad"));
		String raza = request.getParameter("raza");
		double peso = Double.parseDouble(request.getParameter("peso"));
		boolean apadrinado = Boolean.parseBoolean(request.getParameter("apadrinado"));
		String identificacion = request.getParameter("identificacion");
		String altitud = request.getParameter("altitud");
		String latitud = request.getParameter("latitud");
		
		Perro perro;
		String mensaje = "";
		
		switch(accion) {
		case "insert":
			longId = extraerId(id);
			perro = new Perro(longId,nombre, edad, raza, peso, apadrinado, identificacion, altitud, latitud);
		dao.insert(perro);
		mensaje="Se ha insertado correctamente" + perro.getNombre();
		break;
		case "update":
			longId = extraerId(id);
			perro = new Perro(longId,nombre, edad, raza, peso, apadrinado, identificacion, altitud, latitud);
		dao.update(perro);
		mensaje="Se ha actualizado con exito" + perro.getNombre();
		break;
		
		case "delete":
			longId = extraerId(id);
		dao.delete(longId);
		mensaje="Borrado con exito" + longId;
		
		perro = dao.getById(longId);
		request.setAttribute("perro", perro);
		break;
		
		default:
			throw new ControladorException("Solo se admiten insert, update y delete");
		}
		
		request.setAttribute("mensaje", mensaje);
		request.getRequestDispatcher("/admin/index").forward(request, response);
	}
	
	private long extraerId(String id) {
		long longId;
		
		if(id == null) {
			throw new ControladorException("Id obligatorio");
		}
		
		try {
			longId = Long.parseLong(id);
		} catch (NumberFormatException e) {
			throw new ControladorException("El id debe tener un valor numerico", e);
		}
		return longId;
	}

}
