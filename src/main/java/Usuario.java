import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.ArrayList;

public class Usuario {
    String id;
    PasswordHashedAndSalted passwordHashedAndSalted;
    TipoUsuario tipoUsuario;
    ArrayList<ValidadorPasswords> validadorPasswordsList;

    public Usuario(String id, String password, TipoUsuario tipoUsuario, ArrayList<ValidadorPasswords> validadorPasswordsList) throws InvalidKeySpecException, NoSuchAlgorithmException {
        if (id == null) {
            throw new NullIdException("id no puede ser null");
        }
        if (tipoUsuario == null) {
            throw new NullUsuarioException("tipoUsuario no puede ser null");
        }
        if (validadorPasswordsList == null || validadorPasswordsList.isEmpty()) {
            throw new NullOrEmptyListException("lista vacía o null");
        }
        if (password == null) {
            throw new NullPasswordException("password no puede ser null");
        }
        if (!validarPassword(password, validadorPasswordsList)) {
            throw new InvalidPasswordException("password inválida");
        }

        this.id = id;
        this.tipoUsuario = tipoUsuario;
        this.validadorPasswordsList = validadorPasswordsList;
        this.passwordHashedAndSalted = new PasswordHashedAndSalted(password);
    }

    public boolean validarPassword(String unaPassword, ArrayList<ValidadorPasswords> validadorPasswordsList) {
        for (ValidadorPasswords validadorPasswords : validadorPasswordsList) {
            if (!validadorPasswords.validarPassword(unaPassword)) {
                return false;
            }
        }
        return true;
    }

    public void actualizarContrasenia(String password) throws InvalidKeySpecException, NoSuchAlgorithmException {
        if (!validarPassword(password, this.validadorPasswordsList)) {
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


}

