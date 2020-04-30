package cn.zjf.service;

import java.util.List;

import cn.zjf.bean.User;
import cn.zjf.dao.BaseUserDao;
import cn.zjf.dao.impl.UserDaoImpl;

public class UserService {
	private static BaseUserDao dao = new UserDaoImpl();
	
	public static boolean insertUser(User u) {
		return dao.uInsert(u);
	}
	
	public static boolean deleteUserByUPhone(String uPhone) {
		return dao.deleteUserByUPhone(uPhone);
	}
	
	public static boolean updateUserByUPhone(String uPhone,User newUser) {
		return dao.updateUserByUPhone(uPhone, newUser);
	}
	
	public static User findUserByUPhone(String uPhone) {
		return dao.findUserByUPone(uPhone);
	}
	
	public static List<User> findAll(){
		return dao.findAll();
	}
}
