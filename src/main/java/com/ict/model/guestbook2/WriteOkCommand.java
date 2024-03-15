package com.ict.model.guestbook2;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ict.db.guestbook2.Guest2DAO;
import com.ict.db.guestbook2.Guest2VO;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;


public class WriteOkCommand implements Command {
	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		try {
			String path = request.getServletContext().getRealPath("upload");
			
			MultipartRequest mr = 
					new MultipartRequest(request, path,
							50*1024*1024, "utf-8", 
							new DefaultFileRenamePolicy());
			
			Guest2VO g2vo = new Guest2VO();
			g2vo.setName(mr.getParameter("name"));
			g2vo.setSubject(mr.getParameter("subject"));
			g2vo.setContent(mr.getParameter("content"));
			g2vo.setEmail(mr.getParameter("email"));
			g2vo.setPwd(mr.getParameter("pwd"));
			
			// 첨부파일 있을 때와 없으 때를 구분하자
			if (mr.getFile("f_name") != null) {
				g2vo.setF_name(mr.getFilesystemName("f_name"));
			}else {
				g2vo.setF_name("");
			}
			int result = Guest2DAO.getInsert(g2vo);
			if (result > 0) {
				return "Guest2?cmd=list";
			}
			return "guestbook2/error.jsp";
		} catch (Exception e) {
			System.out.println(e);
			return "guestbook2/error.jsp";
		}
	}
}
