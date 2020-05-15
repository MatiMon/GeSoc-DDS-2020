package Dominio.OperacionEgreso;

public class Producto {
	String nombre;
	double precioUnitario;

	public Producto(String nombre, double precio){
		this.nombre = nombre;
		this.precioUnitario = precio;
	}

	public double getPrecioUnitario() {
		return precioUnitario;
	}
	
	public String getNombreProducto() {
		return nombre;
	}
}
