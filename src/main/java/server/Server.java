package server;

import db.CreacionDatosIniciales;
import spark.Spark;
import spark.debug.DebugScreen;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

public class Server {
    public static void main(String[] args) throws InvalidKeySpecException, NoSuchAlgorithmException {
        CreacionDatosIniciales.insertarDatos();
        Spark.port(getHerokuAssignedPort());
        Router.init();
        DebugScreen.enableDebugScreen();
    }

    static int getHerokuAssignedPort() {
        ProcessBuilder processBuilder = new ProcessBuilder();
        if (processBuilder.environment().get("PORT") != null) {
            return Integer.parseInt(processBuilder.environment().get("PORT"));
        }

        return 9000; //return default port if heroku-port isn't set (i.e. on localhost)
    }
}