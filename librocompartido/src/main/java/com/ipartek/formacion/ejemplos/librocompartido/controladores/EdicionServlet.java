package com.ipartek.formacion.ejemplos.librocompartido.controladores;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.ejemplos.librocompartido.logica.LogicaNegocio;
import com.ipartek.formacion.ejemplos.librocompartido.pojos.Pagina;
import com.ipartek.formacion.ejemplos.librocompartido.pojos.Usuario;

@WebServlet("/edicion")
public class EdicionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("edicion.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		int numero = LogicaNegocio.obtenerNumeroPaginas() + 1;
		String autor = ((Usuario)request.getSession().getAttribute("usuario")).getNick();
		String contenido = request.getParameter("texto");
		
		Pagina pagina = new Pagina(numero, autor, contenido);
		
		LogicaNegocio.agregarPagina(pagina);
		
		response.sendRedirect("index?pagina=" + numero);
	}

}
