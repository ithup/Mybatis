package cn.ithup.mapper;

import java.util.List;

import cn.ithup.pojo.CustomOrders;
import cn.ithup.pojo.Orders;
import cn.ithup.pojo.QueryVo;
import cn.ithup.pojo.User;

public interface UserMapper {

	/**
	 * 根据id查询一条用户信息
	 * 
	 * @param id
	 * @return
	 */
	public User findUserById(Integer id);

	/**
	 * 根据用户名称模糊查询用户信息
	 * 
	 * @param userName
	 * @return
	 */
	public List<User> findUserByUserName(String userName);

	/**
	 * 添加一条用户信息
	 * 
	 * @param user
	 */
	public void insertUser(User user);

	/**
	 * 根据用户名查询用户信息，查询条件放到QueryVo的user属性中
	 * 
	 * @param queryVo
	 * @return
	 */
	public List<User> findUserByUserQueryVo(QueryVo queryVo);

	/**
	 * 查询用户数量
	 * 
	 * @return
	 */
	public int findUserCount();

	/**
	 * 根据用户名称和性别查询用户信息
	 * 
	 * @param user
	 * @return
	 */
	public List<User> findUserByUserNameAndSex(User user);

	/**
	 * 批量查询
	 * 
	 * @param queryVo
	 * @return
	 */
	public List<User> findUserByIds(QueryVo queryVo);

	/**
	 * 批量删除
	 * 
	 * @param queryVo
	 */
	public void deleteUserByIds(QueryVo queryVo);

	public List<CustomOrders> findOrdersAndUser();

	public List<Orders> findOrdersAndUser2();

	public List<User> findUserAndOrders();
}
