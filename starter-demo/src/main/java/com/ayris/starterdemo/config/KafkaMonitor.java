package com.ayris.starterdemo.config;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class KafkaMonitor {

    private String host;

    private String port;

    public String printConfig() {
        return host + "-" + port;
    }

}
