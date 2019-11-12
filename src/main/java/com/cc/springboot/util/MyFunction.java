package com.cc.springboot.util;

import com.alibaba.fastjson.JSONObject;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.*;

@Component
@Lazy(value = false)
public class MyFunction {

    public static void main(String[] args){
        MyFunction mf = new MyFunction();
//        System.out.println(mf.getStartTimeOfMonth(System.currentTimeMillis(),1,""));
    }
    public static void print(Object str)
    {
        System.out.println(str.toString());
    }


    public static String riqichuan(Date date){
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
            return  sdf.format(date);
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
    public static String wuwei(Number number){
        StringBuilder str = new StringBuilder(number+"") ;
        int length = str.length();
        if (length>5){//前面
            return str.substring(length-6,length-1);
        }else if(length<5){
            for (int i = length ; i < 5 ; i ++){
                str.insert(0,'0');
            }
        }
        return  new String(str);
    }
    public static String siwei(Number number){
        StringBuilder str = new StringBuilder(number+"") ;
        int length = str.length();
        if (length>4){//前面
            return str.substring(length-4,length-1);
        }else if(length<4){
            for (int i = length ; i < 4 ; i ++){
                str.insert(0,'0');
            }
        }
        return  new String(str);
    }

    public String fixedNumberString(Number number,int len){//固定长度数字字符串
        StringBuilder str = new StringBuilder(number+"") ;
        int length = str.length();
        if (length > len){//前面
            return str.substring(length-len-1,length-1);
        }else if(length<len){
            for (int i = length ; i < len ; i ++){
                str.insert(0,'0');
            }
        }
        return  new String(str);
    }

    public static Timestamp getCurrentTimestamp(){
        return new Timestamp(System.currentTimeMillis());
    }

    public  int smaller(int num1,int num2){
        if(num1-num2>0){
            return num2;
        }else {
            return num1;
        }
    }
    public  long smaller(long num1,long num2){
        if(num1-num2>0){
            return num2;
        }else {
            return num1;
        }
    }
    public  int smaller(Integer num1,Integer num2){
        if(num1-num2>0){
            return num2;
        }else {
            return num1;
        }
    }

    public static List quchong(List list){
        Set set = new HashSet();
        set.addAll(list);
        list.clear();
        list.addAll(set);
        return list;
    }


    public String stringListToString(Collection collection){
        Iterator it= collection.iterator();
        String str="";
        while (it.hasNext()){
            str+=it.next();
        }
        return str;
    }
    public String heng(){
        return "\n---------------------------------------\n";
    }


    public  Integer toInteger(Object obj){
        if(obj instanceof Integer){
            return (Integer) obj;
        }else if(obj instanceof Long){
            long a = (Long)obj;
            return new Integer((int)a);
        }
        else {
            try {
                return (int)obj;
            }catch (Exception e){
            throw new RuntimeException("无法转换成Integer");
        }
        }
    }

public Object mh(Object obj)
{
	if(null == obj )
	{
		return "";
	}else
	{
		return "'"+obj+"'";
	}
	
	
	}
    


    public String mohu(String key){
        if (null == key || "".equals(key.trim())){
            return "%" ;
        }
        StringBuilder sb =new StringBuilder(key);
        for (int i =0;i<key.length()*2+1;i+=2){
            sb.insert(i,"%");
        }
        return sb.toString();
    }

    public String mohuSimple(String key){
        if (null == key){
            return "%";
        }else {
            return "%"+key+"%";
        }
    }
    
    public  String  dateObtain()
    {
    	Date date = new Date();
		SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd :hh:mm:ss");
		//System.out.println(dateFormat.format(date));
		return dateFormat.format(date);
	
    }
    public Date dateObtainDate()
    {
    	Date date = new Date();
    	return date;
    	
    }
 
    public  Object PageHelperPage(Object page)
    {
    	if(null == page)
    	{
    		
    		return page=1;
    	}else 
    	{
    		return page;
    	}
    	
    }
    public  Object PageHelperPagesize(Object pagesize)
    {
    	if(null == pagesize)
    	{
    		
    		return pagesize=10;
    	}else 
    	{
    		return pagesize;
    	}
    	
    }
    

    public String mohuSimple_ignoreNull(String key){
        if (null == key){
            return "";
        }else {
            return "%"+key+"%";
        }
    }

    public String fillKeywordIgnoreNull(String key){
        if (null == key)
        {
            return null;
        }else {
            return key + "%";
        }
    }



    public String jsonPre(String jsonStr){
        if (!jsonStr.startsWith("[")){
            jsonStr = "[" + jsonStr + "]";
        }
        return jsonStr;
    }

    public int parseInt(String str,int val){
        int number = -10;
        if(str==null){
            return val;
        }else{
            try {
                number =Integer.parseInt(str);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return number;
    }

    public String getStringFromRequest(HttpServletRequest request, String name, String ifnull){
        String str = null;
        str = request.getParameter(name);
        if ((null==str)){
            return ifnull;
        }else {
            return str;
        }
    }

    public Integer getIntFromRequest(HttpServletRequest request, String name, Integer ifnull){
        Integer a = null;
        a = parseInt(request.getParameter(name),ifnull);
        return  a;
    }
    public String space(){
        return "     ";
    }


    public String formatIdString(List<Integer> list){
        StringBuilder sb = new StringBuilder("");
        for (Integer i : list){
            sb.append(i+",");
        }
        sb.deleteCharAt(sb.length()-1);
        return sb.toString();
    }

    public Integer intDefault(Integer number,Integer defaulValue){
        if (null == number){
            return defaulValue;
        }
        return number;
    }
    public Double doubleDefault(Double f,Double defaultValue){
        if (null == f){
            return defaultValue;
        }
        return f;
    }
    public Double doubleDefault(Float f,Double defaultValue){
        if (null == f){
            return defaultValue;
        }
        return f.doubleValue();
    }



    public Long interceptTimeMillis(Date date,int length){//截取日期为一定位数的毫秒数
        long temp = date.getTime();
        try {
            String timeMillisStr = temp+"";
            if (timeMillisStr.length()>=length) {
                temp = Long.parseLong(timeMillisStr.substring(0, length));
            }
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("转换失败");
        }

        return temp;
    }
    public Long interceptTimeMillis(Long millis,int length){
        String timeMillisStr = millis+"";
        if (timeMillisStr.length()>=length){
            return Long.parseLong(timeMillisStr.substring(0,length));
        }
        return millis;
    }

    /**
     * date 从何时开始截取
     * sort 1.向后 2.向前
     * timeUnit 时间单位day/week/month
     * interval 数字
     * length 返回多少位时间戳 现在时间戳总共13位，精确到毫秒；10位时间戳精确到秒 2018/4/25 14:26:55
     * */
    public Long getLastPeriodTimellis(Date date,String timeUnit,int interval,int length){//获取当前时间
        Long result = date.getTime();
        long millis_day = 1000*60*60*24;
        long millis_week = millis_day*7;
        long millis_month = millis_day*30;
        long millis_year = millis_day * 365;

        if ("day".equalsIgnoreCase(timeUnit.trim())){
            result += millis_day*interval;

        }else if ("week".equalsIgnoreCase(timeUnit.trim())){
            result += millis_week*interval;


        }else if ("month".equalsIgnoreCase(timeUnit.trim())){
            result += millis_month*interval;

        }else if ("year".equalsIgnoreCase(timeUnit.trim())){
            result += millis_year*interval;
        }
        else {
            throw new RuntimeException("invalid timeUnit :"+timeUnit);
        }
        return  this.interceptTimeMillis(result,length);
    }

    public long getTimeOfNextMonth(Long time,Date date,String timeZone){

        String tz = (null == timeZone || "".equals(timeZone))? "GMT+8" : timeZone;
        TimeZone curTimeZone = TimeZone.getTimeZone(tz);
        Calendar calendar = Calendar.getInstance(curTimeZone);
        calendar.setTimeInMillis(time);
        calendar.add(Calendar.MONTH,1);
        calendar.set(Calendar.DAY_OF_MONTH,1);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar.getTimeInMillis();

    }

    public long getStartTimeOfDay(long now, String timeZone) {
        String tz = (null == timeZone || "".equals(timeZone))? "GMT+8" : timeZone;
        TimeZone curTimeZone = TimeZone.getTimeZone(tz);
        Calendar calendar = Calendar.getInstance(curTimeZone);
        calendar.setTimeInMillis(now);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar.getTimeInMillis();
    }


    public long getStartTimeOfDay(long now,Integer offset, String timeZone) {
        String tz = (null == timeZone || "".equals(timeZone))? "GMT+8" : timeZone;
        TimeZone curTimeZone = TimeZone.getTimeZone(tz);
        Calendar calendar = Calendar.getInstance(curTimeZone);
        calendar.setTimeInMillis(now);
        if (null != offset){
            calendar.add(Calendar.DAY_OF_MONTH,offset);
        }
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar.getTimeInMillis();
    }



    public long getStartTimeOfMonth(long now, String timeZone) {
        String tz = (null == timeZone || "".equals(timeZone))? "GMT+8" : timeZone;
        TimeZone curTimeZone = TimeZone.getTimeZone(tz);
        Calendar calendar = Calendar.getInstance(curTimeZone);
        calendar.setTimeInMillis(now);
        calendar.set(Calendar.DAY_OF_MONTH,1);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar.getTimeInMillis();
    }

    public long getStartTimeOfMonth(Long now,Integer offset, String timeZone) {
        String tz = (null == timeZone || "".equals(timeZone))? "GMT+8" : timeZone;
        TimeZone curTimeZone = TimeZone.getTimeZone(tz);
        Calendar calendar = Calendar.getInstance(curTimeZone);
        calendar.setTimeInMillis(now);
        if (null != offset){
        calendar.add(Calendar.MONTH,offset);}
        calendar.set(Calendar.DAY_OF_MONTH,1);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar.getTimeInMillis();
    }


    public long getStartTimeOfYear(long now,int offset ,String timeZone) {
        String tz = (null == timeZone || "".equals(timeZone))? "GMT+8" : timeZone;
        TimeZone curTimeZone = TimeZone.getTimeZone(tz);
        Calendar calendar = Calendar.getInstance(curTimeZone);
        calendar.setTimeInMillis(now);
        calendar.add(Calendar.YEAR,offset);
        calendar.set(Calendar.MONTH,0);
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar.getTimeInMillis();
    }

    public long diffYear(long now,int offset ,String timeZone) {
        String tz = (null == timeZone || "".equals(timeZone))? "GMT+8" : timeZone;
        TimeZone curTimeZone = TimeZone.getTimeZone(tz);
        Calendar calendar = Calendar.getInstance(curTimeZone);
        calendar.setTimeInMillis(now);
        calendar.add(Calendar.YEAR,offset);
        return calendar.getTimeInMillis();
    }

    public  int getDaysOfMonth(Long time,Date date) {
        Calendar calendar = Calendar.getInstance();
        if (null != time){
            calendar.setTimeInMillis(time);
        }
        if (null != date){
            calendar.setTime(date);
        }
        return calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
    }


    public String buildString(Collection collection,String  interpunction){
        StringBuilder stringBuilder = new StringBuilder("");
        Iterator iterator = collection.iterator();
        while (iterator.hasNext()){
            stringBuilder.append(iterator.next()+interpunction);
        }
        if (stringBuilder.length()>0){
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        }
        return stringBuilder.toString();
    }


    public String getYmainFlow(String prefix,Integer userId,String suffix){//日期，时间戳，随机数
        StringBuilder stringBuilder = new StringBuilder();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddhhmmss");
        if (null != prefix){
            stringBuilder.append(prefix);
        }
        stringBuilder.append(simpleDateFormat.format(new Date()));
        if (null != userId){
            stringBuilder.append(userId+"");
        }
        if (null != suffix){
            stringBuilder.append(suffix);
        }
        return stringBuilder.toString();
    }

    public Double returnAs2D(Double value,int scale){//保存小数
        if (null == value){
            throw new RuntimeException("value can't be null");
        }
        double result =new BigDecimal(value).setScale(scale,BigDecimal.ROUND_HALF_UP).doubleValue();
        return result;
    }

    public static String removeLastSyntax(String s){
        if (s.length() > 0){
            s = s.substring(0,s.length() - 1);
        }
        return s;
    }

    public <T extends Number> int compareNumber(T val , T sta){
        if (val.doubleValue() > sta.doubleValue()){
            return 1;
        }else if (val.doubleValue() < sta.doubleValue()){
            return -1;
        }
        return 0;
    }

    public static JSONObject getErrorResponse( BindingResult result){
        if (result.hasErrors()){
            JSONObject object = new JSONObject();
            object.put("code","0");
            StringBuilder stringBuilder = new StringBuilder();
            List<ObjectError> errorList = result.getAllErrors();
            for(ObjectError error : errorList){
                stringBuilder.append(error.getDefaultMessage() + ",");
            }
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
            object.put("msg", stringBuilder.toString());
            return object;
        }
        return null;
    }

    public int randNum(int length){
        int res = (int)((Math.random() * 9 + 1) * Math.pow(10, length - 1));
        return res;
    }


}

