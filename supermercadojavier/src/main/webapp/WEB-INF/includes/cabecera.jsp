<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<fmt:setLocale value="es_ES"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<title>Supermercado Pablo</title>

<style>
	.error {
		color: red;
		font-weight: bold;
	}
</style>

</head>
<body>
	 <div class="contenedor">
        <header>
            <div class="logo">
                <img src="img/logo-supermercado.jpg" alt="Logo">
                <h1><a href="index.html">Supermar-Tek</a></h1>
            </div>

            <nav class="nav-main">
                <a href="principal">Principal</a>
                <a href="carrito">Carrito</a>
                <a href="Administracion">Modificar</a>
                <a href="productos.html">Listar</a>
                <a href="login.html">Iniciar sesión</a>
            </nav>
            <a href="#" class="btn-open" onclick="openMenu()">&#9776;</a>

            <div id="menu-mobile" class="content-menu-mobile">
                <div  class="overlay">
                    <div class="overlay-content">
                        <a href="#" class="btn-close" onclick="closeMenu()">&times;</a>
                        <nav class="nav-main-mobile">
                            <a href="index.html">Inicio</a>
                            <a href="registro.html">Añadir Productos</a>
                            <a href="modificar.html">Modificar Productos</a>
                            <a href="productos.html">Listar Productos</a>
                            <a href="login.html">Iniciar sesión</a>
                        </nav>
                    </div>   
                </div>
            </div>


            <script>
                var menu = document.getElementById('menu-mobile');

                function openMenu() {
					menu.style.display = 'block';					
                }

                function closeMenu() {
					menu.style.display = 'none';					
                }
            </script>
        </header>
    </div>

	<main>