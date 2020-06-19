package Dominio.MercadoLibre;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

import java.util.List;

public interface ServicioMercadoLibre {//interfaz que hara uso de retrofit para usar el servicio
	
//Obtenemos el listado de monedas
    @GET("currencies")
    Call<List<MonedasMercadoLibre.Currencie>> monedas();
    
//Obtenemos el listado de paises
  	@GET("countries")
  	Call<List<PaisService>> paises();
  	
//Obtenemos el listado de provincias de un pais
  	@GET("countries/{id}")
  	Call<UbicacionesMercadoLibre.ListadoProvinciaService> provincias(
  			@Path("id") String idPaisService,
  			@Query("attributes") String states);

//Obtenemos el listado de ciudades de una provincia
  	@GET("states/{id}")
  	Call<UbicacionesMercadoLibre.ListadoCiudadService> ciudades(
  			@Path("id") String idProvinciaService,
  			@Query("attributes") String cities);
}
