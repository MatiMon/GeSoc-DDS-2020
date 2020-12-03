package dominio.modelo.ubicacion;

import db.Persistente;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "provincia")
public class Provincia extends Persistente {

    private String nombre;

    @Column(name = "idProvincia")
    private String idProvincia; // Ejemplo de ID: AR-BS_AS

    @ManyToOne
    @JoinColumn(name = "pais_id", referencedColumnName = "id")
    private Pais pais;

    @OneToMany(mappedBy = "provincia")
    private List<Ciudad> ciudades = new ArrayList<Ciudad>();

    public Provincia(String nombre, String id, Pais pais) {
        this.nombre = nombre;
        this.idProvincia = id;
        this.pais = pais;
    }

    //Getters
    public String getNombre() {
        return nombre;
    }

    public String getIdProvincia() {
        return idProvincia;
    }

    public Pais getPais() {
        return pais;
    }

    public void setCiudades(List<Ciudad> ciudades) {
        this.ciudades = ciudades;
    }

    public List<Ciudad> getCiudades() {
        return ciudades;
    }
}
