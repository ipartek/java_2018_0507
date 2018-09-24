<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<%@ include file="WEB-INF/includes/cabecera.jsp" %>
	<div class="container">

		<div class="row" id="pwd-container">
			<div class="col-md-4"></div>

			<div class="col-md-4">
				<section class="login-form">
					<form method="post" action="login" role="login">

						<input type="email" name="mail" placeholder="Email@gmail.com"
							required class="form-control input-lg" /> 
							
						<input type="password" name="password"
							class="form-control input-lg" id="password"
							placeholder="Password" required="" />


						<div class="pwstrength_viewport_progress"></div>


						<button type="submit" name="login" value="login"
							class="btn btn-lg btn-primary btn-block" id="botonsub">Iniciar sesión</button>
							
							<div>
							
							
							</div>

					</form>

					<div class="form-links">
						<a href="#">www.website.com</a>
					</div>
				</section>
			</div>

			<div class="col-md-4"></div>


		</div>


	</div>

<%@ include file="WEB-INF/includes/pie.jsp" %>