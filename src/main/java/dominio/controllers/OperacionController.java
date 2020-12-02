package dominio.controllers;

import com.apple.laf.AquaRootPaneUI;
import dominio.modelo.entidad.EntidadBase;
import dominio.modelo.entidad.EntidadJuridica;
import dominio.modelo.entidad.Organizacion;
import dominio.modelo.moneda.Moneda;
import dominio.modelo.operacionEgreso.OperacionDeEgreso;
import dominio.modelo.operacionEgreso.OperacionEgresoBuilder;
import dominio.modelo.proveedor.Proveedor;
import dominio.modelo.usuario.Usuario;
import dominio.repositories.Repositorio;
import dominio.repositories.factories.FactoryRepositorio;
import spark.ModelAndView;
import spark.Request;
import spark.Response;

import javax.jws.WebParam;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.*;

public class OperacionController extends Controller {

    OperacionEgresoBuilder builder;
    boolean esBase;

    public ModelAndView mostrarOperaciones(Request request, Response response) {
        List<OperacionDeEgreso> operaciones = this.getOperaciones(this.getOrganizacion(request));
        Map<String, Object> parametros = this.getSessionParams(request);
        parametros.put("operaciones", operaciones);
        return new ModelAndView(parametros, "gestion_egresos.hbs");
    }

    public ModelAndView nuevaOperacion(Request request, Response response) {
        builder = new OperacionEgresoBuilder();
        Map<String, Object> parametros = this.getSessionParams(request);

        return new ModelAndView(parametros, "nueva-operacion.hbs");
    }

    public ModelAndView nuevaOperacionData(Request request, Response response) {
        Map<String, Object> parametros = this.getSessionParams(request);

        List<Proveedor> proveedores = FactoryRepositorio.get(Proveedor.class).buscarTodos();
        List<Moneda> monedas = FactoryRepositorio.get(Moneda.class).buscarTodos();
        List<EntidadBase> entidadBases = this.getEntidadesBase(this.getOrganizacion(request));
        List<EntidadJuridica> entidadJuridicas = this.getEntidadesJuridicas(this.getOrganizacion(request));

        if (request.queryParams("tipoEntidad").equals("base")) {
            parametros.put("entidades", entidadBases);
            parametros.put("tipoEntidad", " Base");
            esBase = true;
        } else {
            parametros.put("entidades", entidadJuridicas);
            parametros.put("tipoEntidad", " Juridicas");
            esBase = false;

        }
        parametros.put("monedas", monedas);
        parametros.put("proveedores", proveedores);

        return new ModelAndView(parametros, "nueva-operacion-data.hbs");
    }

    public ModelAndView nuevaOperacionItems(Request request, Response response) {
        Map<String, Object> parametros = this.getSessionParams(request);
        if (request.queryParams("numeroDocumento") != null) {
            int nroDocumento = Integer.parseInt(request.queryParams("numeroDocumento"));
            builder.setNumeroDocumentoComercial(nroDocumento);
        }
        if (request.queryParams("cantidadPresupuestos") != null) {
            int cantidadPresupuestos = Integer.parseInt(request.queryParams("cantidadPresupuestos"));
            builder.setCantidadDePresupuestosRequeridos(cantidadPresupuestos);
        }
        if (request.queryParams("proveedorId") != null) {
            int idProveedor = Integer.parseInt(request.queryParams("proveedorId"));
        }
        if (request.queryParams("monedaId") != null) {
            int idMoneda = Integer.parseInt(request.queryParams("monedaId"));
        }
        if (request.queryParams("entidadId") != null) {
            int idEntidad = Integer.parseInt(request.queryParams("entidadId"));
        }
        return new ModelAndView(parametros, "nueva-operacion-items.hbs");
    }

    public ModelAndView nuevaOperacionFinalizar(Request request, Response response) {
        Map<String, Object> parametros = this.getSessionParams(request);
        //llegan items meterlos al builder
        return new ModelAndView(parametros, "nueva-operacion-finalizar.hbs");
    }

    public ModelAndView crearOperacion(Request request, Response response) {
        Map<String, Object> parametros = this.getSessionParams(request);
        return new ModelAndView(parametros, "gestion_egresos.hbs");
    }

}
