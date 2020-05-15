import Dominio.Usuario.ArchivoCacheado;
import Dominio.Usuario.InvalidFileNameException;
import org.junit.Test;
public class TestArchivoCacheado {

    @Test(expected = InvalidFileNameException.class)
    public void cadenaPertenecienteListaOWASP() {
        new ArchivoCacheado("/este-nombre-es-invalido.txt");
    }
}