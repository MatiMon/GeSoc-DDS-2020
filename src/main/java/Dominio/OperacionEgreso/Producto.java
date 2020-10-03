package Dominio.OperacionEgreso;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name = "producto")
public class Producto {

	@Id
	@Column(name = "id")
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
