package dominio.modelo.entidad;

import dominio.modelo.entidad.categoria.CategoriaEntidad;
import dominio.modelo.operacionEgreso.Etiquetado.EtiquetaEgreso;

import javax.persistence.*;

@Entity
@Table(name = "entidad_base")
public class EntidadBase extends Entidad {
    @Column(name = "nombre_ficticio")
    private String nombreFicticio;
    private String descripcion;

    @ManyToOne
    @JoinColumn(name = "entidad_juridica_id", referencedColumnName = "id")
    private EntidadJuridica entidadJuridica;

    @ManyToOne
    @JoinColumn(name = "categoria_id", referencedColumnName = "id")
    private CategoriaEntidad categoria;

    @Transient
    private Reporte reporte;


    // Constructor
    public EntidadBase(String nombreFicticio, String descripcion, EntidadJuridica entidadJuridica) {
        this.nombreFicticio = nombreFicticio;
        this.descripcion = descripcion;
        this.entidadJuridica = entidadJuridica;
        entidadJuridica.agregarEntidadBase(this);
    }

    public EntidadBase() {

    }

    // Getters
    public String getDescripcion() {
        return descripcion;
    }

    public EntidadJuridica getEntidadJuridica() {
        return entidadJuridica;
    }

    public String getNombreFicticio() {
        return nombreFicticio;
    }

    // Setter
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void agregarValorEgreso(double valor) {
        this.entidadJuridica.agregarValorEgreso(valor);
    }

    public EntidadJuridica entidadJuridica() {
        return this.entidadJuridica;
    }

    @Override
    public boolean superaMontoMaximo() {
        return entidadJuridica.superaMontoMaximo();
    }

    @Override
    public void validarGeneracionOperacion() {
        entidadJuridica.validarGeneracionOperacion();
    }

    @Override
    public void generarReporte(EtiquetaEgreso etiquetaEgreso) {
        reporte.imprimirReporteUltimoMes(etiquetaEgreso, this);
    }

    @Override
    public boolean perteneceAOrganizacion(Organizacion organizacion) {
        return this.entidadJuridica.perteneceAOrganizacion(organizacion);
    }

    public void setEntidadJuridica(EntidadJuridica entidadJuridica){
        this.entidadJuridica = entidadJuridica;
    }

    public CategoriaEntidad getCategoria() {
        return categoria;
    }
}
