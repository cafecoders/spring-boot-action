package com.pan.Springbootaction.config;

import com.pan.Springbootaction.conditional.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

@Configuration
/**
 * @conditional注解，用在按条件配置Bean的场景
 */
public class ConditionalConfig {
    @Bean
    @Conditional(WindowsCondition.class)
    public ListService windowsService() {
        return new WindowsListService();
    }

    @Bean
    @Conditional(LinuxCondition.class)
    public ListService linuxService() {
        return new LinuxListService();
    }
}
