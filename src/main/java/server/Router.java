package server;

import dominio.controllers.LoginController;
import dominio.controllers.OperacionController;
import dominio.controllers.MainController;
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
        MainController mainController = new MainController();
        LoginController loginController = new LoginController();
        OperacionController operacionController = new OperacionController();

        Spark.get("/", loginController::inicioSesion, Router.engine);
        Spark.get("/principal", mainController::paginaPrincipal, Router.engine);
        Spark.get("/egresos", operacionController::mostrarOperaciones, Router.engine);
        Spark.get("/entidades", mainController::gestionEntidades, Router.engine);
        Spark.get("/nueva-operacion", operacionController::nuevaOperacion, Router.engine);
        Spark.post("/login", loginController::login);

    }
}