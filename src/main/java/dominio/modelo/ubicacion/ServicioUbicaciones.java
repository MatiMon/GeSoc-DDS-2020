package dominio.modelo.ubicacion;

import java.util.List;

public interface ServicioUbicaciones {
	List<Pais> getPaises();
//	List<Provincia> getProvincias(String pais);
//	List<Ciudad> getCiudades(String provincia);

    List<Provincia> getProvincias(Pais pais);
	List<Ciudad> getCiudades(Provincia provincia);

	Pais getPais(String idPais);
}
