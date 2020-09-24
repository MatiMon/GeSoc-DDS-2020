package Dominio.MediosDePago;

import Persistencia.Persistente;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@DiscriminatorColumn(name = "tipo", length = 1)
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public abstract class MediosDePago extends Persistente {

}
