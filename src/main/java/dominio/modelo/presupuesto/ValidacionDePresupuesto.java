package dominio.modelo.presupuesto;

import dominio.modelo.operacionEgreso.OperacionDeEgreso;

public interface ValidacionDePresupuesto {
    boolean validar(OperacionDeEgreso operacionDeEgreso);
}
