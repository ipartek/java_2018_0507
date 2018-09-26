package com.ipartek.formacion.javaee.libro.controladores;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.javaee.libro.logica.LogicaNegocio;
import com.ipartek.formacion.javaee.libro.pojo.Pagina;

@WebServlet("/escribirpagina")
public class EscribirPaginaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		response.sendRedirect(request.getContextPath() + "/escribirpagina.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String id = request.getParameter("id");
		String texto = request.getParameter("texto");
		String autor = request.getParameter("autor");
		
		if (texto.length() < 25 || texto == null || autor == null) {
			throw new RuntimeException("Faltan datos por rellenar");
		}else {
			try {
				Pagina pagina = new Pagina(Long.parseLong(id),texto,autor);
				LogicaNegocio.agregarPagina(pagina);
			} catch (Exception e) {
				request.setAttribute("error", e.getMessage());
				return;
			}
			
			request.setAttribute("mensaje", "Operacion correcta");
			request.getRequestDispatcher("/principal").forward(request, response);
			
		}
		
		
	}

}
