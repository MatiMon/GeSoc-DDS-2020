package dominio.repositories.daos;

import db.Persistente;
import dominio.repositories.BusquedaCondicional;

import java.util.List;

public class DAOMemoria<T> implements DAO<T> {
    private List<Persistente> entidades;

    public DAOMemoria(List<Persistente> entidades){
        this.entidades = entidades;
    }

    @Override
    public List<T> buscarTodos() {
        return (List<T>) this.entidades;
    }

    @Override
    public T buscar(int id) {
        return (T) this.entidades
                .stream()
                .filter(e -> e.getId() == id)
                .findFirst()
                .get();
    }

    @Override
    public T buscar(BusquedaCondicional condicional) {
        return (T) this.entidades
                .stream()
                .filter(condicional.getCondicionPredicado())
                .findFirst()
                .get();
    }

    @Override
    public void agregar(Object unObjeto) {
        this.entidades.add((Persistente) unObjeto);
    }

    @Override
    public void modificar(Object unObjeto) {

    }

    @Override
    public void eliminar(Object unObjeto) {
        this.entidades.remove(unObjeto);
    }
}
