package com.ayris.controller;

import org.flywaydb.core.Flyway;

public class FlywayTest {

    public static void main(String[] args) {
        String url = "jdbc:mysql://110.42.203.15:3308/mock_test?useUnicode=true&characterEncoding=utf-8&useSSL=false&serverTimezone=GMT%2B8&useTimezone=true";
        String user = "root";
        String password = "123456";

        Flyway flyway = Flyway.configure().dataSource(url, user, password).load();

        flyway.migrate();
    }

}
