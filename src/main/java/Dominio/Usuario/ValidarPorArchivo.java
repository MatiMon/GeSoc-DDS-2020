package Dominio.Usuario;

public class ValidarPorArchivo implements ValidarPasswords {
    private ArchivoCacheado archivoCacheado;

    public ValidarPorArchivo(ArchivoCacheado archivoCacheado) {
        this.archivoCacheado = archivoCacheado;
    }

    @Override
    public boolean validarPassword(String password) {
        return !this.archivoCacheado.passwordEnArchivo(password);
    }
}
