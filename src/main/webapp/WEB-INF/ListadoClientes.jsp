<%@page import="Dominio.Clientes"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>Listado de Clientes</title>

	<style type="text/css">
		<jsp:include page="/css/StyleSheet.css"></jsp:include>
	</style>

	<link href="https://cdn.datatables.net/v/dt/dt-3.1.4/datatables.min.css" rel="stylesheet">
	<script src="https://cdn.datatables.net/v/dt/dt-3.1.4/datatables.min.js" ></script>
</head>
<body>

<%
	ArrayList<Clientes> listaClientes = (ArrayList<Clientes>) request.getAttribute("listaClientes");
	int cantidad = (listaClientes != null) ? listaClientes.size() : 0;
%>

<div class="layout">

	<nav class="sidebar">
		<h2>Menú</h2>
		<a href="ServletClientes">Alta de Cliente</a>
		<a href="ServletListadoClientes" class="active">Listado de Clientes</a>
	</nav>

	<main class="contenido">

		<h1>Listado de Clientes (<%= cantidad %>)</h1>
		<p class="usuario">Usuario: <%= session.getAttribute("usuarioLogueado") %></p>

		<table id="tablaClientes" class="display">
			<thead>
				<tr>
					<th>DNI</th>
					<th>CUIL</th>
					<th>Nombre y Apellido</th>
					<th>Sexo</th>
					<th>Fecha de Nacimiento</th>
					<th>Dirección</th>
					<th>Nacionalidad</th>
					<th>Localidad</th>
					<th>Provincia</th>
				</tr>
			</thead>

			<tbody>
				<%
					if (listaClientes != null) {
						for (Clientes cliente : listaClientes) {
				%>
				<tr>
					<td><%= cliente.getDni() %></td>
					<td><%= cliente.getCuil() %></td>
					<td><%= cliente.getNombre() %> <%= cliente.getApellido() %></td>
					<td><%= cliente.getSexo() %></td>
					<td><%= cliente.getFechaNacimiento() %></td>
					<td><%= cliente.getDireccion() %></td>
					<td><%= cliente.getNacionalidad() %></td>
					<td><%= cliente.getLocalidad() %></td>
					<td><%= cliente.getProvincia() %></td>
				</tr>
				<%
						}
					}
				%>
			</tbody>
		</table>

	</main>
</div>

<script>
	new DataTable('#tablaClientes', {
		pageLength: 5,
		language: {
			url: 'https://cdn.datatables.net/plug-ins/3.1.3/i18n/es-AR.json'
		}
	});
</script>

</body>
</html>
