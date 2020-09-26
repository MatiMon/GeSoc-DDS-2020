package Dominio.Usuario;

import Dominio.OperacionEgreso.Item;
import Dominio.OperacionEgreso.OperacionDeEgreso;
import Dominio.Presupuesto.Presupuesto;
import Persistencia.Persistente;

import javax.persistence.Embeddable;
import javax.persistence.Entity;
import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Mensaje extends Persistente {
    private LocalDateTime fechaYHora;
    private String descripcion;
    private boolean leido;

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

    public String getDescripcion(){
    	return descripcion;
    }
    
    public void setDescripcion(String descripcion) {
    	this.descripcion = descripcion;
    }

    public Mensaje crearMensajeValidacion(OperacionDeEgreso operacion, boolean validacion) {
        this.fechaYHora = LocalDateTime.now();
        this.leido = false;
        if(validacion) {
        	this.descripcion = "La operación" + operacion.toString() + "fue validada.";
        }
        else {
        	this.descripcion = "La operación" + operacion.toString() + "no fue validada.";
        }

        return this;
    }


}