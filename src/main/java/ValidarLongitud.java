public class ValidarLongitud implements ValidadorPasswords {
    final int longitudMinima = 4;
    final int longitudMaxima = 64;

    @Override
    public boolean validarPassword(String password) {
        return longitudMinima <= password.length() && password.length() <= longitudMaxima;
    }
}
