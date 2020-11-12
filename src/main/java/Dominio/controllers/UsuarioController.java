package Dominio.controllers;

import Dominio.Usuario.Usuario;
import Dominio.repositories.Repositorio;
import Dominio.repositories.factories.FactoryRepositorio;
import spark.ModelAndView;
import spark.Request;
import spark.Response;

public class UsuarioController {
    private Repositorio<Usuario> repoUsuarios;

    public UsuarioController(){
        this.repoUsuarios = FactoryRepositorio.get(Usuario.class);
    }

    public ModelAndView inicioSesion(Request request, Response response){
        return new ModelAndView(null, "inicio.hbs");
    }

    public ModelAndView paginaPrincipal(Request request, Response response){
        return new ModelAndView(null, "pagina_principal.hbs");
    }

    public ModelAndView gestionEgresos(Request request, Response response){
        return new ModelAndView(null, "gestion_egresos.hbs");
    }

    public ModelAndView gestionEntidades(Request request, Response response){
        return new ModelAndView(null, "gestion_entidades.hbs");
    }
}
