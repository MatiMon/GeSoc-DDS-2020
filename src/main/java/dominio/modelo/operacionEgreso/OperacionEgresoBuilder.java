package dominio.modelo.operacionEgreso;

import dominio.modelo.entidad.Entidad;
import dominio.modelo.mediosDePago.MediosDePago;
import dominio.modelo.moneda.Moneda;
import dominio.modelo.operacionEgreso.Etiquetado.RepositorioDeEtiquetas;
import dominio.modelo.presupuesto.ProcesoValidacionOperaciones;
import dominio.modelo.proveedor.Proveedor;
import dominio.modelo.usuario.Usuario;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class OperacionEgresoBuilder {
    private TipoDocumentoComercial tipoDocumentoComercial;
    private int numeroDocumentoComercial;
    private String pathArchivo;
    private Proveedor proveedor;
    private List<Item> items = new ArrayList<>();
    private MediosDePago medioPago;
    private Entidad entidad;
    private Usuario usuarioAlta;
    private int cantidadPresupuestosRequeridos;
    private Moneda moneda;

    public OperacionDeEgreso grabarOperacion() {
        Objects.requireNonNull(this.proveedor, "El proveedor es obligatorio");
        Objects.requireNonNull(this.medioPago, "El medio de pago es obligatorio");
        Objects.requireNonNull(this.entidad, "La entidad es obligatoria");
        Objects.requireNonNull(this.usuarioAlta, "El usuario es obligatorio");
        if (items.isEmpty()) {
            throw new sinItemsException();
        }
        this.entidad.validarGeneracionOperacion();

        OperacionDeEgreso operacion = new OperacionDeEgreso(this.tipoDocumentoComercial,
                this.numeroDocumentoComercial,
                this.pathArchivo,
                this.proveedor,
                new Date(),
                this.items,
                this.medioPago,
                this.entidad,
                this.usuarioAlta,
                this.cantidadPresupuestosRequeridos,
                this.moneda,
                RepositorioDeEtiquetas.getInstance());
        ProcesoValidacionOperaciones.agregarOperacion(operacion);
        return operacion;
    }

    public OperacionEgresoBuilder setTipoDocumentoComercial(TipoDocumentoComercial tipoDoc) {
        this.tipoDocumentoComercial = tipoDoc;
        return this;
    }

    public OperacionEgresoBuilder setNumeroDocumentoComercial(int nroDocumento) {
        this.numeroDocumentoComercial = nroDocumento;
        return this;
    }

    public OperacionEgresoBuilder setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
        return this;
    }

    public OperacionEgresoBuilder agregarItem(Producto producto, int cantidad) {
        items.add(new Item(producto, cantidad));
        return this;
    }

    public OperacionEgresoBuilder eliminarItem(int key) {
        try {
            items.remove(key);
        } catch (Exception e) {
            throw new IntentaEliminarItemInexistenteException(key);
        }
        return this;
    }

    public OperacionEgresoBuilder setMetodoPago(MediosDePago medio) {
        this.medioPago = medio;
        return this;
    }

    public OperacionEgresoBuilder setEntidad(Entidad entidad) {
        this.entidad = entidad;
        return this;
    }

    public List<Item> getItems() {
        return this.items;
    }

    public OperacionEgresoBuilder setPathArchivo(String path) {
        this.pathArchivo = path;
        return this;
    }

    public OperacionEgresoBuilder setUsuarioAlta(Usuario user) {
        this.usuarioAlta = user;
        return this;
    }

    public OperacionEgresoBuilder setCantidadDePresupuestosRequeridos(int cant) {
        this.cantidadPresupuestosRequeridos = cant;
        return this;
    }

    public OperacionEgresoBuilder setMoneda(Moneda moneda){
        this.moneda = moneda;
        return this;
    }

}
