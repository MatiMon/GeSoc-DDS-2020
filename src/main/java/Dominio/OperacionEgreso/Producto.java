package Dominio.OperacionEgreso;

import java.math.BigDecimal;

public class Producto {
	String nombre;
	BigDecimal precioUnitario;

	public Producto(String nombre, BigDecimal precio){
		this.nombre = nombre;
		this.precioUnitario = precio;
	}

	public BigDecimal getPrecioUnitario() {
		return precioUnitario;
	}
	
	public String getNombreProducto() {
		return nombre;
	}
}
