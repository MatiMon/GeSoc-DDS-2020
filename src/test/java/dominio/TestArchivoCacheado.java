package dominio;

import dominio.modelo.usuario.ArchivoCacheado;
import dominio.modelo.usuario.InvalidFileNameException;
import org.junit.Test;
public class TestArchivoCacheado {

    @Test(expected = InvalidFileNameException.class)
    public void cadenaPertenecienteListaOWASP() {
        new ArchivoCacheado("/este-nombre-es-invalido.txt",6000 );
    }
}