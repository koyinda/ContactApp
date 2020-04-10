package com.adniyo.ContactApp.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.adniyo.ContactApp.config.SpringRootConfig;
//import com.adniyo.ContactApp.dao.UserDAO;
import com.adniyo.ContactApp.domain.User;
import com.adniyo.ContactApp.service.UserService;

public class TestUserDAOSave {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringRootConfig.class);
        //UserDAO userDAO=ctx.getBean(UserDAO.class);
		UserService us = ctx.getBean(UserService.class);
        //TODO: the user details will be taken from User-Reg-Form
        User u=new User();
        u.setName("Ronald");
        u.setPhone("87474783792");
        u.setEmail("ron@hogwart.co.uk");
        u.setAddress("Hogwart");
        u.setUsername("weasley");
        u.setPassword("145");
        //u.setRole(1);//Admin Role 
        u.setRole(UserService.ROLE_ADMIN);
        u.setUserStatus(UserService.LOGIN_STATUS_ACTIVE); //Active
        //userDAO.save(u);
        us.register(u);
        System.out.println("--------Data Saved------");

	}

}
