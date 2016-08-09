package com.hanbit.web.global;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DispatcherServlet {
	public static void go(HttpServletRequest request, HttpServletResponse response,String view){
		try {
			System.out.println(view+"viewviewviewview@@@@@");
			RequestDispatcher dis = request.getRequestDispatcher(view);
			dis.forward(request, response);
		} catch (Exception e) {
		System.out.println("dispatcher error");
			e.printStackTrace();
		} 
	}
}
