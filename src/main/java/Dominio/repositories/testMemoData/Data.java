package Dominio.repositories.testMemoData;

import Persistencia.Persistente;
import Dominio.Usuario.TipoUsuario;
import Dominio.Usuario.Usuario;

import java.util.ArrayList;
import java.util.List;

public class Data {

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