package dominio.controllers;

import dominio.modelo.entidad.Entidad;
import dominio.modelo.entidad.EntidadBase;
import dominio.repositories.Repositorio;
import dominio.repositories.factories.FactoryRepositorio;
import spark.ModelAndView;
import spark.Request;
import spark.Response;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EntidadController {
    private Repositorio<EntidadBase> repoEntidades;


    public EntidadController() {
        this.repoEntidades = FactoryRepositorio.get(EntidadBase.class);
    }

    public ModelAndView mostrarTodas(Request request, Response response){
        List<EntidadBase> entidadesBase;
        entidadesBase = this.repoEntidades.buscarTodos();

        Map<String,Object> parametros = new HashMap<>();
        parametros.put("entidadesBase",entidadesBase);

        return new ModelAndView(parametros,"gestion_entidades.hbs");
    }
}
