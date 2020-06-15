import Dominio.MediosDePago.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDateTime;

public class TestMediosDePago {

    Tarjeta unaTarjeta;

    @Before
    public void init() {
        unaTarjeta = new Tarjeta(
                    TipoTarjeta.tarjetaCredito,
                "1010202030304040",
                "Juan Perez",
                LocalDateTime.parse("2030-12-01T23:59")
        );
    }


    @Test(expected = HayCaracteresNoNumericosEnLosNumerosDeLaTarjetaExeption.class)
    public void noPuedoCrearUnaTarjetaConLetrasEnELNroDeTarjeta(){
        Tarjeta unaTarjetaConLetras = new Tarjeta(
                TipoTarjeta.tarjetaDebito,
                "abcd666677778888",
                "Raul Gimenez",
                LocalDateTime.parse("2030-12-01T23:59")
        );
    }
    @Test(expected = CantidadIncorrectaDeCaractereresExeption.class)
    public void noPuedoCrearUnaTarjetaConMasDe16Numeros(){
        Tarjeta unaTarjetaConLetras = new Tarjeta(
                TipoTarjeta.tarjetaDebito,
                "55556666777788889",
                "Raul Gimenez",
                LocalDateTime.parse("2030-12-01T23:59")
        );
    }



    @Test(expected = CantidadIncorrectaDeCaractereresExeption.class)
    public void noPuedoCrearUnaTarjetaConMenosDe16DigitosDeNumeroDeTarjeta(){
        Tarjeta unaTarjetaConLetras = new Tarjeta(
                TipoTarjeta.tarjetaDebito,
                "555",
                "Raul Gimenez",
                LocalDateTime.parse("2030-12-01T23:59")

        );
    }
}

