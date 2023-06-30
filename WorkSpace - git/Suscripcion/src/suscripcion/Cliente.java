package suscripcion;

import java.util.ArrayList;


/**
 * Cliente representa a un posiblie cliente del sistema.
 * Hereda todos los atributos y metodos de la clase Persona.
 * 
 * @author Adriel
 *
 */
public class Cliente extends Persona {

	private String email;
	private ArrayList<Suscripcion> suscripciones;
	
	/**
	 * 
	 * @param nombre
	 * @param apellido
	 * @param dni
	 * @param contrasenia
	 * @param email
	 */
	public Cliente(String nombre, String apellido, String dni, String contrasenia, String email) {
		super(nombre, apellido, dni, contrasenia);
		this.email = email;
		this.suscripciones = new ArrayList<Suscripcion>();
	}

	/**
	 * Devuelve el email del cliente.
	 * @return the email
	 */
	public String getUsuario() {
		return email;
	}

	/**
	 * El cliente se suscribe a una Suscripcion s, y la misma se agrega a la lista de suscripciones.
	 * @param s
	 */
	public void suscribirse(Suscripcion s) {
		s.addSuscriptor(this.getUsuario());
		this.suscripciones.add(s);
	}

	/**
	 * El cliente se desuscribe a una Suscripcion s, y la misma se elimina de la lista de suscripciones.
	 * @param s
	 */
	public void desuscribirse(Suscripcion s) {
		s.removeSuscriptor(this.getUsuario());
		this.suscripciones.remove(s);
	}

	/**
	 * El cliente adquiere un pasaje para un Viaje v.
	 * @param v
	 */
	public void sacarPasaje(Viaje v) {
		v.ocuparAsiento();
		System.out.println("Pasaje sacado con exito de " + v.getOrigen() + " hacia " + v.getDestino());
	}
	
	/**
	 * Devuele todas las suscripciones activas del Cliente en una lista de suscripciones.
	 * @return ArrayList<Suscripcion>
	 */
	public ArrayList<Suscripcion> listarSuscripciones(){
		ArrayList<Suscripcion> nueva = new ArrayList<Suscripcion>();
		nueva.addAll(suscripciones);
		return nueva;
	}
}
