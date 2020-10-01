package Dominio.Usuario;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Embedded;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

@DiscriminatorValue("ValidarPorArchivo")
public class ValidarPorArchivo extends ValidarPasswords {
    @Embedded
    private ArchivoCacheado archivoCacheado;

    public ValidarPorArchivo(ArchivoCacheado archivoCacheado) {
        this.archivoCacheado = archivoCacheado;
    }

    @Override
    public boolean validarPassword(String password) {
        return !this.archivoCacheado.passwordEnArchivo(password);
    }

    @Override
    public String getIdentificador() {
        return "ARCHIVO";
    }
}
