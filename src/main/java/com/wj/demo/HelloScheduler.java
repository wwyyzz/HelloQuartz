package com.wj.demo;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import java.text.SimpleDateFormat;
import java.util.Date;

public class HelloScheduler {
    public static void main(String[] args) throws SchedulerException, InterruptedException {
//        创建一个JobDetail实例，将该实例与HelloJob绑定
        JobDetail jobDetail = JobBuilder.newJob(HelloJob.class)
                .withIdentity("myjob")
                .usingJobData("message","hello myJob1")
                .usingJobData("FloatJobValue",3.14F)
                .build();
//        System.out.println("job class:" + jobDetail.getJobClass());
//        System.out.println("job name:" + jobDetail.getKey().getName());
//        System.out.println("job group:" + jobDetail.getKey().getGroup());
//        创建一个Trigger实例，定义该job立即执行，每个两秒执行一次
        Date date = new Date();
        date.setTime(date.getTime() + 3000);

        Date stopTime = new Date();
        stopTime.setTime(date.getTime() + 6000);

        //        CronTrigger
        CronTrigger trigger2 = (CronTrigger) TriggerBuilder
                .newTrigger()
                .withIdentity("mytrigger2","group1")
                .startAt(date)
                .endAt(stopTime)
                .usingJobData("message", "hello myTrigger1")
                .usingJobData("DoubbleTriggerValue", 2.0D)
                .withSchedule(
                        CronScheduleBuilder.cronSchedule("* * * * * ? *"))
                .build();



//        SimpleTrigger
        Trigger trigger = TriggerBuilder
                .newTrigger()
                .withIdentity("mytrigger1","group1")
                .startAt(date)
                .endAt(stopTime)
                .usingJobData("message", "hello myTrigger1")
                .usingJobData("DoubbleTriggerValue", 2.0D)
                .withSchedule(
                        SimpleScheduleBuilder.simpleSchedule()
                                .withIntervalInSeconds(2)
                                .withRepeatCount(50))
                .build();

//        创建Scheduler实例
        SchedulerFactory sfact = new StdSchedulerFactory();
        Scheduler scheduler = sfact.getScheduler();
        scheduler.start();

        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println("Current Exec Time is: " + sf.format(date));
        System.out.println("scheduler is:" + sf.format(scheduler.scheduleJob(jobDetail,trigger2)));

        Thread.sleep(3000L);
        scheduler.standby();

        Thread.sleep(3000L);
        scheduler.start();

    }

}
