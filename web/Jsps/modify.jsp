<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>修改资料</title>
	<style type="text/css">
	*{margin:0;padding:0;}
	body{
		background-image: url(backGround.jpg);
	}
	h5{
		font-size: 70px;
		color: white;
		text-shadow: 5px 5px 5px yellow;
		position: absolute;
		top: 0px;
	}
	#main{
		margin:0 auto;
		width: 1000px;
		position: relative;
	}
	.title{
		font-style: italic;
		font-size: 40px;
		color: white;
		position: absolute;
		top: -80px;
		left: 130px;
	}
	.form{
		font-size: 30px;
		margin-top: 180px;
		width: 80%;
		margin-left: 130px;	
	}
	.pic{
		width: 100px;
		height: 100px;
	}
	.input2{
		text-align: center;
		height: 30px;
		font-size: 27px;
		margin-top: 5px;
		margin-left: 40px;
		border:none;
		opacity: 0.4;
		border: none;
		text-decoration: none;
	}
	.input3{
		text-align: center;
		color:#AA0000;
		height: 30px;
		font-size: 27px;
		margin-top: 5px;
		margin-left: 40px;
		opacity: 0.4;
		border: none;
	}
	.input4{
		height: 30px;
		font-size: 27px;
		margin-top: 5px;
		margin-left: 11px;
		text-align: center;
	}
	.input5{
		margin-left: 250px;
		margin-top: -30px;
		font-size: 27px;
		line-height: 30px;
		width: 450px;
		border-radius: 5px;
	}
	.input6{
		width:80px;
		margin-left: 350px;
		font-size: 30px;
		border-radius: 5px;
	}
	.div{
		color:#FFCC99;
		margin-top: 15px;
	}
	</style>
	
	<script type="text/javascript">
		function validate(){
			address = document.form.address.value;
			phone = document.form.phone.value;
			if(address == ""){
				window.alert("地址不能为空！");
				document.form.address.focus();
				return;
			}
			else if (phone == "") {
				window.alert("联系方式不能为空！");
				document.form.phone.focus();
				return;
			}
			
			else
				form.submit();
		}

		function showImage()
		{	
		    // 获取文件路径
		    var path = document.getElementById('upload').value;
		    // 显示文件路径
		    document.getElementById('imgName').value = path;
		    // 创建 img
		  	document.getElementById('img').src=path;
		}
	</script>
</head>
<body>


	<div id="main">
		<div class="title">修改资料</div>
		<form class="form" name="form">
			<div id="imgPrev" class="div">您当前的头像为：<img id="img" class="pic" /><br></div>
			<input id = 'imgName' style="display: block;" >
			<div class="div">您当前的头像为：<input id="upload" name="upload"  type="file" onChange="showImage()"/><br></div>
			<div class="div">您的用户名为：<input class="input2" value="lin" readonly=""><br></div>
			<div class="div">绑定的邮箱为：<input class="input3" value="935839596@qq.com" readonly=""><br></div>
			<div class="div">您的电话号码为：<input class="input4" name="phone" value="15889666430"></div>
			<div class="div">您的收件地址为：<br><textarea class="input5" name="address"	cols="10" rows="5" value="">深圳市深圳大学</textarea></div><br>
			<input class="input6" type="button" value="提交" onclick="validate()">
		</form>
		
	</div>
</body>
</html>