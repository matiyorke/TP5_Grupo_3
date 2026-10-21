<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style type="text/css">
	<jsp:include page="/css/StyleSheet.css"></jsp:include>
</style>
<title>Iniciar sesión</title>
</head>
<body>

<div id="Cajalogin">

<form action="ServletLogin" method="post">
	<h3>Iniciar sesión</h3>
	<label for="txtUsuario">Usuario</label><br>
	<input type="text" placeholder="Ingrese usuario" id="txtUsuario" required name="txtUsuario"/><br><br>
	<label for="txtContrasenia">Contraseña</label><br>
	<input type="password" placeholder="Ingrese contraseña" id="txtContrasenia" required name="txtContrasenia"/><br><br>
	<input type="submit" name="btnIngresar" value="Ingresar"/>

	<%
		String mensaje = (String) request.getAttribute("mensaje");
		if (mensaje != null) {
	%>
		<p class="mensajeError"><%= mensaje %></p>
	<%
		}
	%>
</form>

</div>

</body>
</html>