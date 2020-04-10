/**
 * 
 */
package com.adniyo.ContactApp.service;

import java.util.List;

import com.adniyo.ContactApp.domain.User;
import com.adniyo.ContactApp.exception.UserBlockedException;

/**
 * @author Oyindamola
 *
 */
public interface UserService {
    public static final Integer LOGIN_STATUS_ACTIVE=1;
    public static final Integer LOGIN_STATUS_BLOCKED=2;
    
    public static final Integer ROLE_ADMIN=1;
    public static final Integer ROLE_USER=2;
    
    
    public void register(User u);
    
    public User login(String username, String password) throws UserBlockedException;
    
    public List<User> getUserList();
    
    public void changeLoginStatus(Integer userId, Integer loginStatus);    
    
    public Boolean isUsernameExist(String username);
}
