package job;

import org.quartz.SchedulerException;

public class EjecutorJobs {

    public static void main(String args[]) throws SchedulerException {
        JobValidador jobValidador = new JobValidador(10);
        jobValidador.iniciar();
    }

}
