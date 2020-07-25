package Dominio.MercadoLibre;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import Dominio.MercadoLibre.MonedasMercadoLibre.Currencie;
import Dominio.Moneda.Moneda;
import Dominio.Ubicacion.Ciudad;
import Dominio.Ubicacion.Pais;
import Dominio.Ubicacion.Provincia;
import Dominio.Ubicacion.ServicioUbicaciones;

public class UbicacionesMercadoLibre implements ServicioUbicaciones {
	private Retrofit retrofit;
	private static UbicacionesMercadoLibre instancia =null; 
// Usamos Singleton para tener solo una instancia de RepositorioDeUbicaciones
	
// CLASES MOLDE:
	class PaisService{
		public String id; // Ejemplo de ID: AR
		public String name;
		public String currency_id;
		public boolean esElPaisBuscado(String idPais){
			return idPais == this.id;
		}
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


    @Override
	public Pais getPais(String idPais){
		try {
			List<PaisService> paisesService = this.listadoDePaises();
			int index = -1;
			int bound = paisesService.size();
			for (int i = 0; i < bound; i++) {
				if (paisesService.get(i).id.equals(idPais)) {
					index = i;
					break;
				}
			}
			if ( index != -1){
				return new Pais(paisesService.get(index).name, paisesService.get(index).id);
			}else{
				return null;
			}

		} catch (IOException getPais) {
			getPais.printStackTrace();
			return null;
		}
	}



	@Override
    public List<Pais> getPaises() {
        try {
            List<PaisService> paisesService = this.listadoDePaises();         
            List<Pais> paises = new ArrayList<>();
            paisesService.forEach(paisService -> paises.add(new Pais(paisService.name, paisService.id)));
            return paises;
        } catch (IOException getPaises) {
            getPaises.printStackTrace();
            return null;
        }
    }
	
	@Override
    public List<Provincia> getProvincias(Pais unPais) {
        try {
        	UbicacionesMercadoLibre.ListadoProvinciaService provinciasService = this.listadoDeProvincias(unPais);         
            List<Provincia> provincias = new ArrayList<>();
            provinciasService.states.forEach(provinciaService -> 
            provincias.add(new Provincia(provinciaService.name, provinciaService.id, unPais)));
            return provincias;
        } catch (IOException getProvincias) {
            getProvincias.printStackTrace();
            return null;
        }
    }
	
	@Override
    public List<Ciudad> getCiudades(Provincia unaProvincia) {
        try {
        	UbicacionesMercadoLibre.ListadoCiudadService ciudadesService = this.listadoDeCiudades(unaProvincia);         
            List<Ciudad> ciudades = new ArrayList<>();
            ciudadesService.cities.forEach(ciudadService -> 
            ciudades.add(new Ciudad(ciudadService.name, ciudadService.id, unaProvincia)));
            return ciudades;
        } catch (IOException getCiudades) {
            getCiudades.printStackTrace();
            return null;
        }
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
	
	public UbicacionesMercadoLibre.ListadoProvinciaService listadoDeProvincias(Pais pais) throws IOException{
		ServicioMercadoLibre mercadoLibreService = this.retrofit.create(ServicioMercadoLibre.class);
		Call<UbicacionesMercadoLibre.ListadoProvinciaService> requestProvincias = mercadoLibreService.provincias(pais.getId(), "states");
		Response<UbicacionesMercadoLibre.ListadoProvinciaService> responseProvincias = requestProvincias.execute();
		UbicacionesMercadoLibre.ListadoProvinciaService listadoDeProvincias = responseProvincias.body();
		return listadoDeProvincias;
	}
	
	public UbicacionesMercadoLibre.ListadoCiudadService listadoDeCiudades(Provincia provincia) throws IOException{
		ServicioMercadoLibre mercadoLibreService = this.retrofit.create(ServicioMercadoLibre.class);
		Call<UbicacionesMercadoLibre.ListadoCiudadService> requestCiudades = mercadoLibreService.ciudades(provincia.getId(), "cities");
		Response<UbicacionesMercadoLibre.ListadoCiudadService> responseCiudades = requestCiudades.execute();
		UbicacionesMercadoLibre.ListadoCiudadService listadoDeCiudades = responseCiudades.body();
		return listadoDeCiudades;
	}

}
