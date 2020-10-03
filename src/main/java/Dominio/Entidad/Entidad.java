package Dominio.Entidad;

import Dominio.OperacionEgreso.Etiquetado.EtiquetaEgreso;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Entidad {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;

    public Long getId(){
        return id;
    }

    public abstract String getNombreFicticio();

    public abstract EntidadJuridica entidadJuridica();

    public abstract boolean superaMontoMaximo();

    public abstract void validarGeneracionOperacion();

    public abstract void generarReporte(EtiquetaEgreso etiquetaEgreso);
}
