package Dominio.Entidad;
import Dominio.Usuario.Usuario;

import java.util.ArrayList;
import java.util.List;


public class Organizacion {
	String nombre;

	List<EntidadJuridica> entidades = new ArrayList<EntidadJuridica>();
	List<Usuario> usuarios = new ArrayList<Usuario>();

	public Organizacion (String nombre) {
		this.nombre = nombre;
	}
	
	public String getNombre() {
		return nombre;
	}

	public void agregarEntidadJuridica(EntidadJuridica entidadJuridica){
		entidades.add(entidadJuridica);
	}
	
	public void agregarUsuario(Usuario usuario){
		usuarios.add(usuario);
	}


}
