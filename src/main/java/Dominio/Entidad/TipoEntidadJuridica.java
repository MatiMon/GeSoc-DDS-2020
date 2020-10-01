package Dominio.Entidad;

import Persistencia.Persistente;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tipo_entidad_juridica", length = 2)
public abstract class TipoEntidadJuridica extends Persistente {
	
}
