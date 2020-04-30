package cn.zjf.service;

import java.util.List;

import cn.zjf.bean.Courier;
import cn.zjf.dao.BaseCourierDao;
import cn.zjf.dao.impl.CourierDaoImpl;

public class CourierService {
	private static BaseCourierDao dao = new CourierDaoImpl();
	
	public static boolean cInsert(Courier c) {
		return dao.cInsert(c);
	}
	
	public static boolean cDeleteByCphone(String cPhone) {
		return dao.cDeleteByCphone(cPhone);
	}
	
	public static boolean cUpdateByCphone(String cPhone,Courier newCourier) {
		return dao.cUpdateByCphone(cPhone, newCourier);
	}
	
	public static Courier findCourierByCphone(String cPhone) {
		return dao.findCourierByCphone(cPhone);
	}
	
	public static List<Courier> findAll(){
		return dao.findAllCourier();
	}
}
