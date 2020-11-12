package dominio.modelo.entidad.categoria;

import dominio.modelo.entidad.Entidad;
import db.Persistente;

import javax.persistence.*;

@Entity
@Table(name = "comportamiento_categoria")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tipo_categoria")
public abstract class ComportamientoCategoria extends Persistente {

    private Boolean encendido = Boolean.FALSE;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_comportamiento")
    protected TiposComportamiento tipo;

    @ManyToOne
    @JoinColumn(name = "categoria_entidad_id", referencedColumnName = "id")
    private CategoriaEntidad categoriaEntidad;

    public abstract void ejecutar(Entidad entidad);

    public void encender() {
        this.encendido = Boolean.TRUE;
    }

    public void apagar() {
        this.encendido = Boolean.FALSE;
    }

    public abstract boolean esDelTipo(TiposComportamiento tipo);

    public void ejecutarSiEstaActivo(Entidad entidad) {
        if (this.encendido) {
            this.ejecutar(entidad);
        }
    }

}
