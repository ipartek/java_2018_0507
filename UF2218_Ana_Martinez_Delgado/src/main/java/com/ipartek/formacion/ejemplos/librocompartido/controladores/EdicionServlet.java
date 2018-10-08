package com.ipartek.formacion.ejemplos.librocompartido.controladores;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.ejemplos.librocompartido.logica.LogicaNegocio;
import com.ipartek.formacion.ejemplos.librocompartido.pojos.ConnectLibrosBD;
import com.ipartek.formacion.ejemplos.librocompartido.pojos.Pagina;
import com.ipartek.formacion.ejemplos.librocompartido.pojos.Usuario;

@WebServlet("/edicion")
public class EdicionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doPost(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String destino="";
		String paginarecib = request.getParameter("numPagina");
		if(paginarecib==null) {
			String contenido=request.getParameter("textarea");
			System.out.println("request.getParameter(textarea);"+request.getParameter("textarea"));
			
			//pagina.getAutor(),pagina.getNumero(),pagina.getContenido()
			Pagina pag=new Pagina();
			pag.setAutor("temporal");
			pag.setContenido(contenido);
			pag.setNumero(LogicaNegocio.numPaginaMayorenBD());
			try {
				System.out.println("YO");
				LogicaNegocio.agregarPagina(pag);
				ConnectLibrosBD.anadirPaginaaBD("TEMPORAL", LogicaNegocio.numPaginaMayorenBD(), contenido);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			destino="index.jsp";
		}else {
			
			System.out.println("NumeroPagina Recibido:"+paginarecib);
			String contenido=LogicaNegocio.obtenerPaginaBD(Integer.parseInt(paginarecib));
			System.out.println("Contenido en el servlet:"+contenido);
			
			request.setAttribute("numero", paginarecib);
			request.setAttribute("pagina", contenido);
			destino="WEB-INF/verPagina.jsp";
		}
		//String autor = ((Usuario)request.getSession().getAttribute("usuario")).getNick();
		request.getRequestDispatcher(destino).forward(request, response);
		
	}

}
