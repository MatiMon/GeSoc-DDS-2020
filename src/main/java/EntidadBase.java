
<<<<<<< HEAD
public class EntidadBase implements Entidad {
	public String nombreFicticio;
=======
public class EntidadBase extends Entidad {
>>>>>>> 01b643bc4677ccc39c91ef16a9820d225a49ca80
	public String descripcion;
	public EntidadJuridica entidadJuridica;

	// Constructor
	public EntidadBase(String nombreFicticio, String descripcion, EntidadJuridica entidadJuridica) {
		this.nombreFicticio = nombreFicticio;
		this.descripcion = descripcion;
		this.entidadJuridica = entidadJuridica;
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
