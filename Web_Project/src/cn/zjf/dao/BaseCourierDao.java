package cn.zjf.dao;

import java.util.List;

import cn.zjf.bean.Courier;

public interface BaseCourierDao {
	String SQL_CINSERT = "INSERT INTO COURIER VALUES(NULL,?,?,?,?,?,0)";
	String SQL_CDELETE_BY_CPHONE = "DELETE FROM COURIER WHERE CPHONE=?";
	String SQL_FIND_COURIER_BY_CPHONE = "SELECT * FROM COURIER WHERE CPHONE=?";
	String SQL_CUPDATE_BY_CPHONE = "UPDATE COURIER SET CNAME=?,CPHONE=?,CCARD=?,CPASS=?,CSEX=?,ACTIVE=? WHERE CPHONE=?";
	String SQL_FIND_ALL_COURIER = "SELECT * FROM COURIER";
	/**
	 * 快递员增加
	 * @param c 快递员
	 * @return true表示增加成功,false表示增加失败
	 */
	boolean cInsert(Courier c);
	/**
	 * 删除快递员
	 * @param cPhone 要删除的快递员的手机号
	 * @return true表示增加成功,false表示增加失败
	 */
	boolean cDeleteByCphone(String cPhone);
	/**
	 * 修改快递员信息
	 * @param cPhone 要修改的快递员的手机号
	 * @param newCourier  新的快递员对象
	 * @return true表示增加成功,false表示增加失败
	 */
	boolean cUpdateByCphone(String cPhone,Courier newCourier);
	/**
	 * 根据手机号查询单个快递员
	 * @param cPhone 要查询的快递员的手机号
	 * @return 单个快递员的信息
	 */
	Courier findCourierByCphone(String cPhone);
	/**
	 * 查询所有快递员信息
	 * @return 快递员列表
	 */
	List<Courier> findAllCourier();
}
