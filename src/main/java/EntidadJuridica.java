import java.util.ArrayList;

public class EntidadJuridica implements Entidad {
	public String nombreFicticio;
	DatosBasicos datosBasicos;
	public TipoEntidadJuridica tipo;
	public ArrayList<EntidadBase> entidadesBase;
	public String IGJid;
	
	public void crearEntidadBase (String nombreFicticio, String descripcion, EntidadJuridica entidadJuridica) {
		EntidadBase nuevaEntidadBase = new EntidadBase (nombreFicticio, descripcion, entidadJuridica);
		this.entidadesBase.add(nuevaEntidadBase);
	}
	
	//Constructor:
	public EntidadJuridica(String nombreFicticio, DatosBasicos datosBasicos, TipoEntidadJuridica tipo) {
		this.nombreFicticio = nombreFicticio;
		this.datosBasicos = datosBasicos;
		this.tipo = tipo;
	}

	//Getters	
	public ArrayList<EntidadBase> getListaEntidadesBase() {
		return entidadesBase;
	}
	public String getIGJid() {
		return IGJid;
	}
	public DatosBasicos getDatosBasicos() {
		return datosBasicos;
	}
	public TipoEntidadJuridica getTipo() {
		return tipo;
	}
	public String getNombreFicticio() {
		return nombreFicticio;
	}
	
	// Setters
	public void setListaEntidadesBase(ArrayList<EntidadBase> listaEntidadesBase) {
		this.entidadesBase = listaEntidadesBase;
	}
	public void setIGJid(String iGJid) {
		IGJid = iGJid;
	}
		
	
}
