package Dominio.Presupuesto;

import Dominio.OperacionEgreso.OperacionDeEgreso;

public class ValidacionCantidadPresupuestos implements ValidacionDePresupuesto {
    @Override
    public boolean validar(OperacionDeEgreso operacionDeEgreso) {
        //return operacionDeEgreso.get == operacion.
        return false;
    }
}
