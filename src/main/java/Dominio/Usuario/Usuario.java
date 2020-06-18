package Dominio.Usuario;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

public class Usuario {
    private String id;
    private PasswordHashedAndSalted passwordHashedAndSalted;
    private TipoUsuario tipoUsuario;
    private ValidadorPasswords validadorPasswords;

    public Usuario(String id, String password, TipoUsuario tipoUsuario, ValidadorPasswords validadorPasswords) throws InvalidKeySpecException, NoSuchAlgorithmException {
        this.validadorPasswords = validadorPasswords;
        if (id == null || tipoUsuario == null || password == null) {
            throw new NullEntryException("No se puede instanciar el usuario con valores null");
        }
        if (!validadorPasswords.validarPassword(password)) {
            throw new InvalidPasswordException("password inválida");
        }
        this.id = id;
        this.tipoUsuario = tipoUsuario;
        this.passwordHashedAndSalted = new PasswordHashedAndSalted(password);
    }

    public void actualizarContrasenia(String password) throws InvalidKeySpecException, NoSuchAlgorithmException {
        if (!this.validadorPasswords.validarPassword(password)) {
            throw new InvalidPasswordException("password inválida");
        }
        this.passwordHashedAndSalted = new PasswordHashedAndSalted(password);
    }

    public boolean autorizarPassword(String password) throws InvalidKeySpecException, NoSuchAlgorithmException {
        return passwordHashedAndSalted.hashMatch(password);
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

    public ValidadorPasswords getValidadorPasswords() {
        return validadorPasswords;
    }

}

