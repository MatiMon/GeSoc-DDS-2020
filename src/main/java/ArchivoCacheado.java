import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class ArchivoCacheado {
    String nombreArchivo;
    ArrayList<String> cache;

    public ArchivoCacheado(String nombreArchivo) {
        this.nombreArchivo = nombreArchivo;
        InputStream inputStream = getClass().getResourceAsStream(nombreArchivo);
        if (inputStream == null) throw new InvalidFileNameException("No existe el archivo");
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        this.cache = new ArrayList<>(reader.lines().collect(Collectors.toList()));
    }

    public boolean passwordEnArchivo(String unaPassword) {
        return cache.contains(unaPassword);
    }
}
