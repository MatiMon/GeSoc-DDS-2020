package Dominio.Entidad;

import Dominio.Entidad.Categoria.CategoriaEntidad;
import Dominio.Entidad.Categoria.TiposComportamiento;
import Dominio.OperacionEgreso.Etiquetado.EtiquetaEgreso;
import Dominio.Proveedor.TipoDeCodigoID;
import Dominio.Ubicacion.Direccion;
import Persistencia.ConverterTipoEntidadJuridica;

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
    private Double valorTotalMontos;

    @Column(name = "monto_maximo_de_egresos")
    private Double montoMaximodeEgresos;

    @ManyToOne
    @JoinColumn(name = "organizacion_id", referencedColumnName = "id")
    private Organizacion organizacion;

    @Transient
    private Reporte reporte;

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


}
