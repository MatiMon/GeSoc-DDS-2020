package Dominio.MercadoLibre;

import retrofit2.Call;
import retrofit2.http.GET;
import java.util.List;

public interface ServicioMercadoLibre {
    @GET("currencies")
    Call<List<MonedasMercadoLibre.Currencie>> monedas();
}
