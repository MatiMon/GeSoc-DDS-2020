package Dominio.Ubicacion;

public class Provincia {
	public String nombre;
	public String id; // Ejemplo de ID: AR-BS_AS
	public String pais;
	
	public Provincia(String nombre, String id, String pais) {
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
	public String getPais() {
		return pais;
	}

}
