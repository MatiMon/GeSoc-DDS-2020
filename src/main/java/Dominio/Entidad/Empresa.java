package Dominio.Entidad;

import javax.persistence.*;

@Entity
@DiscriminatorValue("E")
public class Empresa extends TipoEntidadJuridica {
    @Enumerated(EnumType.STRING)
    ClasificacionAfip clasificacion;

    // Constructor
    public Empresa(ClasificacionAfip clasificacion) {
        this.clasificacion = clasificacion;
    }

    // Getter
    public ClasificacionAfip getClasificacion() {
        return clasificacion;
    }

}
