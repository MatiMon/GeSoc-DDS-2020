import static org.junit.Assert.assertEquals;

import java.time.LocalDateTime;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import Dominio.MediosDePago.HayCaracteresNoNumericosEnLosNumerosDeLaTarjetaExeption;
import Dominio.MediosDePago.Tarjeta;
import Dominio.MediosDePago.TipoTarjeta;
import Dominio.MercadoLibre.MonedasMercadoLibre;
import Dominio.MercadoLibre.UbicacionesMercadoLibre;
import Dominio.Moneda.Moneda;
import Dominio.Ubicacion.Ciudad;
import Dominio.Ubicacion.Pais;
import Dominio.Ubicacion.Provincia;
import Dominio.Ubicacion.RepositorioDeUbicaciones;

public class TestAPIMercadoLibre {
	
	 /*@Before
	    public void init() {
		MonedasMercadoLibre monedasML = MonedasMercadoLibre.instancia();
		List<Moneda> listadoMonedas = monedasML.getMonedas();
		
		RepositorioDeUbicaciones repoUbicaciones = new RepositorioDeUbicaciones();
		UbicacionesMercadoLibre ubicacionesML = UbicacionesMercadoLibre.instancia();
		List<Pais> listadoPaises = ubicacionesML.getPaises();
		List<Provincia> listadoProvinciasArgentinas = ubicacionesML.getProvincias("AR");
		List<Ciudad> listadoCiudadesUshuaia = ubicacionesML.getCiudades("TUxBUFRJRVoxM2M5YQ");
		}*/
	 
	 @Test()
	    public void tierraDelFuegoEsProvinciaDeArgentina() {
		 UbicacionesMercadoLibre ubicacionesML = UbicacionesMercadoLibre.instancia();
		 RepositorioDeUbicaciones repoUbicaciones = new RepositorioDeUbicaciones(ubicacionesML);
	     assertEquals(repoUbicaciones.provinciasDeUnPais("AR").contains("Tierra del Fuego"), true);
	    }
	 
	 @Test()
	    public void ushuaiaEsCiudadDeTierraDelFuego() {
		 UbicacionesMercadoLibre ubicacionesML = UbicacionesMercadoLibre.instancia();
		 RepositorioDeUbicaciones repoUbicaciones = new RepositorioDeUbicaciones(ubicacionesML);
	     assertEquals(repoUbicaciones.ciudadesDeUnaProvincia("Tierra del Fuego").contains("TUxBUFRJRVoxM2M5YQ"), true);
	    }
	

}
