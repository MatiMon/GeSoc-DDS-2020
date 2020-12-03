package dominio.repositories.testMemoData;

import db.Persistente;
import dominio.modelo.usuario.TipoUsuario;
import dominio.modelo.usuario.Usuario;
import dominio.repositories.Repositorio;
import dominio.repositories.factories.FactoryRepositorio;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DataUsuario {
    private static List<Usuario> usuarios = new ArrayList<>();

    public static List<Persistente> getList(){
        if(usuarios.size() == 0) {
            Repositorio<TipoUsuario> repoTipoUsuario = FactoryRepositorio.get(TipoUsuario.class);

            Usuario admin = new Usuario();
            admin.setTipoUsuario(TipoUsuario.Admin);
            admin.setId("1");

            addAll(admin);
        }
        return (List<Persistente>)(List<?>) usuarios;
    }

    private static void addAll(Usuario ... usuarios){
        Collections.addAll(DataUsuario.usuarios, usuarios);
    }
}
