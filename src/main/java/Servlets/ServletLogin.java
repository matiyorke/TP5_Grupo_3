package Servlets;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import Dominio.Usuarios;
import negocio.UsuarioNeg;
import negocioimpl.UsuarioNegImpl;

@WebServlet("/ServletLogin")
public class ServletLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private UsuarioNeg usuNeg = new UsuarioNegImpl();

	public ServletLogin() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/Login.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		if (request.getParameter("btnIngresar") != null) {

			String usuario = request.getParameter("txtUsuario");
			String contrasenia = request.getParameter("txtContrasenia");

			Usuarios usu = usuNeg.validarUsuario(usuario, contrasenia);

			if (usu != null) {
				HttpSession session = request.getSession();
				session.setAttribute("usuarioLogueado", usu.getNombreUsuario());

				response.sendRedirect("ServletClientes");
			} else {
				request.setAttribute("mensaje", "Usuario o contraseña incorrectos.");
				RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/Login.jsp");
				rd.forward(request, response);
			}
		}
	}
}