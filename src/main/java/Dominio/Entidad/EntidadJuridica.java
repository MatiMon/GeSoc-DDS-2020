package Dominio.Entidad;

import java.util.ArrayList;
import java.util.List;

import Dominio.Entidad.Categoria.CategoriaEntidad;
import Dominio.Entidad.Categoria.TiposComportamiento;
import Dominio.Proveedor.TipoDeCodigoID;
import Dominio.Ubicacion.Direccion;

public class EntidadJuridica implements Entidad {
	public String nombreFicticio;
	String razonSocial;
	Direccion direccion;
	TipoDeCodigoID tipoDeCodigoID;
	int codigoID;
	public TipoEntidadJuridica tipo;
	public List<EntidadBase> listaEntidadesBase = new ArrayList<EntidadBase>();
	public String IGJid;
	private CategoriaEntidad categoria;
	private Double valorTotalMontos;
	private Double montoMaximodeEgresos;
	
	//Constructor:
	public EntidadJuridica(String nombreFicticio, String razonSocial, Direccion direccion,
						   TipoDeCodigoID tipoDeCodigoID, int codigoID, TipoEntidadJuridica tipo,
	                       CategoriaEntidad categoria) {
		this.nombreFicticio = nombreFicticio;
		this.razonSocial = razonSocial;
		this.direccion = direccion;
		this.tipoDeCodigoID = tipoDeCodigoID;
		this.codigoID =  codigoID;
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
	public void setMontoMaximodeEgresos(Double valor){this.montoMaximodeEgresos = valor;}

	public void agregarEntidadBase(EntidadBase entidadBase){
		this.categoria.ejecutarSiEstaActivo(this, TiposComportamiento.BLOQUEO_NUEVAS_BASES);
		this.listaEntidadesBase.add(entidadBase);
	}

	public void agregarValorEgreso(double valor){
		this.valorTotalMontos = this.valorTotalMontos + valor;
	}

	public EntidadJuridica entidadJuridica(){
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


}
