package dominio.controllers;

import dominio.modelo.entidad.Entidad;
import dominio.modelo.entidad.EntidadBase;
import dominio.modelo.entidad.EntidadJuridica;
import dominio.repositories.Repositorio;
import dominio.repositories.factories.FactoryRepositorio;
import spark.ModelAndView;
import spark.Request;
import spark.Response;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EntidadController extends Controller {
    private Repositorio<EntidadBase> repoEntidadesBase;
    private Repositorio<EntidadJuridica> repoEntidadesJuridicas;


    public EntidadController() {
        super();
        this.repoEntidadesBase = FactoryRepositorio.get(EntidadBase.class);
        this.repoEntidadesJuridicas = FactoryRepositorio.get(EntidadJuridica.class);
    }

    public ModelAndView mostrarTodas(Request request, Response response) {
        List<EntidadBase> entidadesBase;
        List<EntidadJuridica> entidadesJuridicas;

        entidadesBase = this.repoEntidadesBase.buscarTodos();
        entidadesJuridicas = this.repoEntidadesJuridicas.buscarTodos();

        Map<String, Object> parametros = this.getSessionParams(request);

        String selectedFiltro = this.getSelectedFiltro(request);
        if (selectedFiltro.equals("Todas")) {
            parametros.put("entidadesBase", entidadesBase);
            parametros.put("entidadesJuridicas", entidadesJuridicas);
        }
        if (selectedFiltro.equals("Bases")) {
            parametros.put("entidadesBase", entidadesBase);
        }
        if (selectedFiltro.equals("Juridicas")) {
            parametros.put("entidadesJuridicas", entidadesJuridicas);
        }
        parametros.put(this.getSelectedFiltro(request) + "Selected", true);

        return new ModelAndView(parametros, "gestion_entidades.hbs");
    }

    private String getSelectedFiltro(Request request) {
        if (request.queryParams("filtro") == null) {
            return "Todas";
        }
        return request.queryParams("filtro");
    }
}
