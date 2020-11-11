package Dominio.repositories.testMemoData;

import Persistencia.Persistente;
import Dominio.Usuario.TipoUsuario;
import Dominio.Usuario.Usuario;
import Dominio.repositories.Repositorio;
import Dominio.repositories.factories.FactoryRepositorio;

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
