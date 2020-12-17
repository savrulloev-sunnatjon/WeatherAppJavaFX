package sample;

import java.util.Calendar;
import java.util.Date;

public class TimeManagement {
    public int getWeek(){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        return calendar.get(Calendar.DAY_OF_WEEK);
    }
}
