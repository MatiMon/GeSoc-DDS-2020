
public class DatosBasicos {
	String razonSocial;
	Direccion direccion;
	TipoDeCodigoID tipoDeCodigoID;
	int codigoID;
	
	//Constructor:
	public DatosBasicos(String razonSocial, Direccion direccion, TipoDeCodigoID tipoDeCodigoID, int codigoID) {
		super();
		this.razonSocial = razonSocial;
		this.direccion = direccion;
		this.tipoDeCodigoID = tipoDeCodigoID;
		this.codigoID = codigoID;
	}
	
	//Getters y setters:
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

	public TipoDeCodigoID getTipoDeCodigoID() {
		return tipoDeCodigoID;
	}

	public int getCodigoID() {
		return codigoID;
	}
	
}
