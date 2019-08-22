`<%@page import="com.bean.Select"%>
<%@page import="com.bean.ItemsBean"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <title>Home</title>
        <link rel="stylesheet" type="text/css" href="CSS/Payment.css">
        <link rel="stylesheet" type="text/css" href="CSS/Credit.css">
        <link rel="stylesheet" type="text/css" href="CSS/demo.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <script>
				// If user clicks anywhere outside of the modal, Modal will close
				var modal = document.getElementById('modal-wrapper');	
				window.onclick = function(event) 
				{
					if (event.target == modal) 
					{
						modal.style.display = "none";
					}
				}
        </script>
    </head>
  <%
  
 Select u=(Select) session.getAttribute("user");
  if(u!= null)
  out.println(u.getUsername());
  else{
	  
	  response.sendRedirect("UserHome.html");
	  
  }
  
  
  %>
  	
<%-- <%
  
 /* ItemsBean u1=(ItemsBean) session.getAttribute("Pay");
  if(u1!= null)
  /* out.println(u1.getitemname());
  out.println(u1.getitemprice());
  out.println(u1.getitemoffer()); */
  out.println(u1.getitemquantity()); */
  %> --%>
  <c:if test="${msg1!=null}">
		<div class="msgColor">${msg1}
			<script>
			alert('${msg1 }');
			</script>
		</div>
		</c:if>
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
        		out.println("<label1>|</label1>");
        		out.println("<li><a href='Category.html'>Category</a></li>");
        		out.println("<label1>|</label1>");
        		out.println("<li><a href='Registration.html'>Sign Up</a></li>");
        		out.println("<label1>|</label1>");
        		out.println("<li><a href='UserHome.html'>Logout</a></li>");
        		out.println("<label1>|</label1>");
        		out.println("</ul>");
        		out.println("</nav>");
        	}
        	else
        	{
        		out.println("<nav>");
        		out.println("<ul>");
        		out.println("<li><a href='UserHome.html'>Home</a></li>");
        		out.println("<label1>|</label1>");
        		out.println("<li><a href='Category.html'>Category</a></li>");
        		out.println("<label1>|</label1>");
        		out.println("<li><a href='Registration.html'>Sign Up</a></li>");
        		out.println("<label1>|</label1>");
        		out.println("<li><a href='UserHome.html'>Back</a></li>");
        		out.println("<label1>|</label1>");
        		out.println("</ul>");
        		out.println("</nav>");
        	}
        %>       
            <!-- <nav>
                <ul>
                    <li><a href="#">Contact Us</a></li>
                    <label1>|</label1>
                    <li><a href="#">Products</a></li>
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
        </div>
        <section-1>
        <form action="Payment.html" method="post">
                <div class="pro">
                    <div class="sectionblock">
                   		<div class="col">
						    <div class="simple">
						      <h4 style="margin-left:60px;margin-top:-5px;font-size:20px">Order Info</h4>
						      <c:forEach var="listValue" items="${list}">
						      Product Name:<h style="margin-top:30px; margin-left:20px;"><span class="price">${listValue.itemname}</span></h><br>
						      Item Price:<h style="margin-top:30px; margin-left:20px;"><span class="price">${listValue.itemprice}</span></h><br>
						      Item Offers:<h style="margin-top:60px; margin-left:20px;"><span class="price">${listValue.itemoffer}</span></h><br>
						      Item Quantity:<h style="margin-top:90px; margin-left:20px;" id=1120><span class="price">${qty}</span></h><br>
						      </c:forEach>
						      Total Amount:<h style="margin-top:30px;margin-left:20px;"><span class="price" style="color:black"><b name="totalprice">${total}</b></span></h>
						    </div>
						  </div>
                        <div class="col-75">
                        
					    <div class="cont1">
						
					      
					        <div class="row">
					          <div class="col-50">
					            <h2>Billing Address</h2>
					            <label for="fname"><i class="fa fa-user"></i> Full Name</label>
					            <input type="text" id="fname" name="firstname" placeholder="John M. Doe" maxlength="20" pattern="[A-Za-z]{5,20}" required autofocus/>
					            <label for="email"><i class="fa fa-envelope"></i> Email</label>
					            <input type="text" id="email" name="email" placeholder="john@example.com" maxlength="30" pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,}$" required/>
					            <label for="adr"><i class="fa fa-address-card-o"></i> Address</label>
					            <input type="text" id="adr" name="address" placeholder="542 W. 15th Street" maxlength="40" pattern="[A-Za-z]{5,40}" required/>
					            <label for="city"><i class="fa fa-institution"></i> City</label>
					            <input type="text" id="city" name="city" placeholder="New York" maxlength="30" pattern="[A-Za-z]{3,20}" required>
					
					            <div class="row">
					              <div class="col-50">
					                <label for="state">State</label>
					                <input type="text" id="state" name="state" placeholder="NY" maxlength="30" pattern="[A-Za-z]{3,20}" required>
					              </div>
					              <div class="col-50">
					                <label for="zip">Zip</label>
					                <input type="text" id="zip" name="zip" placeholder="10001" maxlength="6" pattern="[0-9]{6,6}">
					              </div>
					            </div>
					          </div>
					          
					        </div>
					        <!--<label>
					          <input type="checkbox" checked="checked" name="sameadr"> Shipping address same as billing
					        </label>-->
					        <!--  <input type="submit" value="Continue to Pay" class="btn">-->
					      
					    </div>
					  </div>
					   <div class="container-fluid">
       
        <div class="creditCardForm">
            <div class="heading">
                <h1>Confirm Purchase</h1>
            </div>
            <div class="payment">
                
                    <div class="form-group owner">
                        <label for="owner">Name on the Card</label>
                        <input type="text" class="form-control" id="owner" placeholder="Name">
                    </div>
                    <div class="form-group CVV">
                        <label for="cvv">CVV</label>
                        <input type="password" class="form-control" id="cvv" placeholder="***">
                    </div>
                    <div class="form-group" id="card-number-field">
                        <label for="cardNumber">Card Number</label>
                        <input type="text" class="form-control" id="cardNumber" placeholder="1111-2222-3333-4444">
                    </div>
                    <div class="form-group" id="expiration-date">
                        <label>Expiration Date</label>
                        <select>
                            <option value="01">January</option>
                            <option value="02">February </option>
                            <option value="03">March</option>
                            <option value="04">April</option>
                            <option value="05">May</option>
                            <option value="06">June</option>
                            <option value="07">July</option>
                            <option value="08">August</option>
                            <option value="09">September</option>
                            <option value="10">October</option>
                            <option value="11">November</option>
                            <option value="12">December</option>
                        </select>
                        <select>
                            <option value="16"> 2016</option>
                            <option value="17"> 2017</option>
                            <option value="18"> 2018</option>
                            <option value="19"> 2019</option>
                            <option value="20"> 2020</option>
                            <option value="21"> 2021</option>
                        </select>
                    </div>
                    <div class="form-group" id="credit_cards"><br>
                        <img src="Images/visa.jpg" id="visa">
                        <img src="Images/mastercard.jpg" id="mastercard">
                        <img src="Images/amex.jpg" id="amex">
                    </div>
                    <div class="form-group" id="pay-now">
                        <input type="submit" class="btn btn-default"  id="confirm-purchase" value="Confirm">
                    </div> 
                
               
            </div>
            
        </div>
        
    </div>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <script src="js/jquery.payform.min.js" charset="utf-8"></script>
    <script src="js/script.js"></script>
                    </div>
                </div>
                </form>
        </section-1>
        </section>
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
        </div>
    </body>
</html>