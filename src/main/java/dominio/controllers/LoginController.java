package dominio.controllers;

import dominio.modelo.usuario.*;
import dominio.repositories.RepositorioDeUsuarios;
import dominio.repositories.factories.FactoryRepositorioUsuarios;
import spark.ModelAndView;
import spark.Request;
import spark.Response;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LoginController {

    public ModelAndView inicioSesion(Request request, Response response) {
        Map<String, Object> parametros = new HashMap<>();
        return new ModelAndView(parametros, "inicio.hbs");
    }

    public Response login(Request request, Response response) {
        try {
            RepositorioDeUsuarios repoUsuarios = FactoryRepositorioUsuarios.get();

            String nombreDeUsuario = request.queryParams("nombreDeUsuario");
            String contrasenia = request.queryParams("contrasenia");

            String path = "/";

            if (repoUsuarios.existe(nombreDeUsuario)) {
                Usuario usuario = repoUsuarios.buscarUsuario(nombreDeUsuario);
                if (usuario.autorizarPassword(contrasenia)) {
                    request.session(true);
                    request.session().attribute("id", usuario.getId());
                    path = "/principal";
                }
            }
            response.redirect(path);
        } catch (Exception e) {
            //Funcionalidad disponible solo con persistencia en Base de Datos
            response.redirect("/");
        } finally {
            return response;
        }
    }

    public Response logout(Request request, Response response) {
        request.session().invalidate();
        response.redirect("/");
        return response;
    }
}
