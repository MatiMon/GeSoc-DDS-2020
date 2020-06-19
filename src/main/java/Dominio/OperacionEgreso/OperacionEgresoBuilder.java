package Dominio.OperacionEgreso;

import Dominio.Entidad.Entidad;
import Dominio.MediosDePago.MediosDePago;
import Dominio.Presupuesto.BatchValidacionOperaciones;
import Dominio.Presupuesto.Presupuesto;
import Dominio.Proveedor.Proveedor;
import Dominio.Usuario.Usuario;
import javafx.util.Pair;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class OperacionEgresoBuilder {
    private Pair<TipoDocumentoComercial, Integer> documentoContable;
    private String pathArchivo;
    private Proveedor proveedor;
    private List<Item> items = new ArrayList<>();
    private MediosDePago medioPago;
    private Entidad entidad;
    private Usuario usuarioAlta;
    private int cantidadPresupuestosRequeridos;
    // Moneda moneda

    public OperacionDeEgreso grabarOperacion() {
        Objects.requireNonNull(this.proveedor, "El proveedor es obligatorio");
        Objects.requireNonNull(this.medioPago, "El medio de pago es obligatorio");
        Objects.requireNonNull(this.entidad, "La entidad es obligatoria");
        Objects.requireNonNull(this.usuarioAlta, "El usuario es obligatorio");
        if (items.isEmpty()) {
            throw new sinItemsException();
        }
        OperacionDeEgreso operacion = new OperacionDeEgreso(this.documentoContable,
                this.pathArchivo,
                this.proveedor,
                new Date(),
                this.items,
                this.medioPago,
                this.entidad,
                this.usuarioAlta,
                this.cantidadPresupuestosRequeridos);
        BatchValidacionOperaciones.agregarOperacion(operacion);
        return operacion;
    }

    public OperacionEgresoBuilder setDocumentoContable(TipoDocumentoComercial tipoDoc, Integer nroDocumento) {
        this.documentoContable = new Pair<TipoDocumentoComercial, Integer>(tipoDoc, nroDocumento);
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
}
