package com.liu.sensitivewordfilter.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

    public static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public static String dateFormat(Date date) throws ParseException {
        return simpleDateFormat.format(date);
    }


}
