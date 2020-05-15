package Dominio.Direccion;

public class Direccion {
	public String calle;
	public String nroCalle;
	public String codigoPostal;
	
	//Constructor
	public Direccion(String calle, String nroCalle, String codigoPostal) {
		this.calle = calle;
		this.nroCalle = nroCalle;
		this.codigoPostal = codigoPostal;
	}

	//Getters
	public String getCalle() {
		return calle;
	}

	public String getNroCalle() {
		return nroCalle;
	}

	public String getCodigoPostal() {
		return codigoPostal;
	}
	
}
