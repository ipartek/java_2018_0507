package com.borja.libreria.controladores;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class PaginacionServlet
 */
@WebServlet("/PaginacionServlet")
public class PaginacionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PaginacionServlet() {
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
		// TODO Auto-generated method stub
		String numero=request.getParameter("numero");

		if(numero!=null) {
		
			request.getSession().setAttribute("paginaF", numero);
	response.sendRedirect("principal?paginaF="+numero);

		}
		else {
			response.sendRedirect("principal?paginaF"+"-1");

			
		}
		
//		System.out.println(numero);
//		if(numero==null) {
//			numero="0";
//			System.out.println(numero);
//		}
//			
//		if(request.getParameter("siguiente").equalsIgnoreCase("next"))
//		{			request.getSession().setAttribute("paginaF", numero+1);
//		response.sendRedirect("principal?paginaF="+numero);
//System.out.println("entra");
//
//		}
//	int pagina;
//		String paginaQ=request.getParameter("pagina");
//		pagina =Integer.parseInt(paginaQ);
//		System.out.println(pagina);
////		if(request.getParameter("siguiente").equalsIgnoreCase("next")) {
////			pagina++;
////		}
//		request.getSession().setAttribute("paginaQ", pagina);
//		
//		System.out.println();
//		response.sendRedirect("principal?paginaQ="+pagina);
//		
//		
//		
//		doGet(request, response);
	}

}
