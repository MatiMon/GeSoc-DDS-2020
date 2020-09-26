package Dominio.OperacionEgreso;

import Persistencia.Persistente;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class Item extends Persistente {
	private int cantidad;
	@ManyToOne
	private Producto producto;

	public Item (Producto producto, int cantidad){
		this.cantidad = cantidad;
		this.producto = producto;
	}
	
	public Double valorItem() {
		return producto.getPrecioUnitario() * cantidad;
	}


	public String descripcionItem() {
		return String.valueOf(cantidad)+"x"+producto.getNombreProducto()+
				" $"+String.valueOf(producto.getPrecioUnitario())+"c/u";
	}

	public Producto getProducto(){
		return this.producto;
	}

	public int getCantidad(){
		return this.cantidad;
	}
	
	public Item() {
		
	}
}
