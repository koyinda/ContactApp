package com.adniyo.ContactApp.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import com.adniyo.ContactApp.dao.BaseDAO;
import com.adniyo.ContactApp.dao.ContactDAO;
import com.adniyo.ContactApp.domain.Contact;
import com.adniyo.ContactApp.rm.ContactRowMapper;


@Service
public class ContactServiceImpl extends BaseDAO implements ContactService {

	@Autowired
	private ContactDAO contDAO;
	
	public void save(Contact c) {
		contDAO.save(c);
		
		// TODO Auto-generated method stub		
	}

	@Override
	public void update(Contact c) {
		// TODO Auto-generated method stub
		contDAO.update(c);
		
	}

	@Override
	public void delete(Integer cotactId) {
		// TODO Auto-generated method stub
		contDAO.delete(cotactId);
		
	}

	@Override
	public void delete(Integer[] cotactIds) {
		// TODO Auto-generated method stub
		for(int i : cotactIds) {
			contDAO.delete(i);
		}
		
	}

	@Override
	public Contact findById(Integer cotactId) {
		// TODO Auto-generated method stub
		Contact c = contDAO.findById(cotactId);
		
		return c;
	}

	@Override
	public List<Contact> findUserContact(Integer userId) {
		// TODO Auto-generated method stub
		return contDAO.findByProperty("Userid", userId);
	}

	@Override
	public List<Contact> findUserContact(Integer userId, String txt) {
		// TODO Auto-generated method stub
		String sql = "SELECT contactId, userId, name, phone, email, address, remark FROM contact WHERE userId=? AND (name LIKE '%"+txt+"%' OR address LIKE '%"+txt+"%' OR phone LIKE '%"+txt+"%' OR email LIKE '%"+txt+"%' OR remark LIKE '%"+txt+"%')";
        return getJdbcTemplate().query(sql, new ContactRowMapper(),userId); 
	}

}
