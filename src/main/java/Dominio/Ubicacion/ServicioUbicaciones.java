package Dominio.Ubicacion;

import java.util.List;

public interface ServicioUbicaciones {
	List<Pais> getPaises();
	List<Provincia> getProvincias(String pais);
	List<Ciudad> getCiudades(String provincia);

}
