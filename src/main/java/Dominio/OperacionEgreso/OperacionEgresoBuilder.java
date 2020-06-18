package Dominio.OperacionEgreso;

import Dominio.Entidad.Entidad;
import Dominio.MediosDePago.MediosDePago;
import Dominio.Proveedor.Proveedor;
import javafx.util.Pair;

import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;

public class OperacionEgresoBuilder {
    Pair<TipoDocumentoComercial,Integer> documentoContable;
    Proveedor proveedor;
    ArrayList<Item> items = new ArrayList<Item>();
    MediosDePago medioPago;
    Entidad entidad;

    public OperacionDeEgreso grabarOperacion(){
        Objects.requireNonNull(this.proveedor, "El proveedor es obligatorio");
        Objects.requireNonNull(this.medioPago, "El medio de pago es obligatorio");
        Objects.requireNonNull(this.entidad, "La entidad es obligatoria");
        if (items.isEmpty()){
            throw new sinItemsException();
        }
        return new OperacionDeEgreso(this.documentoContable,
                                     this.proveedor,
                                     new Date(),
                                     this.items,
                                     this.medioPago,
                                     this.entidad);
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

    public ArrayList<Item> getItems(){
        return this.items;
    }

}
