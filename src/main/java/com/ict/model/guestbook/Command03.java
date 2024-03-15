package com.ict.model.guestbook;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Command03 implements Command {

	@Override
	// return "결과를 보여줄 jsp 파일위치"
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		String su1 = request.getParameter("su1");
		String su2 = request.getParameter("su2");
		String op = request.getParameter("op");
		long isu1 = Long.parseLong(su1);
		long isu2 = Long.parseLong(su2);
		try {
			long res = 0;
			switch (op) {
			case "+": res = isu1+isu2; break;
			case "-": res = isu1-isu2; break;
			case "*": res = isu1*isu2; break;
			case "/": res = isu1/isu2; break;
			}
			String result = "결과 : "+su1+op+su2+" = "+res;
			request.setAttribute("res", result);
		} catch (Exception e) {
			String result = "0으로 나눌 수 없습니다.";
			request.setAttribute("res", result);
		}
		return "view/ex13_res03.jsp";
	}

}
