package dominio.repositories.testMemoData;

import db.Persistente;
import dominio.modelo.usuario.TipoUsuario;
import dominio.modelo.usuario.Usuario;

import java.util.ArrayList;
import java.util.List;

public class Data {
    //En esta clase generamos fake data para mockear con un DAO en memoria

    public static List<Persistente> getData(Class type){
        List<Persistente> entidades = new ArrayList<>();
        if(type.getName().equals(TipoUsuario.class.getName())){
            entidades = DataTipoUsuario.getList();
        }
        else{
            if(type.getName().equals(Usuario.class.getName())){
                entidades = DataUsuario.getList();
            }
        }
        return entidades;
    }
}