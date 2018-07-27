package com.ipartek.formacion.javaee.servlets;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.javaee.modelos.LoginForm;

/**
 * Servlet implementation class ActualizarServlet
 */
public class ActualizarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ActualizarServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			String ruta = "C:\\Users\\curso\\Desktop\\archivo.txt";
			BufferedReader br = getBuffered(ruta);
			String linea = br.readLine();
				String[] values = linea.split(",");
				LoginForm objd = new LoginForm();
				while (linea!= null) {
					objd.setNombre(values[0].toString());
					objd.setPassword(values[1].toString());
					LoginForm.getLista().add(objd);
					linea = br.readLine();
				}
				response.sendRedirect("index.jsp");
				
			

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	public BufferedReader getBuffered(String link) {

		FileReader lector = null;
		BufferedReader br = null;
		try {
			File Arch = new File(link);
			if (!Arch.exists()) {
				System.out.println("No existe el archivo");
			} else {
				lector = new FileReader(link);
				br = new BufferedReader(lector);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return br;
	}
}
