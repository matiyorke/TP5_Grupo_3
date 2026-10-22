<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Alta de clientes</title>
<style type="text/css">
	<jsp:include page="/css/StyleSheet.css"></jsp:include>
</style>
</head>
<body>

<div class="layout">

	<nav class="sidebar">
		<h2>Menú</h2>
		<a href="ServletClientes" class="active">Alta de Cliente</a>
		<a href="ServletListadoClientes">Listado de Clientes</a>
	</nav>

	<main class="contenido">

		<h1>Formulario de Cliente</h1>
		<p class="usuario">Usuario: <%= session.getAttribute("usuarioLogueado") %></p>

		<% if(request.getAttribute("mensaje")!=null) { %>
			<h4 class="mensajeError"><%=request.getAttribute("mensaje") %></h4>
		<% } %>

		<form action="ServletClientes" method="post" class="formulario">

			<div class="campo">
				<label for="txtDni">DNI *</label>
				<input type="text" id="txtDni" name="txtDni">
				<small>Solo números. 6 a 8 dígitos (ej: 12345678).</small>
			</div>

			<div class="campo">
				<label for="txtCuil">CUIL *</label>
				<input type="text" id="txtCuil" name="txtCuil">
				<small>Formato: 11 dígitos (ej: 20333444555).</small>
			</div>

			<div class="campo">
				<label for="txtNombre">Nombre *</label>
				<input type="text" id="txtNombre" name="txtNombre">
			</div>

			<div class="campo">
				<label for="txtApellido">Apellido *</label>
				<input type="text" id="txtApellido" name="txtApellido">
			</div>

			<div class="campo">
				<label for="ddlSexo">Sexo *</label>
				<select id="ddlSexo" name="ddlSexo">
					<option value="">-- Seleccione --</option>
					<option value="M">M</option>
					<option value="F">F</option>
					<option value="Otro">Otro</option>
				</select>
			</div>

			<div class="campo">
				<label for="txtNacionalidad">Nacionalidad</label>
				<input type="text" id="txtNacionalidad" name="txtNacionalidad">
			</div>

			<div class="campo">
				<label for="txtFechaNacimiento">Fecha de nacimiento *</label>
				<input type="date" id="txtFechaNacimiento" name="txtFechaNacimiento"
					max="<%= new java.sql.Date(System.currentTimeMillis()) %>">
			</div>

			<div class="campo">
				<label for="txtDireccion">Dirección</label>
				<input type="text" id="txtDireccion" name="txtDireccion">
			</div>

			<div class="campo">
				<label for="txtLocalidad">Localidad</label>
				<input type="text" id="txtLocalidad" name="txtLocalidad">
			</div>

			<div class="campo">
				<label for="txtProvincia">Provincia</label>
				<input type="text" id="txtProvincia" name="txtProvincia">
			</div>

			<div class="campo">
				<label for="txtCorreo">Correo electrónico *</label>
				<input type="email" id="txtCorreo" name="txtCorreo">
				<small>Ej: nombre@dominio.com</small>
			</div>

			<div class="campo">
				<label for="txtTelefono">Teléfono</label>
				<input type="text" id="txtTelefono" name="txtTelefono">
			</div>

			<div class="acciones">
				<button type="submit" name="btnGuardar" value="Guardar">Guardar cliente</button>
			</div>

		</form>

	</main>
</div>

</body>
</html>

