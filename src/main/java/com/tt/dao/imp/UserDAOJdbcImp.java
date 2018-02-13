package com.tt.dao.imp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.tt.dao.api.UserDAOJdbc;
import com.tt.domain.User;

public class UserDAOJdbcImp implements UserDAOJdbc{
	
	
	private DataSource dataSource;
	
	public void setDataSource(DataSource dataSource) {
		
		try {
			dataSource.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.dataSource = dataSource;
	}

	public User getUser(String userId,String password){
		
		String sql = "SELECT * FROM tt_user WHERE user_id = ? and password=?";
		
		Connection conn = null;
		
		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, userId);
			ps.setString(2,password);
			User user = null;
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				user = new User();
				user.setUserId(rs.getString("user_id"));
				user.setPassword(rs.getString("password"));
				user.setRole(rs.getString("role"));
				
			}
			rs.close();
			ps.close();
			return user;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			if (conn != null) {
				try {
				conn.close();
				} catch (SQLException e) {}
			}
		}
			
		
	}
	
	
}
