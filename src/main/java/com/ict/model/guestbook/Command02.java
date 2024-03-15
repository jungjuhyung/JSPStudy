package com.ict.model.guestbook;

import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Command02 implements Command {

	@Override
	// return "결과를 보여줄 jsp 파일위치"
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		Calendar now = Calendar.getInstance();
		int year = now.get(Calendar.YEAR);
		int month = now.get(Calendar.MONTH)+1;
		int day = now.get(Calendar.DATE);
		int luck = (int)(Math.random()*101);
		String result =year+". "+month+". "+day+"의 운수는 "+luck+"% 입니다.";
		request.setAttribute("luck", result);
		return "view/ex13_res02.jsp";
	}

}
