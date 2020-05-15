package Dominio.Entidad;

public class Empresa implements TipoEntidadJuridica {
	ClasificacionAfip clasificacion;

	// Constructor
	public Empresa(ClasificacionAfip clasificacion) {
		this.clasificacion = clasificacion;
	}

	// Getter
	public ClasificacionAfip getClasificacion() {
		return clasificacion;
	}	

}
