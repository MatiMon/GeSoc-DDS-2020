package dominio.modelo.presupuesto;

import dominio.modelo.operacionEgreso.OperacionDeEgreso;

public class ValidacionMenorPrecio implements ValidacionDePresupuesto {
    @Override
    public boolean validar(OperacionDeEgreso operacionDeEgreso) {

        return operacionDeEgreso.getPresupuestos().stream().mapToDouble(presupuesto -> presupuesto.getValorTotal()).anyMatch(elem -> Double.compare(elem, operacionDeEgreso.getValorTotal()) == 0);


    }
}
