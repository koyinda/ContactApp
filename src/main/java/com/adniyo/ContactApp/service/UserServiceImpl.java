package com.adniyo.ContactApp.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.adniyo.ContactApp.dao.BaseDAO;
import com.adniyo.ContactApp.dao.UserDAO;
import com.adniyo.ContactApp.domain.User;
import com.adniyo.ContactApp.exception.UserBlockedException;
import com.adniyo.ContactApp.rm.UserRowMapper;


@Service
public class UserServiceImpl extends BaseDAO implements UserService {

	@Autowired
	private UserDAO userDAO;
	@Override
	public void register(User u) {
		// TODO Auto-generated method stub
		userDAO.save(u);
		
	}

	@Override
	public User login(String username, String password) throws UserBlockedException {
		// TODO Auto-generated method stub
		String sql = "SELECT userid, name, phone, email, address, username, role, userStatus FROM users "
				+ "WHERE username=:in and password=:pw";
		@SuppressWarnings("rawtypes")
		Map<String, Comparable> m = new HashMap<String, Comparable>();
        m.put("in", username);
        m.put("pw", password);
        User u;
        try {
        	u = getNamedParameterJdbcTemplate().queryForObject(sql,m, new UserRowMapper());
        }catch(EmptyResultDataAccessException ex) {
        	return null;
        }
        
		if(u.getUserStatus().equals(LOGIN_STATUS_BLOCKED)) {
			throw new UserBlockedException("You account is currently inactive. Please contact Admin");
		}
		
		return u;
	}

	@Override
	public List<User> getUserList() {
		// TODO Auto-generated method stub

		return userDAO.findByProperty("role", UserService.ROLE_USER);
	}

	@Override
	public void changeLoginStatus(Integer userid, Integer userStatus) {
		// TODO Auto-generated method stub
        String sql = "UPDATE users SET userStatus=:userStatus WHERE userid=:userid";
        Map<String, Integer> m = new HashMap<String, Integer>();
        m.put("userid", userid);
        m.put("userStatus", userStatus);
        getNamedParameterJdbcTemplate().update(sql, m);
		
	}

	@Override
	public Boolean isUsernameExist(String username) {
		// TODO Auto-generated method stub
		  String sql = "SELECT count(username) FROM users WHERE username=?";
	        Integer count = getJdbcTemplate().queryForObject(sql, new String[]{username}, Integer.class);
	        return count>0 ? true : false;
	}
	public List<User> findUser(String txt) {
		// TODO Auto-generated method stub
		String sql = "SELECT userid, name, phone, email, address, username, role, userStatus FROM users WHERE (name LIKE '%"+ txt+ "%' OR address LIKE '%"+txt+"%' OR phone LIKE '%"+txt+"%' OR email LIKE '%"+txt+"%')";
        
		return getJdbcTemplate().query(sql, new UserRowMapper()); 
	}

}
