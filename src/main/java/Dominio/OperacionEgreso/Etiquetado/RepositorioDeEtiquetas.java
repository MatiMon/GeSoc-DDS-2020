package Dominio.OperacionEgreso.Etiquetado;

import Dominio.OperacionEgreso.OperacionDeEgreso;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RepositorioDeEtiquetas {

    List<EtiquetaEgreso> listaDeEtiquetas = new ArrayList<>();

    public void agregarEtiqueta(OperacionDeEgreso operacionDeEgreso, EtiquetaEgreso etiquetaEgreso){
        listaDeEtiquetas.add(etiquetaEgreso);
        etiquetaEgreso.agregarOperacion(operacionDeEgreso);
    }
    public void quitarEtiqueta(OperacionDeEgreso operacionDeEgreso, EtiquetaEgreso etiquetaEgreso){
        listaDeEtiquetas.remove(etiquetaEgreso);
        etiquetaEgreso.quitarOperacion(operacionDeEgreso);
    }

    List<EtiquetaEgreso> getEtiquetas(OperacionDeEgreso operacionDeEgreso) {
        return listaDeEtiquetas.stream().filter(e -> e.tieneOperacion(operacionDeEgreso)).collect(Collectors.toList());
    }
}
