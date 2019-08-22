package com.controller;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.bean.ItemsBean;
@Controller
public class Deliverycontroller {
	@RequestMapping("/delivery")  
    public ModelAndView delivery() {  
  
         
        return new ModelAndView("Delivery");  
    }  

}
