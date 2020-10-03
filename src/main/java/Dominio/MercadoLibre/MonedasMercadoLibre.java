package Dominio.MercadoLibre;

import Dominio.Moneda.Moneda;
import Dominio.Moneda.ServicioDeMonedas;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MonedasMercadoLibre implements ServicioDeMonedas {

    private static MonedasMercadoLibre instancia = null;
    private Retrofit retrofit;

    class Currencie {
        String id;
        String symbol;
        String description;
    }

    @Override
    public List<Moneda> getMonedas() {
        try {
            List<Currencie> currencies = this.currencies();
            List<Moneda> monedas = new ArrayList<>();
            currencies.forEach(currencie -> monedas.add(new Moneda(currencie.id,currencie.symbol,currencie.description)));
            return monedas;
        } catch (IOException getCurrencies) {
            getCurrencies.printStackTrace();
            return null;
        }
    }

    public List<Currencie> currencies() throws IOException {
        ServicioMercadoLibre service = this.retrofit.create(ServicioMercadoLibre.class);
        Call<List<Currencie>> requestCurrencies = service.monedas();
        Response<List<Currencie>> responceCurrencies = requestCurrencies.execute();
        return responceCurrencies.body();
    }

    public static MonedasMercadoLibre instancia(){
        if(instancia== null) instancia = new MonedasMercadoLibre();
        return instancia;
    }

    private MonedasMercadoLibre() {
        this.retrofit = new Retrofit.Builder()
                .baseUrl("https://api.mercadolibre.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }
}
