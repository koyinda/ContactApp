package com.adniyo.ContactApp.dao;

import java.util.*;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import com.adniyo.ContactApp.domain.Contact;
import com.adniyo.ContactApp.rm.ContactRowMapper;

@Repository
public class ContactDAOImpl extends BaseDAO implements ContactDAO {

	@Override
	public void save(Contact c) {
		// TODO Auto-generated method stub
        String sql = "INSERT INTO contact(userid, name, phone, email, address, remark) VALUES(:userId, :name, :phone, :email, :address, :remark)";
        @SuppressWarnings("rawtypes")
		Map<String, Comparable> m = new HashMap<String, Comparable>();
        m.put("userId", c.getUserid());
        m.put("name", c.getName());
        m.put("phone", c.getPhone());
        m.put("email", c.getEmail());
        m.put("address", c.getAddress());
        m.put("remark", c.getRemark());
        SqlParameterSource ps = new MapSqlParameterSource(m);
        KeyHolder kh = new GeneratedKeyHolder();
        getNamedParameterJdbcTemplate().update(sql, ps, kh);
        c.setContactid(kh.getKey().intValue());
	}

	@Override
	public void update(Contact c) {
		// TODO Auto-generated method stub
        String sql = "UPDATE contact SET name=:name, phone=:phone, email=:email, address=:address, remark=:remark WHERE contactId=:contactId";
        @SuppressWarnings("rawtypes")
		Map<String, Comparable> m = new HashMap<String, Comparable>();
        m.put("contactId", c.getContactid());
        m.put("name", c.getName());
        m.put("phone", c.getPhone());
        m.put("email", c.getEmail());
        m.put("address", c.getAddress());
        m.put("remark", c.getRemark());
        getNamedParameterJdbcTemplate().update(sql, m);		
	}

	@Override
	public void delete(Contact c) {
		// TODO Auto-generated method stub
		this.delete(c.getContactid());
	}

	@Override
	public void delete(Integer contactId) {
		// TODO Auto-generated method stub
        String sql = "DELETE FROM contact WHERE contactId=?";
        getJdbcTemplate().update(sql, contactId);		
	}

	@Override
	public Contact findById(Integer contactId) {
		// TODO Auto-generated method stub
        String sql = "SELECT contactId, userId, name, phone, email, address, remark FROM contact WHERE contactId=?";
        return getJdbcTemplate().queryForObject(sql, new ContactRowMapper(), contactId);
		
	}

	@Override
	public List<Contact> findAll() {
		// TODO Auto-generated method stub
        String sql = "SELECT contactId, userId, name, phone, email, address, remark FROM contact";
        return getJdbcTemplate().query(sql, new ContactRowMapper());
	}

	@Override
	public List<Contact> findByProperty(String propName, Object propValue) {
        String sql = "SELECT contactId, userId, name, phone, email, address, remark FROM contact WHERE "+propName+"=?";
        return getJdbcTemplate().query(sql, new ContactRowMapper(), propValue);
	}

}
