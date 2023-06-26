package suscripcion;

import java.util.ArrayList;

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
	
	public void addCliente(Cliente c) {
		boolean mail = false;
	
		if(!this.clientes.isEmpty()) {
			int i = 0;	
			while((!mail)&&(i<this.clientes.size())) {
				if(this.clientes.get(i).getUsuario().equals(c.getUsuario())) {
					mail = true;
				}
				i++;
			}
		}
		if(!mail) {
			this.clientes.add(c);
		}
	}
	
	public Cliente logueoCliente(String usuario, String password) {
		for(Cliente c : this.clientes) {
			if((c.getContrasenia().equals(password)) && (c.getUsuario().equals(usuario))) {
				c.setLogueado(true);
				return c;
			}
		}
		return null;
	}
	
	public Suscripcion getSuscripcion(String origen, String destino) {
		for(Suscripcion s: this.serviciosSuscripcion) {
			if((s.getOrigen().equals(origen)&&(s.getDestino().equals(destino)))) {
				return s;
			}
		}
		return null;
	}
	
	public void addSuscripcion(String origen, String destino) {
		Suscripcion s = getSuscripcion(origen, destino);
		if(s == null) {
			s = new Suscripcion(origen, destino);
			serviciosSuscripcion.add(s);
		}
	}
	
	public void addViaje(Viaje v) {
		if(!this.viajes.contains(v)) {
			this.viajes.add(v);
		}
	}
	
	public void chequear(Viaje viaje) {
		if(viaje.cumpleRequerimiento(DIFERENCIAHORARIA,CANTIDADASIENTOS)) {
			for(Suscripcion s : this.serviciosSuscripcion) {
				if(s.getOrigen().equals(viaje.getOrigen())&&s.getDestino().equals(viaje.getDestino())) {
					s.notificar();
				}
			}
		
		}
	}
	
}
