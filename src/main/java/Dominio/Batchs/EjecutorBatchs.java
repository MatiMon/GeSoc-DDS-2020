package Dominio.Batchs;

import Dominio.Presupuesto.BatchValidacionOperaciones;
import Dominio.Presupuesto.ValidacionCantidadPresupuestos;
import Dominio.Presupuesto.ValidacionCoincidenciaPresupuesto;
import Dominio.Presupuesto.ValidacionMenorPrecio;

import java.util.Timer;
import java.util.TimerTask;

public class EjecutorBatchs extends TimerTask {

    private static int periodicidadEjecucion = 24; //en horas

    @Override
    public void run() {
        System.out.println("Timer task started");
        BatchValidacionOperaciones validador = BatchValidacionOperaciones.getInstance();

        validador.agregarValidacion( new ValidacionCantidadPresupuestos());
        validador.agregarValidacion( new ValidacionMenorPrecio());
        validador.agregarValidacion( new ValidacionCoincidenciaPresupuesto());

        validador.validarYNotificarOperaciones();
        System.out.println("Timer task finished");
    }

    public static void main(String args[]){

        TimerTask ejecutorBatchs = new EjecutorBatchs();
        //running timer task as daemon thread
        Timer timer = new Timer(true);
        timer.scheduleAtFixedRate(ejecutorBatchs, 0, calcularPeriodicidad());
        System.out.println("TimerTask started");

        //cancel after sometime
        try {
            Thread.sleep(120000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        timer.cancel();
        System.out.println("TimerTask cancelled");
        try {
            Thread.sleep(30000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static int calcularPeriodicidad(){
        return periodicidadEjecucion * 60 * 60 * 10000;
    }

}
