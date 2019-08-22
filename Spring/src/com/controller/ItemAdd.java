package com.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.bean.ItemsBean;
@Controller
public class ItemAdd {
	String name;
	static Connection con = null;
	static Connection con1 = null;
	@RequestMapping("/addItem")  
    public ModelAndView Additems() {  
  
		List<ItemsBean> list = new ArrayList<>();
		try{
		Class.forName("com.mysql.jdbc.Driver");
		con1 =DriverManager.getConnection("jdbc:mysql://localhost:3307/test", "root", "1996");
		PreparedStatement pre = con1.prepareStatement("select * from Category ");
		ResultSet rs = pre.executeQuery();
		while(rs.next()) {
			ItemsBean pro=new ItemsBean();
			pro.setItemcategory(rs.getString("Cat_name"));
			list.add(pro);
		}
		con1.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
        return new ModelAndView("Itemsadd","list",list);  
    }  
	@RequestMapping(value="/addItem",method=RequestMethod.POST)
	public ModelAndView addItem(@ModelAttribute("ItemsBean") ItemsBean itemsbean)
	{
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con =DriverManager.getConnection("jdbc:mysql://localhost:3307/test", "root", "1996");
			PreparedStatement pre = con.prepareStatement("insert into Additem (Item_id,itemname,itemprice,itemvendor,itemoffer"
					+ ",itemcategory,itemqty,Catid,imagename) values (? , ? , ? , ? , ? , ? , ? , ? , ?)");
			name=itemsbean.getItemcategory();
			pre.setString(1, Generateid());
			pre.setString(2,itemsbean.getItemname());
			pre.setFloat(3, itemsbean.getItemprice());
			pre.setString(4, itemsbean.getItemvendor());
			pre.setInt(5, itemsbean.getItemoffer());
			pre.setString(6, itemsbean.getItemcategory());
			pre.setInt(7, itemsbean.getItemquantity());
			pre.setString(8,getCatid());
			pre.setString(9,itemsbean.getImagename());
			int i=pre.executeUpdate();
			con.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	return new ModelAndView("redirect:addItem.html","items", itemsbean);
	
	}
	public String Generateid()
	{
		Random rand=new Random();
		int value=rand.nextInt(1000);
		String Itemid="ITM"+value;
		return(Itemid);
	}
	public String getCatid()
	{
		String catid=null;
		ItemsBean item=new ItemsBean();
		try
		{
		Class.forName("com.mysql.jdbc.Driver");
		con1 =DriverManager.getConnection("jdbc:mysql://localhost:3307/test", "root", "1996");
		PreparedStatement pre = con1.prepareStatement("select catid from Category where Cat_name='"+name+"' ");
		ResultSet rs = pre.executeQuery();
		while(rs.next()) {
			
			catid=rs.getString("catid");
		}
		con1.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return catid;
	}	
	
}
