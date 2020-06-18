package Dominio.OperacionEgreso;

import Dominio.Entidad.Entidad;
import Dominio.MediosDePago.MediosDePago;
import Dominio.Presupuesto.Presupuesto;
import Dominio.Proveedor.Proveedor;
import Dominio.Usuario.Usuario;
import javafx.util.Pair;
import java.util.List;
import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;

public class OperacionEgresoBuilder {
    Pair<TipoDocumentoComercial,Integer> documentoContable;
    String pathArchivo;
    Proveedor proveedor;
    List<Item> items;
    MediosDePago medioPago;
    Entidad entidad;
    Usuario usuarioAlta;
    List<Presupuesto> presupuestos;
    int cantidadPresupuestosRequeridos;
    // Moneda moneda

    public OperacionDeEgreso grabarOperacion(){
        Objects.requireNonNull(this.proveedor, "El proveedor es obligatorio");
        Objects.requireNonNull(this.medioPago, "El medio de pago es obligatorio");
        Objects.requireNonNull(this.entidad, "La entidad es obligatoria");
        Objects.requireNonNull(this.usuarioAlta,"El usuario es Obligatorio");
        if (items.isEmpty()){
            throw new sinItemsException();
        }
        return new OperacionDeEgreso(this.documentoContable,
                                     this.pathArchivo,
                                     this.proveedor,
                                     new Date(),
                (ArrayList<Item>) this.items,
                                     this.medioPago,
                                     this.entidad,
                                     this.usuarioAlta,
                                     this.presupuestos,
                                     this.cantidadPresupuestosRequeridos);
    }

    public OperacionEgresoBuilder setDocumentoContable(TipoDocumentoComercial tipoDoc, Integer nroDocumento)
    {
        this.documentoContable = new Pair<TipoDocumentoComercial, Integer>(tipoDoc, nroDocumento);
        return this;
    }

    public OperacionEgresoBuilder setProveedor(Proveedor proveedor){
        this.proveedor = proveedor;
        return this;
    }
    public OperacionEgresoBuilder agregarItem(Producto producto, int cantidad){
        items.add(new Item(producto, cantidad));
        return this;
    }

    public OperacionEgresoBuilder eliminarItem(int key){
        try {
            items.remove(key);
        }
        catch(Exception e)
        {
            throw new IntentaEliminarItemInexistenteException(key);
        }
        return this;
    }

    public OperacionEgresoBuilder setMetodoPago(MediosDePago medio){
        this.medioPago = medio;
        return this;
    }

    public OperacionEgresoBuilder setEntidad(Entidad entidad){
        this.entidad = entidad;
        return this;
    }

    public List<Item> getItems(){
        return this.items;
    }

    public OperacionEgresoBuilder setPathArchivo(String path){
        this.pathArchivo = path;
        return this;
    }

    public OperacionEgresoBuilder setUsuarioAlta(Usuario user){
        this.usuarioAlta = user;
        return this;
    }

    public OperacionEgresoBuilder agregarPresupuesto(Presupuesto presupuesto){
        presupuestos.add(presupuesto);
        return this;
    }

    public OperacionEgresoBuilder quitarPresupuesto(Presupuesto presupuesto){
        presupuestos.remove(presupuesto);
        return this;
    }

    public OperacionEgresoBuilder SetCantidadDePresupuestosRequeridos(int cant){
        this.cantidadPresupuestosRequeridos = cant;
        return this;
    }
}
