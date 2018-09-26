package com.ipartek.formacion.javaee.libroelectronico.controladores;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.javaee.libroelectronico.accesodatos.LibroMapDAO;
import com.ipartek.formacion.javaee.libroelectronico.pojo.Libro;

/**
 * Servlet implementation class PaginacionServlet
 */
@WebServlet("/index")
public class PaginacionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String spageid = request.getParameter("page");
		int pageid = Integer.parseInt(spageid);
		
		if (pageid < 1) {
			response.sendRedirect(request.getContextPath() + "/index.jsp");
		}else {
			
			Libro libro;
			try {
				libro = LibroMapDAO.getInstance().getById(pageid);
				
				int paginasTotales = (int) libro.getTotalid();
				
				if(pageid > paginasTotales) {
					response.sendRedirect(request.getContextPath() + "/index.jsp");
				}else {
					request.setAttribute("libro", libro);
					request.getRequestDispatcher("/index.jsp").forward(request, response);
				}
			} catch (Exception e) {
				response.sendRedirect(request.getContextPath() + "/index.jsp");
				//e.printStackTrace();
			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
