package com.ipartek.ebook.controlador;

import com.ipartek.ebook.logica.LogicaNegocio;
import com.ipartek.ebook.pojo.Pagina;
import sun.rmi.runtime.Log;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class PrincipalServlet
 */
@WebServlet("/principal")
public class PrincipalServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public PrincipalServlet() {
        super();
        // TODO Auto-generated constructor stub
        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		String sPagina =  request.getParameter("pagina");
		int pagina;
		int numMaxPagina=LogicaNegocio.ultimaPagina().getId();
		if(sPagina==null || sPagina.trim().length()==0){
			pagina=1;
		}else{
			pagina=Integer.parseInt(sPagina);
			if(pagina<1 ){
				pagina=1;
			}
			if(pagina>numMaxPagina){
				pagina=numMaxPagina;
			}
		}
		Pagina paginaObj= LogicaNegocio.obtenerPaginaPorId(pagina);

		request.setAttribute("paginaMostrada", paginaObj);
		request.setAttribute("ultimaPagina",numMaxPagina);
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String texto = request.getParameter("texto");
		if(texto==null ) {
			doGet(request, response);
		}else{
			Pagina pagina =LogicaNegocio.buscarPalabraEnPagina(texto);
			int numMaxPagina=LogicaNegocio.ultimaPagina().getId();
			if(pagina==null){
				String error ="No se ha encontrado el texto";
				request.setAttribute("error", error);
				pagina=LogicaNegocio.obtenerPaginaPorId(1);
			}
			request.setAttribute("paginaMostrada", pagina);
			request.setAttribute("ultimaPagina",numMaxPagina);
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
	}

}
