package com.ict.model.guestbook;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ict.db.guestbook.VO;


public class Command05 implements Command {

	@Override
	// return "결과를 보여줄 jsp 파일위치"
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		// 일처리
		// 배열, 컬렉션
		// **DB에서 컬렉션, object, 숫자로 결과가 올 수도 있다.
		
		// 일반적인 체크박스에서 받은 배열을 그대로 넣기
		String[] hobby = request.getParameterValues("hobby");
		request.setAttribute("hobby", hobby);
		
		// DB에서 넘어온 VO클래스 받아서 넘기기
		VO vo1 = new VO("1", "둘리", "24", "서울");
		request.setAttribute("vo", vo1);
		
		// DB에서 넘어온 List컬렉션을 받아서 넘기기
		VO vo2 = new VO("2", "도우너", "2", "경기");
		VO vo3 = new VO("3", "마이콜", "34", "대구");
		VO vo4 = new VO("4", "희동이", "15", "대전");
		List<VO> list = new ArrayList<VO>();
		list.add(vo2);
		list.add(vo3);
		list.add(vo4);
		request.setAttribute("list", list);
		
		// 강제로 DB에서 처리한 것처럼 VO에 정보를 넣자
		return "view/ex14_res02.jsp";
	}

}
