package dominio.modelo.proveedor;

import dominio.modelo.ubicacion.Direccion;
import db.Persistente;

import javax.persistence.*;

@Entity
@Table (name = "proveedor")
public class Proveedor extends Persistente {
    @Column(name = "razon_social")
    private String razonSocial;

    @OneToOne
    private Direccion direccion;

    @Column(name = "tipo_codigo_id")
    @Enumerated(EnumType.ORDINAL)
    private TipoDeCodigoID tipoDeCodigoID;

    @Column(name = "codigo_id")
    private int codigoID;

    //Constructor:
    public Proveedor(String razonSocial, Direccion direccion, TipoDeCodigoID tipoDeCodigoID, int codigoID) {
        this.razonSocial = razonSocial;
        this.direccion = direccion;
        this.tipoDeCodigoID = tipoDeCodigoID;
        this.codigoID = codigoID;
    }

    //Getters
    public String getRazonSocial() {
        return razonSocial;
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public TipoDeCodigoID getTipoDeCodigoID() {
        return tipoDeCodigoID;
    }

    public int getCodigoID() {
        return codigoID;
    }

    // Setters
    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }
    
    public Proveedor() {
    	
    }


}
