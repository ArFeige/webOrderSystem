
<html>
<head>
	<meta charset="utf-8">
    <title>用户登录</title>
    <style type="text/css">
    *{margin: 0px;padding: 0px;}
    body{
    	height: 750px;
    	background:black url(../Images/logo.jpg) no-repeat 500px 0px;
    }
    h1{
    	position: absolute;
    	top: 120px;
    	right: 650px;
    	color: red;
    }
    a{
    	text-decoration: none;
    }
    #middle{
    	border: 1px solid black;
    	width: 100%;
    	height: 75%;
    	z-index: 2;
    	margin-top: 200px;
        background-image: url(../Images/loginBack.jpg);
    }
    #form{
    	background-color: lightblue;
    	width: 400px;
    	height: 300px;
    	margin-top: 100px;
    	margin-left: 1300px;
    	position: relative;
    }
    .img1{
    	position:absolute;
    	width: 40px;
    	height: 40px;
    	top:100px;
    	left:30px;
    }
    .img2{
    	position:absolute;
    	width: 40px;
    	height: 40px;
    	top:160px;
    	left:30px;
    }

    .input1{
    	margin-top: 100px;
    	margin-left: 80px;
    	height: 40px;
    	width: 220px;
    }
    .input2{
    	margin-top: 20px;
    	margin-left: 80px;
    	height: 40px;
    	width: 220px;
    }
    .btn1{
    	margin-left: 120px;
    	margin-top: 20px;
    	width: 50px;
    	height: 30px;
    }
    .btn2{
    	margin-left: 30px;
    	margin-top: 20px;
    	width: 50px;
    	height: 30px;
    }
    .link1{
    	font-size:10px;
    	margin-top:10px;
    	float: left;
    }
    .link2{
    	margin-top: 10px;
    	font-size: 10px;
    	float: right;
    }
    </style>
    <script src="http://libs.baidu.com/jquery/1.9.1/jquery.js"></script>
	<script type="text/javascript">
    	function validate(){
				userName = document.form.userName.value;
				password = document.form.password.value;
				if (userName == "") {
					window.alert("请输入账号");
					document.form.userName.focus();
					return;
				}
				else if(password == ""){
					alert("请输入密码");
					document.form.password.focus();
					return;
				}
				else 
				{
					form.submit();
				}	
		}
    </script>
</head>
<body>
    <h1>All hackers come to us!</h1>
    <div id="middle" > 
    	<form id="form" name="form">
    		<input class="img1" src="user.png" type="image" value="?">
    		<input class="img2" src="pwd.png" type="image" value="?">
    		<input class="input1" name="userName" type="text" >
    		<input class="input2" name="password" type="password">	<br/>
    		<input class="btn1" name="btn1" type="button" value="登录" onclick="validate()">  
    		<input class="btn2" name="btn2" type="button" value="重置"><br/>
    		<a class="link1" href="#">forget password?</a>
    		<a class="link2" href="#">haven't account?</a>
    	</form>
    </div>
</body>
</html>