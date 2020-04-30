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
	 * ���������
	 * @param e Ҫ���ӵĿ������
	 * @return ���ӵĿ����ȡ����
	 */
	int insert(Express e);
	
	/**
	 * 
	 * @param id Ҫɾ���Ŀ��id
	 * @param eNumber Ҫɾ���Ŀ������
	 * @return true��ʾɾ���ɹ� false��ʾɾ��ʧ��
	 */
	boolean deleteByIdOrEnumber(int id,String eNumber);
	/**
	 * 
	 * @param id Ҫɾ���Ŀ������
	 * @return true��ʾɾ���ɹ� false��ʾɾ��ʧ��
	 */
	boolean deleteByEnumber(String eNumber);
	
	/**
	 * 
	 * @param eNumber Ҫ�޸Ŀ������
	 * @param newExpress �µĿ����Ϣ
	 * @return true��ʾ�޸ĳɹ� false��ʾ�޸�ʧ��
	 */
	boolean updateByEnumber(String eNumber, Express newExpress);
	/**
	 * 1.�޸�ȡ��ʱ��Ϊ��ǰʱ��
	 * 2.�޸�statusΪ1
	 * 3.��ȡ��������Ϊnull
	 * @param code ȡ����
	 * @return ȡ���Ľ�� true��ʾ false��ʾʧ��
	 */
	boolean updateStatusByCode(int code);
	/**
	 * ��ѯ���п��
	 * @return ���еĿ����Ϣ
	 */
	List<Express> findAll();
	/**
	 * ��ѯ�û����еĿ��
	 * @param userPhone �û��ֻ���
	 * @return ��ѯ��� , �û����еĿ����Ϣ
	 */
	/**
	 * ���ݿ�����Ų�ѯ���������Ϣ
	 * @param eNumber �������
	 * @return ��ѯ���Ŀ����Ϣ ���������ʱ ����null
	 */
	Express findByEnumber(String eNumber);
	/**
	 * �����û��ֻ������ѯ�������п��
	 * @param userPhone �û��ֻ�����
	 * @param status Ҫ��ѯ�Ŀ����Ϣ 1��ʾ��ȡ��  0��ʾδȡ��
	 * @return
	 */
	List<Express> findUserPhoneAndStatus(String userPhone,int status);
	
	
	
	
	

}
