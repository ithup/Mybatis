package cn.ithup.test;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import cn.ithup.mapper.UserMapper;
import cn.ithup.pojo.CustomOrders;
import cn.ithup.pojo.Orders;
import cn.ithup.pojo.QueryVo;
import cn.ithup.pojo.User;


public class UserMapperTest {
	private SqlSessionFactory factory;
	
	//作用:在测试方法前执行这个方法
	@Before
	public void setUp() throws Exception{
		String resource = "SqlMapConfig.xml";
		//通过流将核心配置文件读取进来
		InputStream inputStream = Resources.getResourceAsStream(resource);
		//通过核心配置文件输入流来创建会话工厂
		factory = new SqlSessionFactoryBuilder().build(inputStream);
	}
	
	@Test
	public void testFindUserById() throws Exception{
		SqlSession openSession = factory.openSession();
		//通过getMapper方法来实例化接口
		UserMapper mapper = openSession.getMapper(UserMapper.class);
		
		User user = mapper.findUserById(1);
		System.out.println(user);
	}
	
	@Test
	public void testFindUserByUserName() throws Exception{
		SqlSession openSession = factory.openSession();
		//通过getMapper方法来实例化接口
		UserMapper mapper = openSession.getMapper(UserMapper.class);
		
		List<User> list = mapper.findUserByUserName("王");
		
		System.out.println(list);
	}
	
	@Test
	public void testInsertUser() throws Exception{
		SqlSession openSession = factory.openSession();
		//通过getMapper方法来实例化接口
		UserMapper mapper = openSession.getMapper(UserMapper.class);
		
		User user = new User();
		user.setUsername("老王");
		user.setSex("1");
		user.setBirthday(new Date());
		user.setAddress("北京昌平");
		
		mapper.insertUser(user);
		
		openSession.commit();
	}
	
	@Test
	public void testFindByQueryVo(){
		SqlSession session = factory.openSession();
		UserMapper mapper = session.getMapper(UserMapper.class);
		QueryVo queryVo = new QueryVo();
		User user = new User();
		user.setUsername("小");
		user.setSex("0");
		queryVo.setUser(user);
		List<User> list = mapper.findUserByUserQueryVo(queryVo);
		for (User users : list) {
			System.out.println(users);
		}
	}
	
	
	@Test
	public void testfindUserCount(){
		SqlSession session = factory.openSession();
		UserMapper mapper = session.getMapper(UserMapper.class);
		int count = mapper.findUserCount();
		System.out.println(count);
	}
	
	@Test
	public void testfindUserByUserNameAndSex(){
		SqlSession session = factory.openSession();
		UserMapper userMapper = session.getMapper(UserMapper.class);
		User user = new User();
		user.setUsername(null);
		user.setSex(null);
		List<User> list = userMapper.findUserByUserNameAndSex(user);
		for (User user2 : list) {
			System.out.println(user2);
		}
	}
	
	/**
	 * 批量查询
	 */
	@Test
	public void testfindUserByIds(){
		SqlSession session = factory.openSession();
		UserMapper userMapper = session.getMapper(UserMapper.class);
		QueryVo queryVo = new QueryVo();
		List<Integer> ids = new ArrayList<Integer>();
		ids.add(11);
		ids.add(16);
		ids.add(22);
		queryVo.setIds(ids );
		List<User> list = userMapper.findUserByIds(queryVo);
		for (User user : list) {
			System.out.println(user);
		}
	}

	/**
	 * 批量删除
	 */
	@Test
	public void testDeleteUserByIds(){
		SqlSession session = factory.openSession();
		UserMapper userMapper = session.getMapper(UserMapper.class);
		QueryVo queryVo = new QueryVo();
		List<Integer> ids = new ArrayList<Integer>();
		ids.add(24);
		ids.add(25);
		queryVo.setIds(ids);
		userMapper.deleteUserByIds(queryVo);
	}
	
	@Test
	public void testfindOrdersAndUser(){
		SqlSession session = factory.openSession();
		UserMapper userMapper = session.getMapper(UserMapper.class);
		List<CustomOrders> list = userMapper.findOrdersAndUser();
		for (CustomOrders customOrders : list) {
			System.out.println(customOrders);
		}
	}
	@Test
	public void testfindOrdersAndUser2(){
		SqlSession session = factory.openSession();
		UserMapper userMapper = session.getMapper(UserMapper.class);
		List<Orders> list = userMapper.findOrdersAndUser2();
		for (Orders orders : list) {
			System.out.println(orders);
		}
	}
	
	
	
	
	
	
	
}
