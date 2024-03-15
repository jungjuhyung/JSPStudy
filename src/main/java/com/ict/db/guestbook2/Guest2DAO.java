package com.ict.db.guestbook2;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

public class Guest2DAO {
	private static SqlSession ss;
	
	private synchronized  static SqlSession getSession() {
		if (ss==null) {
			ss = Guest2DBService.getFactoty().openSession();
		}
		return ss;
	}
	
	// DB 처리하는 메서드
	
	// 전체 데이터를 받는 메서드
	public static List<Guest2VO> getList() {
		// DB에서 오류가 많이 나기 때문에 try~catch로 확인
		try {
			List<Guest2VO> list = null;
			list = getSession().selectList("guestbook2.list");
			return list;			
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}
	
	public static Guest2VO getOne(String idx) {
		Guest2VO one = null;
		one = getSession().selectOne("guestbook2.selectone", idx);
		return one;
	}
	
	public static int getInsert(Guest2VO gvo) {
		
		try {
			int result = 0;
			result = getSession().insert("guestbook2.insert", gvo);
			ss.commit();
			return result;
			
		} catch (Exception e) {
			System.err.println(e);
		}
		return 0;
	}
	public static int getDelete(String idx) {
		try {
			int result = 0;
			result = getSession().delete("guestbook2.delete", idx);
			ss.commit();
			return result;
			
		} catch (Exception e) {
			System.err.println(e);
		}
		return 0;
	}
	public static int getUpdate(Guest2VO gvo) {
		int result = 0;
		System.out.println(gvo.getIdx());
		result = getSession().update("guestbook2.update", gvo);
		ss.commit();
		return result;
	}
}
