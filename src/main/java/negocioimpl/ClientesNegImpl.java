package negocioimpl;

import java.util.ArrayList;

import Dominio.Clientes;
import datos.ClientesDao;
import datosImpl.ClientesDaoImpl;
import negocio.ClientesNeg;

public class ClientesNegImpl implements ClientesNeg {

	private ClientesDao cliDao = new ClientesDaoImpl();

	public ClientesNegImpl() {
	}

	public ClientesNegImpl(ClientesDao cliDao) {
		this.cliDao = cliDao;
	}

	@Override
	public boolean agregarCliente(Clientes cliente) {
		return cliDao.agregarCliente(cliente);
	}

	@Override
	public ArrayList<Clientes> obtenerTodos() {
		return cliDao.obtenerTodos();
	}

	@Override
	public boolean existeCorreo(String correo) {
		return cliDao.existeCorreo(correo);
	}
}