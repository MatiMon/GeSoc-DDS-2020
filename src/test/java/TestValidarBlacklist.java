import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestValidarBlacklist {
    ValidarPorArchivo validador = new ValidarPorArchivo(new ArchivoCacheado("/password-blacklist.txt"));

    @Test
    public void cadenaPertenecienteListaOWASP() {
        assertEquals(validador.validarPassword(("documento")), false);
    }

    @Test
    public void cadenaNoPertencienteListaOWASP() {
        assertEquals(validador.validarPassword(("soyUnaPasswordPotente")), true);
    }
}