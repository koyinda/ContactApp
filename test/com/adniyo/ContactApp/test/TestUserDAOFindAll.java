package com.adniyo.ContactApp.test;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.adniyo.ContactApp.config.SpringRootConfig;
import com.adniyo.ContactApp.dao.UserDAO;
import com.adniyo.ContactApp.domain.User;

public class TestUserDAOFindAll {
    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringRootConfig.class);
        UserDAO userDAO=ctx.getBean(UserDAO.class);       
        List<User> us = userDAO.findAll();
        for (User u : us) {
            System.out.println(u.getUserid()+" "+u.getName()+" "+u.getRole());
            //TODO: access other columns
       }

    }    
}
