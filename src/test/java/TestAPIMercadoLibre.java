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
import Dominio.Moneda.RepositorioDeMonedas;
import Dominio.Ubicacion.Ciudad;
import Dominio.Ubicacion.Pais;
import Dominio.Ubicacion.Provincia;
import Dominio.Ubicacion.RepositorioDeUbicaciones;

public class TestAPIMercadoLibre {

	@Test()
	public void pesoArgentinoEnColeccion() {
		MonedasMercadoLibre monedasML = MonedasMercadoLibre.instancia();
		RepositorioDeMonedas repoMonedas = new RepositorioDeMonedas(monedasML);
		repoMonedas.monedas.contains("Peso Argentino");
	}

	@Test()
	public void argentinaEnColeccion() {
		UbicacionesMercadoLibre ubicacionesML = UbicacionesMercadoLibre.instancia();
		RepositorioDeUbicaciones repoUbicaciones = new RepositorioDeUbicaciones(ubicacionesML);
		repoUbicaciones.paises.contains("Argentina");
	}

	@Test()
	public void tierraDelFuegoEsProvinciaDeArgentina() {
		UbicacionesMercadoLibre ubicacionesML = UbicacionesMercadoLibre.instancia();
		RepositorioDeUbicaciones repoUbicaciones = new RepositorioDeUbicaciones(ubicacionesML);
		repoUbicaciones.provinciasDeUnPais("AR").contains("Tierra del Fuego");
	}

	@Test()
	public void ushuaiaEsCiudadDeTierraDelFuego() {
		// id Tierra del Fuego: TUxBUFRJRVoxM2M5YQ
		// id Ushuaia: TUxBQ1VTSDQ0ZjFk
		UbicacionesMercadoLibre ubicacionesML = UbicacionesMercadoLibre.instancia();
		RepositorioDeUbicaciones repoUbicaciones = new RepositorioDeUbicaciones(ubicacionesML);
		repoUbicaciones.ciudadesDeUnaProvincia("TUxBUFRJRVoxM2M5YQ").contains("TUxBQ1VTSDQ0ZjFk");
	}
}
