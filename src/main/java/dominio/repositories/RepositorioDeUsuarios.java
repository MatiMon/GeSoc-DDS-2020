package dominio.repositories;


import dominio.modelo.usuario.Usuario;
import dominio.repositories.daos.DAO;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public class RepositorioDeUsuarios extends Repositorio<Usuario> {

    public RepositorioDeUsuarios(DAO<Usuario> dao) {
        super(dao);
    }

    public Boolean existe(String nombreDeUsuario){
        return buscarUsuario(nombreDeUsuario) != null;
    }

    public Usuario buscarUsuario(String nombreDeUsuario){
        return this.dao.buscar(condicionNombreUsuario(nombreDeUsuario));
    }

    private BusquedaCondicional condicionNombreUsuario(String nombreDeUsuario){
        CriteriaBuilder criteriaBuilder = criteriaBuilder();
        CriteriaQuery<Usuario> usuarioQuery = criteriaBuilder.createQuery(Usuario.class);

        Root<Usuario> condicionRaiz = usuarioQuery.from(Usuario.class);

        Predicate condicionNombreDeUsuario = criteriaBuilder.equal(condicionRaiz.get("nombreUsuario"), nombreDeUsuario);

        usuarioQuery.where(condicionNombreDeUsuario);

        return new BusquedaCondicional(null, usuarioQuery);
    }
}
