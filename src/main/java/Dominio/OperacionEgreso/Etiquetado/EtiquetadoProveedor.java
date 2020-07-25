package Dominio.OperacionEgreso.Etiquetado;

import Dominio.Proveedor.Proveedor;

public class EtiquetadoProveedor implements TipoEtiqueta {

    private Proveedor proveedor;

    public EtiquetadoProveedor(Proveedor proveedor){
        this.proveedor = proveedor;
    }

    @Override
    public String getDescripcion() {
        return proveedor.getRazonSocial();
    }
}
