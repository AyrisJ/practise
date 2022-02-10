package com.ayris.starterdemo.config;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
@EnableConfigurationProperties(KafkaCfg.class)
public class KafkaMonitorAutoConfiguration {

    @Bean
    public KafkaMonitor kafkaMonitor(KafkaCfg kafkaCfg) {
        KafkaMonitor kafkaMonitor = new KafkaMonitor();
        kafkaMonitor.setHost(kafkaCfg.getHost());
        kafkaMonitor.setPort(kafkaCfg.getPort());
        return kafkaMonitor;
    }

}
