<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link href="CSS/Adminhome.css"  rel="stylesheet" type="text/css" />
<link href="CSS/User.css"  rel="stylesheet" type="text/css" />
</head>
<body>
	<form>
       	<jsp:include page="common/Header.jsp"></jsp:include>
        <jsp:include page="common/Navigation.jsp"></jsp:include>
        <div class="container" style="height:756px;">
        <h2 style="margin-left:500px;">Product Delete</h2>
                <div class="Adminnav" style="margin-left: 100px">
                    <ul >
                        <li><a href="admin.html" style="color:rgba(255,0,0,1);">Home</a></li>
                        <li><a href="#" style="padding: 8px 0px 8px 0px;color:rgba(0,0,0,1);">></a></li>
                        <li><a href="user.html" style="color:rgba(255,0,0,1);">Product</a></li>
                    </ul>
                </div>
                <div class="controlls" style="margin-left:100px;margin-top:50px;width:800px;">
                    <table border="1">
                        <thead>
                            <th>Firstname</th>
                            <th>Lastname</th>
                            <th>Username</th>
                            <th>EmailAddress</th>
                            <th>Phonenumber</th>
                            <th>Gender</th>
                            <th>Address</th>
                            
                        </thead>
                        <tbody>
                        <c:forEach var="listValue" items="${list}">
                            <tr>
                                <td>${listValue.firstname}</td>
                                <td>${listValue.lastname}</td>
                                <td>${listValue.username}</td>
                                <td>${listValue.emailAddress}</td>
                                <td>${listValue.phonenumber}</td>
                                <td>${listValue.gender}</td>
                                <td>${listValue.address}</td>
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