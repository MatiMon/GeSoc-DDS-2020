package Dominio.Presupuesto;
import Dominio.OperacionEgreso.OperacionDeEgreso;


import java.util.ArrayList;
import java.util.List;
import java.util.Timer;


public class BatchValidacionOperaciones  {

    private static BatchValidacionOperaciones instance;
    private static List<OperacionDeEgreso> operaciones = new ArrayList<OperacionDeEgreso>();
    private ValidadorDePresupuestos validador = new ValidadorDePresupuestos();

    //Singleton
    private BatchValidacionOperaciones(){}
    public static BatchValidacionOperaciones getInstance(){
        if(instance == null){
            instance = new BatchValidacionOperaciones();
        }
        return instance;
    }

    public static void agregarOperacion(OperacionDeEgreso operacion){
        operaciones.add(operacion);
    }

    public void agregarValidacion( ValidacionDePresupuesto validacion){
        this.validador.agregarValidacion(validacion);
    }

    public void validarYNotificarOperaciones(){
        //recorrer la lista de operaciones, validandola y mandando un mensaje a su lista de interesados
        operaciones.stream().forEach(operacion -> operacion.informarValidacion(this.validador.validar(operacion)));
    }




}
