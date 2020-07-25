package Dominio.Entidad.Categoria;

import Dominio.Entidad.Entidad;

public abstract class ComportamientoCategoria {

    private Boolean encendido = Boolean.FALSE;

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
