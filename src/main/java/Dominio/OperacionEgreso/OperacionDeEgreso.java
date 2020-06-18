package Dominio.OperacionEgreso;

import Dominio.Entidad.Entidad;
import Dominio.MediosDePago.MediosDePago;
import Dominio.Presupuesto.Presupuesto;
import Dominio.Proveedor.Proveedor;
import Dominio.Usuario.Usuario;
import javafx.util.Pair;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

//import org.apache.commons.lang3.tuple.Pair;

public class OperacionDeEgreso {
    private Pair<TipoDocumentoComercial, Integer> documentoContable;
    private String pathArchivo;
    private Proveedor proveedor;
    private Date f_Operacion;
    private List<Item> items;
    private MediosDePago pago;
    private Entidad entidad;
    private Usuario usuarioAlta;
    private Double valorTotal;
    private List<Presupuesto> presupuestos = new ArrayList<>();
    private int cantidadPresupuestosRequeridos;
    private List<Usuario> usuariosRevisores = new ArrayList<>();
    // private Moneda moneda


    public OperacionDeEgreso(Pair<TipoDocumentoComercial, Integer> documentoContable,
                             String path,
                             Proveedor proveedor,
                             Date f_Operacion,
                             List<Item> items,
                             MediosDePago pago,
                             Entidad entidad,
                             Usuario unUser,
                             int cantPresupuestos) {
        this.documentoContable = documentoContable;
        this.pathArchivo = path;
        this.proveedor = proveedor;
        this.items = items;
        this.f_Operacion = f_Operacion;
        this.pago = pago;
        this.entidad = entidad;
        this.valorTotal = this.valorTotal();
        this.usuarioAlta = unUser;
        this.cantidadPresupuestosRequeridos = cantPresupuestos;
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

/*
	void notificarRevisores(){
		usuariosRevisores.forEach(usuario -> usuario.notificar());
	}*/

    public void agregarPresupuesto(Presupuesto presupuesto) {
        this.presupuestos.add(presupuesto);
    }

    public void quitarPresupuesto(Presupuesto presupuesto) {
        this.presupuestos.remove(presupuesto);
    }


    public TipoDocumentoComercial getTipoDocumentoComercial() {
        return documentoContable.getKey();
    }

    public Integer getNroDocumentoComercial() {
        return documentoContable.getValue();
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

    public Pair<TipoDocumentoComercial, Integer> getDocumentoComercial() {
        return this.documentoContable;
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

    public void setUsuariosRevisores(List<Usuario> usuariosRevisores) {
        this.usuariosRevisores = usuariosRevisores;
    }

}
