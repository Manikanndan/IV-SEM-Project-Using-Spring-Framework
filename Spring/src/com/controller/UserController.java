package com.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.bean.Select;
import com.bean.UserBean;
import util.Userid;
@Controller
public class UserController {
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView login(@ModelAttribute("user") Select user,HttpSession httpSession) {
		
		String msg="User does not Exist";
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3307/test", "root", "1996");
			
			PreparedStatement pre= con.prepareStatement("select user_id, Firstname,Lastname,Username,EmailAddress,Gender,Password,ConfirmPassword from Register where Username=? and password=?");
		/*System.out.println(user.getUsername());*/
			pre.setString(1, user.getUsername());
			pre.setString(2, user.getPassword());
			ResultSet rs= pre.executeQuery();
			if(rs.next()){
				msg=" User login sucessfully";
				/*System.out.println("User_id");*/
				Userid.userid=rs.getInt("User_id");
				user.setUser_id(rs.getInt("User_id"));
			}else{
				return new ModelAndView("Home","msg", msg);
			}
			
			//HttpSession session = request.getSession();
			//User user = (User) session.getAttribute("user");
			httpSession.setAttribute("user", user);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			msg="Error occure<br>"+e.getMessage();
			e.printStackTrace();
			return new ModelAndView("UserHome","msg", msg);
		}
		if("admin".equalsIgnoreCase(user.getUsername())){
			msg="Admin user login Scuessfully";
			return new ModelAndView("AdminHome","msg", msg);// will redirect to viewemp
		}
		
		return new ModelAndView("Home","msg", msg);
	}

}
