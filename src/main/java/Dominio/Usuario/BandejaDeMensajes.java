package Dominio.Usuario;

import java.util.ArrayList;
import java.util.List;

import Dominio.OperacionEgreso.OperacionDeEgreso;
import Persistencia.Persistente;

import javax.persistence.*;

@Entity
// Lo ideal seria meter esto en usuario y tener en mensaje una FK a usuario
@Table(name = "bandeja_de_mensajes")
public class BandejaDeMensajes extends Persistente{

    @OneToMany(mappedBy = "bandejaDeMensajes")
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
