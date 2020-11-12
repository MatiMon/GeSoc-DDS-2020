package dominio;

import dominio.modelo.mediosDePago.CantidadIncorrectaDeCaractereresExeption;
import dominio.modelo.mediosDePago.HayCaracteresNoNumericosEnLosNumerosDeLaTarjetaExeption;
import dominio.modelo.mediosDePago.Tarjeta;
import dominio.modelo.mediosDePago.TipoTarjeta;
import org.junit.Before;
import org.junit.Test;

import java.util.Date;

public class TestMediosDePago {

    Tarjeta unaTarjeta;

    @Before
    public void init() {
        unaTarjeta = new Tarjeta(
                TipoTarjeta.tarjetaCredito,
                "1010202030304040",
                "Juan Perez",
                new Date()
        );
    }


    @Test(expected = HayCaracteresNoNumericosEnLosNumerosDeLaTarjetaExeption.class)
    public void noPuedoCrearUnaTarjetaConLetrasEnELNroDeTarjeta() {
        Tarjeta unaTarjetaConLetras = new Tarjeta(
                TipoTarjeta.tarjetaDebito,
                "abcd666677778888",
                "Raul Gimenez",
                new Date()
        );
    }

    @Test(expected = CantidadIncorrectaDeCaractereresExeption.class)
    public void noPuedoCrearUnaTarjetaConMasDe16Numeros() {
        Tarjeta unaTarjetaConLetras = new Tarjeta(
                TipoTarjeta.tarjetaDebito,
                "55556666777788889",
                "Raul Gimenez",
                new Date()
        );
    }

    @Test(expected = CantidadIncorrectaDeCaractereresExeption.class)
    public void noPuedoCrearUnaTarjetaConMenosDe16DigitosDeNumeroDeTarjeta() {
        Tarjeta unaTarjetaConLetras = new Tarjeta(
                TipoTarjeta.tarjetaDebito,
                "555",
                "Raul Gimenez",
                new Date()
        );
    }
}

