package cn.zjf.dao;

import java.util.List;

import cn.zjf.bean.User;

public interface BaseUserDao {
	String SQL_INSERT_USER = "INSERT INTO USER VALUES(NULL,?,?,?,?,0)";
	String SQL_DELETE_USER_BY_UPHONE = "DELETE FROM USER WHERE UPHONE=?";
	String SQL_UPDATE_BY_UPHONE = "UPDATE USER SET UNAME=?,UPHONE=?,UPASS=?,USEX=?,ACTIVE=? WHERE UPHONE=?";
	String SQL_FIND_USER_BY_UPHONE = "SELECT * FROM USER WHERE UPHONE=?";
	String SQL_FIND_ALL = "SELECT * FROM USER";
	
	/**
	 * ����û�
	 * @param u	�û�
	 * @return true��ʾ�ɹ�	false��ʾʧ��
	 */
	boolean uInsert(User u);
	/**
	 * 	�����û��ֻ���ɾ���û���Ϣ
	 * @param uPhone Ҫɾ�����û��ֻ���
	 * @return true��ʾ�ɹ�	false��ʾʧ��
	 */
	boolean deleteUserByUPhone(String uPhone);
	/**
	 * 	�����û��ֻ����޸��û���Ϣ
	 * @param uPhone Ҫ�޸ĵ��û��ֻ���
	 * @return	true��ʾ�ɹ�	false��ʾʧ��
	 */
	boolean updateUserByUPhone(String uPhone,User newUser);
	/**
	 * 	�����ֻ��Ų�ѯ�û���Ϣ
	 * @param uPhone Ҫ��ѯ���û����ֻ���
	 * @return	Ҫ��ѯ���û�
	 */
	User findUserByUPone(String uPhone);
	/**
	 * 	��ѯȫ���û�
	 * @return �û��б�
	 */
	List<User> findAll();
}
