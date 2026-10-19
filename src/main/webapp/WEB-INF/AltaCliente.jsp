<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Alta de clientes</title>
</head>
<body>

<p>Usuario logueado: <b><%= session.getAttribute("usuarioLogueado") %></b></p>

<p>
	<a href="ServletClientes">Alta de clientes</a>
	<a href="ServletClientes?listar=1">Listado de clientes</a>
</p>

<h2>Alta de clientes</h2>

<% if(request.getAttribute("mensaje")!=null) { %>
	<h4 style="color:red"><%=request.getAttribute("mensaje") %></h4>
<% } %>

<form action="ServletClientes" method="post">

	<p>DNI: <input type="text" name="txtDni"></p>
	<p>CUIL: <input type="text" name="txtCuil"></p>
	<p>Nombre: <input type="text" name="txtNombre"></p>
	<p>Apellido: <input type="text" name="txtApellido"></p>

	<p>Sexo:
		<select name="ddlSexo">
			<option value="">Seleccione</option>
			<option value="M">M</option>
			<option value="F">F</option>
			<option value="Otro">Otro</option>
		</select>
	</p>

	<p>Fecha de nacimiento:
		<input type="date" name="txtFechaNacimiento" max="<%= new java.sql.Date(System.currentTimeMillis()) %>">
	</p>

	<p>Dirección: <input type="text" name="txtDireccion"></p>
	<p>Nacionalidad: <input type="text" name="txtNacionalidad"></p>
	<p>Localidad: <input type="text" name="txtLocalidad"></p>
	<p>Provincia: <input type="text" name="txtProvincia"></p>
	<p>Correo electrónico: <input type="email" name="txtCorreo"></p>
	<p>Teléfono: <input type="text" name="txtTelefono"></p>

	<p><input type="submit" name="btnGuardar" value="Guardar"></p>
</form>

</body>
</html>