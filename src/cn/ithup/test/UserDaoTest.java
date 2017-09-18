package cn.ithup.test;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.ithup.dao.UserDao;
import cn.ithup.dao.UserDaoImpl;
import cn.ithup.pojo.User;


public class UserDaoTest {

	private ApplicationContext ac;
	
	//作用:在测试方法前执行这个方法
	@Before
	public void setUp() throws Exception{
		ac = new ClassPathXmlApplicationContext("ApplicationContext.xml");
	}
	
	@Test
	public void testFindUserById() throws Exception{
		UserDao userDao = ac.getBean(UserDao.class);
		User user = userDao.findUserById(1);
		System.out.println(user);
	}
	
	@Test
	public void testFindUserByUserName () throws Exception{
		UserDao userDao = ac.getBean(UserDao.class);
		List<User> list = userDao.findUserByUserName("小");
		System.out.println(list);
	}
}
