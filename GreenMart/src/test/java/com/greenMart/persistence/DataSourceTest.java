package com.greenMart.persistence;

import java.sql.Connection;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class DataSourceTest {

	@Autowired
	private DataSource dataSource;
	
	@Autowired
	private SqlSessionFactory sqlSessionFactory;
	
	@Test
	public void testConnection(){
		try(
				Connection con = dataSource.getConnection();
				SqlSession session = sqlSessionFactory.openSession();
			) {

			System.out.println("con=" + con);
			System.out.println("session = " + session);
			//SqlSessionFactoryBuilder : 설정 정보 읽어서 SqlSessionFactory 만드는 역할
			//SqlSessionFactory : SqlSession을 만드는 역할
			//SqlSession: 실제 sql을 날리는 역할
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
