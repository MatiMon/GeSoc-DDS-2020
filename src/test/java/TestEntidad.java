import Dominio.Direccion.Direccion;
import Dominio.Entidad.ClasificacionAfip;
import Dominio.Entidad.Empresa;
import Dominio.Entidad.EntidadBase;
import Dominio.Entidad.EntidadJuridica;
import Dominio.Proveedor.DatosBasicos;
import Dominio.Proveedor.TipoDeCodigoID;

import static org.junit.Assert.assertEquals;

public class TestEntidad {
	Direccion direccion = new Direccion("Una calle", "Un numero123", "1712");
	TipoDeCodigoID tipoDeCodigoID = TipoDeCodigoID.CUIT;
	
	Empresa empresa = new Empresa(ClasificacionAfip.MEDIANA1);
	EntidadJuridica entidadJuridica = new EntidadJuridica("entidadJuridica", "el proveedor", direccion, TipoDeCodigoID.CUIT, 51112, empresa);
	EntidadBase entidadBase = new EntidadBase("Carlos", "Un buen tipo", entidadJuridica);
	
}
