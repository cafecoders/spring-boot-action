package com.pan.Springbootaction.listener;

import com.pan.Springbootaction.event.DemoEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class DemoListener implements ApplicationListener<DemoEvent> {
    @Override
    public void onApplicationEvent(DemoEvent demoEvent) {
        String msg = demoEvent.getMsg();

        System.out.println("bean-demoListener接收到了bean-demoPublisher发送的消息，msg：" + msg);
    }
}
