package suscripcion;

import java.util.ArrayList;

public class Cliente extends Persona {

	private String email;
	private ArrayList<Suscripcion> suscripciones;
	public Cliente(String nombre, String apellido, String dni, String contrasenia, String email) {
		super(nombre, apellido, dni, contrasenia);
		this.email = email;
		this.suscripciones = new ArrayList<Suscripcion>();
	}

	public String getUsuario() {
		return email;
	}

	public void suscribirse(Suscripcion s) {
		s.addSuscriptor(this.getUsuario());
		this.suscripciones.add(s);
	}

	public void desuscribirse(Suscripcion s) {
		s.removeSuscriptor(this.getUsuario());
		this.suscripciones.remove(s);
	}

	public void sacarPasaje(Viaje v) {
		v.ocuparAsiento();
		System.out.println("Pasaje sacado con exito de " + v.getOrigen() + " hacia " + v.getDestino());
	}
	
	public ArrayList<Suscripcion> listarSuscripciones(){
		ArrayList<Suscripcion> nueva = new ArrayList<Suscripcion>();
		nueva.addAll(suscripciones);
		return nueva;
	}
}
