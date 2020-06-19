package Dominio.Usuario;

import java.util.ArrayList;
import java.util.List;

public class BandejaDeMensajes {

    private List<Mensaje> mensajes = new ArrayList<>();

    public List<Mensaje> getMensajes() {
        return mensajes;
    }

    public void agregarMensaje(Mensaje mensaje) {
        mensajes.add(mensaje);
    }
}
