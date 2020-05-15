package Dominio.Proveedor;

public class Proveedor {
	DatosBasicos datosBasicos;

	//Constructor:
	public Proveedor(DatosBasicos datosBasicos) {
		this.datosBasicos = datosBasicos;
	}

	//Getter
	public DatosBasicos getDatosBasicos() {
		return datosBasicos;
	}

}
