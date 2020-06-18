package Dominio.Proveedor;

import Dominio.Ubicacion.Direccion;

public class DatosBasicos {
	String razonSocial;
	Direccion direccion;
	TipoDeCodigoID tipoDeCodigoID;
	int codigoID;
	
	//Constructor:
	public DatosBasicos(String razonSocial, Direccion direccion, TipoDeCodigoID tipoDeCodigoID, int codigoID) {
		this.razonSocial = razonSocial;
		this.direccion = direccion;
		this.tipoDeCodigoID = tipoDeCodigoID;
		this.codigoID = codigoID;
	}
	
	//Getters
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
	
	// Setters
	public void setRazonSocial(String razonSocial) {
		this.razonSocial = razonSocial;
	}
	public void setDireccion(Direccion direccion) {
		this.direccion = direccion;
	}
	
}
