package dominio;

import dominio.modelo.usuario.ArchivoCacheado;
import dominio.modelo.usuario.ValidarPorArchivo;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestValidarBlacklist {
    ValidarPorArchivo validador = new ValidarPorArchivo(new ArchivoCacheado("/password-blacklist.txt", 70000));

    @Test
    public void cadenaPertenecienteListaOWASP() {
        assertEquals(validador.validarPassword(("documento")), false);
    }

    @Test
    public void cadenaNoPertencienteListaOWASP() {
        assertEquals(validador.validarPassword(("soyUnaPasswordPotente")), true);
    }
}