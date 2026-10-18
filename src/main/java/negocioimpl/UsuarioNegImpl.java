package negocioimpl;

import Dominio.Usuarios;
import datos.UsuarioDao;
import datosImpl.UsuarioDaoImpl;
import negocio.UsuarioNeg;

public class UsuarioNegImpl implements UsuarioNeg {

	private UsuarioDao usuDao = new UsuarioDaoImpl();

	public UsuarioNegImpl() {
	}

	public UsuarioNegImpl(UsuarioDao usuDao) {
		this.usuDao = usuDao;
	}

	@Override
	public Usuarios validarUsuario(String nombreUsuario, String contrasenia) {
		return usuDao.validarUsuario(nombreUsuario, contrasenia);
	}
}