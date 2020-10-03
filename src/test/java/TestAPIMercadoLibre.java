import Dominio.MercadoLibre.MonedasMercadoLibre;
import Dominio.MercadoLibre.UbicacionesMercadoLibre;
import Dominio.Moneda.RepositorioDeMonedas;
import Dominio.Ubicacion.RepositorioDeUbicaciones;
import org.junit.Test;

public class TestAPIMercadoLibre {

	@Test()
	public void pesoArgentinoEnColeccion() {
		MonedasMercadoLibre monedasML = MonedasMercadoLibre.instancia();
		RepositorioDeMonedas repoMonedas = new RepositorioDeMonedas(monedasML);
		repoMonedas.monedas.contains("Peso argentino");
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
		//repoUbicaciones.provinciasDeUnPais( repoUbicaciones.getPais("AR") ).contains("Tierra del Fuego");
	}

	@Test()
	public void ushuaiaEsCiudadDeTierraDelFuego() {
		// id Tierra del Fuego: TUxBUFRJRVoxM2M5YQ
		// id Ushuaia: TUxBQ1VTSDQ0ZjFk
		UbicacionesMercadoLibre ubicacionesML = UbicacionesMercadoLibre.instancia();
		RepositorioDeUbicaciones repoUbicaciones = new RepositorioDeUbicaciones(ubicacionesML);
		//repoUbicaciones.ciudadesDeUnaProvincia("TUxBUFRJRVoxM2M5YQ").contains("TUxBQ1VTSDQ0ZjFk");
	}
}
