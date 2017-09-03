package cn.ithup.mapper;

import java.util.List;

import cn.ithup.pojo.User;


public interface UserMapper {

	/**
	 * 根据id查询一条用户信息
	 * @param id
	 * @return
	 */
	public User findUserById(Integer id);
	
	/**
	 * 根据用户名称模糊查询用户信息
	 * @param userName
	 * @return
	 */
	public List<User> findUserByUserName(String userName);
	
	/**
	 * 添加一条用户信息
	 * @param user
	 */
	public void insertUser(User user);
}
