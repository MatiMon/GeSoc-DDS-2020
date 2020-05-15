package Dominio.Entidad;

import Dominio.Proveedor.DatosBasicos;

import java.util.ArrayList;

public class Organizacion {
	String nombre;

	ArrayList<EntidadJuridica> entidades = new ArrayList<EntidadJuridica>();

	public Organizacion (String nombre) {
		this.nombre = nombre;
	}
	
	public String getNombre() {
		return nombre;
	}

	public void agregarEntidadJuridica(EntidadJuridica entidadJuridica){
		entidades.add(entidadJuridica);
	}


}
