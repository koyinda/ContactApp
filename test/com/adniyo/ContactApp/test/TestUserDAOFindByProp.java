package com.adniyo.ContactApp.test;

import java.util.*;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.adniyo.ContactApp.config.SpringRootConfig;
import com.adniyo.ContactApp.dao.UserDAO;
import com.adniyo.ContactApp.domain.User;

public class TestUserDAOFindByProp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringRootConfig.class);
        UserDAO userDAO=ctx.getBean(UserDAO.class);   
        
        //List<User> users = userDAO.findByProperty("userId", 1);
        //List<User> users = userDAO.findByProperty("name", "Vikram");
        List<User> users = userDAO.findByProperty("role", 2);
        for (User u : users) {
             System.out.println(u.getUserid()+" "+u.getName()+" "+u.getRole());
             //TODO: access other columns
        }
	}

}
