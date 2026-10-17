package datos;

import Dominio.Usuarios;

public interface UsuarioDao {

	public Usuarios validarUsuario(String nombreUsuario, String contrasenia);
	
}