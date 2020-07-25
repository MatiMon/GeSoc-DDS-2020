package Dominio.Ubicacion;

public class Provincia {
	public String nombre;
	public String id; // Ejemplo de ID: AR-BS_AS
	public Pais pais;
	
	public Provincia(String nombre, String id, Pais pais) {
		this.nombre = nombre;
		this.id = id;
		this.pais = pais;
	}
	//Getters
	public String getNombre() {
		return nombre;
	}
	public String getId() {
		return id;
	}
	public Pais getPais() {
		return pais;
	}

}
