package com.ipartek.txarkur.controladores;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.txakur.pojo.Perro;
import com.ipartek.txarkur.LogicaNegocio.LogicaNegocio;

/**
 * Servlet implementation class BusquedaServlet
 */
@WebServlet("/buscar")
public class BusquedaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BusquedaServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String busqueda=request.getParameter("buscar");
		ArrayList<Perro> perroCoin;
		perroCoin=LogicaNegocio.perrosPorId(busqueda);
		request.setAttribute("perrosCoin", perroCoin);
		request.getRequestDispatcher("mostrarCoin.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
