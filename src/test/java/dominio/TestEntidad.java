package dominio;

import Dominio.Entidad.Categoria.CategoriaEntidad;
import Dominio.Entidad.ClasificacionAfip;
import Dominio.Entidad.Empresa;
import Dominio.Entidad.EntidadBase;
import Dominio.Entidad.EntidadJuridica;
import Dominio.Proveedor.TipoDeCodigoID;
import Dominio.Ubicacion.Ciudad;
import Dominio.Ubicacion.Direccion;
import Dominio.Ubicacion.Pais;
import Dominio.Ubicacion.Provincia;

public class TestEntidad {
    Pais pais = new Pais("Suiza", "1as");
    Provincia provincia = new Provincia("Berna", "1we", pais);
    Ciudad ciudad = new Ciudad("Berna", "BRN123", provincia);

    Direccion direccion = new Direccion("Una calle", "Un numero123", "PB", "Mesa de Entrada", ciudad);
    TipoDeCodigoID tipoDeCodigoID = TipoDeCodigoID.CUIT;

    Empresa empresa = new Empresa(ClasificacionAfip.MEDIANA1);
    EntidadJuridica entidadJuridica = new EntidadJuridica("entidadJuridica", "el proveedor",
            direccion, TipoDeCodigoID.CUIT, 51112, empresa, new CategoriaEntidad("ONG"));
    EntidadBase entidadBase = new EntidadBase("Carlos", "Un buen tipo", entidadJuridica);
}
