package Dominio.OperacionEgreso;

import java.math.BigDecimal;

public class Item {
	int cantidad;
	Producto producto;

	public Item (Producto producto, int cantidad){
		this.cantidad = cantidad;
		this.producto = producto;
	}
	
	public Double valorItem() {
		return producto.getPrecioUnitario() * cantidad);
	}
	public String descripcionItem() {
		return String.valueOf(cantidad)+"x"+producto.getNombreProducto()+
				" $"+String.valueOf(producto.getPrecioUnitario())+"c/u";
	}
}
