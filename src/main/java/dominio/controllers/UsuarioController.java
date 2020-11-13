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
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class UsuarioController {
    private Repositorio<Usuario> repoUsuarios;
    private Repositorio<OperacionDeEgreso> repoEgresos;

    public UsuarioController() throws InvalidKeySpecException, NoSuchAlgorithmException {
        this.repoUsuarios = FactoryRepositorio.get(Usuario.class);
        this.repoEgresos = FactoryRepositorio.get(OperacionDeEgreso.class);
    }

    public ModelAndView paginaPrincipal(Request request, Response response) {
        this.repoUsuarios = FactoryRepositorio.get(Usuario.class);
        long userId = request.session().attribute("id");
        Map<String, Object> parametros = new HashMap<>();
        Usuario usuario = this.repoUsuarios.buscar(userId);
        Organizacion organizacion = usuario.getOrganizacion();
        List<OperacionDeEgreso> operaciones = this.repoEgresos.buscarTodos()
                .stream()
                .filter(operacionDeEgreso -> operacionDeEgreso.getEntidad().perteneceAOrganizacion(organizacion))
                .collect(Collectors.toList());
        parametros.put("mensajes", usuario.getBandeja().getMensajes());
        parametros.put("nombreUsuario", usuario.getNombreUsuario());
        parametros.put("organizacion", organizacion.getNombre());
        //traer las operaciones de la organizacion
        parametros.put("operaciones", operaciones);
        return new ModelAndView(parametros, "pagina_principal.hbs");
    }

    public ModelAndView gestionEgresos(Request request, Response response) {
        return new ModelAndView(null, "gestion_egresos.hbs");
    }

    public ModelAndView gestionEntidades(Request request, Response response) {
        return new ModelAndView(null, "gestion_entidades.hbs");
    }
}
