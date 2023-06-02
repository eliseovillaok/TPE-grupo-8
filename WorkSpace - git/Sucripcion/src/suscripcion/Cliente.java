package suscripcion;

public class Cliente extends Persona{

	private String email;
	
	public Cliente(String nombre, String apellido, String dni, String contrasenia, String email) {
		super(nombre,apellido,dni,contrasenia);
		this.email = email;
	}

	public String getUsuario() {
		return email;
	}
}

// sacarpasaje. suscribirse. desuscribirse.
// sacarpasaje usa clase pasaje.
// bool sacarpasaje(string origen ,string destino)
// bool suscribirse(suscripcion)
	//suscripcion.addsuscriptor
