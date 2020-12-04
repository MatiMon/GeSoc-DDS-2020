package dominio.modelo.operacionEgreso.Etiquetado;

import dominio.modelo.proveedor.Proveedor;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
@DiscriminatorValue("Proveedor")
public class EtiquetadoProveedor extends TipoEtiqueta {

    @OneToOne
    private Proveedor proveedor;

    public EtiquetadoProveedor(Proveedor proveedor){
        this.proveedor = proveedor;
    }

    @Override
    public String getDescripcion() {
        return proveedor.getRazonSocial();
    }
}
