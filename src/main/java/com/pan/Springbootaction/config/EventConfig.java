package com.pan.Springbootaction.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.pan.Springbootaction.event,com.pan.Springbootaction.listener,com.pan.Springbootaction.publisher")
public class EventConfig {

}
