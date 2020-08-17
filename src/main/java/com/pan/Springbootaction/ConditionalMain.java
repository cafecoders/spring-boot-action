package com.pan.Springbootaction;

import com.pan.Springbootaction.conditional.ListService;
import com.pan.Springbootaction.config.ConditionalConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ConditionalMain {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ConditionalConfig.class);

        ListService listService = context.getBean(ListService.class);

        System.out.println(context.getEnvironment().getProperty("os.name") + "系统下的列表命令为：" + listService.showListCmd());
    }
}
