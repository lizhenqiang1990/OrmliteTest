package com.attendance.fp.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class DateUtil {
    
    public static String getDate(long datetime) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date(datetime);
        String dateStr = sdf.format(date);
        return dateStr;
    }
    
    public static String getDateTime(long datetime) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        Date date = new Date(datetime);
        String dateStr = sdf.format(date);
        return dateStr;
    }
    
    public static String geTime(long datetime) {
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        Date date = new Date(datetime);
        sdf.getTimeZone().setRawOffset(0x0);
        String dateStr = sdf.format(date);
        return dateStr;
    }
}
