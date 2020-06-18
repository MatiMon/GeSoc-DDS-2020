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
import Dominio.Usuario.*;
import org.junit.Before;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;

public class TestSetUpGeneral {
    private static final ArchivoCacheado owaspFile = new ArchivoCacheado("/password-blacklist.txt", 5555);
    private static final ArchivoCacheado blacklistFile = new ArchivoCacheado("/10k-most-common.txt", 4563);
    protected Proveedor proveedor;
    protected Producto producto1 = new Producto("Prod1", new Double(100));
    protected Producto producto2 = new Producto("Prod2", new Double(200));
    protected Organizacion organizacion = new Organizacion("Org 1");
    protected EntidadJuridica entidadJuridica;
    protected EntidadBase entidadBase;
    protected Usuario usuario1;
    protected ValidadorPasswords validadorPasswords1 = new ValidadorPasswords(
            Arrays.asList(
                    new ValidarPorArchivo(owaspFile),
                    new ValidarPorArchivo(blacklistFile),
                    new ValidarCaracteresConsecutivos(),
                    new ValidarLongitud()
            )
    );


    Direccion direccion = new Direccion("Una calle", "Un numero123", "1712");
    Direccion direccion2 = new Direccion("Otra calle", "1234", "15522");
    TipoDeCodigoID tipoDeCodigoID = TipoDeCodigoID.CUIT;
    DatosBasicos datosBasicos = new DatosBasicos("Una razon social", direccion, tipoDeCodigoID, 1234);
    Empresa empresa = new Empresa(ClasificacionAfip.MEDIANA1);


    @Before
    public void setUp() throws InvalidKeySpecException, NoSuchAlgorithmException {
        entidadJuridica = new EntidadJuridica("entidadJuridica", "el proveedor", direccion2, TipoDeCodigoID.CUIT,
                51112, empresa);
        organizacion.agregarEntidadJuridica(entidadJuridica);
        entidadBase = new EntidadBase("Carlos", "Un buen tipo", entidadJuridica);
        proveedor = new Proveedor("Una razon social", direccion, tipoDeCodigoID, 1234);
        usuario1 = new Usuario("id1","pass1234241sfsf",TipoUsuario.Admin,validadorPasswords1);
    }

    protected MediosDePago unaTarjeta() {
        return new Tarjeta(
                TipoTarjeta.tarjetaCredito,
                "1010202030304040",
                "Juan Perez",
                LocalDateTime.parse("2020-7-1"));
    }

    protected MediosDePago enEectivo() {
        return new Efectivo("12345");
    }

}
