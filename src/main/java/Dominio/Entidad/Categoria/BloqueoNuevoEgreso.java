package Dominio.Entidad.Categoria;

import Dominio.Entidad.Entidad;

import javax.persistence.*;

@Entity
@DiscriminatorValue("EGRESO")
public class BloqueoNuevoEgreso extends ComportamientoCategoria {

    public BloqueoNuevoEgreso() {
        tipo = TiposComportamiento.BLOQUEO_NUEVO_EGRESO;
    }

    @Override
    public boolean esDelTipo(TiposComportamiento tipo) {
        return this.tipo.equals(tipo);
    }

    @Override
    public void ejecutar(Entidad entidad) {
        if (entidad.superaMontoMaximo())
            throw new ExcepcionCategoria("Entidad bloqueada para nuevo egreso por superar maximo");
    }

}
