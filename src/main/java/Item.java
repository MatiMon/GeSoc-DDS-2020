
public class Item {
	int cantidad;
	Producto producto;
	
	public int valorItem() {
		return cantidad*producto.getPrecioUnitario();
	}
	public String descripcionItem() {
		return String.valueOf(cantidad)+"x"+producto.getNombreProducto()+
				" $"+String.valueOf(producto.getPrecioUnitario())+"c/u";
	}
}
