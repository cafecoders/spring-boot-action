package com.pan.Springbootaction;

import com.pan.Springbootaction.config.TaskExecutorConfig;
import com.pan.Springbootaction.service.AsyncTaskService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AsyncMain {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(TaskExecutorConfig.class);

        AsyncTaskService asyncTaskService = context.getBean(AsyncTaskService.class);

        for(int i = 0; i < 10; i++) {
            asyncTaskService.executeAsyncTask(i);
            asyncTaskService.executeAsyncTaskPlus(i);
        }

        context.close();
    }
}
