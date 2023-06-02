package suscripcion;

public class Admin extends Persona {
	
	public Admin(String nombre, String apellido, String dni, String contrasenia) {
		super(nombre,apellido,dni,contrasenia);
	}
	
	public String getUsuario() {
		return (super.getNombre());
	}
}
