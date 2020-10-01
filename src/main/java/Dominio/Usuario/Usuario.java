package Dominio.Usuario;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

import Dominio.OperacionEgreso.OperacionDeEgreso;
import Persistencia.Persistente;

import javax.persistence.*;

@Entity // TODO: investigar one to many unidireccional o con element collection, para no tener doble referencia.
@Table(name = "usuario")
public class Usuario extends Persistente {
    @Column(name = "nombre_usuario")
    private String nombreUsuario;

    @Embedded
    private PasswordHashedAndSalted passwordHashedAndSalted;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_usuario")
    private TipoUsuario tipoUsuario;

    @Transient
    private ValidadorPasswords validadorPasswords;

    @OneToOne
    private BandejaDeMensajes bandeja;

    public Usuario(String id, String password, TipoUsuario tipoUsuario, ValidadorPasswords validadorPasswords) throws InvalidKeySpecException, NoSuchAlgorithmException {
        this.validadorPasswords = validadorPasswords;
        if (id == null || tipoUsuario == null || password == null) {
            throw new NullEntryException("No se puede instanciar el usuario con valores null");
        }
        if (!validadorPasswords.validarPassword(password)) {
            throw new InvalidPasswordException("password inválida");
        }
        this.nombreUsuario = id;
        this.tipoUsuario = tipoUsuario;
        this.passwordHashedAndSalted = new PasswordHashedAndSalted(password);
        this.bandeja = new BandejaDeMensajes();
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


    public void setId(String id) {
        this.nombreUsuario = id;
    }

    public TipoUsuario getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(TipoUsuario tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    public BandejaDeMensajes getBandeja() {
        return bandeja;
    }

    public void setBandeja(BandejaDeMensajes bandeja) {
        this.bandeja = bandeja;
    }

    public ValidadorPasswords getValidadorPasswords() {
        return validadorPasswords;
    }

    public void altaRevisionOperacion(OperacionDeEgreso operacion) {
        operacion.agregarUsuarioRevisor(this);
    }

    public void notificar(OperacionDeEgreso operacionDeEgreso, boolean validacion) {
        bandeja.agregarMensajeValidacion(operacionDeEgreso, validacion);
    }

    public Usuario() {

    }

}

