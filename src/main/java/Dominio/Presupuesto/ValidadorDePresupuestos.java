package Dominio.Presupuesto;

import Dominio.OperacionEgreso.OperacionDeEgreso;

import java.util.List;

public class ValidadorDePresupuestos {
    List<ValidadorDePresupuestos> validaciones;

    boolean validar(OperacionDeEgreso operacionDeEgreso){
        return validaciones.stream().allMatch(validacion -> validacion.validar(operacionDeEgreso));
    }
}
