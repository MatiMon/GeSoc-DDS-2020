package Dominio.Entidad.Categoria;

import Dominio.Entidad.Entidad;

import javax.persistence.*;

@Entity
@DiscriminatorValue("BASE")
public class BloquearNuevasBases extends ComportamientoCategoria {

    public BloquearNuevasBases() {
        tipo = TiposComportamiento.BLOQUEO_NUEVAS_BASES;
    }

    @Override
    public boolean esDelTipo(TiposComportamiento tipo) {
        return this.tipo.equals(tipo);
    }

    @Override
    public void ejecutar(Entidad entidad) {
        throw new ExcepcionCategoria("Entidad bloqueada para nueva entidad base");
    }
}
