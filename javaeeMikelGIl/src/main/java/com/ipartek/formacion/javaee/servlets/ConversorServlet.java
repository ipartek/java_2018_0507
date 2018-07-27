package com.ipartek.formacion.javaee.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.javaee.modelos.ConversorForm;
import com.ipartek.formacion.javaee.modelos.LoginFormException;

/**
 * Servlet implementation class Conversor
 */
public class ConversorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		// Recogida de datos
		String millas = request.getParameter("millas");
		String kms = request.getParameter("kms");
		String kmsaMillas = request.getParameter("kmsaMillas");
		String millasaKms = request.getParameter("millasaKms");
		String button = request.getParameter("button");

		// Empaquetado en modelo
		ConversorForm conversor = new ConversorForm();
		
		try {
			conversor.setKms(kms);
		}catch (LoginFormException e) {
		}
		
		try {
			conversor.setMillas(millas);
		}catch (LoginFormException e) {
		}
		
		
        if ("btnConvertirKmsAMillas".equals(button)) {
            Double resultado = ConversorForm.kmsaMillas(kms);
            conversor.setKmsAMillas(resultado.toString());
        }else if("btnConvertirMillasAKms".equals(button)) {
        	Double resultado = ConversorForm.millasAKms(millas);
        	conversor.setMillasAKms(resultado.toString());
        }
        
        request.setAttribute("conversor", conversor);
        request.getRequestDispatcher("conversormillas.jsp").forward(request, response);
	}
	
	

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

}
