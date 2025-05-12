package com.ayris.simple;

import cn.hutool.core.date.DateUtil;

import java.text.DateFormat;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class UnitTest {

    public static void main(String[] args) {
        System.out.println(DateUtil.now());
        DateUtil.date();

        ZoneId gmtZone = ZoneId.of("GMT");
        ZonedDateTime nowTime = ZonedDateTime.now(gmtZone);
        System.out.println(nowTime.format(DateTimeFormatter.ISO_ZONED_DATE_TIME));

        DateTimeFormatter formatter = DateTimeFormatter.RFC_1123_DATE_TIME.withLocale(Locale.US);
        String formattedDate = nowTime.format(formatter);
        System.out.println(formattedDate);
    }

}
