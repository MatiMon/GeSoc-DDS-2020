package Job;

import org.quartz.*;
import org.slf4j.*;
import org.quartz.impl.StdSchedulerFactory;

import java.util.Date;

import static org.quartz.DateBuilder.evenMinuteDate;
import static org.quartz.JobBuilder.newJob;
import static org.quartz.TriggerBuilder.newTrigger;

public class EjecutorJobs {

    public static void main(String args[]) throws SchedulerException {
        JobValidador jobValidador = new JobValidador(10);
        jobValidador.iniciar();
    }

}
