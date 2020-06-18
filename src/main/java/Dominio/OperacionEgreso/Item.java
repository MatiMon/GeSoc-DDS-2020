package Dominio.OperacionEgreso;


public class Item {
	private int cantidad;
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
}
