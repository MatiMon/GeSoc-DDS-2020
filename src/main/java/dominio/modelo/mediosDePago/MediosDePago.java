package dominio.modelo.mediosDePago;

import db.Persistente;

import javax.persistence.*;

@Entity
@Table(name = "medios_de_pago")
@DiscriminatorColumn(name = "tipo_pago", length = 1)
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public abstract class MediosDePago extends Persistente {

}
