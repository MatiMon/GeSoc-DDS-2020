package dominio.controllers;

import dominio.modelo.entidad.*;
import dominio.modelo.entidad.categoria.CategoriaEntidad;
import dominio.modelo.moneda.Moneda;
import dominio.modelo.proveedor.Proveedor;
import dominio.modelo.ubicacion.Direccion;
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

    protected Repositorio<Direccion> repoDirecciones;

    public EntidadController(){
        this.repoDirecciones = FactoryRepositorio.get(Direccion.class);
    }

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

    public ModelAndView nuevaEntidad(Request request, Response response) {
        Map<String, Object> parametros = this.getSessionParams(request);
        List<EntidadBase> entidadesBases = this.getEntidadesBase(this.getOrganizacion(request));
        List<EntidadJuridica> entidadesJuridicas = this.getEntidadesJuridicas(this.getOrganizacion(request));
        List<Direccion> direcciones = repoDirecciones.buscarTodos();
        parametros.put("entidadesJuridicas", entidadesJuridicas);
        parametros.put("entidadesBase", entidadesBases);
        parametros.put("direcciones",direcciones);
        return new ModelAndView(parametros, "nueva-entidad.hbs");
    }

    public ModelAndView nuevaEntidadData(Request request, Response response) {

        return new ModelAndView(null, "nueva-entidad-data.hbs");
    }


    private String getSelectedFiltro(Request request) {
        if (request.queryParams("filtro") == null) {
            return "Todas";
        }
        return request.queryParams("filtro");
    }


}
