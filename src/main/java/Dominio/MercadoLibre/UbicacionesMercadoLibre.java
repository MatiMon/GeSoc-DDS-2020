package Dominio.MercadoLibre;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import java.io.IOException;
import java.util.List;

public class UbicacionesMercadoLibre {
	private Retrofit retrofit;
	private static UbicacionesMercadoLibre instancia =null; 
// Usamos Singleton para tener solo una instancia de RepositorioDeUbicaciones
	
	class PaisService{
		public String id; // Ejemplo de ID: AR
		public String name;
		public String currency_id;
	}
	
	class ProvinciaService {
		public String id; // Ejemplo de ID: AR-BS_AS
		public String name;
    }
	
	class ListadoProvinciaService {
		public List<ProvinciaService> states;
    }
	
	class CiudadService {
		public String name;
		public String id;
    }
	
	class ListadoCiudadService {
		public List<CiudadService> cities;
    }
	
	
	private UbicacionesMercadoLibre() {
		this.retrofit = new Retrofit.Builder().baseUrl("https://api.mercadolibre.com/classified_locations/")
				.addConverterFactory(GsonConverterFactory.create()).build();
// Builder para Retrofit, luego un Factory para crear el convertirdor de Gson y por ultimo hacemos el build
	}
	
	public static UbicacionesMercadoLibre instancia() {
		if(instancia == null) {
			instancia = new UbicacionesMercadoLibre();
		}
		return instancia;
	}
	
	public List<PaisService> listadoDePaises() throws IOException {
		ServicioMercadoLibre mercadoLibreService = this.retrofit.create(ServicioMercadoLibre.class);
		//instanciamos un objeto que implementa la interfaz ServicioPaisesMercadoLibre
		Call<List<PaisService>> requestPaises = mercadoLibreService.paises();
		Response<List<PaisService>> responsePaises = requestPaises.execute(); //aca se hace el send
		List<PaisService> listadoDePaises = responsePaises.body();//aca llega el tipo definido en el call de la interfaz
		return listadoDePaises;
	}
	
	public UbicacionesMercadoLibre.ListadoProvinciaService listadoDeProvincias(String idPaisService) throws IOException{
		ServicioMercadoLibre mercadoLibreService = this.retrofit.create(ServicioMercadoLibre.class);
		Call<UbicacionesMercadoLibre.ListadoProvinciaService> requestProvincias = mercadoLibreService.provincias(idPaisService, "states");
		Response<UbicacionesMercadoLibre.ListadoProvinciaService> responseProvincias = requestProvincias.execute();
		UbicacionesMercadoLibre.ListadoProvinciaService listadoDeProvincias = responseProvincias.body();
		return listadoDeProvincias;
	}
	
	public UbicacionesMercadoLibre.ListadoCiudadService listadoDeCiudades(String idCiudadService) throws IOException{
		ServicioMercadoLibre mercadoLibreService = this.retrofit.create(ServicioMercadoLibre.class);
		Call<UbicacionesMercadoLibre.ListadoCiudadService> requestCiudades = mercadoLibreService.ciudades(idCiudadService, "cities");
		Response<UbicacionesMercadoLibre.ListadoCiudadService> responseCiudades = requestCiudades.execute();
		UbicacionesMercadoLibre.ListadoCiudadService listadoDeCiudades = responseCiudades.body();
		return listadoDeCiudades;
	}

}
