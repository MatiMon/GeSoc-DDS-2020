package Dominio.Ubicacion;

import Persistencia.Persistente;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

@Entity
public class Direccion extends Persistente {
	public String calle;
	@Column(name = "nro_calle")
	public String nroCalle;
	public String piso;
	public String unidad;
	@OneToOne
	public Ciudad ciudad;
	@OneToOne
	public Provincia provincia;
	@OneToOne
	public Pais pais;

	@Transient
	public RepositorioDeUbicaciones repositorio; //modelar
	
	//Constructor
	public Direccion(String calle, String nroCalle, String piso, String unidad) {
		this.calle = calle;
		this.nroCalle = nroCalle;
		this.piso = piso;
		this.unidad = unidad;
	}

	//Getters
	public String getCalle() {
		return calle;
	}

	public String getNroCalle() {
		return nroCalle;
	}
	
	public String piso() {
		return piso;
	}

	public String nombreCiudad() {
		return ciudad.getNombre();
	}

	public String nombreProvincia() {
		return provincia.getNombre();
	}
	
	public String nombrePais() {
		return pais.getNombre();
	}

	//Setters
	public void setPiso(String piso) { this.piso = piso; }

	public void setCiudad (Ciudad ciudad) { this.ciudad = ciudad; }

	public void setProvincia(Provincia provincia) { this.provincia = provincia;	}

	public void setPais(Pais pais) { this.pais = pais; }
	
}
