package cn.ithup.dao;

import java.util.List;

import cn.ithup.pojo.User;


public interface UserDao {
	
	/**
	 * �����û�id��ѯһ���û���Ϣ
	 * @param id
	 * @return
	 */
	public User findUserById(Integer id);
	
	/**
	 * �����û�����ģ����ѯ�û���Ϣ�б�
	 * @param userName
	 * @return
	 */
	public List<User> findUserByUserName(String userName);
}
