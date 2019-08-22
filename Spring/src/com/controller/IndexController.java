package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServletRequest;

@Controller  
public class IndexController {  
  
    @RequestMapping("UserHome")  
    public ModelAndView UserHome(HttpServletRequest request) {  
    	
         
        HttpSession httpsession=request.getSession();
        httpsession.invalidate();
        return new ModelAndView("UserHome");  
    }  
      
}  
