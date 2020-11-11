package dominio;

import Dominio.Usuario.ValidarLongitud;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestValidarLongitud {
    ValidarLongitud validador = new ValidarLongitud();

    @Test
    public void passwordMenorMinimo() {
        assertEquals(validador.validarPassword(("feq")), false);
    }

    @Test
    public void passwordIgualAlMinimo() {
        assertEquals(validador.validarPassword(("mgrt")), true);
    }

    @Test
    public void passwordIgualAlMaximo() {
        assertEquals(validador.validarPassword(("owaspowaspowaspowaspowaspowaspowaspowaspowaspowaspowaspwasp")), true);
    }

    @Test
    public void passwordMayorMaximo() {
        assertEquals(validador.validarPassword(("owaspowaspowaspowaspowaspowaspowaspowaspowaspowaspowaspwaspdfasdfsadfsadfdfaf")), false);
    }

    @Test
    public void passwordEntreMinimoAndMaximo() {
        assertEquals(validador.validarPassword(("diseniodesistemas")), true);
    }
}
