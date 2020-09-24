package Dominio.Ubicacion;

import Persistencia.Persistente;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Pais extends Persistente {
	public String nombre;
	@Column(name = "id_pais")
	public String idPais; // Ejemplo de ID: AR
	
	
	public Pais(String nombre, String id) {
		this.nombre = nombre;
		this.idPais = id;
	}
	//Getters
	public String getNombre() {
		return nombre;
	}
	public String getIdPais() {
		return idPais;
	}
	
	

}
