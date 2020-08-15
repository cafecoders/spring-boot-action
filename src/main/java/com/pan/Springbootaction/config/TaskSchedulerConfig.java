package com.pan.Springbootaction.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

@Configuration
@ComponentScan("com.pan.Springbootaction.*")
@EnableScheduling
public class TaskSchedulerConfig {
}
