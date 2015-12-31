package psn.lotus.core.util;

import java.util.Calendar;
import java.util.Date;

/**
 * @author: nicee
 * @since: 2015/12/29
 */
public class DateUtils {

    static final Calendar CALENDAR = Calendar.getInstance();

    public static Date getCurrentTime() {
        return CALENDAR.getTime();
    }

}
