package suscripcion;

import java.time.LocalDateTime;

import java.time.temporal.ChronoUnit;

/**
 * La clase Plataforma representa al sistema completo en donde quedan
 * registrados los clientes, el administrador, los viajes que se ofrecen,
 * las localidades disponibles y las suscripciones para los clientes.
 * 
 * @author Lucas
 *
 */
public class Viaje {
	private String origen;
	private String destino;
	private LocalDateTime fechaSalida;
	private LocalDateTime fechaLlegada;
	private String empresa;
	private int tiempoEstimado;
	private int asientosDisponibles;
	private int precio;

	/**
	 * @param origen
	 * @param destino
	 * @param fecha
	 * @param hora_salida
	 * @param hora_llegada
	 * @param empresa
	 * @param tiempoEstimado
	 * @param asientosDisponibles
	 * @param precio
	 */
	public Viaje(String origen, String destino, LocalDateTime fechaSalida, LocalDateTime fechaLlegada, String empresa,
			int tiempoEstimado, int asientosDisponibles, int precio) {
		super();
		this.origen = origen;
		this.destino = destino;
		this.fechaSalida = fechaSalida;
		this.fechaLlegada = fechaLlegada;
		this.empresa = empresa;
		this.tiempoEstimado = tiempoEstimado;
		this.asientosDisponibles = asientosDisponibles;
		this.precio = precio;
	}

	/**
	 * Devuelve el origen del viaje seleccionado.
	 * @return the origen
	 */
	public String getOrigen() {
		return origen;
	}

	/**
	 * Cambia el origen del viaje
	 * @param origen the origen to set
	 */
	public void setOrigen(String origen) {
		this.origen = origen;
	}

	/**
	 * Devuelve el destino del viaje seleccionado.
	 * @return the destino
	 */
	public String getDestino() {
		return destino;
	}

	/**
	 * Cambia el destino del viaje.
	 * @param destino the destino to set
	 */
	public void setDestino(String destino) {
		this.destino = destino;
	}

	/**
	 * Devuelve la fecha de salida del viaje seleccionado.
	 * @return the fechaSalida
	 */
	public LocalDateTime getFechaSalida() {
		return fechaSalida;
	}

	/**
	 * Cambia la fecha de salida del viaje.
	 * @param fechaSalida the fechaSalida to set
	 */
	public void setFechaSalida(LocalDateTime fechaSalida) {
		this.fechaSalida = fechaSalida;
	}

	/**
	 * Devuelve la fecha de llegada del viaje seleccionado.
	 * @return the fechaLlegada
	 */
	public LocalDateTime getFechaLlegada() {
		return fechaLlegada;
	}

	/**
	 * Cambia la fecha de llegada del viaje.
	 * @param fechaLlegada the fechaLlegada to set
	 */
	public void setFechaLlegada(LocalDateTime fechaLlegada) {
		this.fechaLlegada = fechaLlegada;
	}

	/**
	 * Devuelve la empresa que será responsable del viaje.
	 * @return the empresa
	 */
	public String getEmpresa() {
		return empresa;
	}

	/**
	 * Cambia la empresa responsable del viaje.
	 * @param empresa the empresa to set
	 */
	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}

	/**
	 * Devuelve el tiempo estimado de duración del viaje.
	 * @return the tiempoEstimado
	 */
	public int getTiempoEstimado() {
		return tiempoEstimado;
	}

	/**
	 * Cambia el tiempo estimado de duración del viaje.
	 * @param tiempoEstimado the tiempoEstimado to set
	 */
	public void setTiempoEstimado(int tiempoEstimado) {
		this.tiempoEstimado = tiempoEstimado;
	}

	/**
	 * Devuelve la cantidad de asientos disponibles del viaje seleccionado.
	 * @return the asientosDisponibles
	 */
	public int getAsientosDisponibles() {
		return asientosDisponibles;
	}

	/**
	 * Ocupa un asiento del viaje
	 */
	public void ocuparAsiento() {
		this.asientosDisponibles = this.asientosDisponibles - 1;
	}

	/**
	 * Devuelve el precio del viaje seleccionado.
	 * @return the precio
	 */
	public int getPrecio() {
		return precio;
	}

	/**
	 * Cambia el precio del viaje.
	 * @param precio the precio to set
	 */
	public void setPrecio(int precio) {
		this.precio = precio;
	}

	/**
	 * Verifica si el viaje cumple los requerimientos para notificar el viaje improvisado. Si el viaje cumple con la diferencia horaria y la cantidad de asientos dada devuelve true.
	 * 
	 * @param diferenciaHoraria
	 * @param cantidadAsientos
	 * @return boolean
	 */
	public boolean cumpleRequerimiento(long diferenciaHoraria, int cantidadAsientos) {
		LocalDateTime hoy = LocalDateTime.now();
		long horas = ChronoUnit.HOURS.between(hoy, this.fechaSalida);

		if ((horas <= diferenciaHoraria) && (this.asientosDisponibles >= cantidadAsientos)) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Verifica si dos viajes son iguales comparando su origen y su destino.
	 * True==Los viajes son iguales; False==Los viajes no son iguales.
	 * 
	 * @return boolean
	 */
	@Override
	public boolean equals(Object o) {
		Viaje v = (Viaje) o;
		// Para una proxima version se debe comparar horarios y empresa.
		return (v.getOrigen().equals(getOrigen())) && (v.getDestino().equals(getDestino())&&(v.getFechaSalida().equals(getFechaSalida()))&&
				(v.getFechaLlegada().equals(getFechaLlegada())&&(v.getEmpresa().equals(getEmpresa()))));
	}

}
