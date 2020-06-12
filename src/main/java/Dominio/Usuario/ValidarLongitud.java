package Dominio.Usuario;

public class ValidarLongitud implements ValidarPasswords {
    private final int longitudMinima = 4;
    private final int longitudMaxima = 64;

    @Override
    public boolean validarPassword(String password) {
        return longitudMinima <= password.length() && password.length() <= longitudMaxima;
    }
}
