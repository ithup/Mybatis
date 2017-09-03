package cn.ithup.mapper;

import java.util.List;

import cn.ithup.pojo.CustomOrders;
import cn.ithup.pojo.Orders;
import cn.ithup.pojo.QueryVo;
import cn.ithup.pojo.User;

public interface UserMapper {

	/**
	 * ����id��ѯһ���û���Ϣ
	 * 
	 * @param id
	 * @return
	 */
	public User findUserById(Integer id);

	/**
	 * �����û�����ģ����ѯ�û���Ϣ
	 * 
	 * @param userName
	 * @return
	 */
	public List<User> findUserByUserName(String userName);

	/**
	 * ���һ���û���Ϣ
	 * 
	 * @param user
	 */
	public void insertUser(User user);

	/**
	 * �����û�����ѯ�û���Ϣ����ѯ�����ŵ�QueryVo��user������
	 * 
	 * @param queryVo
	 * @return
	 */
	public List<User> findUserByUserQueryVo(QueryVo queryVo);

	/**
	 * ��ѯ�û�����
	 * 
	 * @return
	 */
	public int findUserCount();

	/**
	 * �����û����ƺ��Ա��ѯ�û���Ϣ
	 * 
	 * @param user
	 * @return
	 */
	public List<User> findUserByUserNameAndSex(User user);

	/**
	 * ������ѯ
	 * 
	 * @param queryVo
	 * @return
	 */
	public List<User> findUserByIds(QueryVo queryVo);

	/**
	 * ����ɾ��
	 * 
	 * @param queryVo
	 */
	public void deleteUserByIds(QueryVo queryVo);

	public List<CustomOrders> findOrdersAndUser();

	public List<Orders> findOrdersAndUser2();

	public List<User> findUserAndOrders();
}
