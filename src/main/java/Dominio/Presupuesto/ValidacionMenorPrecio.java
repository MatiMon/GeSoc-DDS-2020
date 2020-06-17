package Dominio.Presupuesto;

import Dominio.OperacionEgreso.OperacionDeEgreso;

public class ValidacionMenorPrecio implements ValidacionDePresupuesto{
    @Override
    public boolean validar(OperacionDeEgreso operacionDeEgreso){
        //operacionDeEgreso.getPresupuestos()
        return false;
    }
}
