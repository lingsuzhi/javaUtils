package date;


import org.testng.annotations.Test;

import java.time.DayOfWeek;
import java.time.Duration;
import java.time.LocalDateTime;

public class dateUtils {


    /**
     * 计算时间差，返回天数
     * @param time 时间
     * @return 天数,不足会舍弃
     */
    public static long durationDay(LocalDateTime time) {
        Duration duration = Duration.between(time, LocalDateTime.now());
        return duration.toDays();
    }
    /**
     * 计算时间差，返回秒数
     * @param time 时间
     * @return 秒数
     */
    public static long durationSecond(LocalDateTime time) {
        Duration duration = Duration.between(time, LocalDateTime.now());
        return duration.getSeconds();
    }

    /**
     * 当日   返回     时：分
     * 昨天   返回     昨天
     * 7天内  返回     当天星期几
     * 30天内 返回     一周前
     * 30天外 返回     一月前
     *
     * @param time
     * @return
     */
    public static String durationStr(LocalDateTime time) {
        long val = durationDay(time);
        if(val<0){
            return "";
        }
        if(val == 0){
            String hour = String.valueOf(time.getHour());
            String minute= String.valueOf(time.getMinute());
            return hour + ":" + minute;
        }
        if(val == 1){
            return "昨天";
        }
        if(val < 7){
            DayOfWeek dayOfWeek = time.getDayOfWeek();
            return dayOfWeekChina(dayOfWeek);
        }
        if(val<30             ){
            return "一周前";
        }

        return "一月前";

    }
    public static String dayOfWeekChina(DayOfWeek dayOfWeek){
        if (DayOfWeek.MONDAY.equals(dayOfWeek)){
            return "星期一";
        }
        if (DayOfWeek.TUESDAY.equals(dayOfWeek)){
            return "星期二";
        }
        if (DayOfWeek.WEDNESDAY.equals(dayOfWeek)){
            return "星期三";
        }
        if (DayOfWeek.THURSDAY.equals(dayOfWeek)){
            return "星期四";
        }
        if (DayOfWeek.FRIDAY.equals(dayOfWeek)){
            return "星期五";
        }
        if (DayOfWeek.SATURDAY.equals(dayOfWeek)){
            return "星期六";
        }
        if (DayOfWeek.SUNDAY.equals(dayOfWeek)){
            return "星期日";
        }
        return null;
    }
    @Test
    private void durationStr_Test(){
        String str =  durationStr(LocalDateTime.of(2018,9,20,22,0,0));
        System.out.println(str);
    }
    @Test
    private void durationDay_test(){
        long l = dateUtils.durationDay(LocalDateTime.of(2018,10,31,22,0,0));
        System.out.println(l);
    }
    @Test
    private void durationSecond_test(){
        long l = dateUtils.durationSecond(LocalDateTime.of(2018,11,1,22,0,0));
        System.out.println(l);
    }
}
