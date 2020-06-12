package Dominio.Usuario;

import java.util.List;

public class ValidadorPasswords {
    private List<ValidarPasswords> validarPasswordsList;

    public ValidadorPasswords(List<ValidarPasswords> validarPasswordsList) {
        this.validarPasswordsList = validarPasswordsList;
    }

    public boolean validarPassword(String password) {
        return validarPasswordsList.stream()
                .allMatch(validadorPasswords->validadorPasswords.validarPassword(password));
    }

    public void agregarValidadorALista(ValidarPasswords validarPasswords) {
        this.validarPasswordsList.add(validarPasswords);
    }

    public List<ValidarPasswords> getValidarPasswordsList() {
        return this.validarPasswordsList;
    }

}
