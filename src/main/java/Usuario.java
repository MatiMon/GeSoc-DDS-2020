import java.util.List;
import org.xipki.password.PasswordBasedEncryption;

public class Usuario {
    String id;
    String password;
    TipoUsuario tipoUsuario;
    List<ValidadorPasswords> validadorPasswordsList;
    public Usuario(String id, String password, TipoUsuario tipoUsuario, List<ValidadorPasswords> validadorPasswordsList) {
        //TODO: agregar excepciones, validacion de passwords y hash n salt
        if(id == null){
            //ex
        }
        if(tipoUsuario == null){
            //ex
        }
        if(validadorPasswordsList == null || validadorPasswordsList.isEmpty()){
            //ex
        }
        if(password == null){
            //ex
        }
        if(true){
            //ex
        }
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


}

