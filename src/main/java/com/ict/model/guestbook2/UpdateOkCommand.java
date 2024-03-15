package com.ict.model.guestbook2;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ict.db.guestbook2.Guest2DAO;
import com.ict.db.guestbook2.Guest2VO;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;


public class UpdateOkCommand implements Command {
	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		try {
			String path = request.getServletContext().getRealPath("upload");
			
			MultipartRequest mr = new MultipartRequest(request, path,
					500*1024*1024, "utf-8",
					new DefaultFileRenamePolicy());
			
			Guest2VO g2vo = new Guest2VO();
			g2vo.setIdx(mr.getParameter("idx"));
			g2vo.setName(mr.getParameter("name"));
			g2vo.setSubject(mr.getParameter("subject"));
			g2vo.setContent(mr.getParameter("content"));
			g2vo.setEmail(mr.getParameter("email"));
			g2vo.setPwd(mr.getParameter("pwd"));
			
			String old_f_name = mr.getParameter("old_f_name");
			if (mr.getFile("f_name") == null) {
				g2vo.setF_name(old_f_name);
			}else {
				g2vo.setF_name(mr.getFilesystemName("f_name"));
			}
			
			int result = Guest2DAO.getUpdate(g2vo);
			if (result > 0) {
				return "Guest2?cmd=onelist&idx="+g2vo.getIdx();
			}else {
				return "guestbook2/error.jsp";
			}
			
		} catch (Exception e) {
			System.out.println(e);
			return "guestbook2/error.jsp";
			
		}
	}
}
