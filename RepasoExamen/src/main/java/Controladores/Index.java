package Controladores;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import AccesoDatos.TreeMapDAO;
import modelos.Usuario;


@WebServlet("/index")
public class Index extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<Usuario> usuarios = TreeMapDAO.getInstance().getAll();
		
		request.setAttribute("listado", usuarios);
		request.getRequestDispatcher("index.jsp").forward(request, response);
					
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
