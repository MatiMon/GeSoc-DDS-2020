package Dominio.Entidad;

public interface Entidad {
	
	public String getNombreFicticio();

	public EntidadJuridica entidadJuridica();

	public boolean superaMontoMaximo();

	void validarGeneracionOperacion();
}
