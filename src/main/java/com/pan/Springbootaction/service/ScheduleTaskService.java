package com.pan.Springbootaction.service;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class ScheduleTaskService {
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    @Scheduled(fixedDelay = 5000)
    public void reportCurrentTime() {
        System.out.println("每隔5秒执行。。。" + dateFormat.format(new Date()));
    }

    @Scheduled(cron = "05 57 23 ? * *")
    public void fixTimeReport() {
        System.out.println("在指定时间。。。" + dateFormat.format(new Date()));
    }
}
