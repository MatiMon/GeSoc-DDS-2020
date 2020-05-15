package Dominio.Usuario;

public class InvalidFileNameException extends RuntimeException {
    public InvalidFileNameException(String message) {
        super(message);
    }
}
