package com.ict.db.guestbook;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

public class GuestDAO {
	private static SqlSession ss;
	
	private synchronized  static SqlSession getSession() {
		if (ss==null) {
			ss = GuestDBService.getFactoty().openSession();
		}
		return ss;
	}
	
	// DB 처리하는 메서드
	
	// 리스트
	public static List<GuestVO> getList() {
		List<GuestVO> list = null;
		list = getSession().selectList("guestbook.list");
		return list;
	}
	
	public static GuestVO getOne(String idx) {
		GuestVO one = null;
		one = getSession().selectOne("guestbook.selectone", idx);
		return one;
	}
	
	public static int getInsert(GuestVO gvo) {
		int result = 0;
		result = getSession().insert("guestbook.insert", gvo);
		ss.commit();
		return result;
	}
	public static int getDelete(String idx) {
		int result = 0;
		result = getSession().delete("guestbook.delete", idx);
		ss.commit();
		return result;
	}
	public static int getUpdate(GuestVO gvo) {
		int result = 0;
		System.out.println(gvo.getIdx());
		result = getSession().update("guestbook.update", gvo);
		ss.commit();
		return result;
	}
}
