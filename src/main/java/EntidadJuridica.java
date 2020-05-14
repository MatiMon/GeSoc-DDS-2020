import java.util.ArrayList;

public class EntidadJuridica extends Entidad {
	
	public String nombreFicticio;
	DatosBasicos datosBasicos;
	public TipoEntidadJuridica tipo;
	public ArrayList<EntidadBase> listaEntidadesBase;
	public String IGJid;
	
	//Constructor:
	public EntidadJuridica(String nombreFicticio, DatosBasicos datosBasicos, TipoEntidadJuridica tipo) {
		this.nombreFicticio = nombreFicticio;
		this.datosBasicos = datosBasicos;
		this.tipo = tipo;
	}

	//Getters y Setters:	
	public ArrayList<EntidadBase> getListaEntidadesBase() {
		return listaEntidadesBase;
	}

	public void setListaEntidadesBase(ArrayList<EntidadBase> listaEntidadesBase) {
		this.listaEntidadesBase = listaEntidadesBase;
	}

	public String getIGJid() {
		return IGJid;
	}

	public void setIGJid(String iGJid) {
		IGJid = iGJid;
	}

	public DatosBasicos getDatosBasicos() {
		return datosBasicos;
	}

	public TipoEntidadJuridica getTipo() {
		return tipo;
	}
		
	
}
