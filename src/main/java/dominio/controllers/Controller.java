package dominio.controllers;

import dominio.modelo.entidad.Organizacion;
import dominio.modelo.operacionEgreso.OperacionDeEgreso;
import dominio.modelo.usuario.Usuario;
import dominio.repositories.Repositorio;
import dominio.repositories.factories.FactoryRepositorio;
import spark.Request;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public abstract class Controller {
    protected Repositorio<Usuario> repoUsuarios;
    protected Repositorio<OperacionDeEgreso> repoEgresos;


    public Controller() {
        this.repoUsuarios = FactoryRepositorio.get(Usuario.class);
        this.repoEgresos = FactoryRepositorio.get(OperacionDeEgreso.class);
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

    protected List<OperacionDeEgreso> getOperaciones(Organizacion organizacion){
        return this.repoEgresos.buscarTodos()
                .stream()
                .filter(operacionDeEgreso -> operacionDeEgreso.getEntidad().perteneceAOrganizacion(organizacion))
                .collect(Collectors.toList());
    }
}
