<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>AdminPanel-Items</title>

<link href="CSS/Adminhome.css"  rel="stylesheet" type="text/css" />
<link href="CSS/Equipments.css"  rel="stylesheet" type="text/css" />
</head>
<body>
	<jsp:include page="common/Header.jsp"></jsp:include>
	<jsp:include page="common/Navigation.jsp"></jsp:include>
	<form action="addItem.html" method="post">
	<div style="position:absolute;background:rgba(237, 237, 237,1);height:756px;width:1147px;margin-left:202px;margin-top:144px;">
	 	<img src="Images/product.jpg" style="position:absolute;margin-top:0px;width:1147px;"/>
	 	<h2 style="position:absolute;margin-left:500px;margin-top:30px;">Add Product</h2>
                <div class="innernav" style="margin-top:50px;">
                    <ul>
                        <li><a href="admin.html">Home</a></li>
                        <li><a href="#" style="padding: 8px 0px 8px 0px;">></a></li>
                        <li><a href="#">Product</a></li>
                    </ul>
                </div>
                <div class="controlls" style="margin-left:200px;margin-top:100px;background-color: rgba(255, 255,255,0.9);">
                    <label>Item Name</label>
                    <input type="text" name="itemname" value="" placeholder="Item Name" maxlength="20" pattern="[A-Za-z]{5,20}" required autofocus/>
                    <label style="margin-top: 140px;">Item Price</label>
                    <input type="text" name="itemprice" value="" placeholder="Item Price" maxlength="5" pattern="[0-9]{0,5}" style="margin-top: 130px;" required/>
                    <label style="margin-top: 230px;">Item Vendor</label>
                    <input type="text" name="itemvendor" value="" placeholder="Item Vendor" maxlength="20" pattern="[A-Za-z]{0,20}" style="margin-top: 220px;" required/>
                    <label style="margin-top: 320px;">Item Category</label>
                    
                    <select style="margin-top: 310px;" name="itemcategory" required>
                    <c:forEach var="listValue" items="${list}">
                        <option>${listValue.itemcategory}</option>
                         </c:forEach>
                    </select>
                   
                    <label style="margin-top: 410px;">Item Offer</label>
                    <input type="text" name="itemoffer" value="" placeholder="Item Offer" maxlength="2"  pattern="[0-9]{1,2}" style="margin-top: 400px;" required/>
                    <label style="margin-top: 500px;">Item Quantity</label>
                    <input type="text" name="itemquantity" value="" placeholder="Item Quantity"  pattern="[0-9]{1,2}" maxlength="2" min="1" max="50" style="margin-top: 490px;" required/>
                    <a href="addItem.html"><input type="submit" value="AddItem" /></a>
                    <label style="margin-left:550px;">Select The Image</label>
                    <input type="file" name="imagename" required/>
                </div>
	</div>
	</form>
	<jsp:include page="common/Footer.jsp"></jsp:include>
</body>
</html>