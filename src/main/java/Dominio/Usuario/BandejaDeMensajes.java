package Dominio.Usuario;

import Dominio.OperacionEgreso.OperacionDeEgreso;

import javax.persistence.Embeddable;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Embeddable
public class BandejaDeMensajes {

    @OneToMany(mappedBy = "usuario")
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
