

<style>
	.tag
	{
		Position:absolute; 
		background-color:rgb(206, 206, 206);
		height:100px;
		width:500px;
		margin-left:300px;
		margin-top:15px;
		padding:10px 20px;
		border-left:5px solid black;
		border-left-radius:5px;
		border-top-left-radius: 5px;
		border-bottom-left-radius: 5px;
	}
	.logout
	{
		Position:absolute; 
		height:40px;
		width:100px;
		margin-left:1150px;
		margin-top:70px;
		padding:8px 20px 10px 25px;
	}
	.logout a
	{
		Position:absolute;
		font-family:'Times New Roman';
		text-decoration:none;
		background-color:rgba(0,0,0,1);
		color:rgba(255,255,255,1);
		font-size:20px;
		padding:8px 20px 10px 25px;
	}
	.logout a:hover
	{
		background-color:red;
	}
</style>

<header class="header">
	<div class="logo">
		<img src="Images/Logo.jpg"/>
    </div>
    <div class="tag">
    	<h1>Cosmos-AdminPanel</h1>
    </div>
    <div class="logout">
    	<i class="glyphicon glyphicon-user"></i>
    	<a href="adminhome.html">Logout</a>
    </div>
</header> 