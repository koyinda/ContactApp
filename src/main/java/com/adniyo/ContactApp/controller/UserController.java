package com.adniyo.ContactApp.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.adniyo.ContactApp.command.LoginCommand;
import com.adniyo.ContactApp.command.UserCommand;
import com.adniyo.ContactApp.domain.User;
import com.adniyo.ContactApp.exception.UserBlockedException;
import com.adniyo.ContactApp.service.UserService;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = {"/", "/index"})
    public String index() {
       // m.addAttribute("command", new LoginCommand());
        return "index"; //JSP - /WEB-INF/view/index.jsp
    }
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String handlelogin (@ModelAttribute("command") LoginCommand cmd, Model m, HttpSession session) {
    	try {
			User u = userService.login(cmd.getUsername(), cmd.getPassword());
			if(u == null)
			{
				m.addAttribute("ERROR", "Your Username or password is invalid");
				return "login";
			}else {
				 addUserInSession(u, session);
				return u.getRole().equals(UserService.ROLE_USER) ? "redirect:user-dashboard" : "redirect:admin-dashboard";
			}
		} catch (UserBlockedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			m.addAttribute("ERROR", e.getMessage());
			return "login";
		} 
    }
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(Model m) {
        m.addAttribute("command", new LoginCommand());
        return "login"; //JSP - /WEB-INF/view/index.jsp
    }
    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String register(Model m) {
    	m.addAttribute("cmd", new UserCommand());
        return "register"; //JSP - /WEB-INF/view/index.jsp
    }
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String registerUser(@ModelAttribute("cmd") UserCommand cmd, Model m) {
    	
    	try {
    		User u = cmd.getUser();
        	u.setUserStatus(UserService.LOGIN_STATUS_ACTIVE);
    		userService.register(u);
    		return "redirect:login?act=reg";
    	}catch(DuplicateKeyException e){
    		e.printStackTrace();
    		m.addAttribute("ERROR", "Username is already registered. Please select another username.");
            return "register";
    	}
    	
    	

         //JSP - /WEB-INF/view/index.jsp
    }    
    @RequestMapping(value = {"/user-dashboard"})
    public String userdashboard() {
       // m.addAttribute("command", new LoginCommand());
        return "dashboard"; //JSP - /WEB-INF/view/index.jsp
    }    
    @RequestMapping(value = {"/admin-dashboard"})
    public String admindashboard() {
       // m.addAttribute("command", new LoginCommand());
        return "dashboard_admin"; //JSP - /WEB-INF/view/index.jsp
    }
    @RequestMapping(value = "/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:index?act=lo";
    }
    private void addUserInSession(User u, HttpSession session) {
        session.setAttribute("user", u);
        session.setAttribute("userId", u.getUserid());
        session.setAttribute("role", u.getRole());
    }
    @RequestMapping(value = "/ulist")
    public String userlist(Model m, HttpSession session) {
    		m.addAttribute("userList", userService.getUserList());
    		return "ulist";
    	
    }   
    @RequestMapping(value = "/cstatus")//change_status
    @ResponseBody
    public String changestatus(@RequestParam Integer userid, @RequestParam Integer userStatus) {
    	try {
    		userService.changeLoginStatus(userid, userStatus);
    		return "SUCCESS: Status Changed";
    	}catch(Exception e)
    	{
    		e.printStackTrace();
    		return "ERROR: Something went wrong";	
    	}	
    }
    @RequestMapping(value = "/checkavail")//change_status
    @ResponseBody
    public String checkAvailaibility(@RequestParam String username) {
        if(userService.isUsernameExist(username)){
            return "This username is already taken. Choose another name";
        }else{
            return "Yes! You can take this";
        }
    }
    @RequestMapping(value = "/user_search")
    public String contactSearch(Model m, HttpSession session, @RequestParam("freeText") String freeText) {
        m.addAttribute("userList", userService.findUser( freeText));
        return "ulist"; //JSP
    } 
}
