package com.adniyo.ContactApp.service;

import java.util.List;

import com.adniyo.ContactApp.domain.Contact;

public interface ContactService {
    public void save(Contact c);

    public void update(Contact c);

    public void delete(Integer cotactId);

    public void delete(Integer[] cotactIds);
    
    public Contact findById(Integer cotactId);

    public List<Contact> findUserContact(Integer userId);

    public List<Contact> findUserContact(Integer userId, String txt);
}
