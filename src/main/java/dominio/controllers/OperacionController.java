package dominio.controllers;

import db.EntityManagerHelper;
import dominio.modelo.entidad.EntidadBase;
import dominio.modelo.entidad.EntidadJuridica;
import dominio.modelo.mediosDePago.Efectivo;
import dominio.modelo.mediosDePago.Tarjeta;
import dominio.modelo.mediosDePago.TipoTarjeta;
import dominio.modelo.moneda.Moneda;
import dominio.modelo.operacionEgreso.OperacionDeEgreso;
import dominio.modelo.operacionEgreso.OperacionEgresoBuilder;
import dominio.modelo.operacionEgreso.Producto;
import dominio.modelo.operacionEgreso.TipoDocumentoComercial;
import dominio.modelo.proveedor.Proveedor;
import dominio.repositories.Repositorio;
import dominio.repositories.factories.FactoryRepositorio;
import spark.ModelAndView;
import spark.Request;
import spark.Response;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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
        try {
            if (request.queryParams("numeroDocumento") != null) {
                int nroDocumento = Integer.parseInt(request.queryParams("numeroDocumento"));
                builder.setNumeroDocumentoComercial(nroDocumento);
            }
            if (request.queryParams("cantidadPresupuestos") != null) {
                int cantidadPresupuestos = Integer.parseInt(request.queryParams("cantidadPresupuestos"));
                builder.setCantidadDePresupuestosRequeridos(cantidadPresupuestos);
            }
            if (request.queryParams("proveedorId") != null) {
                long idProveedor = Long.parseLong(request.queryParams("proveedorId"));
                Repositorio<Proveedor> repoProveedor = FactoryRepositorio.get(Proveedor.class);
                Proveedor proveedor = repoProveedor.buscar(idProveedor);
                builder.setProveedor(proveedor);
            }
            if (request.queryParams("monedaId") != null) {
                long idMoneda = Long.parseLong(request.queryParams("monedaId"));
                Repositorio<Moneda> repoMonedas = FactoryRepositorio.get(Moneda.class);
                Moneda moneda = repoMonedas.buscar(idMoneda);
                builder.setMoneda(moneda);
            }
            if (request.queryParams("entidadId") != null) {
                long idEntidad = Long.parseLong(request.queryParams("entidadId"));
                if (esBase) {
                    EntidadBase entidadBase = repoEntidadesBase.buscar(idEntidad);
                    builder.setEntidad(entidadBase);
                } else {
                    EntidadJuridica entidadJuridica = repoEntidadesJuridicas.buscar(idEntidad);
                    builder.setEntidad(entidadJuridica);
                }
            }
            if (request.queryParams("tipoDocumento") != null) {
                String tipoDoc = request.queryParams("tipoDocumento");
                if (tipoDoc.equals("factura")) {
                    this.builder.setTipoDocumentoComercial(TipoDocumentoComercial.Factura);
                }
                if (tipoDoc.equals("ticket")) {
                    this.builder.setTipoDocumentoComercial(TipoDocumentoComercial.Ticket);
                }
            }

            if (request.queryParams("tipoMedioPago") != null) {
                String medioDePago = request.queryParams("tipoMedioPago");
                switch (medioDePago) {
                    case "efectivo":
                        Efectivo efectivo = FactoryRepositorio.get(Efectivo.class).buscarTodos().get(0);
                        builder.setMetodoPago(efectivo);
                        break;
                    case "tarjetaCredito":
                        Tarjeta tarjetaCredito = FactoryRepositorio.get(Tarjeta.class).buscarTodos()
                                .stream().filter(tarjeta -> tarjeta.getTipo() == TipoTarjeta.tarjetaCredito)
                                .collect(Collectors.toList()).get(0);
                        builder.setMetodoPago(tarjetaCredito);
                        break;
                    case "tarjetaDebito":
                        Tarjeta tarjetaDebito = FactoryRepositorio.get(Tarjeta.class).buscarTodos()
                                .stream().filter(tarjeta -> tarjeta.getTipo() == TipoTarjeta.tarjetaDebito)
                                .collect(Collectors.toList()).get(0);
                        builder.setMetodoPago(tarjetaDebito);
                        break;
                    default:
                        break;
                }
            }
            return new ModelAndView(parametros, "nueva-operacion-items.hbs");
        } catch (Exception e) {
            return nuevaOperacion(request, response);
        }
    }

    public ModelAndView nuevaOperacionFinalizar(Request request, Response response) {
        try {
            Map<String, Object> parametros = this.getSessionParams(request);
            String descripcion = request.queryParams("descripcion");
            Double precio = Double.parseDouble(request.queryParams("precio"));
            int cantidad = Integer.parseInt(request.queryParams("cantidad"));
            Producto producto = new Producto(descripcion, descripcion, precio);

            builder.agregarItem(producto, cantidad);

            return new ModelAndView(parametros, "nueva-operacion-finalizar.hbs");
        } catch (Exception e) {
            return nuevaOperacion(request, response);
        }
    }

    public ModelAndView crearOperacion(Request request, Response response) {
        Map<String, Object> parametros = this.getSessionParams(request);

        builder.setUsuarioAlta(this.getUsuario(request));
        OperacionDeEgreso operacionDeEgreso = builder.grabarOperacion();
        EntityManagerHelper.beginTransaction();
        EntityManager entityManager = EntityManagerHelper.getEntityManager();
        entityManager.persist(operacionDeEgreso);

        EntityManagerHelper.commit();

        return mostrarOperaciones(request, response);
    }

}
