package com.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.bean.ItemsBean;
import com.bean.Select;
import com.bean.UserBean;
import com.bean.User;
import com.bean.Bill;

import util.Userid;
@Controller
public class Routecontroller {

	private int qty1;
	private String id1="";
	private int off;
	private float price;
	private float total;
	private float Temp;
	
	
   @RequestMapping("/index")  
    public ModelAndView Index() { 
          
        return new ModelAndView("UserHome");  
    } 

   @RequestMapping("/UltraSound")  
   public ModelAndView UltraSound() {  
  
       return new ModelAndView("UltraSound");  
   } 
   
   @RequestMapping("/Stretcher")  
   public ModelAndView Stretcher() {  
         
       return new ModelAndView("Stretcher");  
   } 
   
   @RequestMapping("/SeatWalker")  
   public ModelAndView SeatWalker() {  
         
       return new ModelAndView("SeatWalker");  
   } 
   
   @RequestMapping("/ophthalmickeratometer")  
   public ModelAndView ophthalmickeratometer() {  
         
       return new ModelAndView("ophthalmickeratometer");  
   } 
   
   @RequestMapping("/obstetricalforceps")  
   public ModelAndView obstetricalforceps() {  
         
       return new ModelAndView("obstetricalforceps");  
   } 
   
   
   
   @RequestMapping("/DigitalThermometer")  
   public ModelAndView DigitalThermometer(HttpSession httpSession) { 
	   Select bean=new Select();
	   String Status = new String();
       if(httpSession.getAttribute("user") != null) {
    	   Status = "Login";
    	
       }
       else
       {
    	   Status = "Logout";
       }
       return new ModelAndView("DigitalThermometer");  
   } 
   
   @RequestMapping("/bloodglucosemeter")  
   public ModelAndView bloodglucosemeter() {  
         
       return new ModelAndView("bloodglucosemeter");  
   } 
   
   @RequestMapping("/MRIScanner")  
   public ModelAndView MRIScanner() {  
         
       return new ModelAndView("MRIScanner");  
   } 
   
   @RequestMapping("/admin")  
   public ModelAndView admin() {  
 
			
       return new ModelAndView("AdminHome");  
   } 
   @RequestMapping("/adminhome")  
   public ModelAndView adminhome(HttpServletRequest request) {  
 
	   
			
			HttpSession httpsession=request.getSession();
	        httpsession.invalidate();
			
       return new ModelAndView("UserHome");  
   } 
   
   @RequestMapping("/Pay")  
   public ModelAndView Payment(@RequestParam("id") String id,@RequestParam("qty") int qty) { 
	   /*int q=Integer.parseInt(request.getParameter("qty"));
	   System.out.println(q);*/
	   qty1=qty;
	   id1=id;
	   List<ItemsBean> list = new ArrayList<>();
		try{
		Class.forName("com.mysql.jdbc.Driver");
		Connection con1 =DriverManager.getConnection("jdbc:mysql://localhost:3307/test", "root", "1996");
		PreparedStatement pre = con1.prepareStatement("select * from Additem where Item_id='"+id+"'");
		ResultSet rs = pre.executeQuery();
		while(rs.next()) {
			ItemsBean pro=new ItemsBean();
			pro.setItemid(rs.getString("Item_id"));
			pro.setItemname(rs.getString("itemname"));
			pro.setItemprice(rs.getFloat("itemprice"));
			pro.setItemoffer(rs.getInt("itemoffer"));
			price=rs.getFloat("itemprice");
			off=rs.getInt("itemoffer");
			list.add(pro);
		}		
		con1.close();
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
		}
		float totalprice=getprice();
		 int totalp=(int)totalprice;
		ModelAndView mv=new ModelAndView("Payment");
		mv.addObject("id",id);
		mv.addObject("qty",qty);
		mv.addObject("list",list);
		mv.addObject("total", totalp);
		return mv;  
   } 
   @RequestMapping("/Payment") 
   public ModelAndView pay(HttpServletRequest req,@ModelAttribute("Select") Select select)
   {
	   String odrstat = "Ordered";
	   float totalprice=getprice();
	   int totalp=(int)totalprice;
	   @SuppressWarnings("deprecation")
	   SimpleDateFormat f=new SimpleDateFormat("dd/MM/yyyy");
	   Date dt = new Date();
	   String addr = select.getAddress()+" "+select.getState()+" "+select.getCity()+" "+select.getZip();
	   /*System.out.println(String.valueOf(dt));*/
	   
	    try
	    {
	    	Class.forName("com.mysql.jdbc.Driver");
			Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3307/test", "root", "1996");
			PreparedStatement pre = con.prepareStatement("insert into orderitem (Item_id,User_id,Totalprice,Qty,Orderdate"
					+ ",Address,Orderstat) values (? , ? , ? , ? , ? , ? , ? )");

			
			pre.setString(1, id1);
			pre.setInt(2,Userid.userid);
			pre.setFloat(3, totalp);
			pre.setInt(4, qty1);
			pre.setString(5, String.valueOf(f.format(dt)));
			pre.setString(6, addr);
			pre.setString(7,odrstat);
			int i=pre.executeUpdate();
			con.close();
	    } catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	   
	   ModelAndView mv=new ModelAndView("redirect:New.html");
	  
	   return mv;
   }
   public float getprice()
   {
	   float price1=(price*qty1);
	   if(off==0)
	   {
		   price=(price*qty1);
	   }
	   else
	   {
		   
		   Temp=(price1/100)*off;
		   price=price1-Temp;
		   
	   }
	   return price;
   }
   @RequestMapping("/Category")  
   public ModelAndView Category() {  
 
        
       return new ModelAndView("Category");  
   } 
   @RequestMapping("/Home")  
   public ModelAndView Home() {  
 
        
       return new ModelAndView("Home");  
   } 
   
   @RequestMapping(value="/View",method=RequestMethod.GET)  
   public ModelAndView View(@RequestAttribute("id1") String id1 /*HttpSession httpSession*/) { 
	 System.out.println(id1);
	   	List<ItemsBean> list = new ArrayList<>();
	    String msg1="Please Login";
		try{
		Class.forName("com.mysql.jdbc.Driver");
		Connection con1 =DriverManager.getConnection("jdbc:mysql://localhost:3307/test", "root", "1996");
		PreparedStatement pre = con1.prepareStatement("select * from Additem where Item_id='"+id1+"'");
		ResultSet rs = pre.executeQuery();
		while(rs.next()) {
			ItemsBean pro=new ItemsBean();
			pro.setItemid(rs.getString("Item_id"));
			pro.setItemname(rs.getString("Itemname"));
			pro.setItemprice(rs.getFloat("itemprice"));
			pro.setItemoffer(rs.getInt("itemoffer"));
			pro.setItemquantity(rs.getInt("itemqty"));
			pro.setImagename(rs.getString("imagename"));
			list.add(pro);
			
			
		}
		//httpSession.setAttribute("Pay", view1);
		con1.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
         
		
       return new ModelAndView("View","list",list);  
   } 

	@RequestMapping(value="/Products",method=RequestMethod.GET)  
	   public ModelAndView Products(@RequestAttribute("id") String id) { 
		List<ItemsBean> list = new ArrayList<>();
		try{
		Class.forName("com.mysql.jdbc.Driver");
		Connection con1 =DriverManager.getConnection("jdbc:mysql://localhost:3307/test", "root", "1996");
		PreparedStatement pre = con1.prepareStatement("select * from Additem where Catid='"+id+"'");
		ResultSet rs = pre.executeQuery();
		while(rs.next()) {
			ItemsBean pro=new ItemsBean();
			pro.setItemid(rs.getString("Item_id"));
			pro.setItemname(rs.getString("Itemname"));
			pro.setItemprice(rs.getFloat("itemprice"));
			pro.setItemoffer(rs.getInt("itemoffer"));
			pro.setImagename(rs.getString("imagename"));
			list.add(pro);
		}
		
		con1.close();
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
		}
        return new ModelAndView("Sub-Category","list",list);    
	   }
   
   @RequestMapping("/Registration")  
   public ModelAndView Registration() {  
         
       return new ModelAndView("Registration");  
   } 

   
   @RequestMapping(value = "/registrationSave", method = RequestMethod.POST)
	public ModelAndView save(@ModelAttribute("select") Select select) {
		
	// TODO Auto-generated method stub
			try {
				Class.forName("com.mysql.jdbc.Driver");
				Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3307/test", "root", "1996");
				System.out.println(select.getUsername());

				PreparedStatement pre = con.prepareStatement("insert into Register (Firstname,Lastname,Username,EmailAddress,Phonenumber,Gender,Address,Password,ConfirmPassword) values (? , ? , ? , ? , ? , ? , ? , ? , ? )");
				pre.setString(1, select.getFirstname());
				pre.setString(2, select.getLastname());
				pre.setString(3, select.getUsername());
				pre.setString(4, select.getEmailAddress());
				pre.setString(5, select.getPhonenumber());
				pre.setString(6, select.getGender());
				pre.setString(7, select.getAddress());
				pre.setString(8, select.getPassword());
				pre.setString(9, select.getConfirmPassword());
				

				int i=pre.executeUpdate();

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return new ModelAndView("UserHome","select", select);// will redirect to viewemp
														// request mapping
	}
   
   @RequestMapping("Product")  
   public ModelAndView show() {  
		List<ItemsBean> ListofProduct =  new ArrayList<>();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3307/test","root","1996");
			PreparedStatement pre;
			pre = con.prepareStatement("select * from Additem");
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
        
       return new ModelAndView("Productdelete","list",ListofProduct);  
   }  
	@RequestMapping(value="Delete",method=RequestMethod.GET)  
   public ModelAndView delete(@RequestParam("id") String id) 
	{
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3307/test","root","1996");
			PreparedStatement pre;
			pre = con.prepareStatement("delete from Additem where Item_id = '"+id+"'");
			pre.executeUpdate();
			con.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return new ModelAndView("redirect:Product.html");
	}	
	
	@RequestMapping("user")
	public ModelAndView save() {
		
		List<User> list=  new ArrayList<>();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3307/test","root","1996");
			PreparedStatement pre;
			pre = con.prepareStatement("select * from Register where Username <> 'admin'");
			ResultSet rs= pre.executeQuery();
			
			while(rs.next()){
				User user = new User();
				user.setFirstname(rs.getString("FirstName"));
				user.setLastname(rs.getString("Lastname"));
				user.setUsername(rs.getString("Username"));
				user.setEmailAddress(rs.getString("EmailAddress"));
				user.setPhonenumber(rs.getString("Phonenumber"));
				user.setGender(rs.getString("Gender"));
				user.setAddress(rs.getString("Address"));
				list.add(user);
			}
			System.out.println(list);
			con.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return new ModelAndView("User","list",list);
	}
	 @RequestMapping("/New")  
	   public ModelAndView New() {  
	 
	        
	       return new ModelAndView("NewFile");  
	   } 
	 
	 
	 @RequestMapping(value="/Billing",method=RequestMethod.GET)  
	   public ModelAndView Billing(/*@RequestAttribute("id1") String id1 HttpSession httpSession*/) { 
		 System.out.println(id1);
		   	List<Bill> list = new ArrayList<>();
		    String msg1="Please Login";
			try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con1 =DriverManager.getConnection("jdbc:mysql://localhost:3307/test", "root", "1996");
			PreparedStatement pre = con1.prepareStatement("select * from orderitem where User_id='"+Userid.userid+"'");
			ResultSet rs = pre.executeQuery();
			while(rs.next()) {
				Bill pro=new Bill();
				pro.setOrderid(rs.getInt("Orderid"));
				pro.setItem_id(rs.getString("Item_id"));
				pro.setTotalprice(rs.getFloat("Totalprice"));
				pro.setQty(rs.getInt("Qty"));
				pro.setOrderdate(rs.getString("Orderdate"));
				pro.setAddress(rs.getString("Address"));
				list.add(pro);
				
				
			}
			//httpSession.setAttribute("Pay", view1);
			con1.close();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
	         
			
	       return new ModelAndView("Billing","list",list);  
	 
	 }
}
