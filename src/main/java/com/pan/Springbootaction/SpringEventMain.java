package com.pan.Springbootaction;

import com.pan.Springbootaction.config.EventConfig;
import com.pan.Springbootaction.publisher.DemoPublisher;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * spring event通知机制，用在单机系统的消息通知上蛮好
 */
public class SpringEventMain {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(EventConfig.class);

        DemoPublisher publisher = context.getBean(DemoPublisher.class);
        publisher.publish("hello world!");

        context.close();
    }
}
