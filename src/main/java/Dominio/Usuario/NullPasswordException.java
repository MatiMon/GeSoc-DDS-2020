package Dominio.Usuario;

public class NullPasswordException extends RuntimeException {
    public NullPasswordException(String message) {
        super(message);
    }
}