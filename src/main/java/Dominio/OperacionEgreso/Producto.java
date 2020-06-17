package Dominio.OperacionEgreso;

import java.math.BigDecimal;

public class Producto {
	String nombre;
	Double precioUnitario;

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
