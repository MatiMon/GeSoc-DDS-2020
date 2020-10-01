package Dominio.Usuario;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Transient;

@DiscriminatorValue("ValidarLongitud")
public class ValidarLongitud extends ValidarPasswords {
    @Transient
    private final int longitudMinima = 4;
    @Transient
    private final int longitudMaxima = 64;

    @Override
    public boolean validarPassword(String password) {
        return longitudMinima <= password.length() && password.length() <= longitudMaxima;
    }

    @Override
    public String getIdentificador() {
        return "LONGITUD";
    }
}
