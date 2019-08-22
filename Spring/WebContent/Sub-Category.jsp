<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="com.bean.Select"%>
<%@page import="com.bean.UserBean"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <title>Sub-Category</title>
        <link rel="stylesheet" type="text/css" href="CSS/Sub-Category.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    </head>
    <%
  
 Select u=(Select) session.getAttribute("user");
  
  
  %>
     <c:if test="${msg!=null}">
		<div class="msgColor">${msg}
			<script>
			alert('${msg }');
			</script>
		</div>
		</c:if>
 	<body>
 	 
 	<header class="head">
 	<%
        	if(u!=null)
        	{
        		out.println("<nav>");
        		out.println("<ul>");
        		out.println("<li><a href='Home.html'>Home</a></li>");
        		out.println("<label>|</label>");
        		out.println("<li><a href='Category.html'>Category</a></li>");
        		out.println("<label>|</label>");
        		out.println("<li>"+u.getUsername()+"</li>");
        		out.println("<label>|</label>");
        		out.println("<li><a href='UserHome.html'>Logout</a></li>");
        		out.println("<label>|</label>");
        		out.println("</ul>");
        		out.println("</nav>");
        	}
        	else
        	{
        		out.println("<nav>");
        		out.println("<ul>");
        		out.println("<li><a href='UserHome.html'>Home</a></li>");
        		out.println("<label>|</label>");
        		out.println("<li><a href='Category.html'>Category</a></li>");
        		out.println("<label>|</label>");
        		out.println("<li><a href='Registration.html'>Sign Up</a></li>");
        		out.println("<label>|</label>");
        		out.println("<li><a href='UserHome.html'>Back</a></li>");
        		out.println("<label>|</label>");
        		out.println("</ul>");
        		out.println("</nav>");
        	}
        %>       
            <!-- <nav>
                <ul>
                    <li><a href="#">Contact Us</a></li>
                    <label1>|</label1>
                    <li><a href="Products.html">Category</a></li>
                    <label1>|</label1>
                    <li><a href="Registration.html">Sign Up</a></li>
                    <label1>|</label1>
                    <li><a href="UserHome.html">Logout</a></li>
                </ul>
            </nav> -->
            <div class="L1">
                <img src="Images/rsz_1logo.jpg">
            </div>
            <!--<h1>OnlineMedicals</h1>-->
            <input type="text" id="search" id="s1" value="" placeholder="Search" />
            <button type="submit" id="sea"><i class="fa fa-search"></i></button>
            <div class="account">
                <!-- <ul>
                    <li class="icon"><a href="#"><i class="fa fa-user icon"></i></a></li>
                    <li style="padding-left:2px;">
                        <div class="dropdown">
                            <a  class="dropbtn" href="#">MyAccount</a>
                            <div class="dropdown-content">
                                <ul>
                                     <li><a class="1" href="#">My Account</a></li>
                                     <li><a class="2" href="#">My Cart</a></li>
                                     <li><a class="3" href="#">Order Status</a></li>
                                     <li><a class="4" href="#">Change Password</a></li>
                                     <li><a class="5" href="#">Return</a></li>
                                </ul>
                            </div>
                        </div>
                    </li>
                    <li><a href="#"><i class="fa fa-cart-plus"></i></a></li>
                    <li><a href="#">My cart</a></li>
                </ul> -->
            </div>
        </header>
            <section>
            <div class="slideshow">
                    <div class="slideshow-container">
                            <div class="mySlides fade">
                                    <img src="Images/hospitalbeds.png" style="width:100%">
                                    <!--<div class="text">Caption Text</div>-->
                            </div>
                            <div class="mySlides fade">
                                    <img src="Images/business_accounts.jpg" style="width:100%">
                                    <!--<div class="text">Caption Two</div>-->
                            </div>
                            <div class="mySlides fade">
                                    <img src="Images/blue_panel_home.jpg" style="width:100%">
                                    <!--<div class="text">Caption Three</div>-->
                            </div>
                            <a class="prev" onclick="plusSlides(-1)">&#10094;</a>
                            <a class="next" onclick="plusSlides(1)">&#10095;</a>
                    </div>
                    <script>
            var slideIndex = 1;
            showSlides(slideIndex);
            
            function plusSlides(n) 
            {
                showSlides(slideIndex += n);
            }

            function currentSlide(n) 
            {
                showSlides(slideIndex = n);
            }

            function showSlides(n) 
            {

                var slides = document.getElementsByClassName("mySlides");
                var dots = document.getElementsByClassName("dot");
                if (n > slides.length) 
                {
                    slideIndex = 1
                }    
                if (n < 1) 
                {
                    slideIndex = slides.length
                }
                for (i = 0; i < slides.length; i++) 
                {
                    slides[i].style.display = "none";  
                }
                for (i = 0; i < dots.length; i++) 
                {
                    dots[i].className = dots[i].className.replace(" active", "");
                }
                slides[slideIndex-1].style.display = "block";  
                dots[slideIndex-1].className += " active";

            }
        </script>
        
 		<div class="row">
 		<c:forEach var="listValue" items="${list}">
			  <div class="column">
			    <div class="card">
			      <img src="Images/${listValue.imagename }" alt="Jane" style="width:100% ; height: 250px">
			      <div class="container">
			        <h2>${listValue.itemname}</h2>
			        <p class="title">${listValue.itemprice}</p>
			        <p class="title">${listValue.itemoffer}</p>
			        <p><a href="View.html?id1=${listValue.itemid}"><button class="button">View</button></a></p>
			      </div>
			    </div>
			  </div>
			</c:forEach>
			</div>

			<footer>
            <div class="fot">
                <div class="head">
                    <h1>Your Satisfaction is Our Goal</h1>
                    <h3>Huge Selection - Always Low Prices - Fast Shipping - Best Customer Service</h3>
                </div>
            </div>
        </footer>
        <footer1>
            <div class="fot1">
                <nav>
                    <ul>
                        <li><a href="#">ContactUs</a></li>
                        <li><a href="#">Services</a></li>
                        <li><a href="#">AboutUs</a></li>
                        <li><a href="#">Feedback</a></li>
                        <li><a href="#">My Account</a></li>
                    </ul>
                </nav>
                <hr style="height: 2px;width: 50%;margin-top: 10%"/>
                <div class="icons">
                        <img src="Images/facebookicon.png"/>
                        <img src="Images/twitter.jpg" style="margin-left:-30px"/>
                        <img src="Images/insta.png" style="margin-left:40px"/>
                </div>
                <h4>Copyright @ Cosmos Medical Equipment. All Rights Reserved</h4>
            </div>
        </footer1>
 		
    </body>
</html>