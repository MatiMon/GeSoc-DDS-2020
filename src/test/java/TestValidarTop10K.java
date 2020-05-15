import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestValidarTop10K {
    ValidarPorArchivo validador = new ValidarPorArchivo(new ArchivoCacheado("/10k-most-common.txt"));

    @Test
    public void cadenaPertenecienteListaOWASP() {
        assertEquals(validador.validarPassword(("monkey")), false);
    }

    @Test
    public void cadenaNoPertencienteListaOWASP() {
        assertEquals(validador.validarPassword(("soyUnaPasswordPotente")), true);
    }
}