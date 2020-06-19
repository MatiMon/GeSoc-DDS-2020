package Dominio.MercadoLibre;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ServicioUbicacionesMercadoLibre { // interfaz que hara uso de retrofit para usar el servicio
	
	//Obtenemos el listado de paises
	@GET("countries")
	Call<List<PaisService>> paises();
	
	//Obtenemos el listado de provincias de un pais
	@GET("countries/{id}")
	Call<UbicacionesMercadoLibre.ListadoProvinciaService> provincias(
			@Path("id") String idPaisService,
			@Query("attributes") String states);


}
