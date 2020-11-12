package dominio.controllers;

import dominio.modelo.usuario.Usuario;
import dominio.repositories.Repositorio;
import dominio.repositories.factories.FactoryRepositorio;
import spark.ModelAndView;
import spark.Request;
import spark.Response;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.HashMap;
import java.util.Map;

public class UsuarioController {
    private Repositorio<Usuario> repoUsuarios;

    public UsuarioController() throws InvalidKeySpecException, NoSuchAlgorithmException {
        this.repoUsuarios = FactoryRepositorio.get(Usuario.class);
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
