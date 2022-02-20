package com.scu.group8.mailServer.utils;

//日期转换工具类
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;


public class DateUtil {
    /**
     * 获取当前的日期时间，格式：yyyy-MM-dd HH:mm:ss
     */
    public static Timestamp getCurrentDate(){
        Date date = new Date();
        return new Timestamp(date.getTime());
    }

    public static String getCurrentDateString(){
        //当前日期
        LocalDate now = LocalDate.now();
        //创建一个DateTimeFormatter对象
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        //通过LocalDate的format方法
        return now.format(formatter);
    }

    /**
     * 两个时间相加
     */
    public static Date addTime(Date date,int hour, int minute, int second) throws ParseException {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.HOUR_OF_DAY,hour);
        calendar.add(Calendar.MINUTE,minute);
        calendar.add(Calendar.SECOND,second);

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String result = sdf.format(calendar.getTime());

        return sdf.parse(result);
    }

    /**
     * 判断时间是否处于某个时间段内
     *
     * @param time 需要比较的时间
     * @param beginTime 起始时间
     * @param endTime 结束时间
     */
    public static boolean belongCalendar(Date time, Date beginTime, Date endTime) {
        Calendar date = Calendar.getInstance();
        date.setTime(time);
        Calendar after = Calendar.getInstance();
        after.setTime(beginTime);
        Calendar before = Calendar.getInstance();
        before.setTime(endTime);
        if (date.after(after) && date.before(before)) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 计算忙时时间：
     * 传入：当日Date
     * 输出：当日午市开始时间、当日午市结束时间、当日晚市开始时间、当日晚市结束时间
     */
    public static List<Date> switchBusyCalendar(Date time) {
        Calendar timeCalendar = Calendar.getInstance();
        timeCalendar.setTime(time);

        List<Date> datesList = new LinkedList<>();

        timeCalendar.set(Calendar.HOUR_OF_DAY,11);
        timeCalendar.set(Calendar.MINUTE,30);
        timeCalendar.set(Calendar.SECOND,0);
        Date lunchBeginTime = timeCalendar.getTime();
        datesList.add(lunchBeginTime);

        timeCalendar.set(Calendar.HOUR_OF_DAY,14);
        timeCalendar.set(Calendar.MINUTE,0);
        timeCalendar.set(Calendar.SECOND,0);
        Date lunchEndTime = timeCalendar.getTime();
        datesList.add(lunchEndTime);

        timeCalendar.set(Calendar.HOUR_OF_DAY,17);
        timeCalendar.set(Calendar.MINUTE,0);
        timeCalendar.set(Calendar.SECOND,0);
        Date dinnerBeginTime = timeCalendar.getTime();
        datesList.add(dinnerBeginTime);

        timeCalendar.set(Calendar.HOUR_OF_DAY,20);
        timeCalendar.set(Calendar.MINUTE,0);
        timeCalendar.set(Calendar.SECOND,0);
        Date dinnerEndTime = timeCalendar.getTime();
        datesList.add(dinnerEndTime);

        return datesList;
    }
}