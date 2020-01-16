package librarianassistant;

import java.util.Date;
import java.util.Calendar;

/*
 * This utility class was found on stack overflow:
 * "http://stackoverflow.com/questions/428918/how-can-i-increment-a-date-by-one-day-in-java"
 * and is needed to be able to increment the date
 */

public class DateUtil
{
    public static Date addDays(Date date, int days)
    {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DATE, days); //minus number would decrement the days
        return cal.getTime();
    }
}