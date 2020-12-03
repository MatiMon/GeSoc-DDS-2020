package server;

import dominio.controllers.EntidadController;
import dominio.controllers.LoginController;
import dominio.controllers.MainController;
import dominio.controllers.OperacionController;
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
        EntidadController entidadController = new EntidadController();

        Spark.get("/", loginController::inicioSesion, Router.engine);
        Spark.get("/login-error", loginController::inicioSesionError, Router.engine);
        Spark.get("/principal", mainController::paginaPrincipal, Router.engine);
        Spark.get("/egresos", operacionController::mostrarOperaciones, Router.engine);
        Spark.post("/egresos", operacionController::crearOperacion, Router.engine);
        Spark.get("/entidades", entidadController::mostrarTodas, Router.engine);

        Spark.get("/nueva-entidad",entidadController::nuevaEntidad,Router.engine);
        Spark.get("/nueva-entidad/base",entidadController::nuevaEntidadBase,Router.engine);
        Spark.post("/nueva-entidad/base",entidadController::crearEntidadBase,Router.engine);
        Spark.get("/nueva-entidad/juridica",entidadController::nuevaEntidadJuridica,Router.engine);
        Spark.get("/nueva-entidad/juridica/provincia",entidadController::nuevaEntidadJuridicaProvincia,Router.engine);
        Spark.get("/nueva-entidad/juridica/data",entidadController::nuevaEntidadJuridicaData,Router.engine);

        Spark.get("/entidades/asociar-categoria/:id", entidadController::elegirCategoria, Router.engine);
        Spark.post("/entidades/asociar-categoria/:id", entidadController::asociarCategoria, Router.engine);

        Spark.get("/nueva-operacion", operacionController::nuevaOperacion, Router.engine);
        Spark.get("/nueva-operacion/data", operacionController::nuevaOperacionData, Router.engine);
        Spark.get("/nueva-operacion/items", operacionController::nuevaOperacionItems, Router.engine);
        Spark.get("/nueva-operacion/finalizar", operacionController::nuevaOperacionFinalizar, Router.engine);

        Spark.post("/login", loginController::login);

    }
}