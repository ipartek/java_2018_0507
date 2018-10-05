package com.ipartek.formacion.examen.controladores;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.examen.logica.LogicaLibro;
import com.ipartek.formacion.examen.pojo.Pagina;
import com.ipartek.formacion.examen.pojo.Usuario;


@WebServlet("/escritura")
public class EscribirServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("edicion.jsp").forward(request, response);
		

	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		request.setCharacterEncoding("UTF-8");
		
		String contenido = request.getParameter("texto");
		
		int numero = LogicaLibro.obtenerNumeroPaginas() + 1;
		String autor = ((Usuario)request.getSession().getAttribute("usuario")).getNombre();
		
		Pagina pagina = new Pagina(numero, autor, contenido);
		
		boolean correcto = LogicaLibro.agregarPagina(pagina);
		
		if(correcto) {
			response.sendRedirect("index?pagina=" + numero);
		} else {
			request.setAttribute("texto", contenido);
			request.setAttribute("error", "Se deben rellenar 25 palabras mínimo");
			request.getRequestDispatcher("edicion.jsp").forward(request, response);
		}
	}

}
