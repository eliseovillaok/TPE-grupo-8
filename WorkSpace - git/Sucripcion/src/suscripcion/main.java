package suscripcion;

public class main {
	
	public static void main(String[] args) {
		// main hecho a ojo
		Cliente c1 = new Cliente("Pedro", "Picapiedras", "44298732", "pedrito2008", "pedropica@gmail.com");
		Suscripcion s1 = new Suscripcion("Usuhaia", "Mar de las pampas");
		
		c1.sacarPasaje("Usuhaia", "Mar de las pampas");
		c1.suscribirse(s1);
		s1.notificar();
	}

}
