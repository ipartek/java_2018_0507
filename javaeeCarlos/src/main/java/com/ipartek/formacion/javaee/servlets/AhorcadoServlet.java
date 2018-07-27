package com.ipartek.formacion.javaee.servlets;

import java.io.IOException;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AhorcadoServlet
 */
public class AhorcadoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String palabra = request.getParameter("palabra");
		String letra = request.getParameter("letra");
		int aciertos = 0;
		letra = letra.toUpperCase();
		AhorcadoClass ahorcado= new AhorcadoClass(letra);
		
		String [] palabras = {"AUSTROLOPITHECUS", "PSICOHISTORIA", "RINOCERONTE", "PARAGÜAS", "HORMIGUERO", "PLANETOIDE",
				"DESINTEGRADOR","GATO","NANOTUBO","WOLFRAMIO"};
		int i = new Random().nextInt(palabras.length);
		String palabraA = palabras[i];
		char [] letras = palabraA.toCharArray();
		
		for (int l = 0; l<letras.length;l++) {
			if (String.valueOf(letras[l]).equals(letra)) {
				ahorcado.setPalabra(palabra);
				aciertos++;
			}
		}
		if (letra == null) {
			throw new RuntimeException("No se ha recibido la letra");
		}
		if (letra.equals("")) {
			ahorcado.setMensajeErrorLetra("No se ha introducido la letra");
		}else {
			ahorcado.setLetra(letra);
			ahorcado.setMensajeErrorLetra("");
			request.getRequestDispatcher("Ahorcado.jsp").forward(request, response);
		}
	}

}
