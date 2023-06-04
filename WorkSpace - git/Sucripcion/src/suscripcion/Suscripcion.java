package suscripcion;

import java.util.ArrayList;

public class Suscripcion {

	private String origen;
	private String destino;
	private ArrayList<String> suscriptores;
	
	
	public Suscripcion(String origen, String destino) {
		this.origen = origen;
		this.destino = destino;
		this.suscriptores = new ArrayList<String>();
	}

	
	public String getOrigen() {
		return origen;
	}


	public void setOrigen(String origen) {
		this.origen = origen;
	}


	public String getDestino() {
		return destino;
	}


	public void setDestino(String destino) {
		this.destino = destino;
	}


	public ArrayList<String> getSuscriptores() {
		return (new ArrayList<String>(suscriptores));
	}

	
	public void addSuscriptor (String e) {
		if (!suscriptores.contains(e))
			suscriptores.add(e);
	}
	
	public void removeSuscriptor (String e) {
		suscriptores.remove(e);
		
	}
	
	public void notificar()	{
		for (int i=0; i<suscriptores.size();i++)
			System.out.println("Se le notifica a "+ suscriptores.get(i) + " que hay un viaje improvisado");
	
	}
	
	
}
