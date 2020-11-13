package dominio.controllers;

import dominio.modelo.entidad.Organizacion;
import dominio.modelo.usuario.Usuario;
import dominio.repositories.Repositorio;
import dominio.repositories.factories.FactoryRepositorio;
import spark.Request;

import java.util.HashMap;
import java.util.Map;

public abstract class Controller {
    protected Repositorio<Usuario> repoUsuarios;

    public Controller() {
        this.repoUsuarios = FactoryRepositorio.get(Usuario.class);
    }

    protected Map<String, Object> getSessionParams(Request request){
        Map<String, Object> parametros = new HashMap<>();
        long userId = request.session().attribute("id");
        Usuario usuario = this.repoUsuarios.buscar(userId);
        Organizacion organizacion = usuario.getOrganizacion();
        parametros.put("nombreUsuario", usuario.getNombreUsuario());
        parametros.put("organizacion", organizacion.getNombre());
        return parametros;
    }

    protected Usuario getUsuario (Request request){
        long id = request.session().attribute("id");
        return this.repoUsuarios.buscar(id);
    }

    protected Organizacion getOrganizacion (Request request){
        return getUsuario(request).getOrganizacion();
    }
}
