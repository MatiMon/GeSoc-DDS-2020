import org.junit.Test;

import java.util.Collections;

import static org.junit.Assert.assertEquals;

public class TestUsuario {
    Usuario usuario = new Usuario("ID1","1234",TipoUsuario.Admin, null);

    @Test
    public void testBlablabla() {
       assertEquals(usuario.validadorPasswordsList, null);
    }


}