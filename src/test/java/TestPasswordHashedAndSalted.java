import org.junit.Test;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

import static org.junit.Assert.*;

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