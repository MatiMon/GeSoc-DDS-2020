package server;

import dominio.controllers.LoginController;
import dominio.controllers.UsuarioController;
import spark.Spark;
import spark.template.handlebars.HandlebarsTemplateEngine;
import spark.utils.BooleanHelper;
import spark.utils.HandlebarsTemplateEngineBuilder;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

public class Router {
    private static HandlebarsTemplateEngine engine;

    private static void initEngine() {
        Router.engine = HandlebarsTemplateEngineBuilder
                .create()
                .withDefaultHelpers()
                .withHelper("isTrue", BooleanHelper.isTrue)
                .build();
    }

    public static void init() throws InvalidKeySpecException, NoSuchAlgorithmException {
        Router.initEngine();
        Spark.staticFileLocation("/public");
        Router.configure();
    }

    private static void configure() throws InvalidKeySpecException, NoSuchAlgorithmException {
        UsuarioController usuarioController = new UsuarioController();
        LoginController loginController = new LoginController();

        Spark.get("/", loginController::inicioSesion, Router.engine);
        Spark.get("/principal", usuarioController::paginaPrincipal, Router.engine);
        Spark.get("/egresos", usuarioController::gestionEgresos, Router.engine);
        Spark.get("/entidades", usuarioController::gestionEntidades, Router.engine);
        Spark.get("/nueva-operacion", usuarioController::nuevaOperacion, Router.engine);
        Spark.post("/login", loginController::login);

    }
}