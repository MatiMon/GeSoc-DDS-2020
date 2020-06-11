import Dominio.Usuario.*;
import org.junit.Before;
import org.junit.Test;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import static org.junit.Assert.*;

public class TestUsuario {

    private static final ArchivoCacheado owaspFile = new ArchivoCacheado("/password-blacklist.txt", 5555);
    private static final ArchivoCacheado blacklistFile = new ArchivoCacheado("/10k-most-common.txt", 4563);
    protected Usuario usuario;

    public TestUsuario() throws InvalidKeySpecException, NoSuchAlgorithmException {
    }

    @Before
    public void setup() throws InvalidKeySpecException, NoSuchAlgorithmException {
        this.usuario = new Usuario("ID1",
                "1234asdf",
                TipoUsuario.Admin,
                new ValidadorPasswords(new ArrayList<ValidarPasswords>(
                        Arrays.asList(
                                new ValidarPorArchivo(owaspFile),
                                new ValidarPorArchivo(blacklistFile),
                                new ValidarCaracteresConsecutivos(),
                                new ValidarLongitud()
                        )
                )
                )
        );
    }

    @Test
    public void testPasswordCaracteresRepetidos() {
        assertFalse(usuario.validarPassword("aaaaaa"));
    }

    @Test
    public void testPasswordValida() {
        assertTrue(usuario.validarPassword("passwordValida123xyz"));
    }

    @Test
    public void testPasswordDeOWASP10k() {
        assertFalse(usuario.validarPassword("superman"));
    }

    @Test
    public void testPasswordEnBlacklist() {
        assertFalse(usuario.validarPassword("usuario"));
    }

    @Test
    public void testPasswordCorta() {
        assertFalse(usuario.validarPassword("zbf"));
    }

    @Test
    public void testPasswordLarga() {
        assertFalse(usuario.validarPassword("zbfzbfzbfzbfzbfzbfzbfzbfzbfzbfzbfzbfzbfzbfzbfzbfzbfzbfzbfzbfzbfzbfzbfzbfzbfzbfzbfz123"));
    }

    @Test(expected = NullEntryException.class)
    public void idNullLanzaException() throws InvalidKeySpecException, NoSuchAlgorithmException {
        new Usuario(null, "1234asdad", TipoUsuario.Estandar, new ValidadorPasswords(new ArrayList<>(Collections.singletonList(new ValidarPorArchivo(owaspFile)))));
    }

    @Test(expected = NullEntryException.class)
    public void passwordNullLanzaException() throws InvalidKeySpecException, NoSuchAlgorithmException {
        new Usuario("312", null, TipoUsuario.Estandar, new ValidadorPasswords(new ArrayList<>(Collections.singletonList(new ValidarPorArchivo(owaspFile)))));
    }

    @Test(expected = NullEntryException.class)
    public void usuarioNullLanzaException() throws InvalidKeySpecException, NoSuchAlgorithmException {
        new Usuario("ID31", "12345112asdasdq", null, new ValidadorPasswords(new ArrayList<>(Collections.singletonList(new ValidarPorArchivo(owaspFile)))));
    }

    @Test
    public void ValidadorVacioAceptaCualquierPassword() throws InvalidKeySpecException, NoSuchAlgorithmException {
        new Usuario("ID31", "12345112asdasdq", TipoUsuario.Admin, new ValidadorPasswords(new ArrayList<>()));
        assertTrue(usuario.validarPassword("123451qweqweqwe"));
    }

    @Test
    public void autorizaPasswordCorrecta() throws InvalidKeySpecException, NoSuchAlgorithmException {
        assertTrue(usuario.autorizarPassword("1234asdf"));
    }

    @Test
    public void rechazaPasswordIncorrecta() throws InvalidKeySpecException, NoSuchAlgorithmException {
        assertFalse(usuario.autorizarPassword("soyUnaPassIncorrecta"));
    }

    @Test
    public void actualizaPasswordYNoAutorizaLaPassVieja() throws InvalidKeySpecException, NoSuchAlgorithmException {
        usuario.actualizarContrasenia("passwordNueva123");
        assertFalse(usuario.autorizarPassword("1234asdf"));
    }

    @Test
    public void actualizaPasswordYAutorizaLaNueva() throws InvalidKeySpecException, NoSuchAlgorithmException {
        usuario.actualizarContrasenia("passwordNueva123");
        assertTrue(usuario.autorizarPassword("passwordNueva123"));
    }

    @Test
    public void agregaUnValidadorALista() throws InvalidKeySpecException, NoSuchAlgorithmException {
        Usuario usuario = new Usuario("Shaq", "1234asdad", TipoUsuario.Estandar, new ValidadorPasswords(new ArrayList<>(Collections.singletonList(new ValidarPorArchivo(owaspFile)))));
        ValidarCaracteresConsecutivos val = new ValidarCaracteresConsecutivos();
        usuario.getValidadorPasswords().agregarValidadorALista(val);
        assertEquals(usuario.getValidadorPasswords().getValidarPasswordsList().size(), 2);
    }
}