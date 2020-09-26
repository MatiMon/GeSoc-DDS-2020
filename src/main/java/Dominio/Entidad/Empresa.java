package Dominio.Entidad;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;

@DiscriminatorValue("E")
public class Empresa extends TipoEntidadJuridica {
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
