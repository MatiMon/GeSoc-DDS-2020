import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class TestEntidad {
	Direccion direccion = new Direccion("Una calle", "Un numero123", "1712");
	TipoDeCodigoID tipoDeCodigoID = TipoDeCodigoID.CUIT;
	DatosBasicos datosBasicos = new DatosBasicos("Una razon social", direccion, tipoDeCodigoID, 1234);
	
	Empresa empresa = new Empresa(ClasificacionAfip.MEDIANA1);
	EntidadJuridica entidadJuridica = new EntidadJuridica("entidadJuridica", datosBasicos, empresa);
	EntidadBase entidadBase = new EntidadBase("Carlos", "Un buen tipo", entidadJuridica);
	
}
