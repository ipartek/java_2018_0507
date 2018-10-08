package Controladores;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import AccesoDatos.TreeMapDAO;
import modelos.Usuario;

@WebServlet("/edicion")
public class Edicion extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String accion = request.getParameter("accion");
		String id = request.getParameter("id");

		if (accion == null) {
			throw new ControladorException("Tienes que mandar una accion");
		}

		long idTransformado;

		Usuario usuario;

		switch (accion) {
		case "insert":
			break;
		case "update":
		case "delete":
			// COMO EL ID VIENE EN STRING NECESITAMOS TRANSFORMARLO A NUMERICO A LA HORA DE
			// COGERLO DE LA LISTA
			// POR ESO NECESITAMOS ESTA FUNCION (FUNCION PRIVADA DEBAJO DEL CODIGO)
			idTransformado = CogerTransformarId(id);
			usuario = TreeMapDAO.getInstance().getById(idTransformado);
			request.setAttribute("usuario", usuario);

			break;
		}

		request.setAttribute("accion", accion);
		request.getRequestDispatcher("edicion.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String accion = request.getParameter("accion");
		String id = request.getParameter("id");
		
		if (accion == null) {
			throw new ControladorException("No se admite accion vacia");
		}
		
		long idTransformado;
		Usuario usu;
		
		switch (accion) {
		
		case "insert":
			usu = new Usuario(email,password);
			TreeMapDAO.getInstance().insert(usu);
			break;
		case "update":
			idTransformado=CogerTransformarId(id);
			usu = new Usuario (idTransformado,email,password);
			TreeMapDAO.getInstance().update(usu);
			break;
		case "delete":
			idTransformado=CogerTransformarId(id);
			TreeMapDAO.getInstance().delete(idTransformado);
			
			usu = TreeMapDAO.getInstance().getById(idTransformado);
			request.setAttribute("usuario", usu);
			break;
		}
		
		request.getRequestDispatcher("index").forward(request, response);
	}

	private long CogerTransformarId(String id) {
		long idTransformado;

		if (id == null) {
			throw new ControladorException("Id vacio");
		}

		idTransformado = Long.parseLong(id);

		return idTransformado;

	}
}
