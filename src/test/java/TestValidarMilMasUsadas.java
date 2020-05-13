import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class TestValidarMilMasUsadas {
    ValidarMilMasUsadas validador = new ValidarMilMasUsadas();
    @Test
    public void cadenaPertenecienteListaOWASP() {
        assertEquals(validador.validarPassword(("monkey")), false);
    }
    @Test
    public void cadenaNoPertencienteListaOWASP() {
        assertEquals(validador.validarPassword(("soyUnaPasswordPotente")), true);
    }
}