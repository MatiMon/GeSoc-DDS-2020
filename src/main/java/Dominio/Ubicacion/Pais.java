package Dominio.Ubicacion;

import java.util.ArrayList;
import java.util.List;

public class Pais {
	
	public List<Provincia> provincias = new ArrayList<Provincia>();
	public String nombre;
	public String id; // Ejemplo de ID: AR
	
	//Getters
	public List<Provincia> getProvincias() {
		return provincias;
	}
	public String getNombre() {
		return nombre;
	}
	public String getId() {
		return id;
	}
	
	

}
