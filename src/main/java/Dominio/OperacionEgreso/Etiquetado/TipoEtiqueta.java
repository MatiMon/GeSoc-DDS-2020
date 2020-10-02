package Dominio.OperacionEgreso.Etiquetado;

import Persistencia.Persistente;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tipo_etiquetado")
@Table(name = "tipo_etiqueta")
public abstract class TipoEtiqueta extends Persistente {
    abstract String getDescripcion();
}
