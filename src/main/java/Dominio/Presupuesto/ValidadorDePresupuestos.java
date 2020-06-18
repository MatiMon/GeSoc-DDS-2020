package Dominio.Presupuesto;

import Dominio.OperacionEgreso.OperacionDeEgreso;

import java.util.ArrayList;
import java.util.List;

public class ValidadorDePresupuestos {
    private List<ValidacionDePresupuesto> validaciones = new ArrayList<>();

    public boolean validar(OperacionDeEgreso operacionDeEgreso) {
        return validaciones.stream().allMatch(validacion -> validacion.validar(operacionDeEgreso));
    }

    public void agregarValidacion(ValidacionDePresupuesto validacionDePresupuesto) {
        this.validaciones.add(validacionDePresupuesto);
    }

    public void quitarValidacion(ValidacionDePresupuesto validacionDePresupuesto){
        this.validaciones.remove(validacionDePresupuesto);
    }

}
