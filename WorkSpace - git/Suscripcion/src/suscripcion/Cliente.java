package suscripcion;

public class Cliente extends Persona {

	private String email;

	public Cliente(String nombre, String apellido, String dni, String contrasenia, String email) {
		super(nombre, apellido, dni, contrasenia);
		this.email = email;
	}

	public String getUsuario() {
		return email;
	}

	public void suscribirse(Suscripcion s) {
		s.addSuscriptor(this.getUsuario());
	}

	public void desuscribirse(Suscripcion s) {
		s.removeSuscriptor(this.getUsuario());
	}

	public void sacarPasaje(String origen, String destino) {
		System.out.println("Pasaje sacado con exito de " + origen + " hacia " + destino);
	}
}
