import java.util.ArrayList;

<<<<<<< HEAD
public class EntidadJuridica implements Entidad {
	public String nombreFicticio;
=======
public class EntidadJuridica extends Entidad {
	
>>>>>>> 01b643bc4677ccc39c91ef16a9820d225a49ca80
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

	//Getters	
	public ArrayList<EntidadBase> getListaEntidadesBase() {
		return listaEntidadesBase;
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
		this.listaEntidadesBase = listaEntidadesBase;
	}
	public void setIGJid(String iGJid) {
		IGJid = iGJid;
	}
		
	
}
