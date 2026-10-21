package negocio;

import java.util.ArrayList;

import Dominio.Clientes;

public interface ClientesNeg {
	public boolean agregarCliente(Clientes cliente);
	public ArrayList<Clientes> obtenerTodos();
	public boolean existeCorreo(String correo);
}