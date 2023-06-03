package suscripcion;

import java.util.ArrayList;

public class Plataforma {
	private ArrayList<Cliente> clientes;
	private Administrador admin;
	
	private ArrayList<Suscripcion> serviciosSuscripcion;
	
	private ArrayList<String> localidades; 

	public Plataforma(Administrador admin) {
		super();
		this.admin = admin;
		this.clientes = new ArrayList<Clientes>();
		this.serviciosSuscripcion = new ArrayList<Suscripcion>();
		this.localidades = new ArrayList<String>();
	}
	
	public void addCliente(Cliente c) {
		this.clientes.add(c);
	}
	
	public Cliente logueoCliente(String usuario, String password) {
		for(Cliente c : this.clientes) {
			if((c.getContrasenia().equals(password)) && (c.getEmail().equals(usuario))) {
				return c;
			}
		}
		return null;
	}
	
	public Suscripcion getSuscripcion(String origen, String destino) {
		for(Suscripcion s: this.serviciosSuscripcion) {
			if((s.getSuscripcion().equals(origen)&&(s.getDestino().equals(destino)))) {
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
	
}
