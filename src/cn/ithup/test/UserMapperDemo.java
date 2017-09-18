package cn.ithup.test;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.ithup.mapper.UserMapper;
import cn.ithup.pojo.User;

public class UserMapperDemo {
	private ApplicationContext ac;

	// 作用:在测试方法前执行这个方法
	@Before
	public void setUp() throws Exception {
		ac = new ClassPathXmlApplicationContext("ApplicationContext.xml");
	}
	@Test
	public void run(){
		UserMapper userMapper = (UserMapper) ac.getBean("userMapper");
		User user = userMapper.findUserById(1);
		System.out.println(user);
}
}
