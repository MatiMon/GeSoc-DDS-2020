package Dominio.Proveedor;

import Dominio.Ubicacion.Direccion;
import Persistencia.Persistente;

import javax.persistence.Entity;

@Entity
public class Proveedor extends Persistente {
    String razonSocial;
    Direccion direccion;
    TipoDeCodigoID tipoDeCodigoID;
    int codigoID;

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


}
