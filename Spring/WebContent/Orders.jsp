<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="CSS/Adminhome.css"  rel="stylesheet" type="text/css" />
<link href="CSS/Orders.css"  rel="stylesheet" type="text/css" />


<title>AdminPanel-Orders</title>
</head>
<body>
	<form>
       	<jsp:include page="common/Header.jsp"></jsp:include>
        <jsp:include page="common/Navigation.jsp"></jsp:include>
        <div class="container" style="height:756px;">
        <h2 style="margin-left:500px;">Product Delete</h2>
                <div class="Adminnav" style="margin-left: 100px">
                    <ul>
                        <li><a href="admin.html">Home</a></li>
                        <li><a href="#" style="padding: 8px 0px 8px 0px;">></a></li>
                        <li><a href="Order.html">Orders</a></li>
                    </ul>
                </div>
                <div class="controlls" style="margin-left:100px;margin-top:50px;width:800px;">
                    <table border="1">
                        <thead>
                            <th >Orderid</th>
                            <th >Item_id</th>
                            <th >Totalprice </th>
                            <th >Qty</th>
                            <th >Orderdate</th>
                            <th >Address </th>
                            <th >Orderstat</th>
                        </thead>
                        <tbody>
                        <c:forEach var="listValue" items="${list}">
                            <tr>
                                <td>${listValue.orderid }</td>
                                <td>${listValue.item_id }</td>
                                <td>${listValue.totalprice }</td>
                                <td>${listValue.qty }</td>
                                <td>${listValue.orderdate }</td>
                                <td>${listValue.address }</td>
                                <td>${listValue.orderstat }</td>
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