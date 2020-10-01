package Dominio.Usuario;

import Dominio.OperacionEgreso.Item;
import Dominio.OperacionEgreso.OperacionDeEgreso;
import Dominio.Presupuesto.Presupuesto;
import Persistencia.Persistente;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "mensaje")
public class Mensaje extends Persistente {

    @Column(name = "fecha_y_hora")
    private LocalDateTime fechaYHora;

    private String descripcion;

    private boolean leido;

    @ManyToOne
    @JoinColumn(name = "usuario_id", referencedColumnName = "id")
    BandejaDeMensajes bandejaDeMensajes;

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
            this.descripcion = "La operación" + operacion.toString() + "fue validada.";
        } else {
            this.descripcion = "La operación" + operacion.toString() + "no fue validada.";
        }

        return this;
    }


}