package dominio.controllers;

import dominio.modelo.entidad.Organizacion;
import dominio.modelo.operacionEgreso.OperacionDeEgreso;
import dominio.modelo.usuario.Usuario;
import dominio.repositories.Repositorio;
import dominio.repositories.factories.FactoryRepositorio;
import spark.ModelAndView;
import spark.Request;
import spark.Response;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

public class OperacionController extends Controller{

    public ModelAndView mostrarOperaciones(Request request, Response response){
        List<OperacionDeEgreso> operaciones = this.getOperaciones(this.getOrganizacion(request));
        Map<String, Object> parametros = this.getSessionParams(request);
        parametros.put("operaciones", operaciones);
        return new ModelAndView(parametros, "gestion_egresos.hbs");
    }

    public ModelAndView nuevaOperacion(Request request, Response response) {
        Map<String, Object> parametros = this.getSessionParams(request);
        return new ModelAndView(parametros, "nueva-operacion.hbs");
    }

}
