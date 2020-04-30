package cn.zjf.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.zjf.Util.DBUtil;
import cn.zjf.bean.User;
import cn.zjf.dao.BaseUserDao;

public class UserDaoImpl implements BaseUserDao {

	@Override
	public boolean uInsert(User u) {
		Connection conn = null;
		PreparedStatement ps = null;
		conn = DBUtil.getConnection();
		try {
			ps = conn.prepareStatement(SQL_INSERT_USER);
			ps.setString(1, u.getuName());
			ps.setString(2, u.getuPhone());
			ps.setString(3, u.getuPass());
			ps.setString(4, u.getuSex());
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
	public boolean deleteUserByUPhone(String uPhone) {
		Connection conn = null;
		PreparedStatement ps = null;
		conn = DBUtil.getConnection();
		try {
			ps = conn.prepareStatement(SQL_DELETE_USER_BY_UPHONE);
			ps.setString(1, uPhone);
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
	public boolean updateUserByUPhone(String uPhone,User newUser) {
		Connection conn = null;
		PreparedStatement ps = null;
		conn = DBUtil.getConnection();
		try {
			ps = conn.prepareStatement(SQL_UPDATE_BY_UPHONE);
			ps.setString(1, newUser.getuName());
			ps.setString(2, newUser.getuPhone());
			ps.setString(3, newUser.getuPass());
			ps.setString(4, newUser.getuSex());
			ps.setString(5, 0+"");
			ps.setString(6, uPhone);
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
	public User findUserByUPone(String uPhone) {
		Connection conn = null;
		PreparedStatement ps = null;
		conn = DBUtil.getConnection();
		ResultSet rs = null;
		try {
			ps = conn.prepareStatement(SQL_FIND_USER_BY_UPHONE);
			ps.setString(1, uPhone);
			rs = ps.executeQuery();
			while(rs.next()) {
				int id = rs.getInt("ID");
				String uName = rs.getString("UNAME");
				String uPass = rs.getString("UPASS");
				String uSex = rs.getString("USEX");
				String active = rs.getString("ACTIVE");
				User u = new User(id,uName,uPhone,uPass,uSex,active);
				return u;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.releaseResource(conn, ps, null);
		}
		return null;
	}

	@Override
	public List<User> findAll() {
		Connection conn = null;
		PreparedStatement ps = null;
		conn = DBUtil.getConnection();
		List<User> data = new ArrayList<>();
		ResultSet rs = null;
		try {
			ps = conn.prepareStatement(SQL_FIND_ALL);
			rs = ps.executeQuery();
			while(rs.next()) {
				int id = rs.getInt("ID");
				String uName = rs.getString("UNAME");
				String uPhone = rs.getString("UPHONE");
				String uPass = rs.getString("UPASS");
				String uSex = rs.getString("USEX");
				String active = rs.getString("ACTIVE");
				User u = new User(id,uName,uPhone,uPass,uSex,active);
				data.add(u);
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
