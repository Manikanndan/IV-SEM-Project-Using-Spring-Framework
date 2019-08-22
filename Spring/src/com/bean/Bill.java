package com.bean;


public class Bill {
	int Orderid;
	String Item_id;
	int User_id;
	float Totalprice;
	int Qty;
	String Orderdate;
	String Address;
	String Orderstat;
	
	public String getOrderstat() {
		return Orderstat;
	}
	public void setOrderstat(String orderstat) {
		Orderstat = orderstat;
	}
	public int getOrderid() {
		return Orderid;
	}
	public void setOrderid(int orderid) {
		Orderid = orderid;
	}
	
	public String getItem_id() {
		return Item_id;
	}
	public void setItem_id(String item_id) {
		Item_id = item_id;
	}
	public int getUser_id() {
		return User_id;
	}
	public void setUser_id(int user_id) {
		User_id = user_id;
	}
	public float getTotalprice() {
		return Totalprice;
	}
	public void setTotalprice(float totalprice) {
		Totalprice = totalprice;
	}
	public int getQty() {
		return Qty;
	}
	public void setQty(int qty) {
		Qty = qty;
	}
	public String getOrderdate() {
		return Orderdate;
	}
	public void setOrderdate(String orderdate) {
		Orderdate = orderdate;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}

}
