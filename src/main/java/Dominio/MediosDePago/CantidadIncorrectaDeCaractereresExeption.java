package Dominio.MediosDePago;

public class CantidadIncorrectaDeCaractereresExeption extends RuntimeException {
    public CantidadIncorrectaDeCaractereresExeption(String mensaje) {
        super(mensaje);
    }
}
