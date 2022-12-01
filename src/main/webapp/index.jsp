<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Carrito Compras</title>
    </head>
    <body>
        <h1>Ejemplo Carrito Compras</h1>
        <h2>Productos</h2>
        <form action="/EjemploCarritoCompras-1.0-SNAPSHOT/CarritoServlet"
              method="post" name="form1">
            Articulo a agregar: <input type="text" name="articulo">
            <br/>
            <input type="submit" value="Enviar">
        </form>
    </body>
</html>