package Dominio.Usuario;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.ArrayList;

public class Usuario {
    String id;
    PasswordHashedAndSalted passwordHashedAndSalted;
    TipoUsuario tipoUsuario;
    ArrayList<ValidadorPasswords> validadorPasswordsList;

    public Usuario(String id, String password, TipoUsuario tipoUsuario, ArrayList<ValidadorPasswords> validadorPasswordsList) throws InvalidKeySpecException, NoSuchAlgorithmException {
        this.validadorPasswordsList = validadorPasswordsList;
        if (id == null || tipoUsuario == null || validadorPasswordsList == null || validadorPasswordsList.isEmpty()|| password == null) {
            throw new NullEntryException("No se puede instanciar el usuario con valores null");
        }
        if (!validarPassword(password)) {
            throw new InvalidPasswordException("password inválida");
        }
        this.id = id;
        this.tipoUsuario = tipoUsuario;
        this.passwordHashedAndSalted = new PasswordHashedAndSalted(password);
    }

    public boolean validarPassword(String password) {
        return validadorPasswordsList.stream()
                .allMatch(validadorPasswords->validadorPasswords.validarPassword(password));
    }

    public void actualizarContrasenia(String password) throws InvalidKeySpecException, NoSuchAlgorithmException {
        if (!validarPassword(password)) {
            throw new InvalidPasswordException("password inválida");
        }
        this.passwordHashedAndSalted = new PasswordHashedAndSalted(password);
    }

    public boolean autorizarPassword(String password) throws InvalidKeySpecException, NoSuchAlgorithmException {
        return passwordHashedAndSalted.hashMatch(password);
    }

    public void agregarValidadorALista(ValidadorPasswords validadorPasswords) {
        this.validadorPasswordsList.add(validadorPasswords);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public TipoUsuario getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(TipoUsuario tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    public ArrayList<ValidadorPasswords> getValidadorPasswordsList() {
        return this.validadorPasswordsList;
    }
}

