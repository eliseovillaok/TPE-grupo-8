package suscripcion;

import java.time.LocalDateTime;

public class main {
	
	public static void main(String[] args) {
		//Test Funcional
		Plataforma p1 = new Plataforma();
		
		Cliente c1 = new Cliente("Adriel", "Picapiedras", "44298732", "cebaMates", "adri@gmail.com");
		Cliente c2 = new Cliente("Mateo", "Picapiedras", "44298732", "mate", "mate@gmail.com");
		Cliente c3 = new Cliente("Lucas", "Picapiedras", "44298732", "lucas", "lucas@gmail.com");
		
		p1.addCliente(c1);
		p1.addCliente(c2);
		p1.addCliente(c3);
		
		Viaje v1 = new Viaje("Olavarria", "Tandil",LocalDateTime.parse("2023-06-27T18:00:00.000"),LocalDateTime.parse("2023-06-27T23:00:00.000"),"Via tac",5,10,2700);
		Viaje v2 = new Viaje("Tandil", "Necochea",LocalDateTime.parse("2023-06-25T20:00:00.000"),LocalDateTime.parse("2023-06-25T23:30:00.000"),"Via tac",3,25,2700);
		Viaje v3 = new Viaje("Necochea", "Mar del Plata",LocalDateTime.parse("2023-06-25T19:00:00.000"),LocalDateTime.parse("2023-06-25T21:00:00.000"),"Via tac",2,20,2700);
		
		p1.addViaje(v1);
		p1.addViaje(v2);
		p1.addViaje(v3);

		p1.addSuscripcion("Olavarria","Tandil");
		p1.addSuscripcion("Tandil","Necochea");
		p1.addSuscripcion("Necochea","Mar del Plata");

		//Testing 1
		Cliente a = p1.logueoCliente("adri@gmail.com", "cebaMates");
		if(a!=null) {
			a.suscribirse(p1.getSuscripcion("Necochea", "Mar del Plata"));
			p1.chequear(v3);
		}
		
		//Testing 2
		Cliente m = p1.logueoCliente("mate@gmail.com","mate");
		Cliente l = p1.logueoCliente("lucas@gmail.com","lucas");
		m.suscribirse(p1.getSuscripcion("Tandil", "Necochea"));
		l.suscribirse(p1.getSuscripcion("Tandil", "Necochea"));
		
		p1.chequear(v2);
		
		l.desuscribirse(p1.getSuscripcion("Tandil", "Necochea"));
		
		p1.chequear(v2);
		
		/*
		
		
		// Creamos nueva suscripcion
		p1.addSuscripcion("Usuhaia", "Mar de las pampas");
		// Sacamos pasaje
		c1.sacarPasaje("Usuhaia", "Mar de las pampas");
		
		// Obtenemos la suscripcion
		Suscripcion s1 = p1.getSuscripcion("Usuhaia", "Mar de las pampas");
		
		// Agregamos un suscriptor y notificamos
		s1.addSuscriptor(c1.getUsuario());
		s1.notificar();
		
		*/
	}
}
 
