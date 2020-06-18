package Dominio.Usuario;

import java.util.List;

public class BandejaDeMensajes {
	
	private List<Mensaje> mensajes;

	public List<Mensaje> getMensajes(){
		return mensajes;
	}
	
	public void agregarMensaje(Mensaje mensaje) {
		mensajes.add(mensaje);
	}
}
