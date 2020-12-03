package dominio.repositories.factories;

import config.Config;
import dominio.modelo.usuario.Usuario;
import dominio.repositories.RepositorioDeUsuarios;
import dominio.repositories.daos.DAO;
import dominio.repositories.daos.DAOHibernate;
import dominio.repositories.daos.DAOMemoria;
import dominio.repositories.testMemoData.Data;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

public class FactoryRepositorioUsuarios {
    private static RepositorioDeUsuarios repo;

    static {
        repo = null;
    }

    public static RepositorioDeUsuarios get() throws InvalidKeySpecException, NoSuchAlgorithmException {
        if(repo == null){
            if(Config.useDataBase){
                DAO<Usuario> dao = new DAOHibernate<>(Usuario.class);
                repo = new RepositorioDeUsuarios(dao);
            }
            else{
                repo = new RepositorioDeUsuarios(new DAOMemoria<>(Data.getData(Usuario.class)));
            }
        }
        return repo;
    }
}
