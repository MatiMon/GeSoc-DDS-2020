package dominio.modelo.presupuesto;

import dominio.modelo.operacionEgreso.OperacionDeEgreso;

public class ValidacionCantidadPresupuestos implements ValidacionDePresupuesto {
    @Override
    public boolean validar(OperacionDeEgreso operacionDeEgreso) {
        return operacionDeEgreso.getPresupuestos().size() >= operacionDeEgreso.getCantidadPresupuestosRequeridos();
    }
}
