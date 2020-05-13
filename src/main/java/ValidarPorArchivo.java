import java.io.*;
import java.util.stream.Stream;

public class ValidarPorArchivo implements ValidadorPasswords {
    ArchivoCacheado archivoCacheado;

    public ValidarPorArchivo(ArchivoCacheado archivoCacheado) {
        this.archivoCacheado = archivoCacheado;
    }

    @Override
    public boolean validarPassword(String password) {
        return !this.archivoCacheado.passwordEnArchivo(password);
    }
}
