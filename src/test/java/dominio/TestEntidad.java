package dominio;

import dominio.modelo.entidad.categoria.CategoriaEntidad;
import dominio.modelo.entidad.ClasificacionAfip;
import dominio.modelo.entidad.Empresa;
import dominio.modelo.entidad.EntidadBase;
import dominio.modelo.entidad.EntidadJuridica;
import dominio.modelo.proveedor.TipoDeCodigoID;
import dominio.modelo.ubicacion.Ciudad;
import dominio.modelo.ubicacion.Direccion;
import dominio.modelo.ubicacion.Pais;
import dominio.modelo.ubicacion.Provincia;

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
