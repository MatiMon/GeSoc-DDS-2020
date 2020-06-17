package Dominio.Ubicacion;

public class Direccion {
	public String calle;
	public String nroCalle;
	public String codigoPostal;
	public String piso;
	public String nombreCiudad;
	public String nombreProvincia;
	public String nombrePais;
	public RepositorioDeUbicaciones repositorio; //modelar 
	
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
	
	public String piso() {
		return piso;
	}

	public String nombreCiudad() {
		return nombreCiudad;
	}

	public String nombreProvincia() {
		return nombreProvincia;
	}
	
	public String nombrePais() {
		return nombrePais;
	}
	
}
