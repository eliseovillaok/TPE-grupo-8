package suscripcion;

import java.time.LocalDate;
import java.util.ArrayList;

/** 
 * La clase Plataforma representa al sistema completo en donde quedan
 * registrados los clientes, el administrador, los viajes que se ofrecen,
 * las localidades disponibles y las suscripciones para los clientes.
 * 
 * @author Nahuel
 */
public class Plataforma {
	private ArrayList<Cliente> clientes;
	// private Administrador admin;
	private ArrayList<Viaje> viajes;
	private ArrayList<Suscripcion> serviciosSuscripcion;
	//private ArrayList<String> localidades;
	
	private static long DIFERENCIAHORARIA = 6;
	private static int CANTIDADASIENTOS = 20;

	public Plataforma() {
		super();
		this.clientes = new ArrayList<Cliente>();
		this.serviciosSuscripcion = new ArrayList<Suscripcion>();
		//this.localidades = new ArrayList<String>();
		this.viajes = new ArrayList<Viaje>();
	}
	
	/**
	 * Agrega un Cliente a la lista de clientes, siempre y cuando
	 * el usuario ingresado no exista en ningun otro cliente regis_
	 * trado.
	 * 
	 * @param c
	 * @return
	 */
	public boolean addCliente(Cliente c) {
		boolean add = true;
	
		if(!this.clientes.isEmpty()) {
			int i = 0;	
			while((add)&&(i<this.clientes.size())) {
				if(this.clientes.get(i).getUsuario().equals(c.getUsuario())) {
					add = false;
				}
				i++;
			}
		}
		if(add) {
			this.clientes.add(c);
		}
		return add;
	}
	
	/**
	 * 
	 *Devuelve un Cliente correspondiente al usuario y password dados por parametro. En el caso de no existir se retornara null
	 *
	 * @param usuario
	 * @param password
	 * @return
	 */
	public Cliente logueoCliente(String usuario, String password) {
		for(Cliente c : this.clientes) {
			if((c.getContrasenia().equals(password)) && (c.getUsuario().equals(usuario))) {
				c.setLogueado(true);
				return c;
			}
		}
		return null;
	}
	
	/**
	 * Busca una Suscripcion a traves de un origen y destino dados por parametro.En el caso de no encontrarse retorna null.
	 * 
	 * @param origen
	 * @param destino
	 * @return
	 */
	public Suscripcion getSuscripcion(String origen, String destino) {
		for(Suscripcion s: this.serviciosSuscripcion) {
			if((s.getOrigen().equals(origen)&&(s.getDestino().equals(destino)))) {
				return s;
			}
		}
		return null;
	}
	
	/**
	 * Agrega una Suscripcion a la lista de suscripciones.
	 * 
	 * @param origen
	 * @param destino
	 * @return
	 */
	public Suscripcion addSuscripcion(String origen, String destino) {
		Suscripcion s = getSuscripcion(origen, destino);
		if(s == null) {
			s = new Suscripcion(origen, destino);
			serviciosSuscripcion.add(s);
		}
		return s;
	}
	
	/**
	 * Agrega un Viaje a la lista de viajes.
	 * 
	 * @param v
	 */
	public void addViaje(Viaje v) {
		if(!this.viajes.contains(v)) {
			this.viajes.add(v);
		}
	}
	
	/**
	 * Verifica si un Viaje cumple con los requerimientos de una suscripcion y notifica a los suscriptos.
	 * 
	 * @param viaje
	 */
	public void chequear(Viaje viaje) {
		if(viaje.cumpleRequerimiento(DIFERENCIAHORARIA,CANTIDADASIENTOS)) {
			for(Suscripcion s : this.serviciosSuscripcion) {
				if(s.getOrigen().equals(viaje.getOrigen())&&s.getDestino().equals(viaje.getDestino())) {
					s.notificar();
				}
			}
		
		}
	}
	
	/**
	 * Devuelve una lista de viajes disponibles, con el origen, destino y fecha solicitados por parámetro.
	 *
	 * 
	 * @param origen
	 * @param destino
	 * @param fechaSalida
	 * @return
	 */
	public ArrayList<Viaje> getViajes(String origen, String destino, LocalDate fechaSalida) {
		if(this.viajes.isEmpty()) {
			return null;
		}else {
			ArrayList<Viaje> lista = new ArrayList<Viaje>(); 
			for (Viaje v : this.viajes) {
				if((v.getOrigen().equals(origen))&&(v.getDestino().equals(destino))&&(v.getFechaSalida().toLocalDate().equals(fechaSalida))) {
					lista.add(v);
				}
			}
			return lista;
		}
	}
	
}
