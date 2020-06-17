package Dominio.Ubicacion;

import java.util.ArrayList;
import java.util.List;

public class Provincia {
	public List<Ciudad> ciudades = new ArrayList<Ciudad>();
	public String nombre;
	public String id; // Ejemplo de ID: AR-BS_AS
	
	//Getters
	public List<Ciudad> getCiudades() {
		return ciudades;
	}
	public String getNombre() {
		return nombre;
	}
	public String getId() {
		return id;
	}

}
