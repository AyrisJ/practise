package com.ayris.starterdemo.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Getter
@Setter
@ConfigurationProperties(prefix = "ayris.kafka")
public class KafkaCfg {

    private String host;

    private String port;

}
