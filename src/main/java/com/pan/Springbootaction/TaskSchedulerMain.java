package com.pan.Springbootaction;

import com.pan.Springbootaction.config.TaskSchedulerConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TaskSchedulerMain {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(TaskSchedulerConfig.class);

        context.close();
    }
}
