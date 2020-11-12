package server;

import spark.Spark;
import spark.debug.DebugScreen;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

public class Server {
    public static void main(String[] args) throws InvalidKeySpecException, NoSuchAlgorithmException {
        Spark.port(9000);
        Router.init();
        DebugScreen.enableDebugScreen();
    }
}