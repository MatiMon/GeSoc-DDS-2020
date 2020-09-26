package Dominio.OperacionEgreso;

import Persistencia.Persistente;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Producto extends Persistente {

	@Column(name = "id_producto")
	private String idProducto;
	private String nombre;

	@Column(name = "precio_unitario")
	private Double precioUnitario;

	public Producto(String id, String nombre, Double precio){
		this.idProducto = id;
		this.nombre = nombre;
		this.precioUnitario = precio;
	}

	public Double getPrecioUnitario() {
		return precioUnitario;
	}
	
	public String getNombreProducto() {
		return nombre;
	}
	
	public Producto() {
		
	}
}
