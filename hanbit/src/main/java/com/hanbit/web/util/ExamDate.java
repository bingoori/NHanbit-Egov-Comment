package com.hanbit.web.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * @package com.hanbit.web.util
 * @file ExamDate.java
 * @author sdwoo90@gmail.com
 * @Date : 2016. 4. 18.
 * @Story :
 */
public class ExamDate {

	public static String  getEndOfMonth(){ 
		  int year =0;
		  String month ="",yun ="",endDay ="";
		  
		SimpleDateFormat d_format = new SimpleDateFormat("yyyy-MM");
		
		year = (Integer.parseInt(d_format.format(Calendar.getInstance().getTime()).split("-")[0]));
		month = (d_format.format(Calendar.getInstance().getTime()).split("-")[1]);
		//setMonth((d_format.format(Calendar.getInstance().getTime()).split("-")[1].charAt(0) == '0')? d_format.format(Calendar.getInstance().getTime()).split("-")[1].substring(1) : d_format.format(Calendar.getInstance().getTime()).split("-")[1]);
		
		int m= Integer.parseInt(month);
		if(m == 2)
		{
			endDay = year +"-"+ month+"-"+(Integer.toString((year%4==0 && year%100 != 0 || year %400 ==0)?29:28));
		}else{
			endDay = year +"-"+ month+"-"+(Integer.toString((m == 1 || m== 3 || m == 5 || m== 7|| m== 8|| m== 10|| m== 12)?31:30));
		}
		 
		return endDay;
	}

 
}
