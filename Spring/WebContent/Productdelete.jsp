<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="CSS/Adminhome.css"  rel="stylesheet" type="text/css" />
<link href="CSS/productdel.css"  rel="stylesheet" type="text/css" />
<title>AdminPanel-ProductDelete</title>
</head>
<body>
	<form action="product.html" method="post">
       	<jsp:include page="common/Header.jsp"></jsp:include>
        <jsp:include page="common/Navigation.jsp"></jsp:include>
        <div class="container" style="height:756px;">
        	<img src="" style="position:absolute;margin-top:0px;width:1147px;"/>
        	<h2 style="position:absolute;margin-left:500px;margin-top:30px;">Product Delete</h2>
                <div class="Adminnav" style="margin-left: 100px;margin-top:50px;">
                    <ul>
                        <li><a href="admin.html" style="color:rgba(255,0,0,1);">Home</a></li>
                        <li><a href="#" style="padding: 8px 0px 8px 0px;color:rgba(0,0,0,1);">></a></li>
                        <li><a href="addItem.html" style="color:rgba(255,0,0,1);">Product</a></li>
                        <li><a href="#" style="padding: 8px 0px 8px 0px;color:rgba(0,0,0,1);">></a></li>
                        <li><a href="Product.html" style="color:rgba(255,0,0,1);">Productdelete</a></li>
                    </ul>
                </div>
                <div class="controlls" style="margin-left:100px;margin-top:100px;width:1000px;background-color: rgba(255, 255,255,0.9);">
                    <table border="1">
                        <thead>
                            <th>Itemname</th>
                            <th>Itemprice</th>
                            <th>Itemvendor</th>
                            <th>Itemcategory</th>
                            <th>ItemOffer</th>
                            <th>Itemquantity</th>
                            <th></th>
                            <th></th>
                        </thead>
                        <tbody>
                        <c:forEach var="Value" items="${list}">
                       
                            <tr>
                                <td style="padding-left:5px;">${Value.itemname}</td>
                                <td style="padding-left:5px;">${Value.itemprice}</td>
                                <td style="padding-left:5px;">${Value.itemvendor}</td>
                                <td style="padding-left:5px;">${Value.itemcategory}</td>
                                <td style="padding-left:5px;">${Value.itemoffer}</td>
                                <td style="padding-left:5px;">${Value.itemquantity}</td>
                                <td style="padding-left:5px;"><a href="Delete.html?id=${Value.itemid}" style="color:red;font-family: Times New Roman;text-decoration: none;" >Delete</a></td>
                                <td style="padding-left:5px;"><a href="Updateproduct.html?id1=${Value.itemid}" style="color:red;font-family: Times New Roman;text-decoration: none;" >Update</a></td>
                            </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
        </div>
        <jsp:include page="common/Footer.jsp"></jsp:include>
   	</form>
</body>
</html>