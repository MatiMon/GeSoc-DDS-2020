import java.util.List;

public class Usuario {
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

