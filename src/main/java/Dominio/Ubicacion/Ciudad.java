package Dominio.Ubicacion;

import javax.persistence.*;

@Entity
@Table(name = "ciudad")
public class Ciudad {

    private String nombre;

    @Id
    @Column(name = "id")
    private String idCiudad; // Ejemplo de ID: TUxVQ0FHVWNmYTJk

    @ManyToOne
    @JoinColumn(name = "provincia_id", referencedColumnName = "id")
    private Provincia provincia;

    public Ciudad(String nombre, String id, Provincia provincia) {
        this.nombre = nombre;
        this.idCiudad = id;
        this.provincia = provincia;
    }

    //Getters
    public String getNombre() {
        return nombre;
    }

    public String getIdCiudad() {
        return idCiudad;
    }

    public Provincia getProvincia() {
        return provincia;
    }


}
