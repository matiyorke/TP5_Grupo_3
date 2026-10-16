<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<div id="Cajalogin">

<form action="ServletLogin" method="post">
	<h3>Iniciar sesión</h3>
	<label for="txtUsuario">Usuario</label><br>
	<input type="text" id="txtUsuario" name="txtUsuario"/><br><br>
	<label for="txtContrasenia">Contraseña</label><br>
	<input type="password" id="txtContrasenia" name="txtContrasenia"/><br><br>
	<input type="submit" name="btnIngresar" value="Ingresar"/>
</form>

</div>

</body>
</html>

