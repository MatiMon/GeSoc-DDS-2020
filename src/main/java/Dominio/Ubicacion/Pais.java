package Dominio.Ubicacion;


public class Pais {
	public String nombre;
	public String id; // Ejemplo de ID: AR
	
	
	public Pais(String nombre, String id) {
		this.nombre = nombre;
		this.id = id;
	}
	//Getters
	public String getNombre() {
		return nombre;
	}
	public String getId() {
		return id;
	}
	
	

}
