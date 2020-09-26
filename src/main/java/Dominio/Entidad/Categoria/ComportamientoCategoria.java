package Dominio.Entidad.Categoria;

import Dominio.Entidad.Entidad;
import Persistencia.Persistente;

import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public abstract class ComportamientoCategoria extends Persistente {

    private Boolean encendido = Boolean.FALSE;

    @Enumerated
    private TiposComportamiento tipo;

    public abstract void ejecutar(Entidad entidad);

    public void encender(){
        this.encendido = Boolean.TRUE;
    }

    public void apagar(){
        this.encendido = Boolean.FALSE;
    }

    public abstract boolean esDelTipo(TiposComportamiento tipo);

    public void ejecutarSiEstaActivo(Entidad entidad){
        if ( this.encendido ) {
            this.ejecutar(entidad);
        }
    }

}
