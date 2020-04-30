package cn.zjf.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.zjf.Util.DBUtil;
import cn.zjf.bean.Courier;
import cn.zjf.dao.BaseCourierDao;

public class CourierDaoImpl implements BaseCourierDao{

	@Override
	public boolean cInsert(Courier c) {
		Connection conn = null;
		PreparedStatement ps = null;
		conn = DBUtil.getConnection();
		try {
			ps = conn.prepareStatement(SQL_CINSERT);
			ps.setString(1, c.getcName());
			ps.setString(2, c.getcPhone());
			ps.setString(3, c.getcCard());
			ps.setString(4, c.getPass());
			ps.setString(5, c.getSex());
			int rowNum = ps.executeUpdate();
			if(rowNum>0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.releaseResource(conn, ps, null);
		}
		return false;
	}

	@Override
	public boolean cDeleteByCphone(String cPhone) {
		Connection conn = null;
		PreparedStatement ps = null;
		conn = DBUtil.getConnection();
		try {
			ps = conn.prepareStatement(SQL_CDELETE_BY_CPHONE);
			ps.setString(1, cPhone);
			int rowNum = ps.executeUpdate();
			if(rowNum>0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.releaseResource(conn, ps, null);
		}
		return false;
	}

	@Override
	public boolean cUpdateByCphone(String cPhone, Courier newCourier) {
		Connection conn = null;
		PreparedStatement ps = null;
		conn = DBUtil.getConnection();
		try {
			ps = conn.prepareStatement(SQL_CUPDATE_BY_CPHONE);
			ps.setString(1, newCourier.getcName());
			ps.setString(2, newCourier.getcPhone());
			ps.setString(3, newCourier.getcCard());
			ps.setString(4, newCourier.getPass());
			ps.setString(5, newCourier.getSex());
			ps.setInt(6, 1);
			ps.setString(7, cPhone);
			int rowNum = ps.executeUpdate();
			if(rowNum>0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.releaseResource(conn, ps, null);
		}
		return false;
	}

	@Override
	public Courier findCourierByCphone(String cPhone) {
		Connection conn = null;
		PreparedStatement ps = null;
		conn = DBUtil.getConnection();
		ResultSet rs = null;
		try {
			ps = conn.prepareStatement(SQL_FIND_COURIER_BY_CPHONE);
			ps.setString(1, cPhone);
			rs = ps.executeQuery();
			while(rs.next()) {
				int id = rs.getInt("ID");
				String cName = rs.getString("CNAME");
				String cCard = rs.getString("cCard");
				String cPass = rs.getString("cPass");
				String sex = rs.getString("csex");
				int active = rs.getInt("active");
				Courier c = new Courier(id,cName,cPhone,cCard,cPass,sex,active);
				return c;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.releaseResource(conn, ps, null);
		}
		return null;
	}

	@Override
	public List<Courier> findAllCourier() {
		Connection conn = null;
		PreparedStatement ps = null;
		conn = DBUtil.getConnection();
		ResultSet rs = null;
		List<Courier> data = new ArrayList<>();
		try {
			ps = conn.prepareStatement(SQL_FIND_ALL_COURIER);
			rs = ps.executeQuery();
			while(rs.next()) {
				int id = rs.getInt("ID");
				String cName = rs.getString("CNAME");
				String cPhone = rs.getString("CPHONE");
				String cCard = rs.getString("CCARD");
				String cPass = rs.getString("CPASS");
				String sex = rs.getString("CSEX");
				int active = rs.getInt("ACTIVE");
				Courier c = new Courier(id,cName,cPhone,cCard,cPass,sex,active);
				data.add(c);
			}
			return data;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.releaseResource(conn, ps, null);
		}
		return null;
	}

}
