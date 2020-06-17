package Dominio.Presupuesto;

import Dominio.OperacionEgreso.OperacionDeEgreso;

public class ValidacionCoincidenciaPresupuesto implements ValidacionDePresupuesto {
    @Override
    public boolean validar(OperacionDeEgreso operacionDeEgreso) {
        return false;
    }
}
