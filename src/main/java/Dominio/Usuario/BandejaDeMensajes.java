package Dominio.Usuario;

import java.util.ArrayList;
import java.util.List;

import Dominio.OperacionEgreso.OperacionDeEgreso;

public class BandejaDeMensajes {

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
