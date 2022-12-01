package ar.com.julio.ejemplocarritocompras.web;

import java.io.*;
import java.util.List;

import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "CarritoServlet", value = "/CarritoServlet")
public class CarritoServlet extends HttpServlet {

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=UTF-8");

        // procesamos el articulo que nos envia el formulario (parametro articulo)
        String articuloNuevo = request.getParameter("articulo");

        // recuperamos el objeto http session
        HttpSession session = request.getSession();

        // recuperamos la lista de articulos del carrito (si es que existe)
        List<String> articulos = (List<String>) session.getAttribute("articulos");

        // verificamos si la lista de articulos existe
        if (articulos == null) {
            // si no existe la creamos
            articulos = new java.util.ArrayList<String>();
            // y la agregamos a la session
            session.setAttribute("articulos", articulos);
        }
        // revisamos y agregamos el nuevo articulo a la lista
        if (articuloNuevo != null && !articuloNuevo.trim().equals("")) {
            articulos.add(articuloNuevo);
        }
        // imprimimos la lista de articulos
        PrintWriter out = response.getWriter();
        out.println("<h1>Listado de Articulos</h1>");
        out.println("<br>");
        for (String articulo : articulos) {
            out.println("<li>" + articulo + "</li>");
        }
        out.println("<br>");
        // agregamos un enlace para volver al formulario
        out.println("<a href='/EjemploCarritoCompras-1.0-SNAPSHOT'>Regresar al inicio</a>");
        out.close();
    }
}