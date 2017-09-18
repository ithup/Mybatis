package cn.ithup.mapper;

import java.util.List;

import cn.ithup.pojo.User;

public interface UserMapper {

	/**
	 * ���id��ѯһ���û���Ϣ
	 * 
	 * @param id
	 * @return
	 */
	public User findUserById(Integer id);

	/**
	 * ����û����ģ���ѯ�û���Ϣ
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

}
