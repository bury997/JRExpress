package cn.zjf.dao;

import java.util.List;


import cn.zjf.bean.Express;

public interface BaseExpressDao {
	String SQL_INSERT = "INSERT INTO EXPRESS (ID,ENUMBER,COMPANY,USERNAME,USERPHONE,INTIME,CODE,INPUTPHONE)VALUES(NULL,?,?,?,?,SYSDATE(),?,?)";
	String SQL_DELETE_BY_ID_OR_ENUMBER = "DELETE FROM EXPRESS WHERE ID=? OR ENUMBER=?";
	String SQL_DELETE_BY_ENUMBER = "DELETE FROM EXPRESS WHERE ENUMBER=?";
	String SQL_UPDATE_BY_ENUMBER = "UPDATE EXPRESS SET ENUMBER=?,COMPANY=?,USERNAME=?,USERPHONE=? WHERE ENUMBER=?";
	String SQL_UPDATE_STATUS_BY_CODE = "UPDATE EXPRESS SET OUTTIME=SYSDATE,CODE=NULL,STATUS=1 WHERE CODE=?";
	String SQL_FIND_ALL = "SELECT * FROM EXPRESS";
	String SQL_FIND_BY_ENUMBER = "SELECT * FROM EXPRESS WHERE ENUMBER=?";
	String SQL_FIND_BY_USERPHONE = "SELECT * FROM EXPRESS WHERE USERPHONE=?";
	/**
	 * 快件的增加
	 * @param e 要增加的快件对象
	 * @return 增加的快件的取件码
	 */
	int insert(Express e);
	
	/**
	 * 
	 * @param id 要删除的快件id
	 * @param eNumber 要删除的快件单号
	 * @return true表示删除成功 false表示删除失败
	 */
	boolean deleteByIdOrEnumber(int id,String eNumber);
	/**
	 * 
	 * @param id 要删除的快件单号
	 * @return true表示删除成功 false表示删除失败
	 */
	boolean deleteByEnumber(String eNumber);
	
	/**
	 * 
	 * @param eNumber 要修改快件单号
	 * @param newExpress 新的快件信息
	 * @return true表示修改成功 false表示修改失败
	 */
	boolean updateByEnumber(String eNumber, Express newExpress);
	/**
	 * 1.修改取件时间为当前时间
	 * 2.修改status为1
	 * 3.将取件码设置为null
	 * @param code 取件码
	 * @return 取件的结果 true表示 false表示失败
	 */
	boolean updateStatusByCode(int code);
	/**
	 * 查询所有快件
	 * @return 所有的快件信息
	 */
	List<Express> findAll();
	/**
	 * 查询用户所有的快件
	 * @param userPhone 用户手机号
	 * @return 查询结果 , 用户所有的快件信息
	 */
	/**
	 * 根据快件单号查询单个快件信息
	 * @param eNumber 快件单号
	 * @return 查询到的快件信息 快件不存在时 返回null
	 */
	Express findByEnumber(String eNumber);
	/**
	 * 根据用户手机号码查询他的所有快件
	 * @param userPhone 用户手机号码
	 * @param status 要查询的快件信息 1表示已取件  0表示未取件
	 * @return
	 */
	List<Express> findUserPhoneAndStatus(String userPhone,int status);
	
	
	
	
	

}
