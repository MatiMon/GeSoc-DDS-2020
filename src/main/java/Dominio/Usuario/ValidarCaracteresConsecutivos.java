package Dominio.Usuario;

import javax.persistence.DiscriminatorValue;

@DiscriminatorValue("ValidarCaracteresConsecutivos")
public class ValidarCaracteresConsecutivos extends ValidarPasswords {
    @Override
    public boolean validarPassword(String passwordPlana) {
        return !allCharactersSame(passwordPlana);
    }

    @Override
    public String getIdentificador() {
        return "CARACTERES";
    }

    private boolean allCharactersSame(String s) {
        int n = s.length();
        for (int i = 1; i < n; i++)
            if (s.charAt(i) != s.charAt(0))
                return false;
        return true;
    }



}
