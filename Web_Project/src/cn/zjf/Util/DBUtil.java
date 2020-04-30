package cn.zjf.Util;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSourceFactory;

public class DBUtil {
	private static DataSource dataSource;
	static {
		//����properties����
		Properties ppt = new Properties();
		//��ȡ�����ļ�
		InputStream is = DBUtil.class.getClassLoader().getResourceAsStream("dbcp.properties");
		//�������ļ������ݼ��ص�properties������
		try {
			ppt.load(is);
			//ͨ�����ӳع����������ӳ�
			dataSource = BasicDataSourceFactory.createDataSource(ppt);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public static Connection getConnection() {
		try {
			return  dataSource.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static void releaseResource(Connection conn,Statement st,ResultSet rs) {
		if(rs!=null) {
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(st!=null) {
			try {
				st.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(conn!=null) {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
