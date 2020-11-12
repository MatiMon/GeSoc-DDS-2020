package dominio.modelo.ubicacion;

import db.Persistente;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table (name = "direccion")
public class Direccion extends Persistente {
    private String calle;
    @Column(name = "nro_calle")
    private String nroCalle;
    private String piso;
    private String unidad;
    private String ciudad;
    private String provincia;
    private String pais;

    @Transient
    private RepositorioDeUbicaciones repositorio; //modelar

    //Constructor
    public Direccion(String calle, String nroCalle, String piso, String unidad, Ciudad ciudad) {
        this.calle = calle;
        this.nroCalle = nroCalle;
        this.piso = piso;
        this.unidad = unidad;
        this.pais = ciudad.getProvincia().getPais().getNombre();
        this.provincia = ciudad.getProvincia().getNombre();
        this.ciudad = ciudad.getNombre();
    }

    //Getters
    public String getCalle() {
        return calle;
    }

    public String getNroCalle() {
        return nroCalle;
    }

    public String piso() {
        return piso;
    }

    public String nombreCiudad() {
        return ciudad;
    }

    public String nombreProvincia() {
        return provincia;
    }

    public String nombrePais() {
        return pais;
    }

    //Setters
    public void setPiso(String piso) {
        this.piso = piso;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

}
