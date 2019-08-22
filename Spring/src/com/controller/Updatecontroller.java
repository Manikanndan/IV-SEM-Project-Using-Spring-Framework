package com.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.bean.ItemsBean;

@Controller
public class Updatecontroller {
	static String item_id1=null;
	
	@RequestMapping(value="Updateproduct",method={RequestMethod.POST,RequestMethod.GET})  
    public ModelAndView view(@RequestParam("id1")String  id1) {  
		item_id1=id1;
		List<ItemsBean> ListofProduct =  new ArrayList<>();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3307/test","root","1996");
			PreparedStatement pre;
			pre = con.prepareStatement("select * from Additem where Item_id='"+id1+"'");
			ResultSet rs= pre.executeQuery();
			
			while(rs.next()){
				ItemsBean product = new ItemsBean();
				product.setItemid(rs.getString("Item_id"));
				product.setItemname(rs.getString("Itemname"));
				product.setItemprice(rs.getFloat("itemprice"));
				product.setItemvendor(rs.getString("itemvendor"));
				product.setItemcategory(rs.getString("itemcategory"));
				product.setItemoffer(rs.getInt("itemoffer"));
				product.setItemquantity(rs.getInt("itemqty"));
				ListofProduct.add(product);
			}
			con.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return new ModelAndView("Productupdate","list",ListofProduct);  
    }  
	
	@RequestMapping("Update")
	public ModelAndView updatepro(HttpServletRequest request) {
		String msg=null;
		ItemsBean Bean=new ItemsBean();
		Bean.setItemprice(Float.parseFloat(request.getParameter("itemprice")));
		Bean.setItemoffer(Integer.parseInt(request.getParameter("itemoffer")));
		Bean.setItemquantity(Integer.parseInt(request.getParameter("itemquantity")));
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3307/test", "root", "1996");
			PreparedStatement pre = con.prepareStatement("Update Additem set itemprice=?, itemoffer=?, itemqty=? where Item_id='"+item_id1+"'");
			pre.setFloat(1, Bean.getItemprice());
			pre.setInt(2, Bean.getItemoffer());
			pre.setInt(3,Bean.getItemquantity());
			int i=pre.executeUpdate();
			if(i==1)
			{
				msg="Update Successfull";
			}
			else
			{
				msg="Update Unsuccessfull";
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return new ModelAndView("redirect:Product.html");
	}
	
}
