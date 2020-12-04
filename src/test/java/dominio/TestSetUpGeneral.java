package dominio;

import dominio.modelo.entidad.*;
import dominio.modelo.entidad.categoria.CategoriaEntidad;
import dominio.modelo.mediosDePago.Efectivo;
import dominio.modelo.mediosDePago.MediosDePago;
import dominio.modelo.mediosDePago.Tarjeta;
import dominio.modelo.mediosDePago.TipoTarjeta;
import dominio.modelo.operacionEgreso.Producto;
import dominio.modelo.operacionEgreso.TipoDocumentoComercial;
import dominio.modelo.proveedor.Proveedor;
import dominio.modelo.proveedor.TipoDeCodigoID;
import dominio.modelo.ubicacion.Ciudad;
import dominio.modelo.ubicacion.Direccion;
import dominio.modelo.ubicacion.Pais;
import dominio.modelo.ubicacion.Provincia;
import dominio.modelo.usuario.*;
import javafx.util.Pair;
import org.junit.Before;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.Arrays;
import java.util.Date;

public class TestSetUpGeneral {
    private static final ArchivoCacheado owaspFile = new ArchivoCacheado("/password-blacklist.txt", 5555);
    private static final ArchivoCacheado blacklistFile = new ArchivoCacheado("/10k-most-common.txt", 4563);
    protected Proveedor proveedor;
    protected Producto producto1 = new Producto("1000", "Prod1", new Double(100));
    protected Producto producto2 = new Producto("1001", "Prod2", new Double(200));
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
    protected Pair<TipoDocumentoComercial, Integer> documentoContable1 = new Pair<>(TipoDocumentoComercial.Factura,
            1964);


    Pais pais = new Pais("Suiza", "1as");
    Provincia provincia = new Provincia("Berna", "1we", pais);
    Ciudad ciudad = new Ciudad("Berna", "BRN123", provincia);

    protected Direccion direccion = new Direccion("Una calle", "Un numero123", "3", "Oficina 2", ciudad);
    protected Direccion direccion2 = new Direccion("Otra calle", "1234", "8", "D", ciudad);
    protected TipoDeCodigoID tipoDeCodigoID = TipoDeCodigoID.CUIT;
    protected Empresa empresa = new Empresa(ClasificacionAfip.MEDIANA1);
    protected CategoriaEntidad catONG = new CategoriaEntidad("ONG");


    @Before
    public void setUp() throws InvalidKeySpecException, NoSuchAlgorithmException {
        entidadJuridica = new EntidadJuridica("entidadJuridica", "el proveedor", direccion2, TipoDeCodigoID.CUIT,
                51112, empresa, catONG);
        organizacion.agregarEntidadJuridica(entidadJuridica);
        entidadBase = new EntidadBase("Carlos", "Un buen tipo", entidadJuridica);
        proveedor = new Proveedor("Una razon social", direccion, tipoDeCodigoID, 1234);
        usuario1 = new Usuario("id1", "pass1234241sfsf", TipoUsuario.Admin, validadorPasswords1);
    }

    protected MediosDePago unaTarjeta() {
        return new Tarjeta(
                TipoTarjeta.tarjetaCredito,
                "1010202030304040",
                "Juan Perez",
                new Date()
        );
    }

    protected MediosDePago enEectivo() {
        return new Efectivo("12345");
    }

}
