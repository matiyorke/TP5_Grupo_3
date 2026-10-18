package negocio;

import Dominio.Usuarios;

public interface UsuarioNeg {
	public Usuarios validarUsuario(String nombreUsuario, String contrasenia);
}