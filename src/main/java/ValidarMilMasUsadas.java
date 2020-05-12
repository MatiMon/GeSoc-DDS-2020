import org.xipki.password.PasswordBasedEncryption;

public class ValidarMilMasUsadas implements ValidadorPasswords{
    @Override
    public boolean validarPassword(String password) {
        return false;
    }
}
