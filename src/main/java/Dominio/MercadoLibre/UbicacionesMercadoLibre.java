package Dominio.MercadoLibre;

import java.io.IOException;

import Dominio.Ubicacion.ListadoDePaises;
import Dominio.Ubicacion.ServicioDeUbicaciones;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class UbicacionesMercadoLibre {
	private Retrofit retrofit;
	private static UbicacionesMercadoLibre instancia =null; 
// Usamos Singleton para tener solo una instancia de RepositorioDeUbicaciones
	
	//public List<Pais> paises = new ArrayList<Pais>();
	//public ServicioDeUbicaciones servicio;
	
	public static UbicacionesMercadoLibre instancia() {
		if(instancia == null) {
			instancia = new UbicacionesMercadoLibre();
		}
		return instancia;
	}
	
	private UbicacionesMercadoLibre() {
		this.retrofit = new Retrofit.Builder().baseUrl("https://api.mercadolibre.com/classified_locations/")
				.addConverterFactory(GsonConverterFactory.create()).build();
// Builder para Retrofit, luego un Factory para crear el convertirdor de Gson y por ultimo hacemos el build
	}
	
	public ListadoDePaises listadoDePaises() throws IOException {
		ServicioDeUbicaciones servicioML = this.retrofit.create(ServicioDeUbicaciones.class);
		//instanciamos un objeto que implementa la interfaz ServicioPaisesMercadoLibre
		Call<ListadoDePaises> requestPaises = servicioML.paises();
		Response<ListadoDePaises> responsePaises = requestPaises.execute(); //aca se hace el send
		ListadoDePaises listadoDePaises = responsePaises.body();//aca llega el tipo definido en el call de la interfaz
		return listadoDePaises;
	}

}
