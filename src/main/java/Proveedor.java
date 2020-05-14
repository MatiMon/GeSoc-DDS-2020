public class Proveedor {
	public String razonSocial;
	public Direccion direccion;
	public int codigoUnicoDeIdentificacion; // DNI, CUIT o CUIL
	
	//Constructor:
	public Proveedor (String razonSocial, Direccion direccion, int codigoUnicoDeIdentificacion) {
		this.razonSocial = razonSocial;
		this.direccion = direccion;
		this.codigoUnicoDeIdentificacion = codigoUnicoDeIdentificacion;
	}
	
	//Getters/Setters
	public String getRazonSocial() {
		return razonSocial;
	}

	public void setRazonSocial(String razonSocial) {
		this.razonSocial = razonSocial;
	}

	public Direccion getDireccion() {
		return direccion;
	}

	public void setDireccion(Direccion direccion) {
		this.direccion = direccion;
	}

	public int getCodigoUnicoDeIdentificacion() {
		return codigoUnicoDeIdentificacion;
	}

}
