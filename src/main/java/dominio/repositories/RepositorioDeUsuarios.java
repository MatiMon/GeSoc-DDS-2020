package dominio.repositories;


import dominio.modelo.usuario.Usuario;
import dominio.repositories.daos.DAO;

public class RepositorioDeUsuarios extends Repositorio<Usuario> {

    public RepositorioDeUsuarios(DAO<Usuario> dao) {
        super(dao);
    }

    public Boolean existe(String nombreDeUsuario, String contrasenia){
        return buscarUsuario(nombreDeUsuario, contrasenia) != null;
    }

    public Usuario buscarUsuario(String nombreDeUsuario, String contrasenia){
        return this.dao.buscar(1);
    }
}
