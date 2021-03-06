package dominio.modelo.usuario;

import db.Persistente;
import dominio.modelo.operacionEgreso.OperacionDeEgreso;

import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

@Entity
@Table(name = "mensaje")
public class Mensaje extends Persistente {

    @Column(name = "fecha_y_hora")
    private LocalDateTime fechaYHora;

    private String descripcion;

    private boolean leido;

    @Transient
    private String fechaString;

    @ManyToOne
    @JoinColumn(name = "usuario_id", referencedColumnName = "id")
    private Usuario usuario;

    public LocalDateTime getFechaYHora() {
        return fechaYHora;
    }

    public void setFechaYHora() {
        this.fechaYHora = LocalDateTime.now();
    }

    public boolean getLeido() {
        return leido;
    }

    public void setLeido(boolean leido) {
        this.leido = leido;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Mensaje crearMensajeValidacion(OperacionDeEgreso operacion, boolean validacion) {
        this.fechaYHora = LocalDateTime.now();
        this.leido = false;
        if (validacion) {
            this.descripcion = "La operación número " + operacion.getId().toString() +
                    " de " + operacion.getEntidad().getNombreFicticio() + " fue validada.";
        } else {
            this.descripcion = "La operación número " + operacion.getId().toString() +
                    " de " + operacion.getEntidad().getNombreFicticio() + " NO fue validada.";
        }

        return this;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getFechaString(){
        return fechaYHora.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
    }


}