package cn.zjf.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import cn.zjf.Util.DBUtil;
import cn.zjf.bean.Express;
import cn.zjf.dao.BaseExpressDao;
import cn.zjf.sms.SendSms;

public class ExpressDaoImpl implements BaseExpressDao{
	@Override
	public int insert(Express e) {
		Connection conn = null;
		PreparedStatement ps = null;
		int code = SendSms.random();
		conn = DBUtil.getConnection();
		try {
			ps = conn.prepareStatement(SQL_INSERT);
			ps.setString(1, e.geteNumber());
			ps.setString(2, e.getCompany());
			ps.setString(3, e.getUserName());
			ps.setString(4, e.getUserPhone());
			ps.setInt(5, code);
			ps.setString(6, e.getInputPhone());
			int res = ps.executeUpdate();
			if(res>0) {
				return code;
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}finally {
			DBUtil.releaseResource(conn, ps, null);
		}
		return 404;
	}

	@Override
	public boolean deleteByIdOrEnumber(int id, String eNumber) {
		Connection conn = null;
		PreparedStatement ps = null;
		conn = DBUtil.getConnection();
		try {
			ps = conn.prepareStatement(SQL_DELETE_BY_ID_OR_ENUMBER);
			ps.setInt(1, id);
			ps.setString(2, eNumber);
			int res = ps.executeUpdate();
			if(res>0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBUtil.releaseResource(conn, ps, null);
		}
		return false;
	}

	@Override
	public boolean deleteByEnumber(String eNumber) {
		Connection conn = null;
		PreparedStatement ps = null;
		conn = DBUtil.getConnection();
		try {
			ps = conn.prepareStatement(SQL_DELETE_BY_ENUMBER);
			ps.setString(1,eNumber);
			int res = ps.executeUpdate();
			if(res>0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBUtil.releaseResource(conn, ps, null);
		}
		return false;
	}

	@Override
	public boolean updateByEnumber(String eNumber, Express newExpress) {
		Connection conn = null;
		PreparedStatement ps = null;
		conn = DBUtil.getConnection();
		try {
			ps = conn.prepareStatement(SQL_UPDATE_BY_ENUMBER);
			ps.setString(1, newExpress.geteNumber());
			ps.setString(2, newExpress.getCompany());
			ps.setString(3, newExpress.getUserName());
			ps.setString(4, newExpress.getUserPhone());
			ps.setString(5, eNumber);
			int res = ps.executeUpdate();
			if(res>0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBUtil.releaseResource(conn, ps, null);
		}
		return false;
	}

	@Override
	public boolean updateStatusByCode(int code) {
		Connection conn = null;
		PreparedStatement ps = null;
		conn = DBUtil.getConnection();
		try {
			ps = conn.prepareStatement(SQL_UPDATE_STATUS_BY_CODE);
			ps.setInt(1, code);
			int res = ps.executeUpdate();
			if(res>0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBUtil.releaseResource(conn, ps, null);
		}
		return false;
	}

	@Override
	public List<Express> findAll() {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		conn = DBUtil.getConnection();
		List<Express> data = new ArrayList<>();
		try {
			ps = conn.prepareStatement(SQL_FIND_ALL);
			rs = ps.executeQuery();
			while(rs.next()) {
				int id = rs.getInt("ID");
				String eNumber = rs.getString("ENUMBER");
				String company = rs.getString("COMPANY");
				String userName = rs.getString("USERNAME");
				String userPhone = rs.getString("USERPHONE");
				int status = rs.getInt("STATUS");
				Timestamp inTime = rs.getTimestamp("INTIME");
				int code = rs.getInt("CODE");
				Timestamp outTime = rs.getTimestamp("OUTTIME");
				String inputPhone = rs.getString("INPUTPHONE");
				Express exp = new Express(id,eNumber,company,userName,userPhone,status,inTime,outTime,inputPhone,code);
				data.add(exp);
				return data;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBUtil.releaseResource(conn, ps, null);
		}
		return null;
	}

	@Override
	public Express findByEnumber(String eNumber) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		conn = DBUtil.getConnection();
		try {
			ps = conn.prepareStatement(SQL_FIND_BY_ENUMBER);
			ps.setString(1, eNumber);
			rs = ps.executeQuery();
			while(rs.next()) {
				int id = rs.getInt("ID");
				String company = rs.getString("COMPANY");
				String userName = rs.getString("USERNAME");
				String userPhone = rs.getString("USERPHONE");
				int status = rs.getInt("STATUS");
				Timestamp inTime = rs.getTimestamp("INTIME");
				int code = rs.getInt("CODE");
				Timestamp outTime = rs.getTimestamp("OUTTIME");
				String inputPhone = rs.getString("INPUTPHONE");
				Express exp = new Express(id,eNumber,company,userName,userPhone,status,inTime,outTime,inputPhone,code);
				return exp;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBUtil.releaseResource(conn, ps, null);
		}
		return null;
	}

	@Override
	public List<Express> findUserPhoneAndStatus(String userPhone, int status) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		conn = DBUtil.getConnection();
		List<Express> data = new ArrayList<>();
		try {
			ps = conn.prepareStatement(SQL_FIND_BY_ENUMBER+"and status=?");
			rs = ps.executeQuery();
			while(rs.next()) {
				int id = rs.getInt("ID");
				String eNumber = rs.getString("ENUMBER");
				String company = rs.getString("COMPANY");
				String userName = rs.getString("USERNAME");
				int status2 = rs.getInt("STATUS");
				Timestamp inTime = rs.getTimestamp("INTIME");
				int code = rs.getInt("CODE");
				Timestamp outTime = rs.getTimestamp("OUTTIMME");
				String inputPhone = rs.getString("INPUTPHONE");
				Express exp = new Express(id,eNumber,company,userName,userPhone,status2,inTime,outTime,inputPhone,code);
				data.add(exp);
				return data;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBUtil.releaseResource(conn, ps, null);
		}
		return null;
	}

}
