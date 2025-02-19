package com.middleware.reports.util;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

    public static Timestamp convertStringToTimestamp(String dateString, String format) throws Exception {
        SimpleDateFormat formatter = new SimpleDateFormat(format);
        Date date = formatter.parse(dateString);
        return new Timestamp(date.getTime());
    }
}
