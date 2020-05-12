import java.util.ArrayList;

public class EntidadJuridica implements Entidad {
	public TipoEntidadJuridica tipo;
	public ClasificacionAfip clasificacion;
	public ArrayList<EntidadBase> listaEntidadesBase;
	public String razonSocial;
	public String nombreFicticio;	
	public Integer CUIT;
	public String IGJid;
	public Direccion direccion;
}
