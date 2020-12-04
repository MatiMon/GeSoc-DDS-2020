package dominio.controllers;

import dominio.modelo.entidad.Organizacion;
import dominio.modelo.operacionEgreso.OperacionDeEgreso;
import dominio.modelo.usuario.Usuario;
import spark.ModelAndView;
import spark.Request;
import spark.Response;

import java.util.List;
import java.util.Map;

public class MainController extends Controller {

    //TODO: un main controller que mande los datos para headers y los demas controller extienden de ese
    // organizar mejor los controllers, repartir la logica que esta toda en UsuarioController en varios.
    // Vista de creacion de operacion
    // Vista de operaciones general
    // Vista de entidades
    // Vista de linkear a categoria

    public ModelAndView paginaPrincipal(Request request, Response response) {
        Map<String, Object> parametros = this.getSessionParams(request);
        Organizacion organizacion = this.getOrganizacion(request);
        Usuario usuario = this.getUsuario(request);
        List<OperacionDeEgreso> operaciones = this.getOperaciones(organizacion).subList(0, 4);
        parametros.put("mensajes", usuario.getBandeja().getMensajes());
        //traer las operaciones de la organizacion
        parametros.put("operaciones", operaciones);
        return new ModelAndView(parametros, "pagina_principal.hbs");
    }

    public ModelAndView gestionEntidades(Request request, Response response) {
        return new ModelAndView(null, "gestion_entidades.hbs");
    }

}
