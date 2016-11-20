<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>密码重置</title>
	<style type="text/css">
	body{
		background-image: url(../Images/onlyForReset.jpg);
	}
	.div3{
		font-size: 30px;
		color: white;
		margin-top:200px;
		margin-left:750px;
	}
	.div4{
		font-size: 30px;
		color: white;
		margin-top: 30px;
		margin-left: 750px;

	}
	input{
		line-height: 30px;
		font-size: 28px;
	}
	.sumit{
		line-height: 30px;
		font-size: 25px;
		margin-top: 20px;
		margin-left: 890px;
	}
	</style>

</head>
<body>
<script type="text/javascript">
		function validate(){
			password1 = document.form.password1.value;
			password2 = document.form.password2.value;
			
			if(password1 == ""){
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
	<form name="form">
		<div class="div3" ><span>请输入重置密码:</span><input class="input3"  name="password1" type="password"></div><br>
		<div class="div4"><span>请再次输入密码:</span><input class="input4"  name="password2" type="password"></div><br>
		<input class="sumit" type="button" value="提交" onclick="validate()">
	</form>
	
</body>
</html>