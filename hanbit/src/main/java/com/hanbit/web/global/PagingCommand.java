package com.hanbit.web.global;

public class PagingCommand extends Command{
	public PagingCommand(String pkg,String command, String strPageNO,
			String keyField, String keyword, int count) {
		super(pkg, command, strPageNO, keyField, keyword, count);
	}
}
