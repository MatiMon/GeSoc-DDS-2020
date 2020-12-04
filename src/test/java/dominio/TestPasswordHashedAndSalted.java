package dominio;

import dominio.modelo.usuario.PasswordHashedAndSalted;
import org.junit.Test;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class TestPasswordHashedAndSalted {
    PasswordHashedAndSalted passwordHashedAndSalted = new PasswordHashedAndSalted("soyUnaPassword");

    public TestPasswordHashedAndSalted() throws InvalidKeySpecException, NoSuchAlgorithmException {
    }

    @Test
    public void mismaPassGeneraMismoHash() throws InvalidKeySpecException, NoSuchAlgorithmException {
        assertTrue(passwordHashedAndSalted.hashMatch("soyUnaPassword"));
    }

    @Test
    public void otraPassGeneraOtroHash() throws InvalidKeySpecException, NoSuchAlgorithmException {
        assertFalse(passwordHashedAndSalted.hashMatch("soyUnString "));
    }


}