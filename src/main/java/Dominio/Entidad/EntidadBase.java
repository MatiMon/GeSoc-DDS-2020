package Dominio.Entidad;

public class EntidadBase implements Entidad {
	public String nombreFicticio;
	public String descripcion;
	public EntidadJuridica entidadJuridica;

	
	// Constructor
	public EntidadBase(String nombreFicticio, String descripcion, EntidadJuridica entidadJuridica) {
		this.nombreFicticio = nombreFicticio;
		this.descripcion = descripcion;
		this.entidadJuridica = entidadJuridica;
		entidadJuridica.agregarEntidadBase(this);
	}

	// Getters
	public String getDescripcion() {
		return descripcion;
	}
	public EntidadJuridica getEntidadJuridica() {
		return entidadJuridica;
	}
	public String getNombreFicticio() {
		return nombreFicticio;
	}
	
	// Setter
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	
}
