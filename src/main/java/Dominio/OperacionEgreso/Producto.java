package Dominio.OperacionEgreso;

import Persistencia.Persistente;

import javax.persistence.Entity;

@Entity
public class Producto extends Persistente {
	private String id;
	private String nombre;
	private Double precioUnitario;

	public Producto(String id, String nombre, Double precio){
		this.id = id;
		this.nombre = nombre;
		this.precioUnitario = precio;
	}

	public Double getPrecioUnitario() {
		return precioUnitario;
	}
	
	public String getNombreProducto() {
		return nombre;
	}
}
