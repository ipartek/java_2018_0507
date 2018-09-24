package com.prueba.piero.modelos;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class ServletLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ServletLogin() {
        super();
        // TODO Auto-generated constructor stub
    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doPost(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Establece el tipo de contenido a mostrar
		response.setContentType("text/html");
		
		//Recuperación de los valores
		String txtNomUsu = request.getParameter("usuario");
		String txtpasswd = request.getParameter("password");
		
		if(!txtNomUsu.equals("") && !txtpasswd.equals("")) {
			
		
		//Recuperar escritor
		PrintWriter out = response.getWriter();
		
		//Generar el contenido html
		out.println("<html><head><title>Prueba</title></head><body>");
		out.println("<h1> Prueba Piero = " + txtNomUsu + " " + txtpasswd + "</h1></body></html>");
		
		//Cerrar el escritor
		out.close();
		}else {
			response.sendRedirect("ServletError?codigoError=104");
		}
	}

}
