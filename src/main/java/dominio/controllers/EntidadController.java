package dominio.controllers;

import dominio.modelo.entidad.Entidad;
import dominio.modelo.entidad.EntidadBase;
import dominio.modelo.entidad.EntidadJuridica;
import dominio.modelo.entidad.categoria.CategoriaEntidad;
import dominio.modelo.usuario.Usuario;
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

    public ModelAndView mostrarTodas(Request request, Response response) {
        List<EntidadBase> entidadesBase;
        List<EntidadJuridica> entidadesJuridicas;

        Repositorio<CategoriaEntidad> repoCategorias = FactoryRepositorio.get(CategoriaEntidad.class);

        List<CategoriaEntidad> categorias = repoCategorias.buscarTodos();

        entidadesBase = this.getEntidadesBase(this.getOrganizacion(request));
        entidadesJuridicas = this.getEntidadesJuridicas(this.getOrganizacion(request));

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
        parametros.put("categorias", categorias);

        return new ModelAndView(parametros, "gestion_entidades.hbs");
    }

    private String getSelectedFiltro(Request request) {
        if (request.queryParams("filtro") == null) {
            return "Todas";
        }
        return request.queryParams("filtro");
    }
}
