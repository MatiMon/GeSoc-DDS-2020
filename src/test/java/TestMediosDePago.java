import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

public class TestMediosDePago {

    Tarjeta unaTarjeta;

    @Before
    public void init() {
        unaTarjeta = new Tarjeta(
                    TipoTarjeta.tarjetaCredito,
                "1010202030304040",
                "123",
                "Juan Perez",
                new java.util.Date(2020,7,1),
                new BigDecimal(20000));

    }

    @Test
    public void siLaTarjetaNoEstaVencidaPeroSuperaElLimiteNoSePuedePagar(){
        Assert.assertEquals(
                unaTarjeta.puedePagarse(new BigDecimal(800000), new java.util.Date(2020,01,01)),
                false
        );
    }

    @Test
    public void siLaTarjetaEstaVencidaYNoSuperaElLimiteNoSePuedePagar(){
        Assert.assertEquals(
                unaTarjeta.puedePagarse(new BigDecimal(800), new java.util.Date(2021,01,01)),
                false
        );
    }

    @Test
    public void siLaTarjetaNoEstaVencidaYNoSuperaElLimiteSePuedePagar(){
        Assert.assertEquals(
                unaTarjeta.puedePagarse(new BigDecimal(800), new java.util.Date(2020,1,1)),
                true
        );
    }

    @Test
    public void siEsElDiaQueVenceLaTarjetaYNoSuperaElLimiteSePuedePagar(){
        Assert.assertEquals(
                unaTarjeta.puedePagarse(new BigDecimal(800), new java.util.Date(2020,7,1)),
                true
        );
    }

    @Test(expected = HayCaracteresNoNumericosEnLosNumerosDeLaTarjetaExeption.class)
    public void noPuedoCrearUnaTarjetaConLetrasEnELCodigoDeSeguridad(){
        Tarjeta unaTarjetaConLetras = new Tarjeta(
                TipoTarjeta.tarjetaDebito,
                "5555666677778888",
                "14K",
                "Raul Gimenez",
                new java.util.Date(2020,12,9),
                new BigDecimal(20000)
        );
    }

    @Test(expected = HayCaracteresNoNumericosEnLosNumerosDeLaTarjetaExeption.class)
    public void noPuedoCrearUnaTarjetaConLetrasEnELNroDeTarjeta(){
        Tarjeta unaTarjetaConLetras = new Tarjeta(
                TipoTarjeta.tarjetaDebito,
                "abcd666677778888",
                "145",
                "Raul Gimenez",
                new java.util.Date(2020,12,9),
                new BigDecimal(20000)
        );
    }
    @Test(expected = CantidadIncorrectaDeCaractereresExeption.class)
    public void noPuedoCrearUnaTarjetaConMasDe16Numeros(){
        Tarjeta unaTarjetaConLetras = new Tarjeta(
                TipoTarjeta.tarjetaDebito,
                "55556666777788889",
                "145",
                "Raul Gimenez",
                new java.util.Date(2020,12,9),
                new BigDecimal(20000)
        );
    }

    @Test(expected = CantidadIncorrectaDeCaractereresExeption.class)
    public void noPuedoCrearUnaTarjetaConMasDe3digitosDeCodigoDeSeguridad(){
        Tarjeta unaTarjetaConLetras = new Tarjeta(
                TipoTarjeta.tarjetaDebito,
                "5555666677778888",
                "1454",
                "Raul Gimenez",
                new java.util.Date(2020,12,9),
                new BigDecimal(20000)
        );
    }

    @Test(expected = CantidadIncorrectaDeCaractereresExeption.class)
    public void noPuedoCrearUnaTarjetaConMenosDe3digitosDeCodigoDeSeguridad(){
        Tarjeta unaTarjetaConLetras = new Tarjeta(
                TipoTarjeta.tarjetaDebito,
                "5555666677778888",
                "14",
                "Raul Gimenez",
                new java.util.Date(2020,12,9),
                new BigDecimal(20000)
        );
    }

    @Test(expected = CantidadIncorrectaDeCaractereresExeption.class)
    public void noPuedoCrearUnaTarjetaConMenosDe16DigitosDeNumeroDeTarjeta(){
        Tarjeta unaTarjetaConLetras = new Tarjeta(
                TipoTarjeta.tarjetaDebito,
                "555",
                "145",
                "Raul Gimenez",
                new java.util.Date(2020,12,9),
                new BigDecimal(20000)
        );
    }

    @Test
    public void siemprePuedoPagarEnEfectivo(){
        Efectivo unMedioDePagoEnEfectivo = new Efectivo("abcd4567");

        Assert.assertEquals(
                unMedioDePagoEnEfectivo.puedePagarse(new BigDecimal(100000000),new java.util.Date(2020,10,9))
                ,true
        );
    }
}
