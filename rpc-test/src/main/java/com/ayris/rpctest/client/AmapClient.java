package com.ayris.rpctest.client;

import com.dtflys.forest.annotation.Get;

import java.util.Map;

public interface AmapClient {

    @Get("http://ditu.amap.com/service/regeo?longitude={0}&latitude={1}")
    Map getLocation(String longitude, String latitude);
}
