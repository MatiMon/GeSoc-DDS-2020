package Dominio.Usuario;

import java.util.ArrayList;
import java.util.List;

import Dominio.OperacionEgreso.OperacionDeEgreso;
import Persistencia.Persistente;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class BandejaDeMensajes extends Persistente {

    @OneToMany
    @JoinColumn(name = "bandeja_id")
    private List<Mensaje> mensajes = new ArrayList<>();

    public List<Mensaje> getMensajes() {
        return mensajes;
    }

    public void agregarMensaje(Mensaje mensaje) {
        mensajes.add(mensaje);
    }

	public void agregarMensajeValidacion(OperacionDeEgreso operacion, boolean resultadoValidacion) {
	    	Mensaje mensaje = new Mensaje();
	    	mensaje.crearMensajeValidacion(operacion, resultadoValidacion);
	    	this.agregarMensaje(mensaje);
	}
}
