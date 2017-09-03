package cn.ithup.test;

import java.io.InputStream;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import cn.ithup.pojo.User;


public class UserTest {
	
	/**
	 * 根据id查询一条用户信息
	 * @throws Exception
	 */
	@Test
	public void testFindUserById() throws Exception{
		String resource = "SqlMapConfig.xml";
		//通过流将核心配置文件读取进来
		InputStream inputStream = Resources.getResourceAsStream(resource);
		//通过核心配置文件输入流来创建会话工厂
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
		//通过工厂创建会话
		SqlSession openSession = factory.openSession();
		//第一个参数:所调用的sql语句= namespace+.+sql的ID
		User user = openSession.selectOne("test.findUserById", 1);
		System.out.println(user);
		openSession.close();
	}
	
	/**
	 * 根据用户名称模糊查询用户信息
	 * @throws Exception
	 */
	@Test
	public void testFindUserbyUserName() throws Exception{
		String resource = "SqlMapConfig.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession openSession = factory.openSession();
		
		List<User> list = openSession.selectList("test.findUserByUserName", "王");
		System.out.println(list);
	}
	
	/**
	 * 添加一条用户记录
	 * @throws Exception
	 */
	@Test
	public void testInsertUser() throws Exception{
		String resource = "SqlMapConfig.xml";
		//通过流将核心配置文件读取进来
		InputStream inputStream = Resources.getResourceAsStream(resource);
		//通过核心配置文件输入流来创建会话工厂
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
		//通过工厂创建会话
		SqlSession openSession = factory.openSession();
		
		User user = new User();
		user.setUsername("赵四");
		user.setBirthday(new Date());
		user.setSex("1");
		user.setAddress("北京昌平");
		System.out.println("====" + user.getId());
		
		openSession.insert("test.insertUser", user);
		//提交事务(mybatis会自动开启事务,但是它不知道何时提交,所以需要手动提交事务)
		openSession.commit();
		
		System.out.println("====" + user.getId());
	}
	
	/**
	 * 根据id删除一条用户信息
	 * @throws Exception
	 */
	@Test
	public void testDelUserById()throws Exception{
		String resource = "SqlMapConfig.xml";
		//通过流将核心配置文件读取进来
		InputStream inputStream = Resources.getResourceAsStream(resource);
		//通过核心配置文件输入流来创建会话工厂
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
		//通过工厂创建会话
		SqlSession openSession = factory.openSession();
		
		openSession.delete("test.delUserById", 27);
		//提交
		openSession.commit();
	}
	
	/**
	 * 根据id更新一条用户信息
	 * @throws Exception
	 */
	@Test
	public void testUpdateUserById() throws Exception{
		String resource = "SqlMapConfig.xml";
		//通过流将核心配置文件读取进来
		InputStream inputStream = Resources.getResourceAsStream(resource);
		//通过核心配置文件输入流来创建会话工厂
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
		//通过工厂创建会话
		SqlSession openSession = factory.openSession();
		
		User user = new User();
		user.setId(26);
		user.setUsername("王麻子");
		openSession.update("test.updateUserById", user);
		
		//提交
		openSession.commit();
	}
}
