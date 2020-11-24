package db;

import dominio.TestSetUpGeneral;
import dominio.modelo.entidad.*;
import dominio.modelo.mediosDePago.Efectivo;
import dominio.modelo.mediosDePago.MediosDePago;
import dominio.modelo.mediosDePago.Tarjeta;
import dominio.modelo.mediosDePago.TipoTarjeta;
import dominio.modelo.operacionEgreso.OperacionDeEgreso;
import dominio.modelo.operacionEgreso.OperacionEgresoBuilder;
import dominio.modelo.operacionEgreso.Producto;
import dominio.modelo.operacionEgreso.TipoDocumentoComercial;
import dominio.modelo.proveedor.Proveedor;
import dominio.modelo.proveedor.TipoDeCodigoID;
import dominio.modelo.ubicacion.Ciudad;
import dominio.modelo.ubicacion.Direccion;
import dominio.modelo.ubicacion.Pais;
import dominio.modelo.ubicacion.Provincia;
import dominio.modelo.usuario.Mensaje;
import dominio.modelo.usuario.TipoUsuario;
import dominio.modelo.usuario.Usuario;
import org.junit.Test;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.Date;

public class TestInsercionDatos extends TestSetUpGeneral {

    public void createData() throws InvalidKeySpecException, NoSuchAlgorithmException {

        //Organizaciones
        Organizacion eaaf = new Organizacion("Equipo Argentino de Antropología Forense - EAAF");
        Organizacion cdia = new Organizacion("Colectivo de Derechos de Infancia y Adolescencia - CDIA");

        //Entidades eaaf
        Pais argentina = new Pais("Argentina", "ARG");
        Provincia provBuenosAires = new Provincia("Buenos Aires", "BA", argentina);
        Ciudad buenosAires = new Ciudad("Buenos Aires", "CABA", provBuenosAires);
        Direccion direccionBsAs = new Direccion("Av. Medrano", "951", null, null, buenosAires);
        EntidadJuridica oficinaBsAs = new EntidadJuridica("Oficina Central Buenos Aires", "EAAF BA", direccionBsAs,
                TipoDeCodigoID.CUIL, 301526921, new Empresa(ClasificacionAfip.MEDIANA1), null);

        Pais usa = new Pais("Estados Unidos", "USA");
        Provincia ny = new Provincia("Nueva York", "NY", usa);
        Ciudad brooklyn = new Ciudad("Brooklyn", "BKLN", ny);
        Direccion direccionUsa = new Direccion("Liberty Ave", "720", null, null, brooklyn);
        EntidadJuridica oficinaUsa = new EntidadJuridica("Oficina Central Nueva York", "EAAF NY", direccionUsa,
                TipoDeCodigoID.CUIL, 301526357, new Empresa(ClasificacionAfip.MEDIANA1), null);

        Pais mexico = new Pais("Mexico", "MX");
        Provincia provDeMexico = new Provincia("Ciudad de Mexico", "MX", mexico);
        Ciudad ciudadDeMexico = new Ciudad("Ciudad de Mexico", "MX", provDeMexico);
        Direccion direccionMexico = new Direccion("Roberto Gayol 55", "55", null, null, ciudadDeMexico);
        EntidadJuridica oficinaMexico = new EntidadJuridica("Oficina Central México", "EAAF MX", direccionMexico,
                TipoDeCodigoID.CUIL, 301522544, new Empresa(ClasificacionAfip.MEDIANA2), null);

        oficinaBsAs.setOrganizacion(eaaf);
        oficinaUsa.setOrganizacion(eaaf);
        oficinaMexico.setOrganizacion(eaaf);
        //entidades cdia

        Direccion direccionSurcos = new Direccion("Jéronimo Salguero", "2800", null, null, buenosAires);
        EntidadJuridica surcos = new EntidadJuridica("Surcos", "Surcos CS", direccionSurcos,
                TipoDeCodigoID.CUIL, 359874666, new OSC(), null);

        EntidadBase andhes = new EntidadBase("Andhes", "Branch de Surcos", surcos);

        surcos.setOrganizacion(cdia);

        //productos

        Producto pintura1 = new Producto("1", "Pintura Z10 latex 20L", 9625.00);
        Producto pintura2 = new Producto("2", "Pintura Loxon impermeabilizante 10L", 6584.49);
        Producto pintura3 = new Producto("3", "Pintura Brikol pisos negro 4L", 3768.29);
        Producto pava = new Producto("4", "Pava electrica Smartlife 1,5L 1850W", 4500.00);
        Producto cafetera = new Producto("5", "Cafetera Smartlife 1095 acero inox", 6300.00);
        Producto celular = new Producto("6", "Telefono celular Motorola 4G", 15060.00);
        Producto cemento = new Producto("7", "Cemento Loma Negra", 704.04);
        Producto arena = new Producto("8", "Arena fina en bolsón x M30", 3100.00);
        Producto hierro = new Producto("9", "Hierro Acindar", 891.00);
        Producto ladrillo = new Producto("10", "Bloque ladrillo cemento", 250.00);
        Producto cortinas = new Producto("11", "Cortinas blackout vinilico 2 paños", 4200.00);

        //usuarios

        Usuario admin = new Usuario("admin", "admin1234", TipoUsuario.Admin, validadorPasswords1);
        Usuario alejandro = new Usuario("aroco", "*_aroco20!-?", TipoUsuario.Estandar, validadorPasswords1);
        Usuario rocio = new Usuario("rrojas", "*-_rrojas!?", TipoUsuario.Estandar, validadorPasswords1);
        Usuario julieta = new Usuario("jazul", "!-*jazul_!?", TipoUsuario.Estandar, validadorPasswords1);

        admin.setOrganizacion(eaaf);
        alejandro.setOrganizacion(eaaf);
        rocio.setOrganizacion(eaaf);
        julieta.setOrganizacion(cdia);

        //medios de pago

        MediosDePago efectivo = new Efectivo();
        MediosDePago tarjetaCredito = new Tarjeta(TipoTarjeta.tarjetaCredito, "4509664512340131", "VISA", new Date());
        MediosDePago tarjetaDebito = new Tarjeta(TipoTarjeta.tarjetaDebito, "4507560013421543", "MASTERCARD", new Date());

        //proveedores TODO: asociar a organizaciones para mostrar solo proveedores de la org

        Direccion direccionProveedores = new Direccion("Av. Libertador", "4519", null, null, buenosAires);
        Proveedor pintureria = new Proveedor("Pinturerias Serretino", direccionProveedores, TipoDeCodigoID.CUIT, 405781354);
        Proveedor mitoas = new Proveedor("Mitoas SA", direccionProveedores, TipoDeCodigoID.CUIT, 405781313);
        Proveedor ingeneriaComercial = new Proveedor("Ingeniería Comercial SRL", direccionProveedores, TipoDeCodigoID.CUIT, 305781341);
        Proveedor corralon = new Proveedor("Corralón Laprida SRL", direccionProveedores, TipoDeCodigoID.CUIT, 205781365);
        Proveedor telasZN = new Proveedor("Telas ZN", direccionProveedores, TipoDeCodigoID.CUIL, 457846568);

        //egresos

        OperacionDeEgreso operacionDeEgreso1 = new OperacionEgresoBuilder()
                .setTipoDocumentoComercial(TipoDocumentoComercial.Factura)
                .setNumeroDocumentoComercial(1245789652)
                .agregarItem(pintura1, 2)
                .agregarItem(pintura2, 3)
                .setEntidad(oficinaBsAs)
                .setMetodoPago(efectivo)
                .setProveedor(pintureria)
                .setUsuarioAlta(admin)
                .grabarOperacion();

        OperacionDeEgreso operacionDeEgreso2 = new OperacionEgresoBuilder()
                .setTipoDocumentoComercial(TipoDocumentoComercial.Factura)
                .setNumeroDocumentoComercial(1245789653)
                .agregarItem(pava, 3)
                .agregarItem(cafetera, 2)
                .setEntidad(oficinaBsAs)
                .setMetodoPago(tarjetaDebito)
                .setProveedor(mitoas)
                .setUsuarioAlta(admin)
                .grabarOperacion();

        OperacionDeEgreso operacionDeEgreso3 = new OperacionEgresoBuilder()
                .setTipoDocumentoComercial(TipoDocumentoComercial.Factura)
                .setNumeroDocumentoComercial(1245789654)
                .agregarItem(celular, 2)
                .setEntidad(oficinaBsAs)
                .setMetodoPago(efectivo)
                .setProveedor(ingeneriaComercial)
                .setUsuarioAlta(admin)
                .grabarOperacion();

        OperacionDeEgreso operacionDeEgreso4 = new OperacionEgresoBuilder()
                .setTipoDocumentoComercial(TipoDocumentoComercial.Factura)
                .setNumeroDocumentoComercial(1245789655)
                .agregarItem(cemento, 10)
                .agregarItem(arena, 5)
                .agregarItem(hierro, 4)
                .agregarItem(ladrillo, 800)
                .setEntidad(oficinaBsAs)
                .setMetodoPago(efectivo)
                .setProveedor(corralon)
                .setUsuarioAlta(admin)
                .grabarOperacion();

        OperacionDeEgreso operacionDeEgreso5 = new OperacionEgresoBuilder()
                .setTipoDocumentoComercial(TipoDocumentoComercial.Factura)
                .setNumeroDocumentoComercial(1245789656)
                .agregarItem(ladrillo, 800)
                .setEntidad(oficinaBsAs)
                .setMetodoPago(efectivo)
                .setProveedor(corralon)
                .setUsuarioAlta(admin)
                .grabarOperacion();

        OperacionDeEgreso operacionDeEgreso6 = new OperacionEgresoBuilder()
                .setTipoDocumentoComercial(TipoDocumentoComercial.Factura)
                .setNumeroDocumentoComercial(1245789657)
                .agregarItem(cortinas, 5)
                .setEntidad(surcos)
                .setMetodoPago(tarjetaCredito)
                .setProveedor(telasZN)
                .setUsuarioAlta(admin)
                .grabarOperacion();





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
