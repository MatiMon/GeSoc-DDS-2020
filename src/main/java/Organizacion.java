import java.util.ArrayList;

public class Organizacion {
	String nombre;
	
	ArrayList<EntidadJuridica> entidadesJuridicas = new ArrayList<EntidadJuridica>();

	public void crearEntidadJuridica (String nombreFicticio, DatosBasicos datosBasicos, TipoEntidadJuridica tipo) {
		EntidadJuridica nuevaEntidadJuridica = new EntidadJuridica (nombreFicticio, datosBasicos, tipo);
		this.entidadesJuridicas.add(nuevaEntidadJuridica);
	}
	
	//Constructor:
	public Organizacion (String nombre) {
		this.nombre = nombre;
	}
	
	//Getters:
	public String getNombre() {
		return nombre;
	}
}
