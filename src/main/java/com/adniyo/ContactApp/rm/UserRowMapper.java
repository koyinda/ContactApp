package com.adniyo.ContactApp.rm;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.adniyo.ContactApp.domain.User;

public class UserRowMapper implements RowMapper<User> {

	@Override
	public User mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		User u = new User();
		u.setUserid(rs.getInt("userid"));
        u.setName(rs.getString("name"));
        u.setPhone(rs.getString("phone"));
        u.setEmail(rs.getString("email"));
        u.setAddress(rs.getString("address"));
        u.setUsername(rs.getString("username"));
        u.setRole(rs.getInt("role"));
        u.setUserStatus(rs.getInt("userStatus"));
        return u;
	}

}
