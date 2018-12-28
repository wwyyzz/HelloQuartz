package com.wj.demo;

import org.quartz.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.SimpleFormatter;

public class HelloJob implements Job {


    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        Date date = new Date();
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println("==========================================");
        System.out.println("Current Exec Time is: " + sf.format(date));









//        编写具体的业务逻辑
//        System.out.println("Hello World!");
//
//        JobKey key = context.getJobDetail().getKey();
//        System.out.println("My job name and group are :" + key.getName() + "   " + key.getGroup());
//
//        TriggerKey triggerKey = context.getTrigger().getKey();
//        System.out.println("My Trigger is:" + triggerKey.getName() + "   " + triggerKey.getGroup());
//
//        JobDataMap dataMap = context.getJobDetail().getJobDataMap();
//        JobDataMap tdataMap = context.getTrigger().getJobDataMap();
//
////        System.out.println(dataMap.getString("message"));
//
//        String jobMsg = dataMap.getString("message");
//        Float jobFloatValue = dataMap.getFloat("FloatJobValue");
//        System.out.println("jobMessage =" + jobMsg);
//        System.out.println("jobFloatValue =" + jobFloatValue);
//
//        System.out.println("triggerMessage =" + tdataMap.getString("message"));
//        System.out.println("triggerDoubleValue =" + tdataMap.getDouble("DoubbleTriggerValue"));
//
//        String triggerMsg = tdataMap.getString("message");
//        Double triggerDoubleValue = tdataMap.getDouble("DoubleTriggleValue");
//        System.out.println("triggerMsg =" + triggerMsg.toString());
//        System.out.println("triggerDoubleValue =" + triggerDoubleValue.toString());
//
//        System.out.println("hi!!!!!!!");

    }
}
