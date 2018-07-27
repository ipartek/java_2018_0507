package com.ipartek.formacion.javaee.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Conversor
 */
public class Conversor extends HttpServlet {
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

        if ("btnConvertirKmsAMillas".equals(button)) {
            Double resultado = Conversor.kmsaMillas(kms);
            request.setAttribute(kmsaMillas, resultado);
        }else if("btnConvertirMillasAKms".equals(button)) {
        	Double resultado = Conversor.millasAKms(millas);
        	request.setAttribute(millasaKms, resultado);
        }
        
        request.getRequestDispatcher("conversormillas.jsp").forward(request, response);
		
	}
	
	private static double kmsaMillas(String kms) {
		// 1KM = 0.62 Millas
		return Double.parseDouble(kms) * 0.62;
	}
	
	private static double millasAKms(String millas) {
		// 1 Milla = 1.61 KM
		return Double.parseDouble(millas) * 1.61;
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

}
