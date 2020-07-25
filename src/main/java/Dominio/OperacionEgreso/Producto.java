package Dominio.OperacionEgreso;


public class Producto {
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
