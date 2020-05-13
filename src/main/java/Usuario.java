import java.util.List;
import org.xipki.password.PasswordBasedEncryption;

public class Usuario {
    public Usuario(String id, String password, TipoUsuario tipoUsuario, List<ValidadorPasswords> validadorPasswordsList) {
        this.id = id;
        this.password = password;
        this.tipoUsuario = tipoUsuario;
        this.validadorPasswordsList = validadorPasswordsList;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public TipoUsuario getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(TipoUsuario tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    public List<ValidadorPasswords> getValidadorPasswordsList() {
        return validadorPasswordsList;
    }

    public void setValidadorPasswordsList(List<ValidadorPasswords> validadorPasswordsList) {
        this.validadorPasswordsList = validadorPasswordsList;
    }

    String id;
    String password;
    TipoUsuario tipoUsuario;
    List<ValidadorPasswords> validadorPasswordsList;
}

