<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="CSS/Adminhome.css"  rel="stylesheet" type="text/css" />
<link href="CSS/Equipments.css"  rel="stylesheet" type="text/css" />
<title>AdminPanel-ProductUpdate</title>
</head>
<body>
	<jsp:include page="common/Header.jsp"></jsp:include>
	<jsp:include page="common/Navigation.jsp"></jsp:include>
	
	<div style="position:absolute;background:rgba(237, 237, 237,1);height:756px;width:1147px;margin-left:202px;margin-top:144px;">
	 	<h2 style="position;absolute;margin-left:500px;">Add Product</h2>
                <div class="innernav">
                    <ul>
                        <li><a href="admin.html">Home</a></li>
                        <li><a href="#" style="padding: 8px 0px 8px 0px;">></a></li>
                        <li><a href="#">Product</a></li>
                    </ul>
                </div>
               <c:forEach var="Value" items="${list}">
               <form action="Update.html" method="post">
                <div class="controlls" style="margin-left:200px;width:600px;">
                	<input type="hidden" name="itemid"/>
                    <label style="margin-left: 110px;">Item ID</label>
                    <input type="text" name="itemid" style="margin-left: 250px;" value="${Value.itemid }" placeholder="Item Name" disabled/>
                    <label style="margin-top: 140px;margin-left: 110px;">Item Name</label>
                    <input type="text" name="itemname" value="${Value.itemname }" placeholder="Item Price" style="margin-top: 130px;margin-left: 250px;" maxlength="30"  pattern="[A-Za-z]{5,20}" disabled/>
                    <label style="margin-top: 230px;margin-left: 110px;">Item Price</label>
                    <input type="text" name="itemprice" value="${Value.itemprice}" placeholder="Item Vendor" style="margin-top: 220px;margin-left: 250px;" maxlength="5"  pattern="[0-9]{3,5}" />
                    <label style="margin-top: 320px;margin-left: 110px;">Item Category</label>
                    <input type="text" name="itemcategory" value="${Value.itemcategory}" placeholder="Item Category" style="margin-top: 310px;margin-left: 250px;" disabled/>
                    <label style="margin-top: 410px;margin-left: 110px;">Item Offer</label>
                    <input type="text" name="itemoffer" value="${Value.itemoffer}" placeholder="Item Offer" style="margin-top: 400px;margin-left: 250px;"maxlength="2"  pattern="[0-9]{1,2}" />
                    <label style="margin-top: 500px;margin-left: 110px;">Item Quantity</label>
                    <input type="text" name="itemquantity" value="${Value.itemquantity}" placeholder="Item Quantity" style="margin-top: 490px;margin-left: 250px;" maxlength="2"  pattern="[0-9]{1,2}"/>
                    <input type="submit" value="Update" style="margin-left: 110px;width: 63.5%;"/>
                </div>
                </c:forEach>
                </form>
	</div>
	
</body>
</html>