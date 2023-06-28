package suscripcion;

/**
 * Persona representa a una persona de la vida real 
 * Será abstracta para poder crear tipos distintos de personas.
 * 
 * @author Eliseo
 *
 */

public abstract class Persona {
	private String nombre;
	private String apellido;
	private String dni;
	private String contrasenia;
	private boolean logueado;

	/**
	 * Crea un tipo de persona recibiendo nombre, apellido, dni, contrasenia
	 * 
	 * @param nombre
	 * @param apellido
	 * @param dni
	 * @param contrasenia
	 */
	public Persona(String nombre, String apellido, String dni, String contrasenia) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
		this.contrasenia = contrasenia;
		this.logueado = false;
	}

	// GETTERS Y SETTERS
	/**
	 * Devuelve el nombre de la persona seleccionada.
	 * 
	 * @return el nombre de la persona.
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Cambia el nombre de la persona.
	 * 
	 * @param nombre será el nuevo nombre que asignaremos.
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Devuelve el apellido de la persona seleccionada.
	 * 
	 * @return el apellido de la persona.
	 */
	public String getApellido() {
		return apellido;
	}

	/**
	 * Cambia el apellido de la persona seleccionada.
	 * 
	 * @param apellido será el nuevo apellido que asignaremos.
	 */
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	/**
	 * Devuelve el dni de la persona seleccionada.
	 * 
	 * @return el dni de la persona.
	 */
	public String getDni() {
		return dni;
	}

	/**
	 * Cambia el dni de la persona seleccionada.
	 * 
	 * @param dni será el nuevo dni que asignaremos.
	 */
	public void setDni(String dni) {
		this.dni = dni;
	}

	/**
	 * Devuelve la contrasenia de la persona seleccionada.
	 * 
	 * @return la contrasenia con la cual la persona fue registrada.
	 */
	public String getContrasenia() {
		return contrasenia;
	}

	/**
	 * Cambia la contrasenia de la persona seleccionada
	 * 
	 * @param contrasenia será la nueva contrasenia que utilizará para loguearse.
	 */
	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}

	/**
	 * Devuelve true si la persona se encuentra logueada o false si no se encuentra
	 * logueada.
	 * 
	 * @return true == logueada; false == not logueada.
	 */
	public boolean isLogueado() {
		return logueado;
	}

	/**
	 * Cambia el estado de una persona en la plataforma.
	 * 
	 * @param logueado variará en true o false, y será el nuevo estado de la
	 *                 persona.
	 */
	public void setLogueado(boolean logueado) {
		this.logueado = logueado;
	}

	/**
	 * Devuelve el usuario con el que la persona se registró, es abstracto por lo
	 * tanto depende de la implementacion de las subclases.
	 * 
	 * @return el usuario con el que se registró la persona en la plataforma.
	 */
	public abstract String getUsuario();

}
