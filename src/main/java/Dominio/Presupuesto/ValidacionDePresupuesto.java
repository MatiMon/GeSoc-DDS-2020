package Dominio.Presupuesto;

import Dominio.OperacionEgreso.OperacionDeEgreso;

public interface ValidacionDePresupuesto {
    boolean validar(OperacionDeEgreso operacionDeEgreso);
}
