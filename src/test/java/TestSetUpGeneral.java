import Dominio.Direccion.Direccion;
import Dominio.Entidad.*;
import Dominio.MediosDePago.Efectivo;
import Dominio.MediosDePago.MediosDePago;
import Dominio.MediosDePago.Tarjeta;
import Dominio.MediosDePago.TipoTarjeta;
import Dominio.OperacionEgreso.Producto;
import Dominio.Proveedor.DatosBasicos;
import Dominio.Proveedor.Proveedor;
import Dominio.Proveedor.TipoDeCodigoID;
import org.junit.Before;

import java.math.BigDecimal;

public class TestSetUpGeneral {
    protected Proveedor proveedor;
    protected Producto producto1 = new Producto("Prod1", 100);
    protected Producto producto2 = new Producto("Prod2", 200);
    protected Organizacion organizacion = new Organizacion("Org 1");
    protected EntidadJuridica entidadJuridica;
    protected EntidadBase entidadBase;


    Direccion direccion = new Direccion("Una calle", "Un numero123", "1712");
    Direccion direccion2 = new Direccion("Otra calle", "1234", "15522");
    TipoDeCodigoID tipoDeCodigoID = TipoDeCodigoID.CUIT;
    DatosBasicos datosBasicos = new DatosBasicos("Una razon social", direccion, tipoDeCodigoID, 1234);
    DatosBasicos datosProveedor = new DatosBasicos("el proveedor", direccion2, TipoDeCodigoID.CUIT, 51112);
    Empresa empresa = new Empresa(ClasificacionAfip.MEDIANA1);


    @Before
    public void setUp(){
        entidadJuridica = new EntidadJuridica("entidadJuridica", datosBasicos, empresa);
        organizacion.agregarEntidadJuridica(entidadJuridica);
        entidadBase = new EntidadBase("Carlos", "Un buen tipo", entidadJuridica);
        proveedor = new Proveedor(datosProveedor);
    }

    protected MediosDePago unaTarjeta(){
        return new Tarjeta(
                TipoTarjeta.tarjetaCredito,
                "1010202030304040",
                "123",
                "Juan Perez",
                new java.util.Date(2020,7,1),
                new BigDecimal(20000));
    }

    protected MediosDePago enEectivo(){
        return new Efectivo("12345");
    }

}