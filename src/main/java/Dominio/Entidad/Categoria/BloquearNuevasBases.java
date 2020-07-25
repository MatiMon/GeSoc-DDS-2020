package Dominio.Entidad.Categoria;

import Dominio.Entidad.Entidad;

public class BloquearNuevasBases extends ComportamientoCategoria {

    private TiposComportamiento tipo = TiposComportamiento.BLOQUEO_NUEVAS_BASES;

    @Override
    public boolean esDelTipo(TiposComportamiento tipo){
        return this.tipo.equals(tipo);
    }

    @Override
    public void ejecutar(Entidad entidad) {
        throw new ExcepcionCategoria("Entidad bloqueada para nueva entidad base");
    }
}
