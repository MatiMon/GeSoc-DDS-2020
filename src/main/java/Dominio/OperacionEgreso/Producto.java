package Dominio.OperacionEgreso;


public class Producto {
	private String nombre;
	private Double precioUnitario;

	public Producto(String nombre, Double precio){
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
