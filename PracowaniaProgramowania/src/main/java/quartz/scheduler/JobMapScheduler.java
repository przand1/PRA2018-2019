package quartz.scheduler;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import quartz.job.JobWithMap;

import java.util.ArrayList;

import static org.quartz.JobBuilder.newJob;
import static org.quartz.SimpleScheduleBuilder.simpleSchedule;
import static org.quartz.TriggerBuilder.newTrigger;

public class JobMapScheduler {

    public static void main(String[] args) throws InterruptedException {

        try {
            // Grab the Scheduler instance from the Factory
            Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
            ArrayList<Human> humans = new ArrayList<Human>();
            humans.add(new Human(213456,"Katowice","Adam","Zły"));
            scheduler.getContext().put("state",humans);

            // define the job and tie it to our JobWithMap class
            JobDetail job = newJob(JobWithMap.class)
                    .withIdentity("myJob", "group1") // name "myJob", group "group1"
                    .build();

            // Trigger the job to run now, and then repeat every 1 seconds
            Trigger trigger = newTrigger()
                    .withIdentity("trigger1", "group1")
                    .startNow()
                    .withSchedule(simpleSchedule()
                            .withIntervalInSeconds(1)
                            .repeatForever())
                    .build();
            // Tell quartz to schedule the job using our trigger
            scheduler.scheduleJob(job, trigger);


//            HumanContainer hc = new HumanContainer();
//            hc.addHuman(new Human(4444,"Gdańsk","Jan","Asfd"));
//            hc.addHuman(new Human(4445,"Gdańsk","Jann","Asfgd"));
//            hc.addHuman(new Human(4446,"Gdańsk","Jean","Asd"));
//            hc.addHuman(new Human(4447,"Gdańsk","Janann","Asdss"));

            // and start it off
            scheduler.start();

            Thread.sleep(6000);

            scheduler.shutdown();

        } catch (SchedulerException se) {
            se.printStackTrace();
        }
    }
}
