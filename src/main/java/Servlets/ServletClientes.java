package Servlets;

import java.io.IOException;
import java.util.ArrayList;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import Dominio.Clientes;
import negocio.ClientesNeg;
import negocioimpl.ClientesNegImpl;

@WebServlet("/ServletClientes")
public class ServletClientes extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private ClientesNeg cliNeg = new ClientesNegImpl();

	public ServletClientes() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		if (session.getAttribute("usuarioLogueado") == null) {
			response.sendRedirect("ServletLogin");
			return;
		}

		if (request.getParameter("listar") != null) {
			ArrayList<Clientes> lista = cliNeg.obtenerTodos();
			request.setAttribute("listaClientes", lista);
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/ListadoClientes.jsp");
			rd.forward(request, response);
		} else {
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/AltaCliente.jsp");
			rd.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		if (session.getAttribute("usuarioLogueado") == null) {
			response.sendRedirect("ServletLogin");
			return;
		}

		if (request.getParameter("btnGuardar") != null) {

			String dni = request.getParameter("txtDni");
			String cuil = request.getParameter("txtCuil");
			String nombre = request.getParameter("txtNombre");
			String apellido = request.getParameter("txtApellido");
			String sexo = request.getParameter("ddlSexo");
			String fecha = request.getParameter("txtFechaNacimiento");
			String direccion = request.getParameter("txtDireccion");
			String nacionalidad = request.getParameter("txtNacionalidad");
			String localidad = request.getParameter("txtLocalidad");
			String provincia = request.getParameter("txtProvincia");
			String correo = request.getParameter("txtCorreo");
			String telefono = request.getParameter("txtTelefono");

			String mensaje = validar(dni, cuil, nombre, apellido, sexo, fecha, direccion, nacionalidad, localidad,
					provincia, correo, telefono);

			if (mensaje.equals("")) {
				if (cliNeg.existeCorreo(correo)) {
					mensaje = "El correo electrónico ya está registrado.";
				} else {
					Clientes cliente = new Clientes(dni, cuil, nombre, apellido, sexo, fecha, direccion, nacionalidad,
							localidad, provincia, correo, telefono);
					if (cliNeg.agregarCliente(cliente)) {
						mensaje = "Cliente agregado correctamente.";
					} else {
						mensaje = "No se pudo guardar el cliente.";
					}
				}
			}

			request.setAttribute("mensaje", mensaje);
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/AltaCliente.jsp");
			rd.forward(request, response);
		}
	}

	// Devuelve "" si todo esta bien, o el mensaje del primer error encontrado
	private String validar(String dni, String cuil, String nombre, String apellido, String sexo, String fecha,
			String direccion, String nacionalidad, String localidad, String provincia, String correo,
			String telefono) {

		if (vacio(dni) || vacio(cuil) || vacio(nombre) || vacio(apellido) || vacio(sexo) || vacio(fecha)
				|| vacio(direccion) || vacio(nacionalidad) || vacio(localidad) || vacio(provincia) || vacio(correo)
				|| vacio(telefono)) {
			return "Debe ingresar todos los campos para poder continuar.";
		}

		if (!soloNumeros(dni) || dni.length() < 6 || dni.length() > 8) {
			return "El DNI debe ser numérico, de 6 a 8 dígitos.";
		}
		if (!soloNumeros(cuil) || cuil.length() != 11) {
			return "El CUIL debe ser numérico, de 11 dígitos.";
		}
		if (!soloLetras(nombre)) {
			return "El nombre debe contener solo letras.";
		}
		if (!soloLetras(apellido)) {
			return "El apellido debe contener solo letras.";
		}
		if (!sexo.equals("M") && !sexo.equals("F") && !sexo.equals("Otro")) {
			return "Debe seleccionar un sexo válido.";
		}

		// El formato de la fecha es aaaa-mm-dd, por eso se puede comparar como texto
		String hoy = new java.sql.Date(System.currentTimeMillis()).toString();
		if (fecha.compareTo(hoy) > 0) {
			return "La fecha de nacimiento no puede ser futura.";
		}

		if (!soloLetrasYNumeros(direccion)) {
			return "La dirección solo puede contener letras y números.";
		}
		if (!soloLetras(nacionalidad)) {
			return "La nacionalidad debe contener solo letras.";
		}
		if (!soloLetras(localidad)) {
			return "La localidad debe contener solo letras.";
		}
		if (!soloLetras(provincia)) {
			return "La provincia debe contener solo letras.";
		}
		if (correo.indexOf("@") < 1 || correo.indexOf(".", correo.indexOf("@")) < 0 || correo.indexOf(" ") >= 0) {
			return "El correo electrónico no tiene un formato válido.";
		}
		if (!soloNumeros(telefono) || telefono.length() != 10) {
			return "El teléfono debe ser numérico, de 10 dígitos.";
		}

		return "";
	}

	private boolean vacio(String texto) {
		return texto == null || texto.trim().equals("");
	}

	private boolean soloNumeros(String texto) {
		for (int i = 0; i < texto.length(); i++) {
			if (!Character.isDigit(texto.charAt(i))) {
				return false;
			}
		}
		return true;
	}

	private boolean soloLetras(String texto) {
		for (int i = 0; i < texto.length(); i++) {
			char c = texto.charAt(i);
			if (!Character.isLetter(c) && c != ' ') {
				return false;
			}
		}
		return true;
	}

	private boolean soloLetrasYNumeros(String texto) {
		for (int i = 0; i < texto.length(); i++) {
			char c = texto.charAt(i);
			if (!Character.isLetterOrDigit(c) && c != ' ') {
				return false;
			}
		}
		return true;
	}
}