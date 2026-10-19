package datosImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import Dominio.Clientes;
import datos.ClientesDao;

public class ClientesDaoImpl implements ClientesDao {

	public ClientesDaoImpl() {

	}

	@Override
	public boolean agregarCliente(Clientes cliente) {
		Conexion cn = new Conexion();
		Connection con = cn.Open();
		boolean guardado = false;

		try {
			PreparedStatement ps = con.prepareStatement(
					"INSERT INTO clientes (dni, cuil, nombre, apellido, sexo, fecha_nacimiento, direccion, "
							+ "nacionalidad, localidad, provincia, correo_electronico, telefono) "
							+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");

			ps.setString(1, cliente.getDni());
			ps.setString(2, cliente.getCuil());
			ps.setString(3, cliente.getNombre());
			ps.setString(4, cliente.getApellido());
			ps.setString(5, cliente.getSexo());
			ps.setString(6, cliente.getFechaNacimiento());
			ps.setString(7, cliente.getDireccion());
			ps.setString(8, cliente.getNacionalidad());
			ps.setString(9, cliente.getLocalidad());
			ps.setString(10, cliente.getProvincia());
			ps.setString(11, cliente.getCorreoElectronico());
			ps.setString(12, cliente.getTelefono());

			guardado = ps.executeUpdate() == 1;
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			cn.close();
		}

		return guardado;
	}

	@Override
	public ArrayList<Clientes> obtenerTodos() {
		Conexion cn = new Conexion();
		Connection con = cn.Open();
		ArrayList<Clientes> lista = new ArrayList<Clientes>();

		try {
			PreparedStatement ps = con.prepareStatement("SELECT * FROM clientes");
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Clientes c = new Clientes(
						rs.getString("dni"),
						rs.getString("cuil"),
						rs.getString("nombre"),
						rs.getString("apellido"),
						rs.getString("sexo"),
						rs.getString("fecha_nacimiento"),
						rs.getString("direccion"),
						rs.getString("nacionalidad"),
						rs.getString("localidad"),
						rs.getString("provincia"),
						rs.getString("correo_electronico"),
						rs.getString("telefono"));

				lista.add(c);
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			cn.close();
		}

		return lista;
	}

	@Override
	public boolean existeCorreo(String correo) {
		Conexion cn = new Conexion();
		Connection con = cn.Open();
		boolean existe = false;

		try {
			PreparedStatement ps = con.prepareStatement("SELECT 1 FROM clientes WHERE correo_electronico = ?");
			ps.setString(1, correo);
			ResultSet rs = ps.executeQuery();

			existe = rs.next();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			cn.close();
		}

		return existe;
	}
}
