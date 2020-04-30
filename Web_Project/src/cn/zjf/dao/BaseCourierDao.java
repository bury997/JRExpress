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
	 * ���Ա����
	 * @param c ���Ա
	 * @return true��ʾ���ӳɹ�,false��ʾ����ʧ��
	 */
	boolean cInsert(Courier c);
	/**
	 * ɾ�����Ա
	 * @param cPhone Ҫɾ���Ŀ��Ա���ֻ���
	 * @return true��ʾ���ӳɹ�,false��ʾ����ʧ��
	 */
	boolean cDeleteByCphone(String cPhone);
	/**
	 * �޸Ŀ��Ա��Ϣ
	 * @param cPhone Ҫ�޸ĵĿ��Ա���ֻ���
	 * @param newCourier  �µĿ��Ա����
	 * @return true��ʾ���ӳɹ�,false��ʾ����ʧ��
	 */
	boolean cUpdateByCphone(String cPhone,Courier newCourier);
	/**
	 * �����ֻ��Ų�ѯ�������Ա
	 * @param cPhone Ҫ��ѯ�Ŀ��Ա���ֻ���
	 * @return �������Ա����Ϣ
	 */
	Courier findCourierByCphone(String cPhone);
	/**
	 * ��ѯ���п��Ա��Ϣ
	 * @return ���Ա�б�
	 */
	List<Courier> findAllCourier();
}
