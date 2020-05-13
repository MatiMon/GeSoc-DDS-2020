import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.stream.Stream;

public class ArchivoCacheado {
    String nombreArchivo;
    Stream<String> cache;
    // TODO: agregar validacion para nombre de archivo valido al instanciar y testear la misma.
    public ArchivoCacheado(String nombreArchivo) {
        this.nombreArchivo = nombreArchivo;
        InputStream inputStream = getClass().getResourceAsStream(nombreArchivo);
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        this.cache = reader.lines();
    }

    public boolean passwordEnArchivo(String unaPassword){
        return this.cache.anyMatch(str-> str.equals(unaPassword));
    }
}
