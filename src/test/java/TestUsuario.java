import org.junit.Test;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;


public class TestUsuario {
    Usuario usuario = new Usuario(
            "ID1",
            "1234",
            TipoUsuario.Admin,
            Arrays.asList(
                    new ValidarPorArchivo(new ArchivoCacheado("/password-blacklist.txt")),
                    new ValidarPorArchivo(new ArchivoCacheado("/10k-most-common.txt")),
                    new ValidarCaracteresConsecutivos(),
                    new ValidarLongitud()
            )
    );

    @Test
    public void testPasswordCaracteresRepetidos() {
        assertEquals(usuario.validarPassword("aaaaaa"), false);
    }

    @Test
    public void testPasswordValida() {
        assertEquals(usuario.validarPassword("passwordValida123xyz"), true);
    }

    @Test
    public void testPasswordDeOWASP10k() {
        assertEquals(usuario.validarPassword("superman"), false);
    }

    @Test
    public void testPasswordEnBlacklist() {
        assertEquals(usuario.validarPassword("usuario"), false);
    }

    @Test
    public void testPasswordCorta() {
        assertEquals(usuario.validarPassword("zbf"), false);
    }

    @Test
    public void testPasswordLarga() {
        assertEquals(usuario.validarPassword("zbfzbfzbfzbfzbfzbfzbfzbfzbfzbfzbfzbfzbfzbfzbfzbfzbfzbfzbfzbfzbfzbfzbfzbfzbfzbfzbfz123"), false);
    }

}