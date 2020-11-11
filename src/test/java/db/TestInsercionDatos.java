package db;

import Dominio.MediosDePago.Efectivo;
import Dominio.MediosDePago.MediosDePago;
import Dominio.OperacionEgreso.OperacionDeEgreso;
import Dominio.OperacionEgreso.OperacionEgresoBuilder;
import Dominio.OperacionEgreso.TipoDocumentoComercial;
import Dominio.Usuario.Mensaje;
import Dominio.Usuario.TipoUsuario;
import Dominio.Usuario.Usuario;
import Dominio.Usuario.ValidadorPasswords;
import Persistencia.EntityManagerHelper;
import dominio.TestSetUpGeneral;
import org.junit.Before;
import org.junit.Test;
import org.uqbarproject.jpa.java8.extras.WithGlobalEntityManager;
import org.uqbarproject.jpa.java8.extras.test.AbstractPersistenceTest;

import javax.persistence.EntityManager;
import javax.print.attribute.standard.Media;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

public class TestInsercionDatos extends TestSetUpGeneral {

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
