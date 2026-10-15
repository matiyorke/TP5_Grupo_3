package Dominio;

public class Usuarios {

int idUsuario;
String nombreUsuario;
String contraseña;

public Usuarios() {}

public Usuarios(String nombreUsuario, String contraseña) {
	
	this.nombreUsuario = nombreUsuario;
	this.contraseña = contraseña;
}

public int getIdUsuario() {
	return idUsuario;
}

public String getNombreUsuario() {
	return nombreUsuario;
}

public void setNombreUsuario(String nombreUsuario) {
	this.nombreUsuario = nombreUsuario;
}

public String getContraseña() {
	return contraseña;
}

public void setContraseña(String contraseña) {
	this.contraseña = contraseña;
}

@Override
public String toString() {
	return "Usuarios [idUsuario=" + idUsuario + ", nombreUsuario=" + nombreUsuario + ", contraseña=" + contraseña + "]";
}


	
	
	
	
	
	
	
	
	
	
	
	
	
}
