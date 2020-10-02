package Dominio.Ubicacion;

import Persistencia.Persistente;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "pais")
public class Pais extends Persistente {

	private String nombre;

	@Column(name = "id_pais")
	private String idPais; // Ejemplo de ID: AR

	@OneToMany (mappedBy = "pais")
	private List<Provincia> provincias = new ArrayList<Provincia>();
	
	
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
