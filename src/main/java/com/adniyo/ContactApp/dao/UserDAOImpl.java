package com.adniyo.ContactApp.dao;

import java.util.*;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.adniyo.ContactApp.domain.User;
import com.adniyo.ContactApp.rm.UserRowMapper;

@Repository
public class UserDAOImpl extends BaseDAO implements UserDAO {

	@Override
	public void save(User u) {
		// TODO Auto-generated method stu
		String sql = "INSERT INTO users(name, phone, email, address, username, password, role, 	userStatus)"
				+ " VALUES(:name, :phone, :email, :address, :username, :password, :role, :userStatus)";
		
		@SuppressWarnings("rawtypes")
		Map<String, Comparable> m = new HashMap<String, Comparable>();
        m.put("name", u.getName());
        m.put("phone", u.getPhone());
        m.put("email", u.getEmail());
        m.put("address", u.getAddress());
        m.put("username", u.getUsername());
        m.put("password", u.getPassword());
        m.put("role", u.getRole());
        m.put("userStatus", u.getUserStatus());
        
        KeyHolder kh = new GeneratedKeyHolder();
        SqlParameterSource ps = new MapSqlParameterSource(m);
        super.getNamedParameterJdbcTemplate().update(sql, ps, kh);
        Integer userId = kh.getKey().intValue();
        u.setUserid(userId);
		
	}

	@Override
	public void update(User u) {
		// TODO Auto-generated method stub
		String sql = "update users set "
				+ "name = :name,"
				+ " phone = :phone,"
				+ " email = :email, "
				+ "address = :address, "
				+ "role = :role, "
				+ "userStatus = :userStatus "
				+ "where userid = :userid";
		
		@SuppressWarnings("rawtypes")
		Map<String, Comparable> m = new HashMap<String, Comparable>();
        m.put("name", u.getName());
        m.put("phone", u.getPhone());
        m.put("email", u.getEmail());
        m.put("address", u.getAddress());
        m.put("role", u.getRole());
        m.put("userStatus", u.getUserStatus());
        m.put("userid", u.getUserid());
        
        getNamedParameterJdbcTemplate().update(sql, m);
		
	}

	@Override
	public void delete(User u) {
		// TODO Auto-generated method stub
		this.delete(u.getUserid());
		
	}

	@Override
	public void delete(Integer userId) {
		// TODO Auto-generated method stub
		String sql = "delete from users where userid = ?";
		getJdbcTemplate().update(sql, userId);
		
	}

	@Override
	public User findById(Integer userId) {
		// TODO Auto-generated method stub
		String sql = "SELECT userid, name, phone, email, address, username, role, userStatus FROM users WHERE userId=?";
		User u = getJdbcTemplate().queryForObject(sql, new UserRowMapper(),userId);
        return u;
	}

	@Override
	public List<User> findAll() {
		// TODO Auto-generated method stub
        String sql = "SELECT userId, name, phone, email, address, username, role, userstatus"
                + " FROM users";
           /*
           List<User> users = getJdbcTemplate().query(sql, new UserRowMapper());
           return users;
           */
           return getJdbcTemplate().query(sql, new UserRowMapper());
	}

	@Override
	public List<User> findByProperty(String propName, Object propValue) {
		// TODO Auto-generated method stub
        String sql = "SELECT userId, name, phone, email, address, username, role, userstatus"
                + " FROM users WHERE "+propName+"=?";
         return getJdbcTemplate().query(sql, new UserRowMapper(), propValue);
	}
	

}
