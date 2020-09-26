package Dominio.Entidad.Categoria;

import Dominio.Entidad.Entidad;
import Persistencia.Persistente;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class CategoriaEntidad extends Persistente {

    private String nombre;

    @OneToMany
    @JoinColumn(name = "id_categoria_entidad")
    private List<ComportamientoCategoria> comportamientos = new ArrayList<ComportamientoCategoria>();

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
