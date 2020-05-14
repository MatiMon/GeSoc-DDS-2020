
public class EntidadBase extends Entidad {
	public String nombreFicticio;
	public String descripcion;
	public EntidadJuridica entidadJuridica;

	public EntidadBase(String nombreFicticio, String descripcion, EntidadJuridica entidadJuridica) {
		this.nombreFicticio = nombreFicticio;
		this.descripcion = descripcion;
		this.entidadJuridica = entidadJuridica;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public EntidadJuridica getEntidadJuridica() {
		return entidadJuridica;
	}
	
}
