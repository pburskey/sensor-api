package com.burskey.sensor.domain;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ParseTimestamp {
    public static final String pattern = "yyyy-MM-dd_HH:mm:ss";

    public static Date parse(String aString) throws ParseException {
        Date date = null;

        if (aString != null && aString.length() > 0) {

            //2018-04-22_17:03:33
            SimpleDateFormat format = new SimpleDateFormat(pattern);
            date = format.parse(aString);
        }


        return date;
    }

    public static String from(Date timeStamp) {
        String aString = null;

        if (timeStamp != null ) {

            //2018-04-22_17:03:33
            SimpleDateFormat format = new SimpleDateFormat(pattern);
            aString = format.format(timeStamp);
        }
        return aString;
    }
}
