package suscripcion;

import java.time.LocalDateTime;

import java.time.temporal.ChronoUnit;

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
	 * @return the origen
	 */
	public String getOrigen() {
		return origen;
	}

	/**
	 * @param origen the origen to set
	 */
	public void setOrigen(String origen) {
		this.origen = origen;
	}

	/**
	 * @return the destino
	 */
	public String getDestino() {
		return destino;
	}

	/**
	 * @param destino the destino to set
	 */
	public void setDestino(String destino) {
		this.destino = destino;
	}

	/**
	 * @return the fechaSalida
	 */
	public LocalDateTime getFechaSalida() {
		return fechaSalida;
	}

	/**
	 * @param fechaSalida the fechaSalida to set
	 */
	public void setFechaSalida(LocalDateTime fechaSalida) {
		this.fechaSalida = fechaSalida;
	}

	/**
	 * @return the fechaLlegada
	 */
	public LocalDateTime getFechaLlegada() {
		return fechaLlegada;
	}

	/**
	 * @param fechaLlegada the fechaLlegada to set
	 */
	public void setFechaLlegada(LocalDateTime fechaLlegada) {
		this.fechaLlegada = fechaLlegada;
	}

	/**
	 * @return the empresa
	 */
	public String getEmpresa() {
		return empresa;
	}

	/**
	 * @param empresa the empresa to set
	 */
	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}

	/**
	 * @return the tiempoEstimado
	 */
	public int getTiempoEstimado() {
		return tiempoEstimado;
	}

	/**
	 * @param tiempoEstimado the tiempoEstimado to set
	 */
	public void setTiempoEstimado(int tiempoEstimado) {
		this.tiempoEstimado = tiempoEstimado;
	}

	/**
	 * @return the asientosDisponibles
	 */
	public int getAsientosDisponibles() {
		return asientosDisponibles;
	}

	/**
	 * 
	 */
	public void ocuparAsiento() {
		this.asientosDisponibles = this.asientosDisponibles - 1;
	}

	/**
	 * @return the precio
	 */
	public int getPrecio() {
		return precio;
	}

	/**
	 * @param precio the precio to set
	 */
	public void setPrecio(int precio) {
		this.precio = precio;
	}

	public boolean cumpleRequerimiento(long diferenciaHoraria, int cantidadAsientos) {
		LocalDateTime hoy = LocalDateTime.now();
		long horas = ChronoUnit.HOURS.between(hoy, this.fechaSalida);

		if ((horas <= diferenciaHoraria) && (this.asientosDisponibles >= cantidadAsientos)) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean equals(Object o) {
		Viaje v = (Viaje) o;
		// Para una proxima version se debe comparar horarios y empresa.
		return (v.getOrigen().equals(getOrigen())) && (v.getDestino().equals(getDestino())&&(v.getFechaSalida().equals(getFechaSalida()))&&
				(v.getFechaLlegada().equals(getFechaLlegada())&&(v.getEmpresa().equals(getEmpresa()))));
	}

}
