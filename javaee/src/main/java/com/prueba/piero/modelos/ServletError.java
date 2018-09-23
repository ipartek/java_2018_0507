package com.prueba.piero.modelos;

import java.io.IOException;
import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class ServletError extends GenericServlet {
	private static final long serialVersionUID = 1L;
       
    public ServletError() {
        super();
        // TODO Auto-generated constructor stub
    }

	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		
		String codigoError = request.getParameter("codigoError");
		
		if(codigoError.equals("104")) {
			response.setContentType("text/html");
			
			response.getWriter().println("Se deben ingresar todos los campos");
		}else {
			request.getRequestDispatcher("./prueba.html").forward(request, response);
		}
	}

}
