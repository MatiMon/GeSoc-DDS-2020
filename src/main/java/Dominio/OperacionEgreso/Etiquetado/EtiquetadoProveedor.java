package Dominio.OperacionEgreso.Etiquetado;

import Dominio.Proveedor.Proveedor;

import javax.persistence.DiscriminatorValue;

@DiscriminatorValue("Proveedor")
public class EtiquetadoProveedor extends TipoEtiqueta {

    private Proveedor proveedor;

    public EtiquetadoProveedor(Proveedor proveedor){
        this.proveedor = proveedor;
    }

    @Override
    public String getDescripcion() {
        return proveedor.getRazonSocial();
    }
}
