package com.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.bean.Order;


@Controller
public class Orderscontroller {
	@RequestMapping("Order")
	public ModelAndView view() {
		
		List<Order> list = new ArrayList<>();
		try{
		Class.forName("com.mysql.jdbc.Driver");
		Connection con1 =DriverManager.getConnection("jdbc:mysql://localhost:3307/test", "root", "1996");
		PreparedStatement pre = con1.prepareStatement("select * from orderitem where Orderstat='Ordered' ");
		ResultSet rs = pre.executeQuery();
		while(rs.next()) {
			Order pro=new Order();
			System.out.println(rs.getInt("Orderid"));
			pro.setOrderid(rs.getInt("Orderid"));
			pro.setItem_id(rs.getString("Item_id"));
			pro.setTotalprice(rs.getFloat("Totalprice"));
			pro.setQty(rs.getInt("Qty"));
			pro.setOrderdate(rs.getString("Orderdate"));
			pro.setAddress(rs.getString("Address"));
			pro.setOrderstat(rs.getString("Orderstat"));
			list.add(pro);
		}
		con1.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return new ModelAndView("Orders","list",list);
	}
}
