package com.dw.web.common.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public  class DateUtil {


    /**
     * 时间转成String
     * @param date
     * @return
     */
    public static String getDateString(Date date){
        String stringDate = null;
        SimpleDateFormat sf = new SimpleDateFormat();
        stringDate = sf.format(date);
        return stringDate ;
    }
}
