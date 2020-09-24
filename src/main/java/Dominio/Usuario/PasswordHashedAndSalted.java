package Dominio.Usuario;

import Persistencia.Persistente;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.persistence.Entity;
import javax.persistence.Transient;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.util.Arrays;

@Entity
public class PasswordHashedAndSalted extends Persistente {
    private byte[] salt = new byte[16];
    private byte[] hash;
    @Transient
    private int iterations = 128;
    @Transient
    private int longitudEnBits = 2048;

    public PasswordHashedAndSalted(String password) throws InvalidKeySpecException, NoSuchAlgorithmException {
        generarSaltRandom();
        this.hash = generarHashPBKDF2(password);
    }

    private void generarSaltRandom() {
        SecureRandom secureRandom = new SecureRandom();
        secureRandom.nextBytes(this.salt);
    }

    private byte[] generarHashPBKDF2(String password) throws NoSuchAlgorithmException, InvalidKeySpecException {
        KeySpec spec = new PBEKeySpec(password.toCharArray(), this.salt, this.iterations, this.longitudEnBits);
        SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
        return factory.generateSecret(spec).getEncoded();
    }

    public boolean hashMatch(String password) throws NoSuchAlgorithmException, InvalidKeySpecException {
        return Arrays.equals(this.hash, generarHashPBKDF2(password));
    }
}
