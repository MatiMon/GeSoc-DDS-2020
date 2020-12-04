package dominio.modelo.mediosDePago;

public class CantidadIncorrectaDeCaractereresExeption extends RuntimeException {
    public CantidadIncorrectaDeCaractereresExeption(String mensaje) {
        super(mensaje);
    }
}
