package Dominio.OperacionEgreso.Etiquetado;

import Persistencia.Persistente;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tipo_etiquetado")
public abstract class TipoEtiqueta extends Persistente {
    abstract String getDescripcion();
}
