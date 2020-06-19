package Dominio.Ubicacion;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ServicioDeUbicaciones {
	//obtenerCiudad(calle, numero, codPostal)
	//obtenerProvincia(calle, numero, codPostal)
	//obtenerPais(calle, numero, codPostal)
	
	@GET("countries")
	Call<ListadoDePaises> paises();


}
