package com.ipartek.superonline.controlador;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.superonline.logica.LogicaNegocio;
import com.ipartek.superonline.pojo.Producto;

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
		//Recojo del dao todos los productos
		
		 String pagina = request.getParameter("pagina");
		List<Producto> productos = LogicaNegocio.obtenerProductos();
		
		 //Si es la primera vez que llegamos a esta pagina web , el valor de pagina sera nulo asique lo establezemos en 0
        if (pagina == null) {
            pagina = "0";
        }
        //Es el tamaño del array de datos
        int tam = productos.size();
        //Cuantos objetos mostraremos por pagina
        int cuantasPorPagina = 3;
        //Es el numero de pagina en el que estamos(Hago un parse porque cuando cogemos la pagina de la request es de tipo string)
        int numPagina = Integer.parseInt(pagina);
        //calculo el desde y el hasta para aplicarlo en el for(Esto siempre sera igual)
        int hasta = cuantasPorPagina * numPagina + cuantasPorPagina;
        int desde = cuantasPorPagina * numPagina;
        //Esto sera el numero total de paginas
        int total = tam / cuantasPorPagina;
        
        
      //Este es el array list que se mandar a a la jsp
        ArrayList<Producto> productoPaginado = new ArrayList<>();
        
        //Recorro el array inicial , mientras no me salga del array y que tampoco supere el hasta
        for (int i = desde; i < tam && i < hasta; i++) {
            productoPaginado.add(productos.get(i));
        }
        //mando a la jsp los productos para listar , la pagina en la que estamos y el total de paginas
        request.setAttribute("productos", productoPaginado);
        request.setAttribute("pagina", numPagina);
        request.setAttribute("total", total);
//redirigo
        request.getRequestDispatcher("index.jsp").forward(request, response);
        
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
