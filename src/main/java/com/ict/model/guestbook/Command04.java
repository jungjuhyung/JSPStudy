package com.ict.model.guestbook;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Command04 implements Command {
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		String uname = request.getParameter("uname");
		String kor = request.getParameter("kor");
		String eng = request.getParameter("eng");
		String mat = request.getParameter("math");
		
		int ikor = Integer.parseInt(kor);
		int ieng = Integer.parseInt(eng);
		int imat = Integer.parseInt(mat);
		int sum = ikor+ieng+imat;
		double avg = ((int)(10*sum/3))/10.0;
		String hak;
		if (avg>=90) {
			hak = "A학점";
		}else if (avg>=80) {
			hak = "B학점";
		}else if (avg>=70) {
			hak = "C학점";
		}else {
			hak="F학점";
		}
		request.setAttribute("uname", uname);
		request.setAttribute("sum", sum);
		request.setAttribute("avg", avg);
		request.setAttribute("hak", hak);
		return "view/ex14_res01.jsp";
	}
}
