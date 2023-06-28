package suscripcion;

import java.io.Console;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;

public class main {

	public static void main(String[] args) {
		// Test Funcional
		Plataforma p1 = new Plataforma();

		Cliente c1 = new Cliente("Adriel", "Picapiedras", "44298732", "cebaMates", "adri@gmail.com");
		Cliente c2 = new Cliente("Mateo", "Picapiedras", "44298732", "mate", "mate@gmail.com");
		Cliente c3 = new Cliente("Lucas", "Picapiedras", "44298732", "lucas", "lucas@gmail.com");

		p1.addCliente(c1);
		p1.addCliente(c2);
		p1.addCliente(c3);

		Viaje v1 = new Viaje("Olavarria", "Tandil", LocalDateTime.parse("2023-06-27T18:00:00.000"),
				LocalDateTime.parse("2023-06-27T23:00:00.000"), "Via tac", 5, 10, 2700);
		Viaje v2 = new Viaje("Tandil", "Necochea", LocalDateTime.parse("2023-06-25T20:00:00.000"),
				LocalDateTime.parse("2023-06-25T23:30:00.000"), "Via tac", 3, 25, 2700);
		Viaje v3 = new Viaje("Necochea", "Mar del Plata", LocalDateTime.parse("2023-06-25T19:00:00.000"),
				LocalDateTime.parse("2023-06-25T21:00:00.000"), "Via tac", 2, 20, 2700);

		p1.addViaje(v1);
		p1.addViaje(v2);
		p1.addViaje(v3);

		p1.addSuscripcion("Olavarria", "Tandil");
		p1.addSuscripcion("Tandil", "Necochea");
		p1.addSuscripcion("Necochea", "Mar del Plata");

		// Testing 1
		Cliente a = p1.logueoCliente("adri@gmail.com", "cebaMates");
		if (a != null) {
			a.suscribirse(p1.getSuscripcion("Necochea", "Mar del Plata"));
			p1.chequear(v3);
		}

		// Testing 2
		Cliente m = p1.logueoCliente("mate@gmail.com", "mate");
		Cliente l = p1.logueoCliente("lucas@gmail.com", "lucas");
		m.suscribirse(p1.getSuscripcion("Tandil", "Necochea"));
		l.suscribirse(p1.getSuscripcion("Tandil", "Necochea"));

		p1.chequear(v2);

		l.desuscribirse(p1.getSuscripcion("Tandil", "Necochea"));

		p1.chequear(v2);
		
		//////////////////////////////////////////////////////////
		boolean flag = false;
		boolean logueo = false;
		Scanner tec = new Scanner(System.in);
		Cliente c = null;
		
		while(!flag) {
			if(!logueo) {
				System.out.println("-> Ingrese 1 para Registrarse.");
				System.out.println("-> Ingrese 2 para logueo.");
			}
			
			System.out.println("-> Ingrese 3 para buscar un viaje.");
			System.out.println("-> Ingrese 4 para Suscribirse a un viaje improvisado.");
			System.out.println("-> Ingrese 5 para ver sus suscripciones activas.");
			System.out.println("-> Ingrese 6 para desuscribirse de un viaje improvisado");
			System.out.println("-> Ingresar 7 para SALIR");
			int resp = tec.nextInt();
			
			switch(resp) {
				case(1):
					System.out.println("Ingrese nombre: ");
					String n = tec.next();
					System.out.println("Ingrese apellido: ");
					String ap = tec.next();
					System.out.println("Ingrese dni: ");
					String dni = tec.next();
					System.out.println("Ingrese Usuario(email): ");
					String us = tec.next();
					System.out.println("Ingrese Password: ");
					String pas = tec.next();
					
					Cliente newC = new Cliente(n,ap,dni,pas,us);
					if(p1.addCliente(newC)) {
						System.out.println("REGISTRO EXITOSO");
						c = newC;
					}else {
						System.out.println("El usuario ya estaba registrado");
					}
					break;
				case(2):
					c = logueo(p1, tec);
					if(c!=null)
						logueo = true;
					break;
				case(3):
					System.out.println("Ingrese el origen: ");
					String origen = tec.next();
					System.out.println("Ingrese el destino: ");
					String destino = tec.next();
					System.out.println("Ingrese día");
					int d = tec.nextInt();
					System.out.println("Ingrese mes");
					int m1 = tec.nextInt();
					System.out.println("Ingrese año");
					int a1 = tec.nextInt();
					
					LocalDate ld = LocalDate.of(a1, m1, d);
					
					ArrayList<Viaje> viajes = p1.getViajes(origen, destino, ld);
					int i = 0;
					for(Viaje v : viajes) 
						System.out.println("~ Viaje "+i+": "+ origen +" - "+destino+". Salida: "+v.getFechaSalida()+". LLegada: "+v.getFechaLlegada());
					
					System.out.println("");
					System.out.println("Si desea comprar un viaje presione 1, en caso contrario presione 2.");
					resp = tec.nextInt();
					if(resp==1) {
						if(logueo)
							comprarPasaje(p1,c,viajes, tec);
						else {
							System.out.println("Primero debe loguearse");
							c=logueo(p1,tec);
							if(c!=null) {
								logueo = true;
								comprarPasaje(p1,c,viajes, tec);
							}
						}
				//ACOMODAR
						System.out.println("¿Desea recibir notificaciones sobre descuentos para viajes similares? Ingrese 1 para SI, e ingrese 2 para NO");
						int num = tec.nextInt();
						if(num==1)
							suscribirse(origen, destino, c, p1);
					}
					break;
				case(4):
					System.out.println("Ingrese el origen: ");
					String o1 = tec.next();
					System.out.println("Ingrese el destino: ");
					String d1 = tec.next();
					
					suscribirse(o1, d1, c, p1);
					break;
				case(5):
					mostrar(c);
					break;
				case(6):
					if(c.listarSuscripciones().isEmpty()) {
						System.out.println("No tiene ninguna suscripcion");
					}else {
						mostrar(c);
						System.out.println("Ingrese el viaje al que se quiere desuscribir: ");
						int des = tec.nextInt();
						c.desuscribirse(c.listarSuscripciones().get(des));
					}
					break;
				case(7):
					flag = true;
					break;
			}
		}
		
	}

	
	private static void suscribirse(String origen, String destino, Cliente c, Plataforma p1) {
		Suscripcion s = p1.getSuscripcion(origen, destino);
		if(s == null) {
			s = p1.addSuscripcion(origen, destino);
			c.suscribirse(s);
		}else {
			if(!s.estaSuscripto(c)) { 
				c.suscribirse(s);
			}
		}
		System.out.println("Suscripcion con exito");
	}
	
	private static void mostrar(Cliente c) {
		int cont=0;
		for(Suscripcion s1 : c.listarSuscripciones()) {
			System.out.println("Suscripcion " + cont + " " + s1.getOrigen()+"-"+s1.getDestino());
			cont++;
		}
	}
	
	private static void comprarPasaje(Plataforma p1, Cliente c, ArrayList<Viaje> viajes, Scanner tec) {
		// TODO Auto-generated method stub
		System.out.println("Ingrese el NUMERO del viaje que desea comprar");
		int num = tec.nextInt();
		
		c.sacarPasaje(viajes.get(num));
		System.out.println("COMPRA EXITOSA");
		
		System.out.println("");

	}

	private static Cliente logueo(Plataforma p1, Scanner tec) {
		// TODO Auto-generated method stub
		System.out.println("-> Ingrese su Usuario: ");
		String user = tec.next();
		System.out.println("-> Ingrese su Password");
		String pass = tec.next();
		Cliente c = p1.logueoCliente(user, pass);
		if(c==null) {
			System.out.println("ERROR en Usuario o Password");
		}else {
			System.out.println("Logueo Exitoso");
		}
		return c;
	}



}
