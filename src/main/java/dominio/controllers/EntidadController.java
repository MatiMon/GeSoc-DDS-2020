package dominio.controllers;

import dominio.modelo.entidad.EntidadBase;
import dominio.modelo.entidad.EntidadJuridica;
import dominio.modelo.entidad.categoria.CategoriaEntidad;
import dominio.repositories.Repositorio;
import dominio.repositories.factories.FactoryRepositorio;
import spark.ModelAndView;
import spark.Request;
import spark.Response;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class EntidadController extends Controller {

    public ModelAndView mostrarTodas(Request request, Response response) {
        List<EntidadBase> entidadesBase;
        List<EntidadJuridica> entidadesJuridicas;
        String filtroCategoriaAnterior = "Todas";
        String filtroEntidadAnterior = "Todas";

        Repositorio<CategoriaEntidad> repoCategorias = FactoryRepositorio.get(CategoriaEntidad.class);

        List<CategoriaEntidad> categorias = repoCategorias.buscarTodos();

        entidadesBase = this.getEntidadesBase(this.getOrganizacion(request));
        entidadesJuridicas = this.getEntidadesJuridicas(this.getOrganizacion(request));

        Map<String, Object> parametros = this.getSessionParams(request);

        String filtroCategorias = request.queryParams("filtroCategorias");
        if (filtroCategorias != null && !filtroCategorias.equals("Categoria")) {
            long idCategoria = Long.parseLong(filtroCategorias);
            CategoriaEntidad categoria = categorias.stream()
                    .filter(categoriaEntidad -> categoriaEntidad.getId() == idCategoria)
                    .collect(Collectors.toList()).get(0);
            entidadesBase = entidadesBase.stream()
                    .filter(entidadBase -> entidadBase.getCategoria() == categoria)
                    .collect(Collectors.toList());
            entidadesJuridicas = entidadesJuridicas.stream()
                    .filter(entidadJuridica -> entidadJuridica.getCategoria() == categoria)
                    .collect(Collectors.toList());
            filtroCategoriaAnterior = categoria.getNombre();

        }

        String selectedFiltro = this.getSelectedFiltro(request);
        if (selectedFiltro.equals("Todas")) {
            parametros.put("entidadesBase", entidadesBase);
            parametros.put("entidadesJuridicas", entidadesJuridicas);
        }
        if (selectedFiltro.equals("Bases")) {
            filtroEntidadAnterior = "Base";
            parametros.put("entidadesBase", entidadesBase);
        }
        if (selectedFiltro.equals("Juridicas")) {
            filtroEntidadAnterior = "Juridicas";
            parametros.put("entidadesJuridicas", entidadesJuridicas);
        }

        parametros.put("filtroCategoriaAnterior", filtroCategoriaAnterior);
        parametros.put("filtroEntidadAnterior", filtroEntidadAnterior);
        parametros.put(this.getSelectedFiltro(request) + "Selected", true);
        parametros.put("categorias", categorias);

        return new ModelAndView(parametros, "gestion_entidades.hbs");
    }

    public ModelAndView asociarCategoria(Request request, Response response) {
        Repositorio<CategoriaEntidad> repoCategorias = FactoryRepositorio.get(CategoriaEntidad.class);
        List<CategoriaEntidad> categorias = repoCategorias.buscarTodos();

        Map<String, Object> parametros = this.getSessionParams(request);

        parametros.put("categorias", categorias);
        return new ModelAndView(parametros, "asociar_categoria.hbs");
    }

    private String getSelectedFiltro(Request request) {
        if (request.queryParams("filtro") == null) {
            return "Todas";
        }
        return request.queryParams("filtro");
    }
}
