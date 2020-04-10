package com.adniyo.ContactApp.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.adniyo.ContactApp.domain.Contact;
import com.adniyo.ContactApp.service.ContactService;	

@Controller
public class ContactController {
    @Autowired
    private ContactService contS;

    @RequestMapping(value = "/contact_form", method = RequestMethod.GET)
    public String contactForm(Model m) {
        Contact contact = new Contact();
        m.addAttribute("cmd", contact);
        return "contact_form";//JSP form view
    }
    @RequestMapping(value = "/contact_form", method = RequestMethod.POST)
    public String saveContact(@ModelAttribute("cmd") Contact c, Model m, HttpSession session) {
    	Integer contactId = (Integer) session.getAttribute("aContactId");
    	if(contactId == null) 
    	{
    		//save
	    	try {
	    		Integer userid = (Integer) session.getAttribute("userId");
	    		c.setUserid(userid);
	    		contS.save(c);
	    		return "redirect:clist?act=sav";
	    	}catch(Exception e){
	    		e.printStackTrace();
	    		m.addAttribute("ERROR", "Contact already exist.");
	            return "contact_form";
	    	}
    	}
    	else
    	{
    		//update
	    	try {
	    		c.setContactid(contactId);
	    		contS.update(c);
	    		session.removeAttribute("aContactId"); 
	    		return "redirect:clist?act=upd";
	    	}catch(Exception e){
	    		e.printStackTrace();
	    		m.addAttribute("ERROR", "Something Went Wrong");
	            return "contact_form";
	    	}    		
    	}
    }    
    @RequestMapping(value = "/clist")
    public String contactlist(Model m, HttpSession session) {
    		m.addAttribute("contactList", contS.findUserContact((Integer) session.getAttribute("userId")));
    		return "clist";
    	
    } 

    @RequestMapping(value = "/edit_contact")
    public String prepareEditForm(Model m, HttpSession session, @RequestParam("cid") Integer contactId) {
        session.setAttribute("aContactId", contactId);
        Contact c = contS.findById(contactId);
        m.addAttribute("cmd", c);
        return "contact_form";//JSP form view
    }
    @RequestMapping(value = "/contact_search")
    public String contactSearch(Model m, HttpSession session, @RequestParam("freeText") String freeText) {
        Integer userId = (Integer) session.getAttribute("userId");
        m.addAttribute("contactList", contS.findUserContact(userId, freeText));
        return "clist"; //JSP
    }   
    @RequestMapping(value = "/del_contact")
    public String deleteContact(@RequestParam("cid") Integer contactId) {
    	contS.delete(contactId);
        return "redirect:clist?act=del";
    }
}
