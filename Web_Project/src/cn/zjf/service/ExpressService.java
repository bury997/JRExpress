package cn.zjf.service;

import java.util.List;

import cn.zjf.bean.Express;
import cn.zjf.dao.BaseExpressDao;
import cn.zjf.dao.impl.ExpressDaoImpl;

public class ExpressService {
	private static BaseExpressDao dao = new ExpressDaoImpl();
	
	public static int insert(Express e) {
		return dao.insert(e);
	}
	
	
	public static boolean deleteByIdOrEnumber(int id,String eNumber) {
		return dao.deleteByIdOrEnumber(id, eNumber);
	}
	
	public static boolean deleteByEnumber(String eNumber) {
		return dao.deleteByEnumber(eNumber);
	}
	
	public static boolean updateByEnumber(String eNumber,Express newExpress) {
		return dao.updateByEnumber(eNumber, newExpress);
	}
	
	public static boolean updateStatusByCode(int code) {
		return dao.updateStatusByCode(code);
	}
	
	public static List<Express> findAll() {
		return dao.findAll();
	}
	
	public static Express findByEnumber(String eNumber) {
		return dao.findByEnumber(eNumber);
	}
	
	public static List<Express> findByUserphoneAndStatus(String userPhone,int status){
		return dao.findUserPhoneAndStatus(userPhone, status);
	}
}
