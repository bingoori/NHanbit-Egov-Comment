package com.hanbit.web.util;

/**
 * 13,700
 */
public class MoneyExpr {

	public static String parsingMoney(String money){
		
		/*
		 * DecimalFormat df = new DecimalFormat("#,###");
		 * System.out.println(df.format(984984984));
		 */
		 int result = money.length() % 3;
		 if(result == 0){
			 result = money.length() / 2;
		 }
		 int len = money.length();
		String start =	money.substring(0, result);
		while(result < len){
			start += ","+money.substring(result,result+3);
			result += 3;
		}
		return start;
	}

}
