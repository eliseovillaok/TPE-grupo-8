package suscripcion;

public abstract class Persona {
	private String nombre;
	private String apellido;
	private String dni;
	private String contrasenia;
	private boolean logueado;
	
	public Persona(String nombre, String apellido, String dni, String contrasenia) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
		this.contrasenia = contrasenia;
		this.logueado = false;
	}
	// GETTERS Y SETTERS
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public String getContrasenia() {
		return contrasenia;
	}
	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}
	public boolean isLogueado() {
		return logueado;
	}
	public void setLogueado(boolean logueado) {
		this.logueado = logueado;
	}

	
	// Metodo abstracto
	public abstract String getUsuario();
	
}
