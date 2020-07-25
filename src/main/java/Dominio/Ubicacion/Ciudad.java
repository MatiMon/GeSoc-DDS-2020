package Dominio.Ubicacion;

public class Ciudad {
	public String nombre;
	public String id; // Ejemplo de ID: TUxVQ0FHVWNmYTJk
	public Provincia provincia;
	
	public Ciudad(String nombre, String id, Provincia provincia) {
		this.nombre = nombre;
		this.id = id;
		this.provincia=provincia;
	}
	//Getters
	public String getNombre() {
		return nombre;
	}
	public String getId() {
		return id;
	}
	public Provincia getProvincia() {
		return provincia;
	}
	
	

}
