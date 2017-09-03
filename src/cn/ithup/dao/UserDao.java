package cn.ithup.dao;

import java.util.List;

import cn.ithup.pojo.User;


public interface UserDao {
	
	/**
	 * 根据用户id查询一个用户信息
	 * @param id
	 * @return
	 */
	public User findUserById(Integer id);
	
	/**
	 * 根据用户名称模糊查询用户信息列表
	 * @param userName
	 * @return
	 */
	public List<User> findUserByUserName(String userName);
}
