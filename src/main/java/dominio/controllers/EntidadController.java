package dominio.controllers;

import db.EntityManagerHelper;
import dominio.modelo.entidad.*;
import dominio.modelo.entidad.categoria.CategoriaEntidad;

import dominio.modelo.moneda.Moneda;
import dominio.modelo.proveedor.Proveedor;
import dominio.modelo.proveedor.TipoDeCodigoID;
import dominio.modelo.ubicacion.Ciudad;
import dominio.modelo.ubicacion.Direccion;
import dominio.modelo.ubicacion.Pais;
import dominio.modelo.ubicacion.Provincia;
import dominio.modelo.usuario.Usuario;


import dominio.repositories.Repositorio;
import dominio.repositories.factories.FactoryRepositorio;
import spark.ModelAndView;
import spark.Request;
import spark.Response;
import sun.corba.EncapsInputStreamFactory;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class EntidadController extends Controller {

    protected Repositorio<Direccion> repoDirecciones;
    private long paisId;
    private long provinciaId;

    public EntidadController() {
        this.repoDirecciones = FactoryRepositorio.get(Direccion.class);
    }

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


    public ModelAndView elegirCategoria(Request request, Response response) {
        Repositorio<CategoriaEntidad> repoCategorias = FactoryRepositorio.get(CategoriaEntidad.class);
        List<CategoriaEntidad> categorias = repoCategorias.buscarTodos();

        long id = Long.parseLong(request.params(":id"));

        EntidadBase entidadBase = this.repoEntidadesBase.buscar(id);
        Map<String, Object> parametros = this.getSessionParams(request);

        if (entidadBase == null) {
            EntidadJuridica entidadJuridica = this.repoEntidadesJuridicas.buscar(id);
            parametros.put("nombreEntidad", entidadJuridica.getNombreFicticio());
        } else {
            parametros.put("nombreEntidad", entidadBase.getNombreFicticio());
        }

        parametros.put("idEntidad", id);
        parametros.put("categorias", categorias);
        return new ModelAndView(parametros, "asociar_categoria.hbs");
    }

    public ModelAndView asociarCategoria(Request request, Response response) {
        Map<String, Object> parametros = this.getSessionParams(request);
        long id = Long.parseLong(request.params(":id"));
        long idCategoria = Long.parseLong((request.queryParams("categoria")));

        EntidadBase entidadBase = this.repoEntidadesBase.buscar(id);
        CategoriaEntidad categoriaEntidad = FactoryRepositorio.get(CategoriaEntidad.class).buscar(idCategoria);

        if (entidadBase == null) {
            EntidadJuridica entidadJuridica = this.repoEntidadesJuridicas.buscar(id);
            entidadJuridica.setCategoria(categoriaEntidad);
            EntityManagerHelper.beginTransaction();
            EntityManager entityManager = EntityManagerHelper.getEntityManager();
            entityManager.persist(entidadJuridica);

            EntityManagerHelper.commit();

        } else {
            entidadBase.setCategoria(categoriaEntidad);
            EntityManagerHelper.beginTransaction();
            EntityManager entityManager = EntityManagerHelper.getEntityManager();
            entityManager.persist(entidadBase);
            EntityManagerHelper.commit();
        }
        return mostrarTodas(request, response);

    }


    private String getSelectedFiltro(Request request) {
        if (request.queryParams("filtro") == null) {
            return "Todas";
        }
        return request.queryParams("filtro");
    }

    public ModelAndView nuevaEntidad(Request request, Response response) {
        Map<String, Object> parametros = this.getSessionParams(request);
        return new ModelAndView(parametros, "nueva-entidad.hbs");
    }

    public ModelAndView nuevaEntidadBase(Request request, Response response) {
        Map<String, Object> parametros = this.getSessionParams(request);
        List<EntidadJuridica> entJuridicas = this.getEntidadesJuridicas(this.getOrganizacion(request));
        parametros.put("entidades_juridicas", entJuridicas);
        return new ModelAndView(parametros, "nueva-entidad-base.hbs");
    }

    public ModelAndView crearEntidadBase(Request request, Response response) {
        Map<String, Object> parametros = this.getSessionParams(request);
        long idEntJurid = Long.parseLong((request.queryParams("EntJuridica")));
        EntidadJuridica entJurid = FactoryRepositorio.get(EntidadJuridica.class).buscar(idEntJurid);
        String nombre = request.queryParams("nombreFicticio");
        String descripcion = request.queryParams("descripcion");
        EntidadBase entBase = new EntidadBase(nombre, descripcion, entJurid);
        EntityManagerHelper.beginTransaction();
        EntityManager entityManager = EntityManagerHelper.getEntityManager();
        entityManager.persist(entBase);

        EntityManagerHelper.commit();
        return mostrarTodas(request, response);

    }


    public ModelAndView nuevaEntidadJuridica(Request request, Response response) {
        Map<String, Object> parametros = this.getSessionParams(request);
        List<Pais> paises = FactoryRepositorio.get(Pais.class).buscarTodos();
        parametros.put("paises", paises);

        return new ModelAndView(parametros, "nueva-entidad-juridica.hbs");

    }

    public ModelAndView nuevaEntidadJuridicaProvincia(Request request, Response response) {
        Map<String, Object> parametros = this.getSessionParams(request);
        paisId = Long.parseLong(request.queryParams("paisId"));
        Pais pais = FactoryRepositorio.get(Pais.class).buscar(paisId);
        List<Provincia> provincias = pais.getProvincias();

        parametros.put("paisSeleccionado", pais.getNombre());
        parametros.put("provincias", provincias);
        return new ModelAndView(parametros, "nueva-entidad-juridica-provincias.hbs");
    }

    public ModelAndView nuevaEntidadJuridicaData(Request request, Response response) {
        Map<String, Object> parametros = this.getSessionParams(request);
        provinciaId = Long.parseLong(request.queryParams("provinciaId"));
        Pais pais = FactoryRepositorio.get(Pais.class).buscar(paisId);
        Provincia provincia = FactoryRepositorio.get(Provincia.class).buscar(provinciaId);
        List<CategoriaEntidad> categorias = FactoryRepositorio.get(CategoriaEntidad.class).buscarTodos();
        List<Ciudad> ciudades = provincia.getCiudades();

        parametros.put("ciudades", ciudades);
        parametros.put("categorias", categorias);
        parametros.put("paisSeleccionado", pais.getNombre());
        parametros.put("provinciaSeleccionada", provincia.getNombre());

        return new ModelAndView(parametros, "nueva-entidad-juridica-data.hbs");

    }

    public ModelAndView crearEntidadJuridica(Request request, Response response) {
        // try {
        String nombreFicticio = request.queryParams("nombreFicticio");
        String razonSocial = request.queryParams("razonSocial");
        String tipoCodigoId = request.queryParams("tipoCodigoId");
        int numeroDocumento = Integer.parseInt(request.queryParams("numDoc"));
        String tipoEntidadJuridica = request.queryParams("tipoEntidadJuridica");
        long idCategoria = Long.parseLong(request.queryParams("categorias"));
        long ciudadId = Long.parseLong(request.queryParams("ciudadId"));
        String calle = request.queryParams("calle");
        String numeroCalle = request.queryParams("numeroCalle");

        Ciudad ciudad = FactoryRepositorio.get(Ciudad.class).buscar(ciudadId);
        Direccion direccion = new Direccion(calle, numeroCalle, null, null, ciudad);

        CategoriaEntidad categoriaEntidad = FactoryRepositorio.get(CategoriaEntidad.class).buscar(idCategoria);
        EntidadJuridica entidadJuridica = new EntidadJuridica(nombreFicticio, razonSocial, direccion,
                crearCodigoId(tipoCodigoId), numeroDocumento, crearTipoEntidad(tipoEntidadJuridica), categoriaEntidad);

        Organizacion organizacion = this.getOrganizacion(request);
        entidadJuridica.setOrganizacion(organizacion);
        organizacion.agregarEntidadJuridica(entidadJuridica);

        EntityManagerHelper.beginTransaction();
        EntityManager entityManager = EntityManagerHelper.getEntityManager();
        entityManager.persist(direccion);
        entityManager.persist(entidadJuridica);
        entityManager.persist(organizacion);

        EntityManagerHelper.commit();

        return mostrarTodas(request, response);
//        } catch (Exception e) {
//            return nuevaEntidadJuridica(request, response);
//        }

    }

    private TipoDeCodigoID crearCodigoId(String tipoCodigoId) {
        switch (tipoCodigoId) {
            case "DNI":
                return TipoDeCodigoID.DNI;
            case "CUIL":
                return TipoDeCodigoID.CUIL;
            case "CUIT":
                return TipoDeCodigoID.CUIT;
            default:
                return null;
        }
    }

    private TipoEntidadJuridica crearTipoEntidad(String tipo) {
        switch (tipo) {
            case "Micro":
                return new Empresa(ClasificacionAfip.MICRO);
            case "Pequenia":
                return new Empresa(ClasificacionAfip.PEQUENIA);
            case "Mediana 1":
                return new Empresa(ClasificacionAfip.MEDIANA1);
            case "Mediana 2":
                return new Empresa(ClasificacionAfip.MEDIANA2);
            case "OSC":
                return new OSC();
            default:
                return null;
        }
    }

}
