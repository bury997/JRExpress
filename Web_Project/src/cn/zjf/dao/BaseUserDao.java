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
	 * 添加用户
	 * @param u	用户
	 * @return true表示成功	false表示失败
	 */
	boolean uInsert(User u);
	/**
	 * 	根据用户手机号删除用户信息
	 * @param uPhone 要删除的用户手机号
	 * @return true表示成功	false表示失败
	 */
	boolean deleteUserByUPhone(String uPhone);
	/**
	 * 	根据用户手机号修改用户信息
	 * @param uPhone 要修改的用户手机号
	 * @return	true表示成功	false表示失败
	 */
	boolean updateUserByUPhone(String uPhone,User newUser);
	/**
	 * 	根据手机号查询用户信息
	 * @param uPhone 要查询的用户的手机号
	 * @return	要查询的用户
	 */
	User findUserByUPone(String uPhone);
	/**
	 * 	查询全部用户
	 * @return 用户列表
	 */
	List<User> findAll();
}
