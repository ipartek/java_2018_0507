<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en" >

<head>
  <meta charset="UTF-8">
  <title>Mega Menu</title>
  
  <jsp:useBean id="cabecera" scope="request" class="com.ipartek.formacion.javaee.libros.modelos.Cabecera" />
  
      
      
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
      
    <link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.min.css">
    <link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap-theme.min.css">
    <script src="https://code.jquery.com/jquery-1.10.2.min.js"></script>
    <script src="//netdna.bootstrapcdn.com/bootstrap/3.0.2/js/bootstrap.min.js"></script>
   <link rel="stylesheet" href="css/style.css">
  </head>
  <body>
<div class="navbar navbar-default yamm">
          <div class="navbar-header">
            <button type="button" data-toggle="collapse" data-target="#navbar-collapse-grid" class="navbar-toggle"><span class="icon-bar"></span><span class="icon-bar"></span><span class="icon-bar"></span></button><a href="#" class="navbar-brand">Yamm Megamenu</a>
          </div>
          <div id="navbar-collapse-grid" class="navbar-collapse collapse">
            <ul class="nav navbar-nav">
              <!-- Grid 12 Menu -->
              <li class="dropdown yamm-fw"><a href="#" data-toggle="dropdown" class="dropdown-toggle">Modo Grid()<b class="caret"></b></a>
                <ul class="dropdown-menu">
                  <li class="grid-demo">
                    <div class="row">
                      <div class="col-sm-12">tamaño 12</div>
                    </div>
                    <div class="row">
                      <div class="col-sm-6">tamaño 6</div>
                      <div class="col-sm-6">tamaño 6</div>
                    </div>
                    <div class="row">
                      <div class="col-sm-4">tamaño 4</div>
                      <div class="col-sm-4">tamaño 4</div>
                      <div class="col-sm-4">tamaño 4</div>
                    </div>
                    <div class="row">
                      <div class="col-sm-3">tamaño 3</div>
                      <div class="col-sm-3">tamaño 3</div>
                      <div class="col-sm-3">tamaño 3</div>
                      <div class="col-sm-3">tamaño 3</div>
                    </div>
                    <div class="row">
                      <div class="col-sm-2">.col-sm-2</div>
                      <div class="col-sm-2">.col-sm-2</div>
                      <div class="col-sm-2">.col-sm-2</div>
                      <div class="col-sm-2">.col-sm-2</div>
                      <div class="col-sm-2">.col-sm-2</div>
                      <div class="col-sm-2">.col-sm-2</div>
                    </div>
                    <div class="row">
                      <div class="col-sm-1">12 columnas de 1</div>
                      <div class="col-sm-1">.col-sm-1</div>
                      <div class="col-sm-1">.col-sm-1</div>
                      <div class="col-sm-1">.col-sm-1</div>
                      <div class="col-sm-1">.col-sm-1</div>
                      <div class="col-sm-1">.col-sm-1</div>
                      <div class="col-sm-1">.col-sm-1</div>
                      <div class="col-sm-1">.col-sm-1</div>
                      <div class="col-sm-1">.col-sm-1</div>
                      <div class="col-sm-1">.col-sm-1</div>
                      <div class="col-sm-1">.col-sm-1</div>
                      <div class="col-sm-1">.col-sm-1</div>
                    </div>
                  </li>
                </ul>
              </li>
              <!--
              <With>Offsets </With>
              -->
              <li class="dropdown yamm-fw"><a href="#" data-toggle="dropdown" class="dropdown-toggle">Offset(Separacion)<b class="caret"></b></a>
                <ul class="dropdown-menu">
                  <li class="grid-demo">
                    <div class="row">
                      <div class="col-sm-4">4</div>
                      <div class="col-sm-4 col-sm-offset-4">4 offset 4</div>
                    </div>
                    <div class="row">
                      <div class="col-sm-3 col-sm-offset-3">3 offset 3</div>
                      <div class="col-sm-3 col-sm-offset-3">3 offset 3</div>
                    </div>
                    <div class="row">
                      <div class="col-sm-6 col-sm-offset-3">6 offset 6</div>
                    </div>
                  </li>
                </ul>
              </li>
              <!--
              <Aside>Menu </Aside>
              -->
              <li class="dropdown yamm-fw"><a href="#" data-toggle="dropdown" class="dropdown-toggle">Aside<b class="caret"></b></a>
                <ul class="dropdown-menu">
                  <li class="grid-demo">
                    <div class="row">
                      <div class="col-sm-3"><br>
                        <h3>3</h3><br>
                      </div>
                      <div class="col-sm-9"><br>
                        <h3>9</h3><br>
                      </div>
                    </div>
                  </li>
                </ul>
              </li>
              <!--
              <Nesting>Menu </Nesting>
              -->
              <li class="dropdown yamm-fw"><a href="#" data-toggle="dropdown" class="dropdown-toggle">Nesting<b class="caret"></b></a>
                <ul class="dropdown-menu">
                  <li class="grid-demo">
                    <div class="row">
                      <div class="col-sm-12">12</div>
                    </div>
                    <div class="row">
                      <div class="col-sm-12">12
                        <div class="row">
                          <div class="col-sm-4">4</div>
                          <div class="col-sm-4">4</div>
                          <div class="col-sm-4">4</div>
                        </div>
                      </div>
                    </div>
                  </li>
                </ul>
              </li>
            </ul>
          </div>
        </div>
        <div style="padding-left: 20px;">(Subtitulo)Diferentes modos de organizacion con Bootstrap</div>

  <script src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>
	
	<section id="principal" class="col-md-8">