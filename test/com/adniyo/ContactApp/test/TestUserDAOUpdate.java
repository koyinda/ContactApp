package com.adniyo.ContactApp.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.adniyo.ContactApp.config.SpringRootConfig;
import com.adniyo.ContactApp.dao.UserDAO;
import com.adniyo.ContactApp.domain.User;

public class TestUserDAOUpdate {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringRootConfig.class);
        UserDAO userDAO=ctx.getBean(UserDAO.class);
        //TODO: the user details will be taken from User-Reg-Form
        User u=new User();
        u.setUserid(2);
        u.setName("Hagrid");
        u.setPhone("08080808080");
        u.setEmail("hagrid@hogwart.com.ng");
        u.setAddress("Hogwart");
        u.setRole(1);//Admin Role 
        u.setUserStatus(1); //Active
        userDAO.update(u);
        System.out.println("--------Data Saved------");

	}

}
