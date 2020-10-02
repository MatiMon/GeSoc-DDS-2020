package Dominio.Entidad.Categoria;

import Dominio.Entidad.Entidad;
import Persistencia.Persistente;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "categoria_entidad")
public class CategoriaEntidad extends Persistente {

    private String nombre;

    @OneToMany (mappedBy = "categoriaEntidad")
    private List<ComportamientoCategoria> comportamientos = new ArrayList<>();

    public CategoriaEntidad(String nombre) {
        this.nombre = nombre;
        agregarComportamientosDefault();
    }

    private void agregarComportamientosDefault() {
        comportamientos.add(new BloqueoNuevoEgreso());
        comportamientos.add(new BloquearNuevasBases());
    }

    public void ejecutarSiEstaActivo(Entidad entidad, TiposComportamiento tipo) {
        comportamientos.stream().forEach(comportamiento -> comportamiento.ejecutarSiEstaActivo(entidad));
    }

}
