package Dominio.Entidad;

import Dominio.OperacionEgreso.Etiquetado.EtiquetaEgreso;

public interface Entidad {
	
	public String getNombreFicticio();

	public EntidadJuridica entidadJuridica();

	public boolean superaMontoMaximo();

	void validarGeneracionOperacion();

	void generarReporte(EtiquetaEgreso etiquetaEgreso);
}
