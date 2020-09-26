package Dominio.Entidad;
import Dominio.Entidad.Categoria.CategoriaEntidad;
import Dominio.Usuario.Usuario;
import Persistencia.Persistente;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Organizacion extends Persistente {
	private String nombre;

	@OneToMany
	@JoinColumn(name = "id_organizacion")
	List<EntidadJuridica> entidades = new ArrayList<EntidadJuridica>();

	@OneToMany
	@JoinColumn(name = "id_organizacion")
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
