package Dominio.Usuario;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Transient;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.stream.Collectors;

@Embeddable
@AttributeOverride(name = "nombreArchivo", column = @Column(name = "nombre_archivo"))
public class ArchivoCacheado {
    @Column(name = "nombre_archivo")
    private String nombreArchivo;
    @Transient
    private ArrayList<String> cache;
    @Transient
    private int tiempoDeRefresco;

    public ArchivoCacheado(String nombreArchivo, int tiempoDeRefresco) {
        this.nombreArchivo = nombreArchivo;
        this.tiempoDeRefresco = tiempoDeRefresco;
        guardarArchivoEnCache(this.nombreArchivo);
    }

    public boolean passwordEnArchivo(String unaPassword) {
        return cache.contains(unaPassword);
    }

    public void guardarArchivoEnCache(String nombreArchivo) {
        InputStream inputStream = getClass().getResourceAsStream(nombreArchivo);
        if (inputStream == null) throw new InvalidFileNameException("No existe el archivo");
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        this.cache = new ArrayList<>(reader.lines().collect(Collectors.toList()));
    }
}
