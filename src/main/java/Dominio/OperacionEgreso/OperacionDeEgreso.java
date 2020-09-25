package Dominio.OperacionEgreso;

import Dominio.Entidad.Entidad;
import Dominio.MediosDePago.MediosDePago;
import Dominio.Moneda.Moneda;
import Dominio.OperacionEgreso.Etiquetado.EtiquetaEgreso;
import Dominio.OperacionEgreso.Etiquetado.RepositorioDeEtiquetas;
import Dominio.Presupuesto.Presupuesto;
import Dominio.Proveedor.Proveedor;
import Dominio.Usuario.Usuario;
import Persistencia.Persistente;
import javafx.util.Pair;
import jdk.nashorn.internal.ir.annotations.Reference;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

//import org.apache.commons.lang3.tuple.Pair;

@Entity
public class OperacionDeEgreso extends Persistente {

    private TipoDocumentoComercial tipoDocumentoComercial;
    private int numeroDocumentoComercial;


    @Column(name = "path_archivo")
    private String pathArchivo;
    @ManyToOne
    private Proveedor proveedor;
    @Column(name = "fecha_operacion")
    private Date f_Operacion;
    @OneToMany
    @JoinColumn(name = "operacion_id")
    private List<Item> items;
    @ManyToOne
    private MediosDePago pago;
    @ManyToOne
    private Entidad entidad;
    @ManyToOne
    private Usuario usuarioAlta;
    private Double valorTotal;
    @OneToMany
    @JoinColumn(name= "id_operacion")
    private List<Presupuesto> presupuestos = new ArrayList<>();
    @Column(name ="cantidad_presupuestos_requeridos")
    private int cantidadPresupuestosRequeridos;

    @ManyToMany
    private List<Usuario> usuariosRevisores = new ArrayList<>();

    @ManyToOne
    private Moneda moneda;
    private Boolean informada;
    @Transient
    private RepositorioDeEtiquetas repositorioDeEtiquetas;

    public OperacionDeEgreso(TipoDocumentoComercial tipoDocumentoComercial,
                             int numeroDocumentoComercial,
                             String path,
                             Proveedor proveedor,
                             Date f_Operacion,
                             List<Item> items,
                             MediosDePago pago,
                             Entidad entidad,
                             Usuario unUser,
                             int cantPresupuestos,
                             Moneda moneda,
                             RepositorioDeEtiquetas repositorioDeEtiquetas) {
        this.tipoDocumentoComercial = tipoDocumentoComercial;
        this.numeroDocumentoComercial = numeroDocumentoComercial;
        this.pathArchivo = path;
        this.proveedor = proveedor;
        this.items = items;
        this.f_Operacion = f_Operacion;
        this.pago = pago;
        this.entidad = entidad;
        this.valorTotal = this.valorTotal();
        this.usuarioAlta = unUser;
        this.cantidadPresupuestosRequeridos = cantPresupuestos;
        this.moneda = moneda;
        this.informada = Boolean.FALSE;
        this.repositorioDeEtiquetas = repositorioDeEtiquetas;
    }

    public Double valorTotal() {
        return items.stream()
                .mapToDouble(item -> item.valorItem())
                .sum();
    }

    public void agregarUsuarioRevisor(Usuario user) {
        usuariosRevisores.add(user);
    }

    public void quitarUsuarioRevisor(Usuario user) {
        usuariosRevisores.remove(user);
    }

    public void agregarPresupuesto(Presupuesto presupuesto) {
        this.presupuestos.add(presupuesto);
    }

    public void quitarPresupuesto(Presupuesto presupuesto) {
        this.presupuestos.remove(presupuesto);
    }


    public TipoDocumentoComercial getTipoDocumentoComercial() {
        return tipoDocumentoComercial;
    }

    public Integer getNumeroDocumentoComercial() {
        return numeroDocumentoComercial;
    }

    public Proveedor getProveedor() {
        return this.proveedor;
    }

    public Date getFechaOperacion() {
        return this.f_Operacion;
    }

    public Entidad getEntidad() {
        return this.entidad;
    }

    public List<Item> getItems() {
        return this.items;
    }

    public MediosDePago getPago() {
        return this.pago;
    }

    public Double getValorTotal() {
        return valorTotal;
    }

    public List<Presupuesto> getPresupuestos() {
        return presupuestos;
    }

    public int getCantidadPresupuestosRequeridos() {
        return cantidadPresupuestosRequeridos;
    }

    public List<Usuario> getUsuariosRevisores() {
        return usuariosRevisores;
    }

    public void informarValidacion(boolean validacion) {
        getUsuariosRevisores().stream().forEach(usuario -> usuario.notificar(this, validacion));
        this.informada = Boolean.TRUE;
    }

    public boolean pendienteInformar() {
        return !this.informada;
    }

    public Moneda getMoneda() {
        return this.moneda;
    }

    public void agregarEtiqueta(EtiquetaEgreso etiqueta) {
        this.repositorioDeEtiquetas.agregarEtiqueta(this, etiqueta);
    }

    public void quitarEtiqueta(EtiquetaEgreso etiqueta) {
        this.repositorioDeEtiquetas.quitarEtiqueta(this, etiqueta);
    }
    
    public OperacionDeEgreso() {
    	
    }
}
