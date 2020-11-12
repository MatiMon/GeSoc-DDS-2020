package dominio.modelo.operacionEgreso.Etiquetado;

import dominio.modelo.operacionEgreso.OperacionDeEgreso;

import javax.persistence.Embeddable;
import javax.persistence.ManyToMany;
import javax.persistence.Transient;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Embeddable
public class RepositorioDeEtiquetas {

    @ManyToMany(mappedBy = "operaciones")
    private List<EtiquetaEgreso> listaDeEtiquetas = new ArrayList<>();

    @Transient
    private static RepositorioDeEtiquetas sSoleInstance;

    private RepositorioDeEtiquetas() {
    }  //private constructor.

    public static RepositorioDeEtiquetas getInstance() {
        if (sSoleInstance == null) { //if there is no instance available... create new one
            sSoleInstance = new RepositorioDeEtiquetas();
        }

        return sSoleInstance;
    }

    public void agregarEtiqueta(OperacionDeEgreso operacionDeEgreso, EtiquetaEgreso etiquetaEgreso) {
        listaDeEtiquetas.add(etiquetaEgreso);
        etiquetaEgreso.agregarOperacion(operacionDeEgreso);
    }

    public void quitarEtiqueta(OperacionDeEgreso operacionDeEgreso, EtiquetaEgreso etiquetaEgreso) {
        listaDeEtiquetas.remove(etiquetaEgreso);
        etiquetaEgreso.quitarOperacion(operacionDeEgreso);
    }

    List<EtiquetaEgreso> getEtiquetas(OperacionDeEgreso operacionDeEgreso) {
        return listaDeEtiquetas.stream().filter(e -> e.tieneOperacion(operacionDeEgreso)).collect(Collectors.toList());
    }
}
