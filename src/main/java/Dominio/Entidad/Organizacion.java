package Dominio.Entidad;

import Dominio.Usuario.Usuario;
import Persistencia.Persistente;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "organizacion")
public class Organizacion extends Persistente {

	private String nombre;

	@OneToMany (mappedBy = "organizacion")
	private List<EntidadJuridica> entidades = new ArrayList<>();

	@OneToMany (mappedBy = "organizacion")
	private List<Usuario> usuarios = new ArrayList<>();

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
