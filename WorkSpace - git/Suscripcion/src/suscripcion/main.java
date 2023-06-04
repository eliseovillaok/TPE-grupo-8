package suscripcion;

public class main {
	
	public static void main(String[] args) {
		Cliente c1 = new Cliente("Pedro", "Picapiedras", "44298732", "pedrito2008", "pedropica@gmail.com");
		Plataforma p1 = new Plataforma();
		
		// Creamos nueva suscripcion
		p1.addSuscripcion("Usuhaia", "Mar de las pampas");
		// Sacamos pasaje
		c1.sacarPasaje("Usuhaia", "Mar de las pampas");
		
		// Obtenemos la suscripcion
		Suscripcion s1 = p1.getSuscripcion("Usuhaia", "Mar de las pampas");
		
		// Agregamos un suscriptor y notificamos
		s1.addSuscriptor(c1.getUsuario());
		s1.notificar();
}
 
