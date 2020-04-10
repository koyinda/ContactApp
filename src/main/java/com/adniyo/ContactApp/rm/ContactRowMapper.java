package com.adniyo.ContactApp.rm;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

import com.adniyo.ContactApp.domain.Contact;


public class ContactRowMapper implements RowMapper<Contact>{
    @Override
    public Contact mapRow(ResultSet rs, int i) throws SQLException {
        Contact c=new Contact();
        c.setContactid(rs.getInt("contactid"));
        c.setUserid(rs.getInt("userid"));
        c.setName(rs.getString("name"));
        c.setEmail(rs.getString("email"));
        c.setAddress(rs.getString("address"));       
        c.setPhone(rs.getString("phone"));       
        c.setRemark(rs.getString("remark"));               
        return c;
    }
}
