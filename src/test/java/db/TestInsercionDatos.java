package db;

import dominio.TestSetUpGeneral;
import dominio.modelo.entidad.*;
import dominio.modelo.mediosDePago.Efectivo;
import dominio.modelo.mediosDePago.MediosDePago;
import dominio.modelo.operacionEgreso.OperacionDeEgreso;
import dominio.modelo.operacionEgreso.OperacionEgresoBuilder;
import dominio.modelo.operacionEgreso.Producto;
import dominio.modelo.operacionEgreso.TipoDocumentoComercial;
import dominio.modelo.proveedor.TipoDeCodigoID;
import dominio.modelo.ubicacion.Ciudad;
import dominio.modelo.ubicacion.Direccion;
import dominio.modelo.ubicacion.Pais;
import dominio.modelo.ubicacion.Provincia;
import dominio.modelo.usuario.Mensaje;
import dominio.modelo.usuario.TipoUsuario;
import dominio.modelo.usuario.Usuario;
import org.junit.Before;
import org.junit.Test;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

public class TestInsercionDatos extends TestSetUpGeneral {
    //Organizaciones
    public Organizacion eaaf = new Organizacion("Equipo Argentino de Antropología Forense - EAAF");
    public Organizacion cdia = new Organizacion("Colectivo de Derechos de Infancia y Adolescencia - CDIA");

    //entidades eaaf
    public Pais argentina = new Pais("Argentina", "ARG");
    public Provincia provBuenosAires = new Provincia("Buenos Aires", "BA", argentina);
    public Ciudad buenosAires = new Ciudad("Buenos Aires", "CABA", provBuenosAires);
    public Direccion direccionBsAs = new Direccion("Av. Medrano", "951", null, null, buenosAires);
    public EntidadJuridica oficinaBsAs = new EntidadJuridica("Oficina Central Buenos Aires", "EAAF BA", direccionBsAs,
            TipoDeCodigoID.CUIL, 301526921, new Empresa(ClasificacionAfip.MEDIANA1), null);

    public Pais usa = new Pais("Estados Unidos", "USA");
    public Provincia ny = new Provincia("Nueva York", "NY", usa);
    public Ciudad brooklyn = new Ciudad("Brooklyn", "BKLN", ny);
    public Direccion direccionUsa = new Direccion("Liberty Ave", "720", null, null, brooklyn);
    public EntidadJuridica oficinaUsa = new EntidadJuridica("Oficina Central Nueva York", "EAAF NY", direccionUsa,
            TipoDeCodigoID.CUIL, 301526357, new Empresa(ClasificacionAfip.MEDIANA1), null);

    public Pais mexico = new Pais("Mexico", "MX");
    public Provincia provDeMexico = new Provincia("Ciudad de Mexico", "MX", mexico);
    public Ciudad ciudadDeMexico = new Ciudad("Ciudad de Mexico", "MX", provDeMexico);
    public Direccion direccionMexico = new Direccion("Roberto Gayol 55", "55", null, null, ciudadDeMexico);
    public EntidadJuridica oficinaMexico = new EntidadJuridica("Oficina Central México", "EAAF MX", direccionMexico,
            TipoDeCodigoID.CUIL, 301522544, new Empresa(ClasificacionAfip.MEDIANA2), null);

    //entidades cdia

    public Direccion direccionSurcos = new Direccion("Jéronimo Salguero", "2800", null, null, buenosAires);
    public EntidadJuridica surcos = new EntidadJuridica("Surcos", "Surcos CS", direccionSurcos,
            TipoDeCodigoID.CUIL, 359874666, new OSC(), null);

    public EntidadBase andhes = new EntidadBase("Andhes", "Branch de Surcos", surcos);

    //productos

    public Producto pintura1 = new Producto("1", "Pintura Z10 latex 20L", 9625.00);
    public Producto pintura2 = new Producto("2", "Pintura Loxon impermeabilizante 10L", 6584.49);
    public Producto pintura3 = new Producto("3", "Pintura Brikol pisos negro 4L", 3768.29);
    public Producto pava = new Producto("4", "Pava electrica Smartlife 1,5L 1850W", 4500.00);
    public Producto cafetera = new Producto("5", "Cafetera Smartlife 1095 acero inox", 6300.00);
    public Producto celular = new Producto("6", "Telefono celular Motorola 4G", 15060.00);
    public Producto cemento = new Producto("7", "Cemento Loma Negra", 704.04);
    public Producto arena = new Producto("8", "Arena fina en bolsón x M30", 3100.00);
    public Producto hierro = new Producto("9", "Hierro Acindar", 891.00);
    public Producto ladrillo = new Producto("10", "Bloque ladrillo cemento", 250.00);
    public Producto cortinas = new Producto("11", "Cortinas blackout vinilico 2 paños", 4200.00);

    @Before

    public void createData() {
        oficinaBsAs.setOrganizacion(eaaf);
        oficinaUsa.setOrganizacion(eaaf);
        oficinaMexico.setOrganizacion(eaaf);

        surcos.setOrganizacion(cdia);

    }

    @Test
    public void testInsercionDatos() throws InvalidKeySpecException, NoSuchAlgorithmException {
        Usuario usuario = new Usuario("admin", "admin1234", TipoUsuario.Admin, validadorPasswords1);
        usuario.setOrganizacion(organizacion);
        MediosDePago mediosDePago = new Efectivo();

        OperacionDeEgreso operacionDeEgreso = new OperacionEgresoBuilder().setTipoDocumentoComercial(TipoDocumentoComercial.Factura)
                .setNumeroDocumentoComercial(12345)
                .agregarItem(producto1, 2)
                .setEntidad(entidadBase)
                .setMetodoPago(mediosDePago)
                .setProveedor(proveedor)
                .setUsuarioAlta(usuario)
                .grabarOperacion();

        Mensaje mensaje = new Mensaje().crearMensajeValidacion(operacionDeEgreso, true);
        mensaje.setUsuario(usuario);
        usuario.getBandeja().agregarMensaje(mensaje);
        organizacion.agregarUsuario(usuario);
        entidadJuridica.setOrganizacion(organizacion);
        entidadJuridica.setMontoMaximodeEgresos(6000.00);

        entidadJuridica.setIGJid("ID1234");
        entidadBase.setEntidadJuridica(entidadJuridica);
        EntityManagerHelper.beginTransaction();
        EntityManagerHelper.getEntityManager().persist(usuario);
        EntityManagerHelper.getEntityManager().persist(organizacion);
        EntityManagerHelper.getEntityManager().persist(entidadJuridica);
        EntityManagerHelper.getEntityManager().persist(entidadBase);
        EntityManagerHelper.getEntityManager().persist(catONG);
        EntityManagerHelper.getEntityManager().persist(direccion2);
        EntityManagerHelper.getEntityManager().persist(direccion);
        EntityManagerHelper.getEntityManager().persist(operacionDeEgreso);
        EntityManagerHelper.getEntityManager().persist(mensaje);
        EntityManagerHelper.getEntityManager().persist(mediosDePago);
        EntityManagerHelper.getEntityManager().persist(proveedor);
        EntityManagerHelper.commit();
    }
}
