package dominio.modelo.ubicacion;

import java.util.ArrayList;
import java.util.List;

public class RepositorioDeUbicaciones {
	public List<Pais> paises = new ArrayList<Pais>();
	
	public ServicioUbicaciones servicio;
	
	public RepositorioDeUbicaciones(ServicioUbicaciones servicio) {
		this.servicio = servicio;
	}

	/*
	public List<Provincia> provinciasDeUnPais(String unPais){
		return this.servicio.getProvincias(unPais);
	}
	
	public List<Ciudad> ciudadesDeUnaProvincia(String unaProvincia){
		return this.servicio.getCiudades(unaProvincia);
	}
	*/
	public List<Provincia> provinciasDeUnPais(Pais unPais){
		return this.servicio.getProvincias(unPais);
	}

	public Pais getPais(String idPais){
		return this.servicio.getPais(idPais);
	}

}
