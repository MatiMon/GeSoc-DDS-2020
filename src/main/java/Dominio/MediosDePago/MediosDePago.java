package Dominio.MediosDePago;

import Persistencia.Persistente;

import javax.persistence.*;

@Entity
@DiscriminatorColumn(name = "tipo_pago", length = 1)
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Table(name = "medios_de_pago")
public abstract class MediosDePago extends Persistente {

}
