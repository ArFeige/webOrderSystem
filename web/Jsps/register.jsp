<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>hackers</title>
	<style type="text/css">
	body{
		background-image: url(../Images/backGround.jpg);
	}

	#desktop{
		border: 1px solid black;
		width:1000px;
		height: 850px;
		margin: 0 auto;
		background: url(../Images/show.jpg) no-repeat center;
		position: relative;
	}

	#form{
		position: absolute;
		top: 150px;
		left: 200px;
		line-height: 80px;
	}

	.label1{
		width: 300px;
		margin-left: 50px;
		height: 60px;	
	}
	.label2{
		width: 300px;
		margin-left: 50px;
		height: 60px;
	}
	.label3{
		width: 300px;
		margin-left: 50px;
		height: 60px;
	}
	.label4{
		width: 300px;
		margin-left: 50px;
		height: 60px;
	}
	span{
		font-size: 28px;
		text-shadow: 2px 2px 2px lightblue;
	}
	input{
		height: 40px;
		font-size: 25px;
		margin-right: 100px;
	}
	.title{
		margin-top: 110px;
		margin-left: 140px;
		font-size: 30px;
		text-shadow: 2px 2px 2px yellow;
		font-style: italic;
	}
	.btn1{
		margin-left: 150px;
	}
	.btn2{
		margin-left: 30px;
	}
	</style>
	<script type="text/javascript">
		function validate(){
			email = document.form.email.value;
			account = document.form.account.value;
			password1 = document.form.password1.value;
			password2 = document.form.password2.value;
			if(email == ""){
				window.alert("请输入邮箱");
				document.form.email.focus();
				return;
			}
			else if (account == "") {
				window.alert("请输入账号");
				document.form.account.focus();
				return;
			}
			else if(password1 == ""){
				alert("请输入密码");
				document.form.password1.focus();
				return;
			}
			else if(password2 == ""){
				alert("请再一次输入密码");
				document.form.password2.focus();
				return;
			}
			else if(password1!=password2)
			{
				alert("两次输入的密码不一致");
				form.reset();
				return;
			}
			else
				form.submit();
		}
	</script>
	<script type="text/javascript">
		function validate(){
			email = document.form.email.value;
			account = document.form.account.value;
			password1 = document.form.password1.value;
			password2 = document.form.password2.value;
			if (email == "") {
				window.alert("请输入您的邮箱!");
				document.form.email.focus();
				return;
			}
			else if (account == "") {
				window.alert("请输入账号!");
				document.form.account.focus();
				return;
			}
			else if(password1 == ""){
				alert("请输入密码!");
				document.form.password1.focus();
				return;
			}
			else if(password2 == ""){
				alert("请再一次输入密码!");
				document.form.password2.focus();
				return;
			}
			else if(password1!=password2)
			{
				alert("两次输入的密码不一致!");
				form.reset();
				return;
			}
			else
				form.submit();
		}
	</script>
</head>
<body>
		<div id="desktop">
			<p class="title">birth of a hacker...buyer</p>
			<form id="form" name="form">
				<label class="label1" ><span>邮箱:</span><input class="input1" style="margin-left: 59px;" name="email" ></label><br>
				<label class="label2" ><span>用户名:</span><input class="input2" style="margin-left: 32px;" name="account"></label><br>
				<label class="label3" ><span>密码:</span><input class="input3" type="password" style="margin-left: 59px;" name="password1"></label><br>
				<label class="label4"><span>确认密码:</span><input class="input4" type="password" style="margin-left: 5px;"name="password2"></label><br>
				<input class="btn1" type="button" value="注册" onclick="validate()">
				<input class="btn2" type="reset" value="重置" >
			</form>
		</div>
</body>
</html>

