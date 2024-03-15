package com.ict.db.guestbook2;

import java.io.InputStream;

import org.apache.ibatis.builder.SqlSourceBuilder;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class Guest2DBService {
	static private SqlSessionFactory factory;
	static String resource = "com/ict/db//guestbook2/guest2_config.xml";
	static {
		try {
			InputStream in = Resources.getResourceAsStream(resource);
			factory = new SqlSessionFactoryBuilder().build(in);
			
		} catch (Exception e) {
		}
	}
	public static SqlSessionFactory getFactoty() {
		return factory;
		
	}
}
