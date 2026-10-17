package datosImpl;

import java.sql.ResultSet;

import Dominio.Usuarios;
import datos.UsuarioDao;

public class UsuarioDaoImpl implements UsuarioDao {

	private Conexion cn;

	public UsuarioDaoImpl()
	{
		
	}
	
	@Override
	public Usuarios validarUsuario(String nombreUsuario, String contrasenia) {
		cn = new Conexion();
		cn.Open();
		Usuarios usuario = null;
		try
		{
			ResultSet rs = cn.query("Select * from usuarios where usuario='" + nombreUsuario + "' and contrasena='" + contrasenia + "'");
			if(rs.next())
			{
				usuario = new Usuarios();
				usuario.setNombreUsuario(rs.getString("usuario"));
				usuario.setContraseña(rs.getString("contrasena"));
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			cn.close();
		}
		return usuario;
	}

}