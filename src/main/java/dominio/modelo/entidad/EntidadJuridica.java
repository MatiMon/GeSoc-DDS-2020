package dominio.modelo.entidad;

import db.converters.ConverterTipoEntidadJuridica;
import dominio.modelo.entidad.categoria.CategoriaEntidad;
import dominio.modelo.entidad.categoria.TiposComportamiento;
import dominio.modelo.operacionEgreso.Etiquetado.EtiquetaEgreso;
import dominio.modelo.proveedor.TipoDeCodigoID;
import dominio.modelo.ubicacion.Direccion;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "entidad_juridica")
public class EntidadJuridica extends Entidad {
    @Column(name = "nombre_ficticio")
    private String nombreFicticio;

    @Column(name = "razon_social")
    private String razonSocial;

    @OneToOne
    private Direccion direccion;

    @Column(name = "tipo_codigo_id")
    @Enumerated(EnumType.ORDINAL)
    private TipoDeCodigoID tipoDeCodigoID;

    @Column(name = "codigo_id")
    private int codigoID;

    @Column(name = "tipo_entidad_juridica")
    @Convert(converter = ConverterTipoEntidadJuridica.class)
    private TipoEntidadJuridica tipo;

    @OneToMany(mappedBy = "entidadJuridica") //nombre de la variable en EntidadBase que usamos para mapear la relacion
    private List<EntidadBase> listaEntidadesBase = new ArrayList<EntidadBase>();

    @Column(name = "IGJ_id")
    private String IGJid;

    @ManyToOne
    @JoinColumn(name = "categoria_id", referencedColumnName = "id")
    private CategoriaEntidad categoria;

    @Column(name = "valor_total_montos")
    private Double valorTotalMontos = 0.00;

    @Column(name = "monto_maximo_de_egresos")
    private Double montoMaximodeEgresos;

    @ManyToOne
    @JoinColumn(name = "organizacion_id", referencedColumnName = "id")
    private Organizacion organizacion;

    @Transient
    private Reporte reporte;

    @Transient
    private String categoriaString;

    //Constructor:
    public EntidadJuridica(String nombreFicticio, String razonSocial, Direccion direccion,
                           TipoDeCodigoID tipoDeCodigoID, int codigoID, TipoEntidadJuridica tipo,
                           CategoriaEntidad categoria) {
        this.nombreFicticio = nombreFicticio;
        this.razonSocial = razonSocial;
        this.direccion = direccion;
        this.tipoDeCodigoID = tipoDeCodigoID;
        this.codigoID = codigoID;
        this.tipo = tipo;
        this.categoria = categoria;
    }

    public EntidadJuridica() {

    }

    //Getters
    public List<EntidadBase> getListaEntidadesBase() {
        return listaEntidadesBase;
    }

    public String getIGJid() {
        return IGJid;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public TipoDeCodigoID getTipoDeCodigoID() {
        return tipoDeCodigoID;
    }

    public int getCodigoID() {
        return codigoID;
    }

    public TipoEntidadJuridica getTipo() {
        return tipo;
    }

    public String getNombreFicticio() {
        return nombreFicticio;
    }

    // Setters
    public void setListaEntidadesBase(ArrayList<EntidadBase> listaEntidadesBase) {
        this.listaEntidadesBase = listaEntidadesBase;
    }

    public void setIGJid(String iGJid) {
        IGJid = iGJid;
    }

    public void setMontoMaximodeEgresos(Double valor) {
        this.montoMaximodeEgresos = valor;
    }

    public void agregarEntidadBase(EntidadBase entidadBase) {
        this.categoria.ejecutarSiEstaActivo(this, TiposComportamiento.BLOQUEO_NUEVAS_BASES);
        this.listaEntidadesBase.add(entidadBase);
    }

    public void agregarValorEgreso(double valor) {
        this.valorTotalMontos = this.valorTotalMontos + valor;
    }

    public EntidadJuridica entidadJuridica() {
        return this;
    }

    @Override
    public boolean superaMontoMaximo() {
        return this.montoMaximodeEgresos > this.valorTotalMontos;
    }

    @Override
    public void validarGeneracionOperacion() {
        this.categoria.ejecutarSiEstaActivo(this, TiposComportamiento.BLOQUEO_NUEVO_EGRESO);
    }

    @Override
    public void generarReporte(EtiquetaEgreso etiquetaEgreso) {
        reporte.imprimirReporteUltimoMes(etiquetaEgreso, this);
    }

    @Override
    public boolean perteneceAOrganizacion(Organizacion organizacion) {
        return this.organizacion == organizacion;
    }

    public void setOrganizacion(Organizacion organizacion) {
        this.organizacion = organizacion;
    }

    public Organizacion getOrganizacion() {
        return this.organizacion;
    }

    public CategoriaEntidad getCategoria() {
        return categoria;
    }

    public void setCategoria(CategoriaEntidad categoria) {
        this.categoria = categoria;
    }

    public String getCategoriaString(){
        if (categoria == null){
            return "Sin Categoría";
        }
        return categoria.getNombre();
    }
}
