package com.ipartek.formacion.javaee.libro.controladores;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.javaee.libro.logica.LogicaNegocio;
import com.ipartek.formacion.javaee.libro.pojo.Pagina;


// /editarlibro

@WebServlet("/edicion")
public class EdicionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("edicion.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String autor = request.getParameter("autor");
		String contenido = request.getParameter("texto");
		
		int numero = LogicaNegocio.obtenerNumeroPaginas() + 1;
		//String autor = ((Usuario)request.getSession().getAttribute("usuario")).getNombre();
		
		Pagina pagina = new Pagina(numero, autor, contenido);
		
		boolean correcto = LogicaNegocio.agregarPagina(pagina);
		
		if(correcto) {
			response.sendRedirect("index?pagina=" + numero);
		} else {
			request.setAttribute("texto", contenido);
			request.setAttribute("error", "Se deben rellenar 25 palabras mínimo");
			request.getRequestDispatcher("edicion.jsp").forward(request, response);
		}
	}

}