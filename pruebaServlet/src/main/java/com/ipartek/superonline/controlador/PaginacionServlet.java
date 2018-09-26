package com.ipartek.superonline.controlador;

import com.ipartek.superonline.pojo.Producto;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Servlet implementation class CarritoServlet
 */
@WebServlet("/paginacion")
public class PaginacionServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public PaginacionServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //Se recoge la pagina de la jsp , es lo que nos indica que mostrar
        String pagina = request.getParameter("pagina");

        //Estos son datos de prueba, habria que cogerlos del dao
        ArrayList<Producto> productos = new ArrayList<>();
        Producto p = new Producto("Producto 1", 12, 1);
        Producto p1 = new Producto("Producto 2", 23, 2);
        Producto p2 = new Producto("Producto 3", 56, 3);
        Producto p3 = new Producto("Producto 4", 78, 4);
        Producto p4 = new Producto("Producto 5", 35, 5);
        Producto p5 = new Producto("Producto 6", 12, 6);
        Producto p6 = new Producto("Producto 7", 23, 7);
        Producto p7 = new Producto("Producto 8", 56, 8);
        Producto p8 = new Producto("Producto 9", 78, 9);
        Producto p9 = new Producto("Producto 10", 35, 10);
        productos.add(p);
        productos.add(p1);
        productos.add(p2);
        productos.add(p3);
        productos.add(p4);
        productos.add(p5);
        productos.add(p6);
        productos.add(p7);
        productos.add(p8);
        productos.add(p9);
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
        request.getRequestDispatcher("paginacion.jsp").forward(request, response);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet(request, response);
    }

}
