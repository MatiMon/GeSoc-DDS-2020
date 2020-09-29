package Dominio.Entidad;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("O")
public class OSC extends TipoEntidadJuridica {

}