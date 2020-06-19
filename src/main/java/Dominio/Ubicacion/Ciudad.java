package Dominio.Ubicacion;

public class Ciudad {
	public String nombre;
	public String id; // Ejemplo de ID: TUxVQ0FHVWNmYTJk
	public String provincia;
	
	public Ciudad(String nombre, String id, String provincia) {
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
	public String getProvincia() {
		return provincia;
	}
	
	

}
