package Dominio.Entidad;

import java.util.ArrayList;
import java.util.List;

import Dominio.Direccion.Direccion;
import Dominio.Proveedor.TipoDeCodigoID;

public class EntidadJuridica implements Entidad {
	public String nombreFicticio;
	String razonSocial;
	Direccion direccion;
	TipoDeCodigoID tipoDeCodigoID;
	int codigoID;
	public TipoEntidadJuridica tipo;
	public List<EntidadBase> listaEntidadesBase = new ArrayList<EntidadBase>();
	public String IGJid;
	
	//Constructor:
	public EntidadJuridica(String nombreFicticio, String razonSocial, Direccion direccion, TipoDeCodigoID tipoDeCodigoID, int codigoID, TipoEntidadJuridica tipo) {
		this.nombreFicticio = nombreFicticio;
		this.razonSocial = razonSocial;
		this.direccion = direccion;
		this.tipoDeCodigoID = tipoDeCodigoID;
		this.codigoID =  codigoID;
		this.tipo = tipo;
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
	public void agregarEntidadBase(EntidadBase entidadBase){
		this.listaEntidadesBase.add(entidadBase);
	}
		
	
}
