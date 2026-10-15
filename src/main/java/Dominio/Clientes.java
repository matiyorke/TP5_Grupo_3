package Dominio;

public class Clientes {
	
int idCliente;
String dni;
String cuil;
String nombre;
String apellido;
String sexo;
String fechaNacimiento;
String direccion;
String nacionalidad;
String localidad;
String provincia;
String correoElectronico;
String telefono;
	
	
public Clientes() {}


public Clientes(String dni, String cuil, String nombre, String apellido, String sexo, String fechaNacimiento,
		String direccion, String nacionalidad, String localidad, String provincia, String correoElectronico,
		String telefono) {

	this.dni = dni;
	this.cuil = cuil;
	this.nombre = nombre;
	this.apellido = apellido;
	this.sexo = sexo;
	this.fechaNacimiento = fechaNacimiento;
	this.direccion = direccion;
	this.nacionalidad = nacionalidad;
	this.localidad = localidad;
	this.provincia = provincia;
	this.correoElectronico = correoElectronico;
	this.telefono = telefono;
}


public int getIdCliente() {
	return idCliente;
}

public String getDni() {
	return dni;
}


public void setDni(String dni) {
	this.dni = dni;
}


public String getCuil() {
	return cuil;
}


public void setCuil(String cuil) {
	this.cuil = cuil;
}


public String getNombre() {
	return nombre;
}


public void setNombre(String nombre) {
	this.nombre = nombre;
}


public String getApellido() {
	return apellido;
}


public void setApellido(String apellido) {
	this.apellido = apellido;
}


public String getSexo() {
	return sexo;
}


public void setSexo(String sexo) {
	this.sexo = sexo;
}


public String getFechaNacimiento() {
	return fechaNacimiento;
}


public void setFechaNacimiento(String fechaNacimiento) {
	this.fechaNacimiento = fechaNacimiento;
}


public String getDireccion() {
	return direccion;
}


public void setDireccion(String direccion) {
	this.direccion = direccion;
}


public String getNacionalidad() {
	return nacionalidad;
}


public void setNacionalidad(String nacionalidad) {
	this.nacionalidad = nacionalidad;
}


public String getLocalidad() {
	return localidad;
}


public void setLocalidad(String localidad) {
	this.localidad = localidad;
}


public String getProvincia() {
	return provincia;
}


public void setProvincia(String provincia) {
	this.provincia = provincia;
}


public String getCorreoElectronico() {
	return correoElectronico;
}


public void setCorreoElectronico(String correoElectronico) {
	this.correoElectronico = correoElectronico;
}


public String getTelefono() {
	return telefono;
}


public void setTelefono(String telefono) {
	this.telefono = telefono;
}


@Override
public String toString() {
	return "Clientes [idCliente=" + idCliente + ", dni=" + dni + ", cuil=" + cuil + ", nombre=" + nombre + ", apellido="
			+ apellido + ", sexo=" + sexo + ", fechaNacimiento=" + fechaNacimiento + ", direccion=" + direccion
			+ ", nacionalidad=" + nacionalidad + ", localidad=" + localidad + ", provincia=" + provincia
			+ ", correoElectronico=" + correoElectronico + ", telefono=" + telefono + "]";
}




}
