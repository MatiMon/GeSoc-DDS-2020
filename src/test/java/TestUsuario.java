import org.junit.Test;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import static org.junit.Assert.*;

public class TestUsuario {

    ArchivoCacheado owaspFile = new ArchivoCacheado("/password-blacklist.txt");
    ArchivoCacheado blacklistFile = new ArchivoCacheado("/10k-most-common.txt");
    Usuario usuario = new Usuario(
            "ID1",
            "1234asdf",
            TipoUsuario.Admin,
            new ArrayList<>(
                    Arrays.asList(
                            new ValidarPorArchivo(owaspFile),
                            new ValidarPorArchivo(blacklistFile),
                            new ValidarCaracteresConsecutivos(),
                            new ValidarLongitud()
                    )
            )
    );


    public TestUsuario() throws InvalidKeySpecException, NoSuchAlgorithmException {
    }

    @Test
    public void testPasswordCaracteresRepetidos() {
        assertFalse(usuario.validarPassword("aaaaaa", usuario.validadorPasswordsList));
    }

    @Test
    public void testPasswordValida() {
        assertTrue(usuario.validarPassword("passwordValida123xyz", usuario.validadorPasswordsList));
    }

    @Test
    public void testPasswordDeOWASP10k() {
        assertFalse(usuario.validarPassword("superman", usuario.validadorPasswordsList));
    }

    @Test
    public void testPasswordEnBlacklist() {
        assertFalse(usuario.validarPassword("usuario", usuario.validadorPasswordsList));
    }

    @Test
    public void testPasswordCorta() {
        assertFalse(usuario.validarPassword("zbf", usuario.validadorPasswordsList));
    }

    @Test
    public void testPasswordLarga() {
        assertFalse(usuario.validarPassword("zbfzbfzbfzbfzbfzbfzbfzbfzbfzbfzbfzbfzbfzbfzbfzbfzbfzbfzbfzbfzbfzbfzbfzbfzbfzbfzbfz123", usuario.validadorPasswordsList));
    }

    @Test(expected = NullIdException.class)
    public void idNullLanzaException() throws InvalidKeySpecException, NoSuchAlgorithmException {
        new Usuario(null, "1234asdad", TipoUsuario.Estandar, new ArrayList<>(Collections.singletonList(new ValidarPorArchivo(owaspFile))));
    }

    @Test(expected = NullPasswordException.class)
    public void passwordNullLanzaException() throws InvalidKeySpecException, NoSuchAlgorithmException {
        new Usuario("312", null, TipoUsuario.Estandar, new ArrayList<>(Collections.singletonList(new ValidarPorArchivo(owaspFile))));
    }

    @Test(expected = NullUsuarioException.class)
    public void usuarioNullLanzaException() throws InvalidKeySpecException, NoSuchAlgorithmException {
        new Usuario("ID31", "12345112asdasdq", null, new ArrayList<>(Collections.singletonList(new ValidarPorArchivo(owaspFile))));
    }

    @Test(expected = NullOrEmptyListException.class)
    public void listaVaciaLanzaException() throws InvalidKeySpecException, NoSuchAlgorithmException {
        new Usuario("ID31", "12345112asdasdq", TipoUsuario.Admin, new ArrayList<>());
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
        Usuario usuario = new Usuario("Shaq", "1234asdad", TipoUsuario.Estandar, new ArrayList<>(Collections.singletonList(new ValidarPorArchivo(owaspFile))));
        ValidarCaracteresConsecutivos val = new ValidarCaracteresConsecutivos();
        usuario.agregarValidadorALista(val);
        assertEquals(usuario.validadorPasswordsList.size(), 2);
    }
}