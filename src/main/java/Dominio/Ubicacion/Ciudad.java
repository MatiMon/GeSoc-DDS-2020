package Dominio.Ubicacion;

import Persistencia.Persistente;

import javax.persistence.*;

@Entity
public class Ciudad extends Persistente {
	public String nombre;
	@Column(name = "id_ciudad")
	public String idCiudad; // Ejemplo de ID: TUxVQ0FHVWNmYTJk

	@OneToOne
	public Provincia provincia;
	
	public Ciudad(String nombre, String id, Provincia provincia) {
		this.nombre = nombre;
		this.idCiudad = id;
		this.provincia=provincia;
	}
	//Getters
	public String getNombre() {
		return nombre;
	}
	public String getIdCiudad() {
		return idCiudad;
	}
	public Provincia getProvincia() {
		return provincia;
	}
	
	

}
