<html>
	<head>
		<meta charset="utf-8">
		<title>Registration Form</title>
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		
		<!-- MATERIAL DESIGN ICONIC FONT -->
		<link rel="stylesheet" href="../fonts/material-design-iconic-font/css/material-design-iconic-font.min.css">

		<!-- STYLE CSS -->
		<link rel="stylesheet" href="CSS/style.css">
	</head>

	<body>

		<div class="wrapper" style="background-image: url('Images/back.jpg');">
			<a href="UserHome.html" class="btn1"><button>Home Page
			</button></a>
			<div class="inner">
				<div class="image-holder">
					<img src="Images/front.jpg" alt="">
				</div>
				<form method="POST" action="registrationSave.html">
					<h3>Registration Form</h3>
					<div class="form-group">
						<input type="text" placeholder="First Name" class="form-control" name="Firstname" maxlength="30" pattern="[A-Za-z]{0,20}" required>
						<input type="text" placeholder="Last Name" class="form-control" name="Lastname" maxlength="30" pattern="[A-Za-z]{0,20}" required>
					</div>
					<div class="form-wrapper">
						<input type="text" placeholder="Username" class="form-control" name="Username" maxlength="30" pattern="[A-Za-z]{0,20}" required>
						<i class="zmdi zmdi-account"></i>
					</div>
					<div class="form-wrapper">
						<input type="email" placeholder="Email Address" class="form-control" name="EmailAddress" maxlength="30" pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,}$" required>
						<i class="zmdi zmdi-email"></i>
					</div>
					<div class="form-wrapper">
						<input type="tel" placeholder="Phone Number" class="form-control" name="Phonenumber" maxlength="13" pattern="[+0-9]{10,13}" required>
						<i class="zmdi zmdi-phone" style="font-size: 17px"></i>
					</div>
                    <div class="form-wrapper">
						<select  id="" class="form-control" name="Gender" required>
							<option value="" disabled selected>Gender</option>
							<option value="male">Male</option>
							<option value="femal">Female</option>
							<option value="other">Other</option>
						</select>
						<i class="zmdi zmdi-caret-down" style="font-size: 17px"></i>
					</div>
                    <div class="form-wrapper">
						<input type="textarea" placeholder="Address" class="form-control" name="Address" maxlength="40" pattern="[A-Za-z]{10,40}" required>
						<i class="zmdi zmdi-address"></i>
					</div>
					<div class="form-wrapper">
						<input type="password" placeholder="Password" class="form-control" name="Password" maxlength="15" pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,15}" required>
						<i class="zmdi zmdi-lock"></i>
					</div>
					<div class="form-wrapper">
						<input type="password" placeholder="Confirm Password" class="form-control" name="ConfirmPassword" maxlength="15" pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,15}" required>
						<i class="zmdi zmdi-lock"></i>
					</div>
					<button>Register
						<i class="zmdi zmdi-arrow-right"></i>
					</button>
				</form>
			</div>
		</div>
		
	</body>
</html>