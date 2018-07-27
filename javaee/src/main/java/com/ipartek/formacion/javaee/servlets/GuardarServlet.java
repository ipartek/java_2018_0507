package com.ipartek.formacion.javaee.servlets;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.javaee.modelos.LoginForm;

/**
 * Servlet implementation class GuardarServlet
 */
public class GuardarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GuardarServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		FileWriter fw = null;
		try {
			fw = new FileWriter("C:\\Users\\curso\\Desktop\\archivo.txt");
			PrintWriter pw = new PrintWriter(fw);
			ArrayList<LoginForm> lista = LoginForm.getLista();
			for (int i = 0; i < lista.size(); i++) {
				
				pw.println(lista.get(i).getNombre()+","+lista.get(i).getPassword());
				
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (fw != null) {
					fw.close();
				}response.sendRedirect("index.jsp");
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
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

}
