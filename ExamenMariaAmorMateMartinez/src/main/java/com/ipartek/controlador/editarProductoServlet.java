package com.ipartek.controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.logica.LogicaNegocio;
import com.ipartek.pojo.Chip;
import com.ipartek.pojo.Perro;
import com.ipartek.pojo.Usuario;

/**
 * Servlet implementation class editarProductoServlet
 */
@WebServlet("/editarprod")
public class editarProductoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public editarProductoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String nombre = request.getParameter("nombre");
		String raza = request.getParameter("raza");
		
		Long id = Long.parseLong(request.getParameter("id")); 
		int edad = Integer.parseInt(request.getParameter("edad"));
		int peso = Integer.parseInt(request.getParameter("peso"));
		double longitud = Double.parseDouble(request.getParameter("peso"));
		double latitud = Double.parseDouble(request.getParameter("peso"));
		
		String apadrinado = request.getParameter("apadrinado");
		boolean ap= false;
		
		if(apadrinado.equalsIgnoreCase("true")) {
			ap=true;
		}
		String identificador = request.getParameter("identificador");
		
		Perro prod = new Perro(nombre,  edad,  raza,  peso,  ap, new Chip(identificador,latitud ,longitud));
		
		LogicaNegocio logica = new LogicaNegocio();
		boolean resultado = logica.updateProd(prod);
		
			
			request.getRequestDispatcher("listadoprod").forward(request, response);
	
	}

}
