package Dominio.repositories.testMemoData;

import Persistencia.Persistente;
import Dominio.Usuario.Usuario;
import Dominio.Usuario.TipoUsuario;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DataTipoUsuario {
    private static List<Usuario> usuarios = new ArrayList<>();

    public static List<Persistente> getList(){
        if(usuarios.size() == 0){
            Usuario admin = new Usuario();
            admin.setTipoUsuario(TipoUsuario.Admin);
            admin.setId("1");

            addAll(admin);
        }
        return (List<Persistente>)(List<?>)usuarios;
    }

    private static void addAll(Usuario usuarios){
        Collections.addAll(DataTipoUsuario.usuarios, usuarios);
    }
}