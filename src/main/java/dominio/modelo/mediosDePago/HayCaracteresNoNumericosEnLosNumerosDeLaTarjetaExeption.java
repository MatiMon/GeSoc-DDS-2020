package dominio.modelo.mediosDePago;

public class HayCaracteresNoNumericosEnLosNumerosDeLaTarjetaExeption extends RuntimeException {
    public HayCaracteresNoNumericosEnLosNumerosDeLaTarjetaExeption(String mensaje){
        super(mensaje);
    }
}
