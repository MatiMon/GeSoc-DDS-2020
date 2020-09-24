package Dominio.Entidad;

import Dominio.OperacionEgreso.Etiquetado.EtiquetaEgreso;
import Persistencia.Persistente;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public abstract class Entidad extends Persistente {

    public abstract String getNombreFicticio();

    public abstract EntidadJuridica entidadJuridica();

    public abstract boolean superaMontoMaximo();

    public abstract void validarGeneracionOperacion();

    public abstract void generarReporte(EtiquetaEgreso etiquetaEgreso);
}
