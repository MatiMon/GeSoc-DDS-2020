package server;

import dominio.controllers.LoginController;
import dominio.controllers.UsuarioController;
import spark.Spark;
import spark.template.handlebars.HandlebarsTemplateEngine;
import spark.utils.BooleanHelper;
import spark.utils.HandlebarsTemplateEngineBuilder;

public class Router {
    private static HandlebarsTemplateEngine engine;

    private static void initEngine() {
        Router.engine = HandlebarsTemplateEngineBuilder
                .create()
                .withDefaultHelpers()
                .withHelper("isTrue", BooleanHelper.isTrue)
                .build();
    }

    public static void init() {
        Router.initEngine();
        Spark.staticFileLocation("/public");
        Router.configure();
    }

    private static void configure(){
        UsuarioController usuarioController = new UsuarioController();
        LoginController loginController = new LoginController();

        Spark.get("/", usuarioController::inicioSesion, Router.engine);
        Spark.get("/principal", usuarioController::paginaPrincipal, Router.engine);
        Spark.get("/egresos", usuarioController::gestionEgresos, Router.engine);
        Spark.get("/entidades", usuarioController::gestionEntidades, Router.engine);
        Spark.post("/login", loginController::login);

    }
}