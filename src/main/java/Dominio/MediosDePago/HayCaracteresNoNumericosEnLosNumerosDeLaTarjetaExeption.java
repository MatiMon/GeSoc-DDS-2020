package Dominio.MediosDePago;

public class HayCaracteresNoNumericosEnLosNumerosDeLaTarjetaExeption extends RuntimeException {
    public HayCaracteresNoNumericosEnLosNumerosDeLaTarjetaExeption(String mensaje){
        super(mensaje);
    }
}
