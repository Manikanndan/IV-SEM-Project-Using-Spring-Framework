<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div>
		<label>Order id:</label>
		<label>Item id:</label>
		<label>TotalPrice:</label>
		<label>Quantity:</label>
		<label>Order date:</label>
		<label>Address:</label>
		
		<c:forEach var="listValue" items="${list}">
			<label>${listvalue.Orderid}</label>
			<label>${listvalue.Item_id}</label>
			<label>${listvalue.Totalprice}</label>
			<label>${listvalue.Qty}</label>
			<label>${listvalue.Orderdate}</label>
			<label>${listvalue.Address}</label>
		</c:forEach>
	</div>
</body>
</html>