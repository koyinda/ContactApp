package com.adniyo.ContactApp.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.adniyo.ContactApp.config.SpringRootConfig;
import com.adniyo.ContactApp.dao.UserDAO;
import com.adniyo.ContactApp.domain.User;

public class TestUserDAOFindSingleRecord {
    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringRootConfig.class);
        UserDAO userDAO=ctx.getBean(UserDAO.class);       
        User u = userDAO.findById(2);
        System.out.println("--------User Details	------");
        System.out.println(u.getUserid());
        System.out.println(u.getName());
        System.out.println(u.getPhone());
        System.out.println(u.getEmail());
        System.out.println(u.getAddress());
        System.out.println(u.getUsername());
        System.out.println(u.getUserStatus());
        System.out.println(u.getRole());
    }    
}
