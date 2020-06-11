package Dominio.Usuario;

import java.util.ArrayList;

public class ValidadorPasswords {
    ArrayList<ValidarPasswords> validarPasswordsList;

    public ValidadorPasswords(ArrayList<ValidarPasswords> validarPasswordsList) {
        this.validarPasswordsList = validarPasswordsList;
    }

    public boolean validarPassword(String password) {
        return validarPasswordsList.stream()
                .allMatch(validadorPasswords->validadorPasswords.validarPassword(password));
    }

    public void agregarValidadorALista(ValidarPasswords validarPasswords) {
        this.validarPasswordsList.add(validarPasswords);
    }

    public ArrayList<ValidarPasswords> getValidarPasswordsList() {
        return this.validarPasswordsList;
    }

}
