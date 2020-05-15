package Dominio.OperacionEgreso;

public class Item {
	int cantidad;
	Producto producto;

	public Item (Producto producto, int cantidad){
		this.cantidad = cantidad;
		this.producto = producto;
	}
	
	public Double valorItem() {
		return cantidad * producto.getPrecioUnitario();
	}
	public String descripcionItem() {
		return String.valueOf(cantidad)+"x"+producto.getNombreProducto()+
				" $"+String.valueOf(producto.getPrecioUnitario())+"c/u";
	}
}
