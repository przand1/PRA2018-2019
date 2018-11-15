package quartz.job;

import org.quartz.*;
import quartz.scheduler.Human;

import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

@PersistJobDataAfterExecution
@DisallowConcurrentExecution
public class JobWithMap  implements org.quartz.Job{

//    ArrayList<Human> state;
//    public void setState(ArrayList state) {
//      state = state;
//    }


    public void execute(JobExecutionContext context) throws JobExecutionException {
        {
            //Job name
            JobKey key = context.getJobDetail().getKey();

            //Job values Map
            JobDataMap dataMap = context.getMergedJobDataMap();

            SchedulerContext schedulerContext = null;
            try {
             schedulerContext = context.getScheduler().getContext();
            } catch (SchedulerException e1) {
             e1.printStackTrace();
            }
            ArrayList<Human> state = (ArrayList<Human>) schedulerContext.get("state");
            for (int i =0;i<state.size();i++) {
                System.out.println("Human "+i+ " "+state.get(i).toString());
            }
        }
    }
}
