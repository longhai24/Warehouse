package com.accp.Goods.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 
* <p>Title: CountDate</p>  
* <p>Description: ���ڲ���������</p>  
* @author Apple 

* @date 2019��4��16��
 */
public class CountDate {
  private final static SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMdd");
  private final static SimpleDateFormat sdfymdhm = new SimpleDateFormat("yyyyMMddHHmmss");
  private final static SimpleDateFormat sdfymdhms =  new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
 
  /**
  *
 * @Title: fTime2
 * @Description: TODO ��ǰ����
 * @return
  */
  public  String getCurrentDay(){
    return sdf.format(new Date());
  }
  /**
   *
  * @Title: fTime2
  * @Description: TODO ��ȡtime���������ǰdayAgo�������
  * @return
   */
  public  String fTime(String time,int dayAgo){
    Date date = null;
    try {
      date = sdf.parse(time);
    } catch (ParseException e) {
        throw new RuntimeException(e);
    }
    Calendar calendar = Calendar.getInstance();
    calendar.setTime(date);
    if(dayAgo>0){
      calendar.add(Calendar.DAY_OF_MONTH, -dayAgo);//ǰ15������
      date = calendar.getTime();
      calendar.setTime(date);
    }
    int year=calendar.get(Calendar.YEAR);
    int month=calendar.get(Calendar.MONTH) + 1;
    int day = calendar.get(Calendar.DAY_OF_MONTH);
    String mon="";
    String d="";
    if(month<10){
      mon="0"+month;
    }else{
      mon=month+"";
    }
    if(day<10){
      d="0"+day;
    }else{
      d=""+day;
    }
    String ret=year+""+mon+""+d;
    return ret;
  }
  /**
   *
  * @Title: fTime2
  * @Description: TODO ��ȡtime��������Ժ�dayAfter�������
  * @return
   */
  public  String fTime2(String time,int dayAfter){
    Date date = null;
    try {
      date = sdf.parse(time);
    } catch (ParseException e) {
        throw new RuntimeException(e);
    }
    Calendar calendar = Calendar.getInstance();
    calendar.setTime(date);
    if(dayAfter>0){
      calendar.add(Calendar.DAY_OF_MONTH, +dayAfter);//��15������
      date = calendar.getTime();
      calendar.setTime(date);
    }
    int year=calendar.get(Calendar.YEAR);
    int month=calendar.get(Calendar.MONTH) + 1;
    int day = calendar.get(Calendar.DAY_OF_MONTH);
    String mon="";
    String d="";
    if(month<10){
      mon="0"+month;
    }else{
      mon=month+"";
    }
    if(day<10){
      d="0"+day;
    }else{
      d=""+day;
    }
    String ret=year+mon+d;
    return ret;
  }
  /**
   *
  * @Title: getDefaultTime
  * @Description: TODO ��ȡ���������
  * @return
   */
  public  String getDefaultTime(){
    Calendar calendar = Calendar.getInstance();
    calendar.add(Calendar.DAY_OF_MONTH, -1);//ǰ1��
    Date date = calendar.getTime();
    String time=sdf.format(date);
    return time;
  }
  /**
   *
  * @Title: getSunday
  * @Description: TODO ��ȡ���һ��������
  * @return
   */
  public  String getSunday(){
    SimpleDateFormat f = new SimpleDateFormat("yyyyMMdd");
    Calendar c = Calendar.getInstance();
    c.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
    return f.format(c.getTime());
  }
  /**
   *
  * @Title: getMonthFirstDay
  * @Description: TODO ��ȡ���µ�һ��
  * @return
   */
  public  String getCurrentMonthFirstDay(){
    Calendar  cal_1=Calendar.getInstance();//��ȡ��ǰ����
    cal_1.add(Calendar.MONTH, 0);
    cal_1.set(Calendar.DAY_OF_MONTH,1);//����Ϊ1��,��ǰ���ڼ�Ϊ���µ�һ��
    String firstDay = sdf.format(cal_1.getTime());
    return firstDay;
  }
  /**
   *
  * @Title: getMonthFirstDay
  * @Description: TODO ��ȡ���µ�һ��
  * @return
   */
  public  String getPreviousMonthFirstDay(){
   //��ȡ��ǰ�µ�һ�죺
  Calendar c = Calendar.getInstance();
  c.add(Calendar.MONTH, -1);
  c.set(Calendar.DAY_OF_MONTH,1);//����Ϊ1��,��ǰ���ڼ�Ϊ���µ�һ��
  String first = sdf.format(c.getTime());
  return first;
  }
  /**
   *
  * @Title: getMonthFirstDay
  * @Description: TODO ��ȡ�������һ��
  * @return
   */
  public  String getPreviousMonthLastDay(){
  //��ȡ��ǰ�����һ��
  Calendar ca = Calendar.getInstance();
  ca.set(Calendar.DAY_OF_MONTH,0);//
  String lastDay = sdf.format(ca.getTime());
  return lastDay;
  }
  /**
   *
  * @Title: getCurrentMonthLastDay
  * @Description: TODO ��ȡָ��ʱ�����һ��
  * @return
   */
  public  String getCurrentMonthLastDay(String time){
    Date date =null;
   try {
    date= sdf.parse(time);
  } catch (ParseException e) {
    // TODO Auto-generated catch block
    e.printStackTrace();
  }
  //��ȡ��ǰ�����һ��
  Calendar ca = Calendar.getInstance();
  ca.setTime(date);
  ca.set(Calendar.DAY_OF_MONTH,
      ca.getActualMaximum(Calendar.DAY_OF_MONTH)); //
  String lastDay = sdf.format(ca.getTime());
  return lastDay;
  }
  /***
   *
  * @Title: getCurrentWeekDay
  * @Description: TODO ��ȡ������һ
   */
  public  String getCurrentMonday(){
     Calendar cal = Calendar.getInstance();
     cal.setFirstDayOfWeek(Calendar.MONDAY);//��ÿ�ܵ�һ����Ϊ����һ��Ĭ����������
     cal.add(Calendar.DATE, 0);
     cal.set(Calendar.DAY_OF_WEEK,Calendar.MONDAY);
     String monday = sdf.format(cal.getTime());
     return monday;
  }
  /***
   *
  * @Title: getPreviousSunday
  * @Description: TODO ��ȡ��������
   */
  public  String getPreviousSunday(){
     Calendar cal = Calendar.getInstance();
     cal.setFirstDayOfWeek(Calendar.MONDAY);//��ÿ�ܵ�һ����Ϊ����һ��Ĭ����������
     cal.add(Calendar.DATE, -1*7);
     cal.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
     String sunday =sdf.format(cal.getTime());
     return sunday;
  }
  /**
   *
  * @Title: getMiniSencond
  * @Description: TODO ������ת��Ϊ������
  * @param str
  * @return
   */
  public  String getMiniSencond(String str){
    long millionSeconds=0;
    try {
      millionSeconds = sdfymdhm.parse(str).getTime();//����
    } catch (ParseException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    return millionSeconds+"";
  }
   /**
   *
  * @Title: getDateSencond
  * @Description: TODO ������ת��Ϊ������
  * @param str
  * @return
   */
  public  long getDateSencond(String str){
    long millionSeconds=0;
    try {
      millionSeconds = sdfymdhms.parse(str).getTime();//����
    } catch (ParseException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    return millionSeconds;
  }
  /**
   * ���������������
   * @param str1
   * @param str2
   * @return
   */
  public  int getDistanceOfTwoDate(String str1,String str2){
    int result=0;
    try{
      Date date1 = sdf.parse(str1);
      Date date2 =sdf.parse(str2);
      Calendar aCalendar = Calendar.getInstance();
        aCalendar.setTime(date1);
        int day1 = aCalendar.get(Calendar.DAY_OF_YEAR);
        aCalendar.setTime(date2);
        int day2 = aCalendar.get(Calendar.DAY_OF_YEAR);
        result = day1-day2;
    }catch(Exception e){
      e.printStackTrace();
    }
    return result;
  }
  /**
   *
  * @Title: long2Date
  * @Description: TODO long ת����(��-��-�� ʱ-��-��)
  * @param timestamp
  * @return
   */
  public  String longToDate(Long msecond){
    Date date = new Date(msecond);
    return sdfymdhms.format(date);
  }
}