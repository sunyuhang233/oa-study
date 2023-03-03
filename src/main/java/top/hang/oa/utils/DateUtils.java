package top.hang.oa.utils;

import java.util.Date;

/**
 * @author Ahang
 * @version 1.0
 * @description TODO
 * @date 2023/3/3 12:55
 */
public class DateUtils {

    public static long getDiffHours(Date startTime, Date endTime){
        long diff=endTime.getTime() - startTime.getTime();
        return diff /(1000*60*60);
    }
}
