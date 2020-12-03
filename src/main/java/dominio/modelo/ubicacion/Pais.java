package dominio.modelo.ubicacion;

import db.Persistente;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "pais")
public class Pais extends Persistente {

    private String nombre;

    @Column(name = "idPais")
    private String idPais; // Ejemplo de ID: AR

    @OneToMany(mappedBy = "pais")
    private List<Provincia> provincias = new ArrayList<>();


    public Pais(String nombre, String id) {
        this.nombre = nombre;
        this.idPais = id;
    }

    //Getters
    public String getNombre() {
        return nombre;
    }

    public String getIdPais() {
        return idPais;
    }

    public void setProvincias(List<Provincia> provincias) {
        this.provincias = provincias;
    }

    public List<Provincia> getProvincias() {
        return provincias;
    }
}
