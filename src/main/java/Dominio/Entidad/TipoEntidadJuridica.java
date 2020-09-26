package Dominio.Entidad;

import Persistencia.Persistente;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tipo_entidad_juridica", length = 2)
public abstract class TipoEntidadJuridica extends Persistente {
	
}
