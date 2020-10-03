package Job;

import Dominio.Presupuesto.ProcesoValidacionOperaciones;
import Dominio.Presupuesto.ValidacionCantidadPresupuestos;
import Dominio.Presupuesto.ValidacionCoincidenciaPresupuesto;
import Dominio.Presupuesto.ValidacionMenorPrecio;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

public class JobValidador implements Job {

    private int frecuencia;

    JobValidador(int frencuenciaEnSegundos) {
        frecuencia = frencuenciaEnSegundos;
    }

    public void iniciar() throws SchedulerException {
        Scheduler scheduler = new StdSchedulerFactory().getScheduler();
        JobDetail jobBase = JobBuilder.newJob(this.getClass()).build();
        scheduler.start();
        scheduler.scheduleJob(jobBase, disparador());
    }

    private Trigger disparador() {
        return TriggerBuilder.newTrigger()
                .startNow()
                .withSchedule(SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(frecuencia).repeatForever())
                .build();
    }

    @Override
    public void execute(JobExecutionContext jobExecutionContext) {
        System.out.println("Arranca el Job");
        ProcesoValidacionOperaciones validador = ProcesoValidacionOperaciones.getInstance();
        validador.agregarValidacion( new ValidacionCantidadPresupuestos());
        validador.agregarValidacion( new ValidacionMenorPrecio());
        validador.agregarValidacion( new ValidacionCoincidenciaPresupuesto());
        validador.validarYNotificarOperaciones();
        System.out.println("Finaliza el Job");
    }

}