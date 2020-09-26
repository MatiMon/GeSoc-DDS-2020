package Dominio.Ubicacion;

import Persistencia.Persistente;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Provincia extends Persistente {
	public String nombre;
	@Column(name = "id_provincia")
	public String idProvincia; // Ejemplo de ID: AR-BS_AS

	@OneToOne
	public Pais pais;
	@OneToMany
	@JoinColumn(name = "id_provincia")
	public List<Ciudad> ciudades = new ArrayList<Ciudad>();
	
	public Provincia(String nombre, String id, Pais pais) {
		this.nombre = nombre;
		this.idProvincia = id;
		this.pais = pais;
	}
	//Getters
	public String getNombre() {
		return nombre;
	}
	public String getIdProvincia() {
		return idProvincia;
	}
	public Pais getPais() {
		return pais;
	}

}
