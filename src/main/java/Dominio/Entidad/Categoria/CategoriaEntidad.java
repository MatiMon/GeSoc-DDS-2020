package Dominio.Entidad.Categoria;

import Dominio.Entidad.Entidad;

import javax.persistence.Entity;
import java.util.ArrayList;
import java.util.List;

public class CategoriaEntidad {

    private String nombre;
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
