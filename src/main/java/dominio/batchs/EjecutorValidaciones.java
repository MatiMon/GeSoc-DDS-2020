package dominio.batchs;

import dominio.modelo.presupuesto.ProcesoValidacionOperaciones;
import dominio.modelo.presupuesto.ValidacionCantidadPresupuestos;
import dominio.modelo.presupuesto.ValidacionCoincidenciaPresupuesto;
import dominio.modelo.presupuesto.ValidacionMenorPrecio;

import java.util.Timer;
import java.util.TimerTask;

public class EjecutorValidaciones extends TimerTask {

    private static int periodicidadEjecucion = 5 ; //en segundos

    @Override
    public void run() {
        System.out.println("Run started");
        ProcesoValidacionOperaciones validador = ProcesoValidacionOperaciones.getInstance();

        validador.agregarValidacion( new ValidacionCantidadPresupuestos());
        validador.agregarValidacion( new ValidacionMenorPrecio());
        validador.agregarValidacion( new ValidacionCoincidenciaPresupuesto());

        validador.validarYNotificarOperaciones();
        System.out.println("Run finished");
    }

    public static void main(String args[]){

        TimerTask ejecutorBatchs = new EjecutorValidaciones();
        //running timer task as daemon thread
        Timer timer = new Timer(true);
        timer.scheduleAtFixedRate(ejecutorBatchs, 0, calcularPeriodicidad());
        System.out.println("Main started");

        //cancel after sometime
        try {
            Thread.sleep(120000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        timer.cancel();
        System.out.println("Main cancelled");
        try {
            Thread.sleep(30000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static int calcularPeriodicidad(){
        return periodicidadEjecucion * 10000;
    }


}
