package Dominio.Entidad;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

public class OSC implements TipoEntidadJuridica {

    @Override
    public String getIdentificador(){
        return "OSC";
    }
}