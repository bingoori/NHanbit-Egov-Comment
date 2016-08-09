package com.hanbit.web.global;

import org.springframework.stereotype.Component;

@Component
public class CommandFactory {
	public static Command createCommand(String pkg,String crud,
			String pageNO,String keyField,String keyword,int count){
		
		Command command = new Command();
		switch (crud) {
		case "list":
			command = new PagingCommand(pkg,crud,pageNO,keyField,keyword,count);
			break;
		case "update":break;
		case "delete":break;
		default:
			break;
		} 
		return command;
	}
}
