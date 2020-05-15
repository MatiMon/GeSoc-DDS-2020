import Dominio.Usuario.ValidarCaracteresConsecutivos;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestValidarCaracteresConsecutivos {
    ValidarCaracteresConsecutivos validador = new ValidarCaracteresConsecutivos();

    @Test
    public void cadenaInvalida() {
        assertEquals(validador.validarPassword(("aaaaaa")), false);
    }

    @Test
    public void cadenaValida() {
        assertEquals(validador.validarPassword(("hola")), true);
    }

    @Test
    public void cadenaNumericaInvalida() {
        assertEquals(validador.validarPassword(("1111111")), false);
    }

    @Test
    public void cadenaNumericaValida() {
        assertEquals(validador.validarPassword(("45621")), true);
    }
}