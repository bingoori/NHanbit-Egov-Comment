package com.hanbit.web.global;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

public class Separate {
	
	public static ArrayList<String> getValidityUrl(HttpServletRequest request) {
		
		String path = request.getServletPath();
		// String queryString = " ";
		String directory = path.split("/")[1];
		String action = path.split("/")[2].split("[.]")[0];
		
		ArrayList<String> arrStr = new ArrayList<String>();
		arrStr.add(directory);
		arrStr.add(action);
		
		return arrStr;
	}
}
	