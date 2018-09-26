package com.formacion.ipartek.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.formacion.ipartek.logica.LogicaNegocio;

/**
 * Servlet implementation class BuscarPalabra
 */
@WebServlet("/buscarPalabra")
public class BuscarPalabraServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BuscarPalabraServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String palabra="";		
		if(request.getParameter("palabra")!=null) {
			palabra=request.getParameter("palabra");
			LogicaNegocio.buscaPal(palabra, request);
			request.getRequestDispatcher("edicion.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String palabra="";		
		if(request.getParameter("palabra")!=null) {
			LogicaNegocio.buscaPal(palabra, request);
			request.getRequestDispatcher("coincidencias.jsp").forward(request, response);
		}
	}

}
