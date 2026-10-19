package datos;

import java.util.ArrayList;

import Dominio.Clientes;

public interface ClientesDao {

	boolean agregarCliente(Clientes cliente);

	ArrayList<Clientes> obtenerTodos();

	boolean existeCorreo(String correo);
}
